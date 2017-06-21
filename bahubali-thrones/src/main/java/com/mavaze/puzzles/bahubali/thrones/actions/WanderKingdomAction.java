package com.mavaze.puzzles.bahubali.thrones.actions;

import java.util.ArrayList;
import java.util.List;

import com.mavaze.puzzles.bahubali.core.actions.AbstractAction;
import com.mavaze.puzzles.bahubali.core.actions.BackAction;
import com.mavaze.puzzles.bahubali.core.actions.EchoAction;
import com.mavaze.puzzles.bahubali.core.character.GameCharacter;
import com.mavaze.puzzles.bahubali.core.domain.GameEntity;
import com.mavaze.puzzles.bahubali.core.listener.MenusUpdateEvent;

public class WanderKingdomAction extends AbstractAction {

	private static final long serialVersionUID = -7905920327656346508L;

	private List<GameEntity> entities = new ArrayList<>();
	
	@Override
	public String getMenuName() {
		return "Wander Kingdom";
	}
	
	public WanderKingdomAction(List<GameEntity> entities) {
		for(GameEntity entity : entities) {
			if (!(entity instanceof GameCharacter)) {
				this.entities.add(entity);
			}
		}
	}

	@Override
	public void execute() {
		super.execute();
		MenusUpdateEvent event = new MenusUpdateEvent(getMenuName());
		event.setMenus(entities);
		event.addMenu(new BackAction(backAction));
		listener.onMenusLayoutUpdated(event);
	}
	
	@Override
	public void postExecute(String response) {
		int selectedOption = Integer.parseInt(response);
		if (selectedOption > 0 && selectedOption <= entities.size()) {
			GameEntity entity = entities.get(selectedOption - 1);
			new EchoAction("You visited " + entity.getMenuName()).builder().listener(listener).nextAction(this).build().execute();
		} else if (backAction != null && selectedOption == entities.size() + 1) {
			backAction.execute();
		} else {
			throw new NumberFormatException("Invalid option selected.");
		}
	}

}
