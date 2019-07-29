package qmul.gvgai.engine.core.player;

import com.badlogic.gdx.graphics.Pixmap;
import qmul.gvgai.engine.core.game.Game;
import qmul.gvgai.engine.core.game.StateObservation;
import qmul.gvgai.engine.core.game.StateObservationMulti;
import qmul.gvgai.engine.ontology.Types;
import qmul.gvgai.engine.tools.ElapsedCpuTimer;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public abstract class Player {

    /**
     * playerID
     */
    private int playerID;

    /**
     * File where the actions played in a given game are stored.
     */
    private String actionFile;

    /**
     * Writer for the actions file.
     */
    private BufferedWriter writer;

    /**
     * Set this variable to FALSE to avoid core.logging the actions to a file.
     */
    private static final boolean SHOULD_LOG = true;

    /**
     * Last action executed by this agent.
     */
    private Types.ACTIONS lastAction = null;

    /**
     * List of actions to be dumped.
     */
    private ArrayList<Types.ACTIONS> allActions;

    /**
     * Random seed of the game.
     */
    private int randomSeed;

    /**
     * Is this a human player?
     */
    private boolean isHuman;

    /**
     * Picks an action. This function is called every game step to request an
     * action from the player. The action returned must be contained in the
     * actions accessible from stateObs.getAvailableActions(), or no action
     * will be applied.
     * Single Player method.
     * @param stateObs Observation of the current state.
     * @param elapsedTimer Timer when the action returned is due.
     * @return An action for the current state
     */
    public abstract Types.ACTIONS act(StateObservation stateObs, ElapsedCpuTimer elapsedTimer);

    /**
     * Used in learning agents to send observations of the state directly after an action has been performed
     */
    public void observe(StateObservation stateObservation) {
    }

    /**
     * Picks an action. This function is called every game step to request an
     * action from the player. The action returned must be contained in the
     * actions accessible from stateObs.getAvailableActions(), or no action
     * will be applied.
     * Multi player method.
     * @param stateObs Observation of the current state.
     * @param elapsedTimer Timer when the action returned is due.
     * @return An action for the current state
     */
    public abstract Types.ACTIONS act(StateObservationMulti stateObs, ElapsedCpuTimer elapsedTimer);


    /**
     * Function called when the game is over. This method must finish before CompetitionParameters.TEAR_DOWN_TIME,
     *  or the agent will be DISQUALIFIED
     * @param stateObs the game state at the end of the game
     * @param elapsedCpuTimer timer when this method is meant to finish.
     */
    public void result(StateObservation stateObs, ElapsedCpuTimer elapsedCpuTimer)
    {
    }

    public void resultMulti(StateObservationMulti stateObs, ElapsedCpuTimer elapsedCpuTimer)
    {
    }

    /**
     * This function sets up the controller to save the actions executed in a given game.
     * @param randomSeed Seed for the sampleRandom generator of the game to be played.
     * @param isHuman Indicates if the player is a human or not.
     */
    public void setup(int randomSeed, boolean isHuman) {
        this.randomSeed = randomSeed;
        this.isHuman = isHuman;

    }

    /**
     * Closes the agent, writing actions to file.
     */
    public void teardown(Game played) {
        try {
            if((this.actionFile != null && !actionFile.equals("")) && SHOULD_LOG) {
                writer = new BufferedWriter(new FileWriter(new File(this.actionFile)));
                writer.write(randomSeed +
                        " " + (played.getWinner() == Types.WINNER.PLAYER_WINS ? 1 : 0) +
                        " " + played.getScore() + " " + played.getGameTick() + "\n");

                for(Types.ACTIONS act : allActions)
                    writer.write(act.toString() + "\n");

                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Logs a single action
     * @param action the action to log.
     */
    final public void logAction(Types.ACTIONS action) {

        lastAction = action;
        if(this.actionFile!=null && SHOULD_LOG)
        {
            allActions.add(action);
        }

    }

    /**
     * Gets the last action executed by this controller.
     * @return the last action
     */
    public Types.ACTIONS getLastAction()
    {
        return lastAction;
    }

    /**
     * Indicates if this player is human controlled.
     * @return true if the player is human.
     */
    public boolean isHuman() { return isHuman;}

    /**
     * @return the ID of this player
     */
    public int getPlayerID() { return playerID; }

    /**
     * Set the ID of this player.
     * @param id - the player's ID
     */
    public void setPlayerID(int id) { playerID = id; }

    /**
     * Get the history of actions of this player.
     * @return arrayList of all actions
     */
    public ArrayList<Types.ACTIONS> getAllActions() { return allActions; }

    /**
     * Gets the player the control to draw something on the screen.
     * It can be used for debug purposes.
     * @param g Graphics device to draw to.
     */
    public void draw(Pixmap g)
    {
        //Overwrite this method in your controller to draw on the screen.
        //This method should be left empty in this class.
    }
}
