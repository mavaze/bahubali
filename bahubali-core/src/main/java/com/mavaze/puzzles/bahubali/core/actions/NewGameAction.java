package com.mavaze.puzzles.bahubali.core.actions;

import java.util.List;

import com.mavaze.puzzles.bahubali.core.context.GameContextHolder;
import com.mavaze.puzzles.bahubali.core.listener.MenusUpdateEvent;
import com.mavaze.puzzles.bahubali.core.listener.StateChangeListener;
import com.mavaze.puzzles.bahubali.core.topic.Topic;
import com.mavaze.puzzles.bahubali.core.topic.TopicRegistry;

public class NewGameAction extends AbstractAction {

	private static final long serialVersionUID = -7081042341528623588L;

	private List<Topic> topics;

	@Override
	public String getMenuName() {
		return "New Game";
	}

	public NewGameAction(StateChangeListener listener) {
		super(listener);
		nextAction = new CreatePlayerAction(listener).builder().backAction(this).listener(listener).build();
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
	public void postExecute(String response) {
		int selectedOption = Integer.parseInt(response);
		if (selectedOption > 0 && selectedOption <= topics.size()) {
			Topic topic = topics.get(selectedOption - 1);
			GameContextHolder.getContext().setActiveTopic(topic);
			nextAction.execute();
		} else if (backAction != null && selectedOption == topics.size() + 1) {
			backAction.execute();
		} else {
			throw new NumberFormatException("Invalid option selected.");
		}
	}

}
