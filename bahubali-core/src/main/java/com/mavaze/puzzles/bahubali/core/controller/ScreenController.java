package com.mavaze.puzzles.bahubali.core.controller;

import java.util.HashMap;
import java.util.Map;

import com.mavaze.puzzles.bahubali.core.actions.HomeCompositeAction;
import com.mavaze.puzzles.bahubali.core.layout.CompositeLayout;
import com.mavaze.puzzles.bahubali.core.layout.MenusLayout;
import com.mavaze.puzzles.bahubali.core.layout.StatisticsLayout;
import com.mavaze.puzzles.bahubali.core.layout.TextLayout;
import com.mavaze.puzzles.bahubali.core.listener.MapsUpdateEvent;
import com.mavaze.puzzles.bahubali.core.listener.MenusUpdateEvent;
import com.mavaze.puzzles.bahubali.core.listener.ScreenStateChangeListener;
import com.mavaze.puzzles.bahubali.core.listener.StateChangeListener;
import com.mavaze.puzzles.bahubali.core.listener.StatisticsUpdateEvent;
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

	public void updateStatistics(StatisticsUpdateEvent event) {
		state.put(StatisticsLayout.KEY, event.getStatistics());
		layout.updateState(state);
	}

	public void updateMenus(MenusUpdateEvent event) {
		state.put(MenusLayout.KEY, event);
		layout.updateState(state);
		terminal.draw();
	}
	
	public void updateMap(MapsUpdateEvent event) {
		// Maps are not yet implemented. Once implemented a logic needs to be added to update the screen.
	}

}
