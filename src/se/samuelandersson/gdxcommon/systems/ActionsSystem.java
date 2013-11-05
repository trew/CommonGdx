package se.samuelandersson.gdxcommon.systems;

import se.samuelandersson.gdxcommon.actions.BaseAction;
import se.samuelandersson.gdxcommon.components.ActionContainer;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.utils.Array;

public class ActionsSystem extends EntityProcessingSystem {

	@Mapper
	ComponentMapper<ActionContainer> am;

	public ActionsSystem() {
		super(Aspect.getAspectForAll(ActionContainer.class));
	}

	@Override
	protected void process(Entity e) {
		ActionContainer actionContainer = am.get(e);
		float delta = world.getDelta();
		Array<BaseAction> entityActions = actionContainer.getActions();
		if (entityActions.size == 0) return;

		for (int i = 0; i < entityActions.size; i++) {
			BaseAction action = entityActions.get(i);
			action.setEntity(e);
			boolean completed = action.update(delta);
			if (completed) entityActions.removeIndex(i--);
		}
	}
}
