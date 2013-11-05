
package se.samuelandersson.gdxcommon.actions;

import se.samuelandersson.gdxcommon.components.SpriteComponent;

import com.artemis.ComponentType;
import com.badlogic.gdx.math.Interpolation;

public class RotateByAction extends RelativeTemporalAction {

	protected float amount;

	protected ComponentType spriteType;
	protected SpriteComponent sprite;

	public RotateByAction (float amount, float duration, Interpolation interpolation) {
		super(duration, interpolation);
		spriteType = ComponentType.getTypeFor(SpriteComponent.class);
		this.amount = amount;
	}

	@Override
	protected void begin () {
		sprite = (SpriteComponent)entity.getComponent(spriteType);
		if (sprite == null) {
			completed = true;
			return;
		}
		super.begin();
	}

	@Override
	protected void updateRelative (float percentDelta) {
		sprite.angle += amount * percentDelta;
	}

}
