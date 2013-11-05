package se.samuelandersson.gdxcommon.components;

import se.samuelandersson.gdxcommon.actions.BaseAction;

import com.artemis.Component;
import com.badlogic.gdx.utils.Array;

/**
 * Allows the owner of this component to have actions applied to them. see {@link Actions}
 * 
 * @author Samuel Andersson
 */
public class ActionContainer extends Component {
	protected Array<BaseAction> actions = new Array<BaseAction>();
	
	public void add(BaseAction action) {
		actions.add(action);
	}
	
	public Array<BaseAction> getActions() {
		return actions;
	}
}
