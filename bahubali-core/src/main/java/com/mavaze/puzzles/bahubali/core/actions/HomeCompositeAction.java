package com.mavaze.puzzles.bahubali.core.actions;

import java.util.ArrayList;
import java.util.List;

import com.mavaze.puzzles.bahubali.core.listener.MenusUpdateEvent;
import com.mavaze.puzzles.bahubali.core.listener.StateChangeListener;

public class HomeCompositeAction extends AbstractAction {

	private static final long serialVersionUID = -7870351529488397656L;

	private List<Action> actions = new ArrayList<>();

	@Override
	public String getMenuName() {
		return "Welcome to Bahubali !!!";
	}

	public HomeCompositeAction(StateChangeListener listener) {

		super(listener);

		Action newGameAction = new NewGameAction(listener).builder().backAction(this).build();
		Action loadGameAction = new LoadGameAction(listener).builder().backAction(this).build();
		Action exitGameAction = new ExitGameAction().builder().listener(listener).build();

		actions.add(newGameAction);
		actions.add(loadGameAction);
		actions.add(exitGameAction);
	}

	@Override
	public void execute() {
		super.execute();
		MenusUpdateEvent event = new MenusUpdateEvent(getMenuName());
		event.setMenus(actions);
		listener.onMenusLayoutUpdated(event);
	}

	@Override
	public void postExecute(String response) {
		int selectedOption = Integer.parseInt(response);
		if (selectedOption > 0 || selectedOption <= actions.size()) {
			actions.get(selectedOption - 1).execute();
		} else {
			throw new NumberFormatException("Invalid option selected.");
		}

	}

}
