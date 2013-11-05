package se.samuelandersson.gdxcommon.actions;

import com.artemis.ComponentType;
import com.badlogic.gdx.math.Interpolation;

import se.samuelandersson.gdxcommon.components.SpriteComponent;

public class ScaleToAction extends TemporalAction {

	protected float startX;
	protected float startY;
	protected float endX;
	protected float endY;

	protected ComponentType spatialType;
	protected SpriteComponent sprite;

	ScaleToAction(float scaleX, float scaleY, float duration, Interpolation interpolation) {
		super(duration, interpolation);
		spatialType = ComponentType.getTypeFor(SpriteComponent.class);
		endX = scaleX;
		endY = scaleY;
	}

	@Override
	protected void begin() {
		sprite = (SpriteComponent) entity.getComponent(spatialType);
		if (sprite == null) {
			completed = true;
			return;
		}
		startX = sprite.scaleX;
		startY = sprite.scaleY;
	}

	@Override
	protected void updateValues(float percent) {
		sprite.scaleX = startX + (endX - startX) * percent;
		sprite.scaleY = startY + (endY - startY) * percent;
	}

}
