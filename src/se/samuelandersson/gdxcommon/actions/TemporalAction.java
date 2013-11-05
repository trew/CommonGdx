package se.samuelandersson.gdxcommon.actions;

import com.badlogic.gdx.math.Interpolation;

public abstract class TemporalAction extends BaseAction {

	protected float startX;
	protected float startY;
	protected float endX;
	protected float endY;

	protected float duration;
	protected float time;
	protected boolean completed = false;
	protected Interpolation interpolation;

	TemporalAction(float duration, Interpolation interpolation) {
		this.duration = duration;
		this.interpolation = interpolation;
	}

	protected void begin() {
	}
	
	protected void end() {
	}
	
	protected abstract void updateValues(float percent);
	
	@Override
	public boolean update(float delta) {
		if (completed) return true;
		if (time == 0) begin();

		time += delta;
		float percent;
		completed = time >= duration;
		if (completed) {
			percent = 1;
		} else {
			percent = time / duration;
			if (interpolation != null) percent = interpolation.apply(percent);
		}
		updateValues(percent);
		if (completed) end();
		return completed;
	}

}
