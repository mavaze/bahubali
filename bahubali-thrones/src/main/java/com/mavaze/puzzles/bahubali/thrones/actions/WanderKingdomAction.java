package com.mavaze.puzzles.bahubali.thrones.actions;

import java.util.ArrayList;
import java.util.List;

import com.mavaze.puzzles.bahubali.core.actions.AbstractAction;
import com.mavaze.puzzles.bahubali.core.actions.BackAction;
import com.mavaze.puzzles.bahubali.core.actions.EchoAction;
import com.mavaze.puzzles.bahubali.core.character.GameCharacter;
import com.mavaze.puzzles.bahubali.core.domain.GameEntity;
import com.mavaze.puzzles.bahubali.core.listener.MenusUpdateEvent;

public class WanderKingdomAction extends AbstractAction<GameEntity> {

	private static final long serialVersionUID = -7905920327656346508L;

	private List<GameEntity> entities = new ArrayList<>();
	
	public WanderKingdomAction(List<GameEntity> entities) {
		for(GameEntity entity : entities) {
			if (!(entity instanceof GameCharacter)) {
				this.entities.add(entity);
			}
		}
	}
	
	@Override
	public String getMenuName() {
		return "Wander Kingdom";
	}
	
	@Override
	protected List<GameEntity> getActionMenus() {
		return entities;
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
	protected void postExecute(GameEntity entity) {
		setNextAction(new EchoAction("You visited " + entity.getMenuName())
				.builder().listener(listener).nextAction(this).build());
	}

}
