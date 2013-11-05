package se.samuelandersson.gdxcommon.actions;

public class DelayAction extends BaseAction {

	float time;
	float delay;
	
	DelayAction () {
	}
	
	public void setDelay(float delay) {
		this.delay = delay;
	}
	
	public float getDelay() {
		return delay;
	}

	@Override
	public boolean update (float delta) {
		time += delta;
		return (time >= delay);
	}

}
