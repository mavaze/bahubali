package com.mavaze.puzzles.bahubali.core.actions;

import com.mavaze.puzzles.bahubali.core.character.Player;
import com.mavaze.puzzles.bahubali.core.context.GameContextHolder;
import com.mavaze.puzzles.bahubali.core.listener.StateChangeListener;

@SuppressWarnings("rawtypes")
public class PlayerCompositeAction extends AbstractCompositeAction {

	private static final long serialVersionUID = 2994719569827543382L;
	
	public PlayerCompositeAction(StateChangeListener listener) {
		super(listener);
		Player player = GameContextHolder.getContext().getActivePlayer();
		for (Action action : player.getActions()) {
			Action updated = ((AbstractAction) action).builder().backAction(this).listener(listener).build();
			getActionMenus().add(updated);
		}
		getActionMenus().add(new QuitAndSaveAction(listener));
	}

	@Override
	public String getMenuName() {
		return "Player Actions";
	}
}
