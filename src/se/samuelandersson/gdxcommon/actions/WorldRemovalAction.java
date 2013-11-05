package se.samuelandersson.gdxcommon.actions;

public class WorldRemovalAction extends BaseAction {

	WorldRemovalAction() {
	}

	@Override
	public boolean update(float delta) {
		entity.deleteFromWorld();
		return true;
	}

}
