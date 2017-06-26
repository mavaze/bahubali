package com.mavaze.puzzles.bahubali.core.listener;

import java.util.LinkedHashMap;
import java.util.Map;

import com.mavaze.puzzles.bahubali.core.character.Player;
import com.mavaze.puzzles.bahubali.core.context.GameContext;
import com.mavaze.puzzles.bahubali.core.context.GameContextHolder;
import com.mavaze.puzzles.bahubali.core.topic.Topic;

public class StatisticsUpdateEvent {

	Map<String, Object> stats;

	public Map<String, Object> getStatistics() {
		return stats;
	}
	
	public void setStatistics(Map<String, Object> stats) {
		this.stats = stats;
	}

	public Builder builder() {
		return new Builder(this);
	}

	public static class Builder {

		private StatisticsUpdateEvent event;

		public Builder(StatisticsUpdateEvent event) {
			this.event = event;
		}

		public StatisticsUpdateEvent build() {
			Map<String, Object> stats = new LinkedHashMap<>();
			updateTopicStats(stats);
			updatePlayerStats(stats);
			event.setStatistics(stats);
			return event;
		}

		private void updateTopicStats(Map<String, Object> stats) {
			GameContext context = GameContextHolder.getContext();
			Topic topic = context.getActiveTopic();
			if (topic != null) {
				stats.put("Topic", topic.getMenuName());
			}
		}
		
		private void updatePlayerStats(Map<String, Object> stats) {
			GameContext context = GameContextHolder.getContext();
			Player player = context.getActivePlayer();
			if (player != null) {
				stats.put("Player Name", player.getMenuName());
				stats.put("Experience", player.getXp());
				stats.put("Health::Life", player.getHealth().getLife());
				stats.put("Health::Shield", player.getHealth().getShield());
				stats.put("Health::MedicalKit", player.getHealth().getMedicalKit());
				stats.put("Resources::Gold", player.getResources().getGold());
				stats.put("Resources::Elixir", player.getResources().getElixir());
			}
		}
	}

}
