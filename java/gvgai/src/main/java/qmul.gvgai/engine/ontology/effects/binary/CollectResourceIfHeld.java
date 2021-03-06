package qmul.gvgai.engine.ontology.effects.binary;

import lombok.extern.slf4j.Slf4j;
import qmul.gvgai.engine.core.content.InteractionContent;
import qmul.gvgai.engine.core.game.Game;
import qmul.gvgai.engine.core.vgdl.VGDLRegistry;
import qmul.gvgai.engine.core.vgdl.VGDLSprite;
import qmul.gvgai.engine.ontology.effects.Effect;
import qmul.gvgai.engine.ontology.sprites.Resource;

@Slf4j
public class CollectResourceIfHeld extends Effect {
    public boolean killResource; //Only if the resource is collected.
    public String heldResource;
    public int heldResourceId;
    public int value;

    public CollectResourceIfHeld(InteractionContent cnt) {
        value = 1;
        killResource = true;
        this.parseParameters(cnt);
        is_kill_effect = killResource;
        heldResourceId = VGDLRegistry.GetInstance().getRegisteredSpriteValue(heldResource);

    }

    @Override
    public void execute(VGDLSprite sprite1, VGDLSprite sprite2, Game game) {
        if (sprite1 == null || sprite2 == null) {
            log.warn("Neither the 1st nor 2nd sprite can be EOS with CollectResourceIfHeld interaction.");
            return;
        }

        if (sprite1.is_resource) {
            Resource r = (Resource) sprite1;
            applyScore = false;

            //Check if we have the secondary resource first
            int numResourcesHeld = sprite2.getAmountResource(heldResourceId);
            if (numResourcesHeld < value)
                return;

            int numResources = sprite2.getAmountResource(r.resource_type);
            if (numResources + r.value <= game.getResourceLimit(r.resource_type)) {
                applyScore = true;
                sprite2.modifyResource(r.resource_type, r.value);
            }

            if (killResource)
                //boolean variable set to false to indicate the sprite was not transformed
                game.killSprite(sprite1, false);
        }
    }
}
