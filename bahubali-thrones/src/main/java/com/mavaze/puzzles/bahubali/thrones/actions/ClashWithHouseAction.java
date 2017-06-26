package com.mavaze.puzzles.bahubali.thrones.actions;

import java.util.ArrayList;
import java.util.List;

import com.mavaze.puzzles.bahubali.core.actions.AbstractAction;
import com.mavaze.puzzles.bahubali.core.actions.BackAction;
import com.mavaze.puzzles.bahubali.core.actions.FightAction;
import com.mavaze.puzzles.bahubali.core.character.GameCharacter;
import com.mavaze.puzzles.bahubali.core.domain.GameEntity;
import com.mavaze.puzzles.bahubali.core.listener.MenusUpdateEvent;
import com.mavaze.puzzles.bahubali.core.listener.StatisticsUpdateEvent;

public class ClashWithHouseAction extends AbstractAction<GameCharacter> {

	private static final long serialVersionUID = 7539129148070267448L;

	private List<GameCharacter> houses = new ArrayList<>();

	public ClashWithHouseAction(List<GameEntity> entities) {
		for (GameEntity entity : entities) {
			if (entity instanceof GameCharacter) {
				houses.add((GameCharacter) entity);
			}
		}
	}
	
	@Override
	public String getMenuName() {
		return "Clash of Houses";
	}
	
	@Override
	protected List<GameCharacter> getActionMenus() {
		return houses;
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
	protected void postExecute(GameCharacter house) {
		FightAction fight = (FightAction) new FightAction().builder().listener(listener).backAction(this).build();
		fight.setOpponent(house);
		fight.execute();
		listener.onStatisticsUpdated(new StatisticsUpdateEvent().builder().build());
	}

	private void removeDeadHouses() {
		houses.removeIf(house -> !house.isAlive());
	}
}