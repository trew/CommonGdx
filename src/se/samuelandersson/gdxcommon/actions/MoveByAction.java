package se.samuelandersson.gdxcommon.actions;

import se.samuelandersson.gdxcommon.components.SpriteComponent;

import com.artemis.ComponentType;
import com.badlogic.gdx.math.Interpolation;

public class MoveByAction extends RelativeTemporalAction {

	protected float amountX, amountY;
	
	protected ComponentType spriteType;
	protected SpriteComponent sprite;
	
	public MoveByAction(float amountX, float amountY, float duration, Interpolation interpolation) {
		super(duration, interpolation);
		spriteType = ComponentType.getTypeFor(SpriteComponent.class);
		this.amountX = amountX;
		this.amountY = amountY;
	}

	@Override
	protected void begin() {
		sprite = (SpriteComponent) entity.getComponent(spriteType);
		if (sprite == null) {
			completed = true;
			return;
		}
		super.begin();
	}
	
	@Override
	protected void updateRelative(float percentDelta) {
		sprite.x += amountX * percentDelta;
		sprite.y += amountY * percentDelta;
	}

}
