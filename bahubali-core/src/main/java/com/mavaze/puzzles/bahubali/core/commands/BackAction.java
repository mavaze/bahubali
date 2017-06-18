package com.mavaze.puzzles.bahubali.core.commands;

import com.mavaze.puzzles.bahubali.core.action.AbstractAction;
import com.mavaze.puzzles.bahubali.core.listener.StateChangeListener;

public class BackAction extends AbstractAction {
	
	public BackAction(StateChangeListener listener) {
		super(listener);
	}

	@Override
	public void execute() {
		backAction.execute();
	}

	@Override
	public String getActionName() {
		return "Back";
	}

}