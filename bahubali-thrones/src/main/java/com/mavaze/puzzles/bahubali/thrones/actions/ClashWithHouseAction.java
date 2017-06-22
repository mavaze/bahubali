package com.mavaze.puzzles.bahubali.thrones.actions;

import java.util.ArrayList;
import java.util.List;

import com.mavaze.puzzles.bahubali.core.actions.AbstractAction;
import com.mavaze.puzzles.bahubali.core.actions.BackAction;
import com.mavaze.puzzles.bahubali.core.actions.EchoAction;
import com.mavaze.puzzles.bahubali.core.actions.FightAction;
import com.mavaze.puzzles.bahubali.core.character.GameCharacter;
import com.mavaze.puzzles.bahubali.core.domain.GameEntity;
import com.mavaze.puzzles.bahubali.core.listener.MenusUpdateEvent;
import com.mavaze.puzzles.bahubali.core.listener.StatisticsUpdateEvent;

public class ClashWithHouseAction extends AbstractAction {

	private static final long serialVersionUID = 7539129148070267448L;

	private List<GameCharacter> houses = new ArrayList<>();

	@Override
	public String getMenuName() {
		return "Clash of Houses";
	}

	public ClashWithHouseAction(List<GameEntity> entities) {
		for (GameEntity entity : entities) {
			if (entity instanceof GameCharacter) {
				houses.add((GameCharacter) entity);
			}
		}
	}

	@Override
	public void execute() {
		super.execute();
		removeDeadHouses();
		MenusUpdateEvent event = new MenusUpdateEvent(getMenuName());
		event.setMenus(houses);
		event.addMenu(new BackAction(backAction));
		listener.onMenusLayoutUpdated(event);
	}

	@Override
	public void postExecute(String response) {
		int selectedOption = Integer.parseInt(response);
		if (selectedOption > 0 && selectedOption <= houses.size()) {
			GameCharacter house = houses.get(selectedOption - 1);
			FightAction fight = (FightAction) new FightAction().builder().listener(listener).build();
			fight.setOpponent(house);
			fight.execute();
			listener.onStatisticsUpdated(new StatisticsUpdateEvent());
			new EchoAction("You fought with " + house.getMenuName()).builder().listener(listener).nextAction(this).build().execute();
		} else if (backAction != null && selectedOption == houses.size() + 1) {
			backAction.execute();
		} else {
			throw new NumberFormatException("Invalid option selected.");
		}
	}

	private void removeDeadHouses() {
		houses.removeIf(house -> !((GameCharacter) house).isAlive());
	}
}