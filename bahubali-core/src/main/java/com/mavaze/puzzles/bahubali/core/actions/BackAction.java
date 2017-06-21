package com.mavaze.puzzles.bahubali.core.actions;

public class BackAction extends AbstractAction {
		
	private static final long serialVersionUID = 4132140587469546261L;

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