package com.mavaze.puzzles.bahubali.core.actions;

@SuppressWarnings("rawtypes")
public class ExitGameAction extends AbstractAction {
	
	private static final long serialVersionUID = -6583631203098389739L;
	
	@Override
	public String getMenuName() {
		return "Exit";
	}

	@Override
	public void execute() {
		new EchoAction("Exiting the game.").builder().listener(listener).build().execute();
		System.exit(0);
	}
}
