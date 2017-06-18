package com.mavaze.puzzles.bahubali.core.layout;

import java.util.List;
import java.util.Map;

import com.mavaze.puzzles.bahubali.core.action.Action;

public class ActionsLayout extends TextLayout {

	public static final String KEY = "ACTIONS";

	public ActionsLayout(int x1, int y1, int x2, int y2) {
		super(x1, y1, x2, y2);
	}
	
	private void update(List<Action> actions) {
		int y = y1 + 3;
		for(Action action : actions) {
			this.setStringAt(x1+3, y++, action.getActionName());
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public void updateState(Map<String, Object> state) {
		if(state.containsKey(ActionsLayout.KEY)) {
			List<Action> actions = (List<Action>) state.get(ActionsLayout.KEY);
			update(actions);
		}
	}
	
}
