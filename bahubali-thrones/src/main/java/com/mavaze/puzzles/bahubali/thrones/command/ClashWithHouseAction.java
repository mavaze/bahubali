package com.mavaze.puzzles.bahubali.thrones.command;

import java.util.ArrayList;
import java.util.List;

import com.mavaze.puzzles.bahubali.core.action.AbstractAction;
import com.mavaze.puzzles.bahubali.core.commands.BackAction;
import com.mavaze.puzzles.bahubali.core.commands.EchoAction;
import com.mavaze.puzzles.bahubali.core.domain.Character;
import com.mavaze.puzzles.bahubali.core.domain.Entity;
import com.mavaze.puzzles.bahubali.core.listener.MenusUpdateEvent;

public class ClashWithHouseAction extends AbstractAction {

	private List<Character> houses = new ArrayList<>();

	@Override
	public String getMenuName() {
		return "Clash of Houses";
	}

	public ClashWithHouseAction(List<Entity> entities) {
		for (Entity entity : entities) {
			if (entity instanceof Character) {
				houses.add((Character) entity);
			}
		}
	}

	@Override
	public void execute() {
		super.execute();
		MenusUpdateEvent event = new MenusUpdateEvent(getMenuName());
		event.setMenus(houses);
		event.addMenu(new BackAction(backAction));
		listener.onMenusLayoutUpdated(event);
	}

	@Override
	public void postExecute(String response) {
		int selectedOption = Integer.parseInt(response);
		if (selectedOption > 0 && selectedOption <= houses.size()) {
			Character house = houses.get(selectedOption - 1);
			new EchoAction("You fought with " + house.getMenuName()).builder().listener(listener).nextAction(this).build().execute();
		} else if (backAction != null && selectedOption == houses.size() + 1) {
			backAction.execute();
		} else {
			throw new NumberFormatException("Invalid option selected.");
		}
	}

}