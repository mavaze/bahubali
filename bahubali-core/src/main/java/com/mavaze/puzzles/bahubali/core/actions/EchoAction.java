package com.mavaze.puzzles.bahubali.core.actions;

import com.mavaze.puzzles.bahubali.core.listener.MenusUpdateEvent;

public class EchoAction extends AbstractAction {
		
	private static final long serialVersionUID = -2413561563318624579L;
	
	private String message;
	
	public EchoAction(String message) {
		this.message = message;
	}

	@Override
	public void execute() {
		super.execute();
		MenusUpdateEvent event = new MenusUpdateEvent(getMenuName());
		listener.onMenusLayoutUpdated(event);
	}
	
	@Override
	public void postExecute(String response) {
		if(nextAction != null) {
			nextAction.execute();
		}
	}

	@Override
	public String getMenuName() {
		return message;
	}

}