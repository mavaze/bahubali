package com.mavaze.puzzles.bahubali.core.commands;

import com.mavaze.puzzles.bahubali.core.action.AbstractAction;
import com.mavaze.puzzles.bahubali.core.listener.StateChangeListener;

public class SaveGameAction extends AbstractAction {
		
	public SaveGameAction(StateChangeListener listener) {
		super(listener);
	}
	
	@Override
	public void execute() {
//		SnapshotDaoSerializer.save();
		
	}

	@Override
	public String getActionName() {
		return "Save Game";
	}


}
