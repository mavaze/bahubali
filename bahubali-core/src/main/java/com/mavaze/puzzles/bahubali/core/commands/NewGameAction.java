package com.mavaze.puzzles.bahubali.core.commands;

import java.util.List;

import com.mavaze.puzzles.bahubali.core.action.AbstractAction;
import com.mavaze.puzzles.bahubali.core.listener.StateChangeListener;
import com.mavaze.puzzles.bahubali.core.topic.Topic;
import com.mavaze.puzzles.bahubali.core.topic.TopicRegistry;

public class NewGameAction extends AbstractAction {

	public NewGameAction(StateChangeListener listener) {
		super(listener);
		nextAction = new CreatePlayerAction(listener).builder().backAction(this).listener(listener).build();
	}

	@Override
	public void execute() {
		List<Topic> topics = TopicRegistry.getInstance().getTopics();
		// display topics
		// set topic
		nextAction.execute();
	}

	@Override
	public String getActionName() {
		return "New Game";
	}

}
