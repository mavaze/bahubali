package com.mavaze.puzzles.bahubali.core.actions;

import com.mavaze.puzzles.bahubali.core.listener.StateChangeListener;

public class HomeCompositeAction extends AbstractCompositeAction {

	private static final long serialVersionUID = -7870351529488397656L;

	public HomeCompositeAction(StateChangeListener listener) {

		super(listener);

		Action newGameAction = new NewGameAction(listener).builder().backAction(this).build();
		Action loadGameAction = new LoadGameAction(listener).builder().backAction(this).build();
		Action exitGameAction = new ExitGameAction().builder().listener(listener).build();

		getActionMenus().add(newGameAction);
		getActionMenus().add(loadGameAction);
		getActionMenus().add(exitGameAction);
	}
	
	@Override
	public String getMenuName() {
		return "Welcome to Bahubali !!!";
	}
}
