package com.mavaze.puzzles.bahubali.core.commands;

import com.mavaze.puzzles.bahubali.core.action.AbstractAction;
import com.mavaze.puzzles.bahubali.core.action.Menu;
import com.mavaze.puzzles.bahubali.core.listener.MenusUpdateEvent;

public class EchoAction extends AbstractAction {
		
	private String message;
	
	public EchoAction(String message) {
		this.message = message;
	}

	@Override
	public void execute() {
		super.execute();
		MenusUpdateEvent event = new MenusUpdateEvent(getMenuName());
		event.addMenu(new Menu() {
			@Override public String getMenuName() {
				return EchoAction.this.getMenuName();
			}
		});
		listener.onMenusLayoutUpdated(event);
	}
	
	@Override
	public void postExecute(String response) {
		nextAction.execute();
	}

	@Override
	public String getMenuName() {
		return message;
	}

}