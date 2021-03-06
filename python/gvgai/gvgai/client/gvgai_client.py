import logging
import os
import sys
import subprocess
from struct import pack_into

import numpy as np

from gvgai.client.iosocket import IOSocket
from gvgai.client.serialization.State import State
from gvgai.client.types import AgentPhase, GamePhase, Action
from gvgai.client.utils.logpipe import LogPipe


class GVGAIClient():

    def _get_libs(self, path):
        libs = []
        for root, _, files in os.walk(path):
            for f in files:
                if (f.endswith('.jar')):
                    libs.append(os.path.join(root, f))
        return libs

    def __init__(self, client_only=False):

        self.io = IOSocket(client_only)
        self.player = None
        self.global_ect = None
        self.terminal = False
        self._running = False
        self.actions = []

        self._logger = logging.getLogger("GVGAIClient")

        # Client only mode stops the service from being started
        if not client_only:
            root_path = os.path.realpath(os.path.dirname(os.path.realpath(__file__)) + "/../../../../")

            java_log_level = logging.INFO

            self._logpipe = LogPipe("JAVA", level=java_log_level)
            # Run the application using gradle
            cmd = [f'{root_path}/gradlew', 'run',
                   f'--args=-i {root_path}/games -p {self.io.port} -l {logging.getLevelName(java_log_level)}']
            try:
                # Pump the logging output to a logger so we can see it
                self.java = subprocess.Popen(cmd, stdout=self._logpipe, stderr=self._logpipe, cwd=root_path)
            except subprocess.CalledProcessError as e:
                self._logger.error(f'exit code: {e.returncode}')
                self._logger.error(f'stderr: {e.stderr.decode(sys.getfilesystemencoding())}')

        self.io.initBuffers()

        self._start()

    def step(self, act):

        if hasattr(act, 'shape'):
            act = int(act)

        # We send the action first and then wait for the response
        game_phase, _, _ = self._read_and_process_server_response()
        self.io.writeToServer(AgentPhase.ACT_STATE, act.to_bytes(4, byteorder='big'))

        state, image = self._observe()

        current_score, reward = self._get_reward(state)
        self._previous_score = current_score

        actions = self._get_actions(state)

        if state.IsGameOver() == True or state.GameWinner() == 'PLAYER_WINS' or game_phase == GamePhase.END_STATE or game_phase == GamePhase.END_STATE:
            done = True
        else:
            done = False

        info = {'winner': state.GameWinner(), 'actions': [a.value for a in actions]}
        return image, reward, done, info

    def reset(self, environment_id=None,
              level_data=None,
              max_steps=-1,
              pixel_observations=True,
              tile_observations=False,
              include_semantic_data=False
              ):
        self._previous_score = 0
        self._tile_observations = tile_observations

        reset = False

        while not reset:

            game_phase, state, _ = self._read_and_process_server_response()

            # If we are in the act state then we abort
            if game_phase == GamePhase.ACT_STATE:
                self._abort_game()

            if game_phase == GamePhase.CHOOSE_LEVEL:
                self._choose_level(environment_id,
                                   level_data=level_data,
                                   max_steps=max_steps,
                                   pixel_observations=pixel_observations,
                                   tile_observations=tile_observations,
                                   include_semantic_data=include_semantic_data
                                   )

            if game_phase == GamePhase.INIT_STATE:
                initial_observation = self._init(state)
                self._running = True
                reset = True

                return initial_observation

            if game_phase == GamePhase.END_STATE:
                self.io.writeToServer(AgentPhase.END_STATE)

    def _get_dimensions(self, state):
        dims = state.WorldDimensionAsNumpy().astype(np.int32)
        return dims[0], dims[1]

    def _read_and_process_server_response(self):
        game_phase_bytes, data_bytes = self.io.readFromServer()
        game_phase = GamePhase(int.from_bytes(game_phase_bytes, 'big'))
        state, image = self._process_data(data_bytes)
        return game_phase, state, image

    def _get_reward(self, state):
        current_score = state.GameScore()
        reward = current_score - self._previous_score
        return current_score, reward

    def _convert_to_actions(self, actions_numpy):
        return [Action(action) for action in actions_numpy]

    def _get_actions(self, state):
        availableActions = self._convert_to_actions(state.AvailableActionsAsNumpy())
        return availableActions + [Action.ACTION_NIL]

    def _process_data(self, data=None):

        try:
            if data is not None:
                state = State.GetRootAsState(data, 0)

                has_pixel_observation = state.ImageArrayLength() != 0
                has_tile_obsevation = state.TileArrayLength() != 0

                width, height = self._get_dimensions(state)
                block_size = state.BlockSize()

                pixel_observation = None
                tile_observation = None
                observation = None

                if has_pixel_observation:
                    pixel_observation = np.reshape(state.ImageArrayAsNumpy().astype(np.uint8), (height, width, -1))

                if has_tile_obsevation:
                    tile_observation = np.reshape(state.TileArrayAsNumpy().astype(np.uint8),
                                                  (height // block_size, width // block_size, -1))

                if has_pixel_observation and has_tile_obsevation:
                    observation = (pixel_observation, tile_observation)
                elif has_tile_obsevation:
                    observation = tile_observation
                elif has_pixel_observation:
                    observation = pixel_observation

                return state, observation

            return None, None

        except Exception as e:
            logging.exception(e)
            print("Line processing [FAILED]")
            # traceback.print_exc()
            sys.exit()

    def _observe(self):
        agent_phase, state, image = self._read_and_process_server_response()
        assert agent_phase == GamePhase.OBSERVE_STATE, "Expecting OBSERVE_STATE from GVGAI, but received %s" % GamePhase(
            agent_phase)
        self.io.writeToServer(AgentPhase.OBSERVE_STATE)

        return state, image

    def _start(self):
        # Firstly we should receive a choose-level state
        game_phase, _, _ = self._read_and_process_server_response()
        assert game_phase == GamePhase.START_STATE, "Expecting START_STATE from GVGAI, but received %s" % GamePhase(
            game_phase)
        self.io.writeToServer(AgentPhase.START_STATE)

    def _abort_game(self):
        self.io.writeToServer(AgentPhase.ABORT_STATE)
        self._observe()
        self._end_game()

    def _end_game(self):
        game_phase, state, image = self._read_and_process_server_response()
        assert game_phase == GamePhase.END_STATE, "Expecting END_STATE from GVGAI, but received %s" % GamePhase(
            game_phase)
        self.io.writeToServer(AgentPhase.END_STATE)

    def _bool2bytes(self, value):
        return bytearray(b'\x01' if value else b'\x00')

    def _choose_level(self, environment_id, level_data=None, max_steps=-1, include_semantic_data=False, pixel_observations=True,
                      tile_observations=False):

        environment_id_bytes = environment_id.encode()
        environment_id_bytes_length = len(environment_id_bytes)

        level_data_bytes_length = 0
        # If we have a custom environment we should also pass the data
        if 'custom' in environment_id:
            if level_data is None:
                level_data = 'wwww\nwA.w\nw0ww\nwwww\n'
            level_data_bytes = level_data.encode()
            level_data_bytes_length = len(level_data_bytes)

        choose_level_data = bytearray(4 + environment_id_bytes_length + 13 + level_data_bytes_length)

        # Environment Id
        pack_into('>i', choose_level_data, 0, environment_id_bytes_length)
        pack_into('%ds' % environment_id_bytes_length, choose_level_data, 4, environment_id_bytes)

        # Environment Data Options
        pack_into('?', choose_level_data, environment_id_bytes_length + 4, include_semantic_data)
        pack_into('?', choose_level_data, environment_id_bytes_length + 5, tile_observations)
        pack_into('?', choose_level_data, environment_id_bytes_length + 6, pixel_observations)
        pack_into('>i',choose_level_data, environment_id_bytes_length + 7, max_steps)

        # Level Data
        pack_into('>i', choose_level_data, environment_id_bytes_length + 11, level_data_bytes_length)
        if level_data_bytes_length > 0:
            data_start = environment_id_bytes_length + 15
            pack_into('%ds' % level_data_bytes_length, choose_level_data, data_start, level_data_bytes)

        self.io.writeToServer(AgentPhase.CHOOSE_LEVEL_STATE, choose_level_data)

    def _init(self, state):
        self.actions = self._get_actions(state)
        self.world_dimensions = state.WorldDimensionAsNumpy().astype(np.int32)
        self.io.writeToServer(AgentPhase.INIT_STATE)

        state, image = self._observe()
        return image

    def stop(self):

        if self._running:
            self._running = False
            try:
                game_phase, state, image = self._read_and_process_server_response()
                assert game_phase == GamePhase.ACT_STATE, "Expecting ACT_STATE from GVGAI, but received %s" % GamePhase(
                    game_phase)
                self._abort_game()
                self._choose_level("END")
            except AssertionError as e:
                self._logger.error(e)

        try:
            if hasattr(self, 'java'):
                self.java.kill()
                self._logpipe.close()
        except AssertionError as e:
            self._logger.error(e)

    def __del__(self):
        self.stop()
