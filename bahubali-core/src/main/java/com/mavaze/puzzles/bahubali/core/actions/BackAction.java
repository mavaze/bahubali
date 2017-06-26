package com.mavaze.puzzles.bahubali.core.actions;

import com.mavaze.puzzles.bahubali.core.domain.MenuItem;

public class BackAction extends AbstractAction<MenuItem> {
		
	private static final long serialVersionUID = 4132140587469546261L;

	public BackAction(Action backAction) {
		this.backAction = backAction;
	}

	@Override
	public String getMenuName() {
		return "Back";
	}
	
	@Override
	public void execute() {
		backAction.execute();
	}

}