package se.samuelandersson.gdxcommon.actions;

import com.artemis.Entity;
import com.badlogic.gdx.utils.Array;

public class ParallelAction extends BaseAction {

	protected Array<BaseAction> actions = new Array<BaseAction>(4);
	private boolean complete;
	
	ParallelAction () {
	}

	@Override
	public boolean update (float delta) {
		if (complete) return true;
		complete = true;
		for (int i = 0, n = actions.size; i < n; i++) {
			if (!actions.get(i).update(delta)) complete = false;	
		}
		return complete;
	}
	
	@Override
	public void setEntity(Entity e) {
		super.setEntity(e);
		for (BaseAction a : actions) {
			a.setEntity(e);
		}
	}
	
	public ParallelAction addAction(BaseAction action) {
		actions.add(action);
		return this;
	}
}
