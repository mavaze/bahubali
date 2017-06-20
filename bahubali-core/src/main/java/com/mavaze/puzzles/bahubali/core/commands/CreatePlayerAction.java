package com.mavaze.puzzles.bahubali.core.commands;

import java.util.Collections;

import com.mavaze.puzzles.bahubali.core.action.AbstractAction;
import com.mavaze.puzzles.bahubali.core.action.Action;
import com.mavaze.puzzles.bahubali.core.context.GameContextHolder;
import com.mavaze.puzzles.bahubali.core.listener.MenusUpdateEvent;
import com.mavaze.puzzles.bahubali.core.listener.StateChangeListener;
import com.mavaze.puzzles.bahubali.core.player.Player;
import com.mavaze.puzzles.bahubali.core.topic.Topic;

public class CreatePlayerAction extends AbstractAction {
	
	@Override
	public String getMenuName() {
		return "Enter player name";
	}
		
	public CreatePlayerAction(StateChangeListener listener) {
		super(listener);
	}

	@Override
	public void execute() {
		super.execute();
		MenusUpdateEvent event = new MenusUpdateEvent(getMenuName());
		event.setMenus(Collections.singletonList((Action)this));
		listener.onMenusLayoutUpdated(event);
	}
	
	private void createPlayer(String userName) {
		
		Player player = new Player(userName);	
		Topic topic = GameContextHolder.getContext().getActiveTopic();
		player.setActions(topic.getPlayerActions());
		GameContextHolder.getContext().setPlayer(player);
		
		nextAction = new PlayerCompositeAction(listener);
	}
	
	@Override
	public void postExecute(String response) {
		createPlayer(response);
		nextAction = new PlayerCompositeAction(listener);
		nextAction.execute();
	}

}