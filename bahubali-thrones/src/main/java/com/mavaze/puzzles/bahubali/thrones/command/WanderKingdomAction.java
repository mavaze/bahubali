package com.mavaze.puzzles.bahubali.thrones.command;

import java.util.ArrayList;
import java.util.List;

import com.mavaze.puzzles.bahubali.core.action.AbstractAction;
import com.mavaze.puzzles.bahubali.core.commands.BackAction;
import com.mavaze.puzzles.bahubali.core.commands.EchoAction;
import com.mavaze.puzzles.bahubali.core.domain.Character;
import com.mavaze.puzzles.bahubali.core.domain.Entity;
import com.mavaze.puzzles.bahubali.core.listener.MenusUpdateEvent;

public class WanderKingdomAction extends AbstractAction {

	private List<Entity> entities = new ArrayList<>();
	
	@Override
	public String getMenuName() {
		return "Wander Kingdom";
	}
	
	public WanderKingdomAction(List<Entity> entities) {
		for(Entity entity : entities) {
			if (!(entity instanceof Character)) {
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
			Entity entity = entities.get(selectedOption - 1);
			new EchoAction("You visited " + entity.getMenuName()).builder().listener(listener).nextAction(this).build().execute();
		} else if (backAction != null && selectedOption == entities.size() + 1) {
			backAction.execute();
		} else {
			throw new NumberFormatException("Invalid option selected.");
		}
	}

}
