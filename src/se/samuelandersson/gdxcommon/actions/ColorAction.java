
package se.samuelandersson.gdxcommon.actions;

import se.samuelandersson.gdxcommon.components.SpriteComponent;

import com.artemis.ComponentType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Interpolation;

public class ColorAction extends TemporalAction {

	private final Color start = new Color();
	private Color currentColor;
	private final Color end = new Color();
	
	protected SpriteComponent sprite;
	protected ComponentType spriteType;

	public ColorAction (Color endColor, float duration, Interpolation interpolation) {
		super(duration, interpolation);
		end.set(endColor);
		spriteType = ComponentType.getTypeFor(SpriteComponent.class);
	}

	@Override
	protected void begin () {
		super.begin();
		sprite = (SpriteComponent)entity.getComponent(spriteType);
		currentColor = sprite.color;
		start.set(currentColor);
	}

	@Override
	protected void updateValues (float percent) {
		currentColor.r = start.r + (end.r - start.r) * percent;
		currentColor.g = start.g + (end.g - start.g) * percent;
		currentColor.b = start.b + (end.b - start.b) * percent;
		currentColor.a = start.a + (end.a - start.a) * percent;
	}

}
