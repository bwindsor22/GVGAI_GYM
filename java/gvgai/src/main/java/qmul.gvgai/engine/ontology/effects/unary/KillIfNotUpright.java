package qmul.gvgai.engine.ontology.effects.unary;

import qmul.gvgai.engine.core.vgdl.VGDLSprite;
import qmul.gvgai.engine.core.content.InteractionContent;
import qmul.gvgai.engine.core.game.Game;
import qmul.gvgai.engine.ontology.effects.Effect;


public class KillIfNotUpright extends Effect
{
	
    public KillIfNotUpright(InteractionContent cnt)
    {
        is_kill_effect = true;
        this.parseParameters(cnt);
    }

    @Override
    public void execute(VGDLSprite sprite1, VGDLSprite sprite2, Game game)
    {
    	double current_rotation = ((sprite1.rotation+2*Math.PI)%(2*Math.PI));
    	if (!(current_rotation < 5.0 && current_rotation > 4.4)){
    		game.killSprite(sprite1, false);
    	}
    }
}
