package com.mavaze.puzzles.bahubali.core.actions;

import java.util.ArrayList;
import java.util.List;

import com.mavaze.puzzles.bahubali.core.character.Player;
import com.mavaze.puzzles.bahubali.core.context.GameContextHolder;
import com.mavaze.puzzles.bahubali.core.listener.MenusUpdateEvent;
import com.mavaze.puzzles.bahubali.core.listener.StateChangeListener;

public class PlayerCompositeAction extends AbstractAction {

	private static final long serialVersionUID = 2994719569827543382L;

	private List<Action> actions = new ArrayList<>();

	@Override
	public String getMenuName() {
		return "Player Actions";
	}
	
	public PlayerCompositeAction() { }

	public PlayerCompositeAction(StateChangeListener listener) {
		super(listener);
		Player player = GameContextHolder.getContext().getActivePlayer();
		for (Action action : player.getActions()) {
			Action updated = ((AbstractAction) action).builder().backAction(this).listener(listener).build();
			actions.add(updated);
		}
		actions.add(new QuitAndSaveAction().builder().listener(listener).build());
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
		if (selectedOption > 0 || selectedOption <= actions.size() + 1) {
			actions.get(selectedOption - 1).execute();
		} else {
			throw new NumberFormatException("Invalid option selected.");
		}
	}

}
