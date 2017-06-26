package com.mavaze.puzzles.bahubali.core.actions;

import java.util.ArrayList;
import java.util.List;

import com.mavaze.puzzles.bahubali.core.listener.MenusUpdateEvent;
import com.mavaze.puzzles.bahubali.core.listener.StateChangeListener;

@SuppressWarnings("serial")
public abstract class AbstractCompositeAction extends AbstractAction<Action> {
	
	private List<Action> actions = new ArrayList<>();
	
	public AbstractCompositeAction(StateChangeListener listener) {
		super(listener);
	}

	@Override
	protected List<Action> getActionMenus() {
		return actions;
	}

	@Override
	public void execute() {
		super.execute();
		MenusUpdateEvent event = new MenusUpdateEvent(getMenuName());
		event.setMenus(actions);
		listener.onMenusLayoutUpdated(event);
	}

	@Override
	protected void postExecute(Action action) {
		setNextAction(action);
	}
}
