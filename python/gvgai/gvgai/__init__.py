from gym.envs.registration import register

from gvgai.client.gvgai_client import GVGAIClient

environments = [
    "boloadventures-lvl4",
    "boloadventures-lvl0",
    "boloadventures-lvl2",
    "boloadventures-lvl1",
    "boloadventures-lvl3",
    "cakybaky-lvl1",
    "cakybaky-lvl2",
    "cakybaky-lvl0",
    "cakybaky-lvl3",
    "cakybaky-lvl4",
    "racebet-lvl3",
    "racebet-lvl1",
    "racebet-lvl2",
    "racebet-lvl4",
    "racebet-lvl0",
    "labyrinth-lvl0",
    "labyrinth-lvl1",
    "labyrinth-lvl4",
    "labyrinth-lvl2",
    "labyrinth-lvl3",
    "bomberman-lvl1",
    "bomberman-lvl4",
    "bomberman-lvl0",
    "bomberman-lvl2",
    "bomberman-lvl3",
    "survivezombies-lvl3",
    "survivezombies-lvl0",
    "survivezombies-lvl2",
    "survivezombies-lvl4",
    "survivezombies-lvl1",
    "cec1-lvl1",
    "cec1-lvl0",
    "waferthinmints-lvl0",
    "mirrors-lvl2",
    "mirrors-lvl4",
    "mirrors-lvl0",
    "mirrors-lvl3",
    "mirrors-lvl1",
    "iceandfire-lvl2",
    "iceandfire-lvl0",
    "iceandfire-lvl4",
    "iceandfire-lvl1",
    "iceandfire-lvl3",
    "blacksmoke-lvl4",
    "blacksmoke-lvl0",
    "blacksmoke-lvl1",
    "blacksmoke-lvl3",
    "blacksmoke-lvl2",
    "tercio-lvl2",
    "tercio-lvl3",
    "tercio-lvl0",
    "tercio-lvl4",
    "tercio-lvl1",
    "chopper-lvl1",
    "chopper-lvl0",
    "chopper-lvl4",
    "chopper-lvl3",
    "chopper-lvl2",
    "lasers-lvl3",
    "lasers-lvl4",
    "lasers-lvl0",
    "lasers-lvl2",
    "lasers-lvl1",
    "intersection-lvl2",
    "intersection-lvl3",
    "intersection-lvl1",
    "intersection-lvl4",
    "intersection-lvl0",
    "enemycitadel-lvl1",
    "enemycitadel-lvl0",
    "enemycitadel-lvl4",
    "enemycitadel-lvl2",
    "enemycitadel-lvl3",
    "eighthpassenger-lvl0",
    "eighthpassenger-lvl3",
    "eighthpassenger-lvl4",
    "eighthpassenger-lvl1",
    "eighthpassenger-lvl2",
    "eggomania-lvl4",
    "eggomania-lvl1",
    "eggomania-lvl0",
    "eggomania-lvl3",
    "eggomania-lvl2",
    "x-racer-lvl1",
    "x-racer-lvl2",
    "x-racer-lvl0",
    "x-racer-lvl3",
    "x-racer-lvl4",
    "camelRace-lvl1",
    "camelRace-lvl2",
    "camelRace-lvl3",
    "camelRace-lvl0",
    "camelRace-lvl4",
    "zelda-lvl0",
    "zelda-lvl1",
    "zelda-lvl4",
    "zelda-lvl2",
    "zelda-lvl3",
    "sistersavior-lvl0",
    "sistersavior-lvl1",
    "escape-lvl0",
    "escape-lvl4",
    "escape-lvl1",
    "escape-lvl3",
    "escape-lvl2",
    "infection-lvl2",
    "infection-lvl0",
    "infection-lvl4",
    "infection-lvl1",
    "infection-lvl3",
    "waitforbreakfast-lvl3",
    "waitforbreakfast-lvl1",
    "waitforbreakfast-lvl4",
    "waitforbreakfast-lvl0",
    "waitforbreakfast-lvl2",
    "colourescape-lvl0",
    "colourescape-lvl1",
    "colourescape-lvl2",
    "colourescape-lvl4",
    "colourescape-lvl3",
    "flower-lvl0",
    "waferthinmintsexit-lvl0",
    "gymkhana-lvl3",
    "gymkhana-lvl0",
    "gymkhana-lvl1",
    "gymkhana-lvl4",
    "gymkhana-lvl2",
    "catapults-lvl0",
    "catapults-lvl1",
    "catapults-lvl2",
    "catapults-lvl3",
    "catapults-lvl4",
    "boulderdash-lvl4",
    "boulderdash-lvl2",
    "boulderdash-lvl0",
    "boulderdash-lvl3",
    "boulderdash-lvl1",
    "themole-lvl1",
    "themole-lvl3",
    "themole-lvl2",
    "themole-lvl4",
    "themole-lvl0",
    "firestorms-lvl4",
    "firestorms-lvl3",
    "firestorms-lvl2",
    "firestorms-lvl0",
    "firestorms-lvl1",
    "jaws-lvl3",
    "jaws-lvl2",
    "jaws-lvl1",
    "jaws-lvl0",
    "jaws-lvl4",
    "painter-lvl2",
    "painter-lvl1",
    "painter-lvl0",
    "painter-lvl3",
    "painter-lvl4",
    "realportals-lvl1",
    "realportals-lvl3",
    "realportals-lvl4",
    "realportals-lvl0",
    "realportals-lvl2",
    "pacman-lvl4",
    "pacman-lvl0",
    "pacman-lvl2",
    "pacman-lvl3",
    "pacman-lvl1",
    "vortex-lvl1",
    "vortex-lvl3",
    "vortex-lvl0",
    "vortex-lvl4",
    "vortex-lvl2",
    "digdug-lvl3",
    "digdug-lvl2",
    "digdug-lvl1",
    "digdug-lvl4",
    "digdug-lvl0",
    "seaquest-lvl2",
    "seaquest-lvl4",
    "seaquest-lvl0",
    "seaquest-lvl1",
    "seaquest-lvl3",
    "decepticoins-lvl3",
    "decepticoins-lvl4",
    "decepticoins-lvl2",
    "decepticoins-lvl0",
    "decepticoins-lvl1",
    "rivers-lvl0",
    "rivers-lvl3",
    "rivers-lvl4",
    "rivers-lvl1",
    "rivers-lvl2",
    "freeway-lvl2",
    "freeway-lvl1",
    "freeway-lvl4",
    "freeway-lvl3",
    "freeway-lvl0",
    "thesnowman-lvl4",
    "thesnowman-lvl1",
    "thesnowman-lvl0",
    "thesnowman-lvl2",
    "thesnowman-lvl3",
    "butterflies-lvl4",
    "butterflies-lvl0",
    "butterflies-lvl3",
    "butterflies-lvl1",
    "butterflies-lvl2",
    "thecitadel-lvl4",
    "thecitadel-lvl0",
    "thecitadel-lvl1",
    "thecitadel-lvl3",
    "thecitadel-lvl2",
    "donkeykong-lvl2",
    "donkeykong-lvl4",
    "donkeykong-lvl0",
    "donkeykong-lvl3",
    "donkeykong-lvl1",
    "missilecommand-lvl0",
    "missilecommand-lvl2",
    "missilecommand-lvl1",
    "missilecommand-lvl3",
    "missilecommand-lvl4",
    "sheriff-lvl0",
    "sheriff-lvl1",
    "sheriff-lvl4",
    "sheriff-lvl2",
    "sheriff-lvl3",
    "ghostbuster-lvl0",
    "ghostbuster-lvl4",
    "ghostbuster-lvl2",
    "ghostbuster-lvl3",
    "ghostbuster-lvl1",
    "witnessprotected-lvl3",
    "witnessprotected-lvl4",
    "witnessprotected-lvl1",
    "witnessprotected-lvl0",
    "witnessprotected-lvl2",
    "chipschallenge-lvl4",
    "chipschallenge-lvl0",
    "chipschallenge-lvl2",
    "chipschallenge-lvl3",
    "chipschallenge-lvl1",
    "portals-lvl1",
    "portals-lvl2",
    "portals-lvl0",
    "portals-lvl3",
    "portals-lvl4",
    "defender-lvl2",
    "defender-lvl1",
    "defender-lvl0",
    "defender-lvl3",
    "defender-lvl4",
    "brainman-lvl3",
    "brainman-lvl4",
    "brainman-lvl0",
    "brainman-lvl1",
    "brainman-lvl2",
    "roadfighter-lvl4",
    "roadfighter-lvl1",
    "roadfighter-lvl0",
    "roadfighter-lvl3",
    "roadfighter-lvl2",
    "overload-lvl0",
    "overload-lvl4",
    "overload-lvl1",
    "overload-lvl2",
    "overload-lvl3",
    "cops-lvl0",
    "cops-lvl2",
    "cops-lvl4",
    "cops-lvl1",
    "cops-lvl3",
    "bomber-lvl3",
    "bomber-lvl4",
    "bomber-lvl2",
    "bomber-lvl1",
    "bomber-lvl0",
    "pokemon-lvl2",
    "pokemon-lvl0",
    "pokemon-lvl4",
    "pokemon-lvl3",
    "pokemon-lvl1",
    "ikaruga-lvl0",
    "ikaruga-lvl1",
    "ikaruga-lvl4",
    "ikaruga-lvl2",
    "ikaruga-lvl3",
    "wrapsokoban-lvl4",
    "wrapsokoban-lvl3",
    "wrapsokoban-lvl1",
    "wrapsokoban-lvl0",
    "wrapsokoban-lvl2",
    "bait-lvl0",
    "bait-lvl4",
    "bait-lvl2",
    "bait-lvl3",
    "bait-lvl1",
    "surround-lvl1",
    "surround-lvl0",
    "surround-lvl4",
    "surround-lvl3",
    "surround-lvl2",
    "whackamole-lvl2",
    "whackamole-lvl0",
    "whackamole-lvl4",
    "whackamole-lvl3",
    "whackamole-lvl1",
    "deflection-lvl4",
    "deflection-lvl0",
    "deflection-lvl2",
    "deflection-lvl3",
    "deflection-lvl1",
    "frogs-lvl1",
    "frogs-lvl2",
    "frogs-lvl4",
    "frogs-lvl3",
    "frogs-lvl0",
    "deceptizelda-lvl2",
    "deceptizelda-lvl0",
    "deceptizelda-lvl3",
    "deceptizelda-lvl4",
    "deceptizelda-lvl1",
    "cec2-lvl0",
    "cec2-lvl1",
    "invest-lvl0",
    "labyrinthdual-lvl2",
    "labyrinthdual-lvl4",
    "labyrinthdual-lvl0",
    "labyrinthdual-lvl1",
    "labyrinthdual-lvl3",
    "realsokoban-lvl2",
    "realsokoban-lvl4",
    "realsokoban-lvl1",
    "realsokoban-lvl0",
    "realsokoban-lvl3",
    "superman-lvl2",
    "superman-lvl1",
    "superman-lvl3",
    "superman-lvl0",
    "superman-lvl4",
    "testgame2-lvl1",
    "testgame2-lvl0",
    "lasers2-lvl0",
    "lasers2-lvl2",
    "lasers2-lvl4",
    "lasers2-lvl3",
    "lasers2-lvl1",
    "fireman-lvl4",
    "fireman-lvl1",
    "fireman-lvl3",
    "fireman-lvl2",
    "fireman-lvl0",
    "hungrybirds-lvl4",
    "hungrybirds-lvl3",
    "hungrybirds-lvl0",
    "hungrybirds-lvl1",
    "hungrybirds-lvl2",
    "crossfire-lvl3",
    "crossfire-lvl1",
    "crossfire-lvl2",
    "crossfire-lvl4",
    "crossfire-lvl0",
    "aliens-lvl0",
    "aliens-lvl3",
    "aliens-lvl4",
    "aliens-lvl2",
    "aliens-lvl1",
    "islands-lvl2",
    "islands-lvl0",
    "islands-lvl1",
    "islands-lvl4",
    "islands-lvl3",
    "testgame3-lvl0",
    "testgame3-lvl1",
    "shipwreck-lvl2",
    "shipwreck-lvl0",
    "shipwreck-lvl4",
    "shipwreck-lvl3",
    "shipwreck-lvl1",
    "testgame1-lvl1",
    "testgame1-lvl0",
    "zenpuzzle-lvl1",
    "zenpuzzle-lvl2",
    "zenpuzzle-lvl4",
    "zenpuzzle-lvl3",
    "zenpuzzle-lvl0",
    "modality-lvl0",
    "modality-lvl4",
    "modality-lvl1",
    "modality-lvl2",
    "modality-lvl3",
    "killBillVol1-lvl2",
    "killBillVol1-lvl4",
    "killBillVol1-lvl1",
    "killBillVol1-lvl0",
    "killBillVol1-lvl3",
    "boulderchase-lvl3",
    "boulderchase-lvl0",
    "boulderchase-lvl4",
    "boulderchase-lvl1",
    "boulderchase-lvl2",
    "defem-lvl0",
    "defem-lvl4",
    "defem-lvl3",
    "defem-lvl2",
    "defem-lvl1",
    "watergame-lvl1",
    "watergame-lvl2",
    "watergame-lvl3",
    "watergame-lvl4",
    "watergame-lvl0",
    "firecaster-lvl4",
    "firecaster-lvl3",
    "firecaster-lvl0",
    "firecaster-lvl2",
    "firecaster-lvl1",
    "dungeon-lvl0",
    "dungeon-lvl3",
    "dungeon-lvl4",
    "dungeon-lvl1",
    "dungeon-lvl2",
    "plants-lvl4",
    "plants-lvl1",
    "plants-lvl3",
    "plants-lvl2",
    "plants-lvl0",
    "investdie-lvl0",
    "chainreaction-lvl2",
    "chainreaction-lvl3",
    "chainreaction-lvl4",
    "chainreaction-lvl1",
    "chainreaction-lvl0",
    "assemblyline-lvl4",
    "assemblyline-lvl3",
    "assemblyline-lvl2",
    "assemblyline-lvl0",
    "assemblyline-lvl1",
    "chase-lvl1",
    "chase-lvl0",
    "chase-lvl3",
    "chase-lvl2",
    "chase-lvl4",
    "racebet2-lvl2",
    "racebet2-lvl4",
    "racebet2-lvl1",
    "racebet2-lvl3",
    "racebet2-lvl0",
    "wildgunman-lvl0",
    "wildgunman-lvl1",
    "wildgunman-lvl2",
    "wildgunman-lvl3",
    "wildgunman-lvl4",
    "sokoban-lvl1",
    "sokoban-lvl3",
    "sokoban-lvl2",
    "sokoban-lvl4",
    "sokoban-lvl0",
    "roguelike-lvl3",
    "roguelike-lvl2",
    "roguelike-lvl1",
    "roguelike-lvl0",
    "roguelike-lvl4",
    "lemmings-lvl2",
    "lemmings-lvl4",
    "lemmings-lvl3",
    "lemmings-lvl1",
    "lemmings-lvl0",
    "garbagecollector-lvl1",
    "garbagecollector-lvl2",
    "garbagecollector-lvl3",
    "garbagecollector-lvl0",
    "garbagecollector-lvl4",
    "clusters-lvl2",
    "clusters-lvl1",
    "clusters-lvl3",
    "clusters-lvl4",
    "clusters-lvl0",
    "beltmanager-lvl2",
    "beltmanager-lvl4",
    "beltmanager-lvl3",
    "beltmanager-lvl0",
    "beltmanager-lvl1",
    "waves-lvl0",
    "waves-lvl4",
    "waves-lvl1",
    "waves-lvl3",
    "waves-lvl2",
    "witnessprotection-lvl1",
    "witnessprotection-lvl3",
    "witnessprotection-lvl2",
    "witnessprotection-lvl4",
    "witnessprotection-lvl0",
    "theshepherd-lvl4",
    "theshepherd-lvl2",
    "theshepherd-lvl1",
    "theshepherd-lvl3",
    "theshepherd-lvl0",
    "run-lvl1",
    "run-lvl4",
    "run-lvl2",
    "run-lvl0",
    "run-lvl3",
    "factorymanager-lvl3",
    "factorymanager-lvl0",
    "factorymanager-lvl4",
    "factorymanager-lvl2",
    "factorymanager-lvl1",
    "cookmepasta-lvl2",
    "cookmepasta-lvl3",
    "cookmepasta-lvl1",
    "cookmepasta-lvl4",
    "cookmepasta-lvl0",
    "angelsdemons-lvl3",
    "angelsdemons-lvl2",
    "angelsdemons-lvl1",
    "angelsdemons-lvl0",
    "angelsdemons-lvl4",
    "cec3-lvl1",
    "cec3-lvl0",
    "doorkoban-lvl0",
    "doorkoban-lvl1",
    "doorkoban-lvl4",
    "doorkoban-lvl2",
    "doorkoban-lvl3",
    "plaqueattack-lvl4",
    "plaqueattack-lvl0",
    "plaqueattack-lvl2",
    "plaqueattack-lvl3",
    "plaqueattack-lvl1",
    "solarfox-lvl1",
    "solarfox-lvl3",
    "solarfox-lvl0",
    "solarfox-lvl4",
    "solarfox-lvl2",
    "avoidgeorge-lvl4",
    "avoidgeorge-lvl1",
    "avoidgeorge-lvl2",
    "avoidgeorge-lvl0",
    "avoidgeorge-lvl3",

    # if we want to provide our own level format here, can use custom
    "boloadventures-custom",
    "cakybaky-custom",
    "racebet-custom",
    "labyrinth-custom",
    "bomberman-custom",
    "survivezombies-custom",
    "cec1-custom",
    "waferthinmints-custom",
    "mirrors-custom",
    "iceandfire-custom",
    "blacksmoke-custom",
    "tercio-custom",
    "chopper-custom",
    "lasers-custom",
    "intersection-custom",
    "enemycitadel-custom",
    "eighthpassenger-custom",
    "eggomania-custom",
    "x-racer-custom",
    "camelRace-custom",
    "zelda-custom",
    "sistersavior-custom",
    "escape-custom",
    "infection-custom",
    "waitforbreakfast-custom",
    "colourescape-custom",
    "flower-custom",
    "waferthinmintsexit-custom",
    "gymkhana-custom",
    "catapults-custom",
    "boulderdash-custom",
    "themole-custom",
    "firestorms-custom",
    "jaws-custom",
    "painter-custom",
    "realportals-custom",
    "pacman-custom",
    "vortex-custom",
    "digdug-custom",
    "seaquest-custom",
    "decepticoins-custom",
    "rivers-custom",
    "freeway-custom",
    "thesnowman-custom",
    "butterflies-custom",
    "thecitadel-custom",
    "donkeykong-custom",
    "missilecommand-custom",
    "sheriff-custom",
    "ghostbuster-custom",
    "witnessprotected-custom",
    "chipschallenge-custom",
    "portals-custom",
    "defender-custom",
    "brainman-custom",
    "roadfighter-custom",
    "overload-custom",
    "cops-custom",
    "bomber-custom",
    "pokemon-custom",
    "ikaruga-custom",
    "wrapsokoban-custom",
    "bait-custom",
    "surround-custom",
    "whackamole-custom",
    "deflection-custom",
    "frogs-custom",
    "deceptizelda-custom",
    "cec2-custom",
    "invest-custom",
    "labyrinthdual-custom",
    "realsokoban-custom",
    "superman-custom",
    "testgame2-custom",
    "lasers2-custom",
    "fireman-custom",
    "hungrybirds-custom",
    "crossfire-custom",
    "aliens-custom",
    "islands-custom",
    "testgame3-custom",
    "shipwreck-custom",
    "testgame1-custom",
    "zenpuzzle-custom",
    "modality-custom",
    "killBillVol1-custom",
    "boulderchase-custom",
    "defem-custom",
    "watergame-custom",
    "firecaster-custom",
    "dungeon-custom",
    "plants-custom",
    "investdie-custom",
    "chainreaction-custom",
    "assemblyline-custom",
    "chase-custom",
    "racebet2-custom",
    "wildgunman-custom",
    "sokoban-custom",
    "roguelike-custom",
    "lemmings-custom",
    "garbagecollector-custom",
    "clusters-custom",
    "beltmanager-custom",
    "waves-custom",
    "witnessprotection-custom",
    "theshepherd-custom",
    "run-custom",
    "factorymanager-custom",
    "cookmepasta-custom",
    "angelsdemons-custom",
    "cec3-custom",
    "doorkoban-custom",
    "plaqueattack-custom",
    "solarfox-custom",
    "avoidgeorge-custom",

]

for env in environments:

    register(
        id='gvgai-{}-v0'.format(env),
        entry_point='gvgai.gym:GVGAI_Env',
        kwargs={'environment_id': env},  # 'obs_type': obs_type
        max_episode_steps=2000
        # nondeterministic=nondeterministic,
        # Play with different setups here
    )