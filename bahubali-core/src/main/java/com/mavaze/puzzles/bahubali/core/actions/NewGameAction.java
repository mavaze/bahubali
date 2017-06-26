package com.mavaze.puzzles.bahubali.core.actions;

import java.util.List;

import com.mavaze.puzzles.bahubali.core.context.GameContextHolder;
import com.mavaze.puzzles.bahubali.core.listener.MenusUpdateEvent;
import com.mavaze.puzzles.bahubali.core.listener.StateChangeListener;
import com.mavaze.puzzles.bahubali.core.listener.StatisticsUpdateEvent;
import com.mavaze.puzzles.bahubali.core.topic.Topic;
import com.mavaze.puzzles.bahubali.core.topic.TopicRegistry;

public class NewGameAction extends AbstractAction<Topic> {

	private static final long serialVersionUID = -7081042341528623588L;

	private List<Topic> topics;

	public NewGameAction(StateChangeListener listener) {
		super(listener);
	}
	
	@Override
	public String getMenuName() {
		return "New Game";
	}
	
	@Override
	protected List<Topic> getActionMenus() {
		return topics;
	}

	@Override
	public void execute() {
		super.execute();
		topics = TopicRegistry.getInstance().getTopics();
		MenusUpdateEvent event = new MenusUpdateEvent("Select Theme");
		event.setMenus(topics);
		event.addMenu(new BackAction(backAction));
		listener.onMenusLayoutUpdated(event);
	}

	@Override
	public void postExecute(Topic topic) {
		GameContextHolder.getContext().setActiveTopic(topic);
		listener.onStatisticsUpdated(new StatisticsUpdateEvent().builder().build());
		setNextAction(new CreatePlayerAction(listener).builder().backAction(this).listener(listener).build());
	}

}
