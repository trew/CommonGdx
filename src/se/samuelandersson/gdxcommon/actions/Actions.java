
package se.samuelandersson.gdxcommon.actions;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Interpolation;

/** Returns actions that are processed in the {@link ActionsSystem}.
 * 
 * @author Samuel Andersson */
public class Actions {

	private Actions () {
	}

	public static DelayAction delay (float time) {
		DelayAction action = new DelayAction();
		action.setDelay(time);
		return action;
	}

	public static ScaleToAction scaleTo (float x, float y) {
		return scaleTo(x, y, 0, null);
	}

	public static ScaleToAction scaleTo (float x, float y, float duration) {
		return scaleTo(x, y, duration, null);
	}

	public static ScaleToAction scaleTo (float x, float y, float duration, Interpolation interpolation) {
		return new ScaleToAction(x, y, duration, interpolation);
	}

	public static MoveToAction moveTo (float x, float y) {
		return moveTo(x, y, 0, null);
	}

	public static MoveToAction moveTo (float x, float y, float duration) {
		return moveTo(x, y, duration, null);
	}

	public static MoveToAction moveTo (float x, float y, float duration, Interpolation interpolation) {
		return new MoveToAction(x, y, duration, interpolation);
	}

	public static RotateToAction rotateTo (float value) {
		return rotateTo(value, 0, null);
	}

	public static RotateToAction rotateTo (float value, float duration) {
		return rotateTo(value, duration, null);
	}

	public static RotateToAction rotateTo (float value, float duration, Interpolation interpolation) {
		return new RotateToAction(value, duration, interpolation);
	}

	public static ScaleByAction scaleBy (float x, float y) {
		return scaleBy(x, y, 0, null);
	}

	public static ScaleByAction scaleBy (float x, float y, float duration) {
		return scaleBy(x, y, duration, null);
	}

	public static ScaleByAction scaleBy (float x, float y, float duration, Interpolation interpolation) {
		return new ScaleByAction(x, y, duration, interpolation);
	}

	public static MoveByAction moveBy (float x, float y) {
		return moveBy(x, y, 0, null);
	}

	public static MoveByAction moveBy (float x, float y, float duration) {
		return moveBy(x, y, duration, null);
	}

	public static MoveByAction moveBy (float x, float y, float duration, Interpolation interpolation) {
		return new MoveByAction(x, y, duration, interpolation);
	}

	public static RotateByAction rotateBy (float amount) {
		return rotateBy(amount, 0, null);
	}

	public static RotateByAction rotateBy (float amount, float duration) {
		return rotateBy(amount, duration, null);
	}

	public static RotateByAction rotateBy (float amount, float duration, Interpolation interpolation) {
		return new RotateByAction(amount, duration, interpolation);
	}

	public static ColorAction color (Color color) {
		return color(color, 0, null);
	}

	public static ColorAction color (Color color, float duration) {
		return color(color, duration, null);
	}

	public static ColorAction color (Color color, float duration, Interpolation interpolation) {
		return new ColorAction(color, duration, interpolation);
	}

	public static SequenceAction sequence () {
		return new SequenceAction();
	}

	public static ParallelAction parallel () {
		return new ParallelAction();
	}

	public static WorldRemovalAction remove () {
		return new WorldRemovalAction();
	}
}
