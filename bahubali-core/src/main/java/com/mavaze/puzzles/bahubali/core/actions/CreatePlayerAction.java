package com.mavaze.puzzles.bahubali.core.actions;

import com.mavaze.puzzles.bahubali.core.character.Player;
import com.mavaze.puzzles.bahubali.core.context.GameContextHolder;
import com.mavaze.puzzles.bahubali.core.listener.MenusUpdateEvent;
import com.mavaze.puzzles.bahubali.core.listener.StateChangeListener;
import com.mavaze.puzzles.bahubali.core.listener.StatisticsUpdateEvent;
import com.mavaze.puzzles.bahubali.core.topic.Topic;

@SuppressWarnings("rawtypes")
public class CreatePlayerAction extends AbstractAction {

	private static final long serialVersionUID = -892940307538331005L;
		
	public CreatePlayerAction(StateChangeListener listener) {
		super(listener);
	}
	
	@Override
	public String getMenuName() {
		return "Enter player name";
	}

	@Override
	public void execute() {
		super.execute();
		MenusUpdateEvent event = new MenusUpdateEvent(getMenuName());
		listener.onMenusLayoutUpdated(event);
	}
	
	@Override
	public void postExecute(String response) {
		createPlayer(response);
		listener.onStatisticsUpdated(new StatisticsUpdateEvent().builder().build());
		new PlayerCompositeAction(listener).execute();
	}
	
	private void createPlayer(String userName) {
		Player player = new Player(userName);	
		Topic topic = GameContextHolder.getContext().getActiveTopic();
		player.setActions(topic.getPlayerActions());
		GameContextHolder.getContext().setActivePlayer(player);
	}

}