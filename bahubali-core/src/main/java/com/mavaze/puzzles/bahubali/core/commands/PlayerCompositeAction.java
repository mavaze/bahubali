package com.mavaze.puzzles.bahubali.core.commands;

import java.util.ArrayList;
import java.util.List;

import com.mavaze.puzzles.bahubali.core.action.AbstractAction;
import com.mavaze.puzzles.bahubali.core.action.Action;
import com.mavaze.puzzles.bahubali.core.context.GameContextHolder;
import com.mavaze.puzzles.bahubali.core.listener.MenusUpdateEvent;
import com.mavaze.puzzles.bahubali.core.listener.StateChangeListener;
import com.mavaze.puzzles.bahubali.core.player.Player;

public class PlayerCompositeAction extends AbstractAction {

	private List<Action> actions = new ArrayList<>();

	@Override
	public String getMenuName() {
		return "Player Actions";
	}

	public PlayerCompositeAction(StateChangeListener listener) {
		super(listener);
		Player player = GameContextHolder.getContext().getPlayer();
		for (Action action : player.getActions()) {
			Action updated = ((AbstractAction) action).builder().backAction(this).listener(listener).build();
			actions.add(updated);
		}
		actions.add(new QuitAndSaveAction());
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
