package qmul.gvgai.engine.core.player;

import java.awt.Graphics2D;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import qmul.gvgai.engine.core.game.Game;
import qmul.gvgai.engine.core.game.StateObservation;
import qmul.gvgai.engine.core.game.StateObservationMulti;
import qmul.gvgai.engine.ontology.Types;
import qmul.gvgai.engine.tools.ElapsedCpuTimer;

/**
 * Created with IntelliJ IDEA.
 * User: ssamot
 * Date: 14/11/13
 * Time: 13:42
 * This is a Java port from Tom Schaul's VGDL - https://github.com/schaul/py-vgdl
 */

/**
 * Subclass of Player, for Single Player games.
 * Implements multi player act method (returns NULL).
 */
public abstract class AbstractPlayer extends Player {

    public Types.ACTIONS act(StateObservationMulti stateObs, ElapsedCpuTimer elapsedTimer) {
        return Types.ACTIONS.ACTION_NIL;
    }

}
