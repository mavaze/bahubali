package com.mavaze.puzzles.bahubali.core.commands;

import com.mavaze.puzzles.bahubali.core.action.AbstractAction;
import com.mavaze.puzzles.bahubali.core.listener.StateChangeListener;

public class CreatePlayerAction extends AbstractAction {
		
	public CreatePlayerAction(StateChangeListener listener) {
		super(listener);
	}

	@Override
	public void execute() {
		
	}

	@Override
	public String getActionName() {
		return "Enter player name";
	}

}