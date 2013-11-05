package se.samuelandersson.gdxcommon.actions;

import com.badlogic.gdx.math.Interpolation;

public abstract class RelativeTemporalAction extends TemporalAction {

	protected float lastPercent;
	
	public RelativeTemporalAction(float duration, Interpolation interpolation) {
		super(duration, interpolation);
	}
	
	@Override
	protected void begin() {
		lastPercent = 0;
	}

	@Override
	protected void updateValues(float percent) {
		updateRelative(percent - lastPercent);
		lastPercent = percent;
	}
	
	protected abstract void updateRelative(float percentDelta);

}
