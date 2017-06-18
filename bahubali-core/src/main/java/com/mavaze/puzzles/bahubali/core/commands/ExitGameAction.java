package com.mavaze.puzzles.bahubali.core.commands;

import com.mavaze.puzzles.bahubali.core.action.AbstractAction;
import com.mavaze.puzzles.bahubali.core.listener.StateChangeListener;

public class ExitGameAction extends AbstractAction {
	
	public ExitGameAction(StateChangeListener listener) {
		super(listener);
	}

	@Override
	public void execute() {
		System.exit(0);		
	}

	@Override
	public String getActionName() {
		return "Exit";
	}

}
