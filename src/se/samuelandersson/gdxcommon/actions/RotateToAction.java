package se.samuelandersson.gdxcommon.actions;

import se.samuelandersson.gdxcommon.components.SpriteComponent;

import com.artemis.ComponentType;
import com.badlogic.gdx.math.Interpolation;

public class RotateToAction extends TemporalAction {

	protected float start, end;
	
	ComponentType spriteType;
	SpriteComponent sprite;
	
	public RotateToAction(float rotation, float duration, Interpolation interpolation) {
		super(duration, interpolation);
		spriteType = ComponentType.getTypeFor(SpriteComponent.class);
		end = rotation;
	}
	
	@Override
	protected void begin() {
		sprite = (SpriteComponent) entity.getComponent(spriteType);
		if (sprite == null) {
			completed = true;
			return;
		}
		start = sprite.angle;
	}

	@Override
   protected void updateValues(float percent) {
		sprite.angle = start + (end - start) * percent;
   }

}
