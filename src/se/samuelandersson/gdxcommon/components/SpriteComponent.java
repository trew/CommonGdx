package se.samuelandersson.gdxcommon.components;

import com.artemis.Component;
import com.badlogic.gdx.graphics.Color;

public class SpriteComponent extends Component {

	public SpriteComponent(float x, float y, float w, float h) {
		this(x, y, w, h, Color.WHITE);
	}

	public SpriteComponent(float x, float y, float w, float h, Color c) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		color.set(c);
	}

	public final Color color = new Color();
	public float x;
	public float y;
	public float w;
	public float h;
	public float scaleX = 1;
	public float scaleY = 1;
	public float angle;
}
