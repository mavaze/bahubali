package com.mavaze.puzzles.bahubali.core.commands;

import com.mavaze.puzzles.bahubali.core.action.AbstractAction;
import com.mavaze.puzzles.bahubali.core.action.Action;

public class BackAction extends AbstractAction {
		
	public BackAction(Action backAction) {
		this.backAction = backAction;
	}

	@Override
	public void execute() {
		backAction.execute();
	}

	@Override
	public String getMenuName() {
		return "Back";
	}

}