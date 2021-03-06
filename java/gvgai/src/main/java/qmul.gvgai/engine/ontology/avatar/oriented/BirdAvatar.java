package qmul.gvgai.engine.ontology.avatar.oriented;

import java.awt.Dimension;

import qmul.gvgai.engine.core.vgdl.VGDLSprite;
import qmul.gvgai.engine.core.content.SpriteContent;
import qmul.gvgai.engine.core.game.Game;
import qmul.gvgai.engine.ontology.Types;
import qmul.gvgai.engine.tools.Direction;
import qmul.gvgai.engine.tools.Utils;
import qmul.gvgai.engine.tools.Vector2d;


public class BirdAvatar extends OrientedAvatar
{
	
    public BirdAvatar(){}

    public BirdAvatar(Vector2d position, Dimension size, SpriteContent cnt)
    {
        //Init the sprite
        this.init(position, size);

        //Specific class default parameter values.
        loadDefaults();

        //Parse the arguments.
        this.parseParameters(cnt);
    }


    protected void loadDefaults()
    {
        super.loadDefaults();
        draw_arrow = true;
        jump_strength = 10;
    }


    /**
     * This update call is for the game tick() loop.
     * @param game current state of the game.
     */
    public void updateAvatar(Game game, boolean requestInput, boolean[] actionMask)
    {
        super.updateAvatar(game, requestInput, actionMask);
        
        Direction action2 = new Direction (0.0,0.0);
        
        if (Math.abs(this.orientation.x()) < 0.5)
    		action2 = new Direction (1.0,0.0);

        if(Utils.processUseKey(getKeyHandler().getMask(), getPlayerID())) {
        	Direction action = new Direction (0,-jump_strength);
        	this.orientation = new Direction (this.orientation.x(),0.0);
        	this.physics.activeMovement(this, action, this.speed);
        }
        
        this.physics.activeMovement(this, action2, this.speed);
        
        this._updateRotation(Math.atan2(this.orientation.y(),this.orientation.x()));
    }
    
    public void postProcess()
    {
        //Define actions here first.
        if(actions.size()==0)
        {
            actions.add(Types.ACTIONS.ACTION_USE);
        }

        super.postProcess();
    }


    public VGDLSprite copy()
    {
        BirdAvatar newSprite = new BirdAvatar();
        this.copyTo(newSprite);
        return newSprite;
    }

    public void copyTo(VGDLSprite target)
    {
    	BirdAvatar targetSprite = (BirdAvatar) target;
        super.copyTo(targetSprite);
    }


}
