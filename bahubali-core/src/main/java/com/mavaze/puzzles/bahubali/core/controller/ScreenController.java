package com.mavaze.puzzles.bahubali.core.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mavaze.puzzles.bahubali.core.action.Action;
import com.mavaze.puzzles.bahubali.core.commands.HomeCompositeAction;
import com.mavaze.puzzles.bahubali.core.layout.ActionsLayout;
import com.mavaze.puzzles.bahubali.core.layout.CompositeLayout;
import com.mavaze.puzzles.bahubali.core.layout.StatisticsLayout;
import com.mavaze.puzzles.bahubali.core.layout.TextLayout;
import com.mavaze.puzzles.bahubali.core.listener.StateChangeListener;
import com.mavaze.puzzles.bahubali.core.terminal.Terminal;
import com.mavaze.puzzles.bahubali.core.terminal.TextTerminal;

public class ScreenController {
	
	private Terminal terminal;
	
	private TextLayout layout;
	
	private Map<String, Object> state = new HashMap<>();
	
	private StateChangeListener listener;
	
	public ScreenController() {
		layout = new CompositeLayout();
		terminal = new TextTerminal(layout);
		listener = new ScreenStateChangeListener(this);
	}
	
	public void start() {
		new HomeCompositeAction(listener).execute();
	}

	public void updateStatistics(Object statistics) {
		state.put(StatisticsLayout.KEY, statistics);
		layout.updateState(state);
		terminal.draw();
	}

	public void updateActions(List<Action> actions) {
		state.put(ActionsLayout.KEY, actions);
		layout.updateState(state);
		terminal.draw();
	}

}
