package com.mavaze.puzzles.bahubali.core.commands;

import java.util.ArrayList;
import java.util.List;

import com.mavaze.puzzles.bahubali.core.action.AbstractAction;
import com.mavaze.puzzles.bahubali.core.action.Action;
import com.mavaze.puzzles.bahubali.core.controller.ActionsUpdateEvent;
import com.mavaze.puzzles.bahubali.core.listener.StateChangeListener;

public class HomeCompositeAction extends AbstractAction {
		
	private List<Action> actions = new ArrayList<>();
	
	public HomeCompositeAction(StateChangeListener listener) {
		
		super(listener);
		
		Action backAction = new BackAction(listener).builder().backAction(this).build();			
		Action newGameAction = new NewGameAction(listener).builder().backAction(backAction).build();
		Action loadGameAction = new LoadGameAction(listener).builder().backAction(backAction).build();
		Action exitGameAction = new ExitGameAction(listener);
		
		actions.add(newGameAction);
		actions.add(loadGameAction);
		actions.add(exitGameAction);
	}

	@Override
	public void execute() {
		super.execute();
		ActionsUpdateEvent event = new ActionsUpdateEvent();
		event.setActions(actions);
		listener.onActionsLayoutUpdated(event);
	}

	@Override
	public String getActionName() {
		return "Home";
	}

	@Override
	public void postExecute(String response) {
		try {
			int selectedOption = Integer.parseInt(response);
			if(selectedOption > 0 || selectedOption <= actions.size()) {
				actions.get(selectedOption-1).execute();
			} else {
				throw new NumberFormatException("Invalid option selected.");
			}
		} catch (NumberFormatException e) {
			
		}
		
	}

}
