package com.mavaze.puzzles.bahubali.core.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.mavaze.puzzles.bahubali.core.actions.HomeCompositeAction;
import com.mavaze.puzzles.bahubali.core.character.Player;
import com.mavaze.puzzles.bahubali.core.context.GameContext;
import com.mavaze.puzzles.bahubali.core.context.GameContextHolder;
import com.mavaze.puzzles.bahubali.core.layout.CompositeLayout;
import com.mavaze.puzzles.bahubali.core.layout.MenusLayout;
import com.mavaze.puzzles.bahubali.core.layout.StatisticsLayout;
import com.mavaze.puzzles.bahubali.core.layout.TextLayout;
import com.mavaze.puzzles.bahubali.core.listener.MenusUpdateEvent;
import com.mavaze.puzzles.bahubali.core.listener.ScreenStateChangeListener;
import com.mavaze.puzzles.bahubali.core.listener.StateChangeListener;
import com.mavaze.puzzles.bahubali.core.listener.StatisticsUpdateEvent;
import com.mavaze.puzzles.bahubali.core.terminal.Terminal;
import com.mavaze.puzzles.bahubali.core.terminal.TextTerminal;
import com.mavaze.puzzles.bahubali.core.topic.Topic;

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
		Map<String, Object> statistics = populateStatistics();
		state.put(StatisticsLayout.KEY, statistics);
		layout.updateState(state);
		//terminal.draw();
	}

	public void updateMenus(MenusUpdateEvent event) {
		state.put(MenusLayout.KEY, event);
		layout.updateState(state);
		terminal.draw();
	}
	
	private Map<String, Object> populateStatistics() {
		Map<String, Object> stats = new LinkedHashMap<>();
		
		GameContext context = GameContextHolder.getContext();
		
		Topic topic = context.getActiveTopic();
		if(topic != null) {
			stats.put("Topic", topic.getMenuName());
		}
		
		Player player = context.getActivePlayer();
		if(player!=null) {
			stats.put("Player Name", player.getMenuName());
			stats.put("Experience", player.getXp());
			stats.put("Health::Life", player.getHealth().getLife());
			stats.put("Health::Shield", player.getHealth().getShield());
			stats.put("Health::MedicalKit", player.getHealth().getMedicalKit());
			stats.put("Resources::Gold", player.getResources().getGold());
			stats.put("Resources::Elixir", player.getResources().getElixir());
		}
		
		return stats;
	}

}
