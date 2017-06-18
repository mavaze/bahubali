package com.mavaze.puzzles.bahubali.core.commands;

import com.mavaze.puzzles.bahubali.core.action.AbstractAction;
import com.mavaze.puzzles.bahubali.core.listener.StateChangeListener;

public class LoadGameAction extends AbstractAction {

	public LoadGameAction(StateChangeListener listener) {
		super(listener);
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getActionName() {
		return "Load Game";
	}


}
