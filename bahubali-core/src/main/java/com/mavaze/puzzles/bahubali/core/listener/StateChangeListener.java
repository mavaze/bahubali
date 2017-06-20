package com.mavaze.puzzles.bahubali.core.listener;

public interface StateChangeListener {

	void onStatisticsUpdated(StatisticsUpdateEvent event);

	void onMenusLayoutUpdated(MenusUpdateEvent event);

	void onMapLayoutUpdated(MapsUpdateEvent event);

}