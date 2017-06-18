package com.mavaze.puzzles.bahubali.core.listener;

import com.mavaze.puzzles.bahubali.core.controller.ActionsUpdateEvent;
import com.mavaze.puzzles.bahubali.core.controller.MapsUpdateEvent;
import com.mavaze.puzzles.bahubali.core.controller.StatisticsUpdateEvent;

public interface StateChangeListener {

	void onStatisticsUpdated(StatisticsUpdateEvent event);

	void onActionsLayoutUpdated(ActionsUpdateEvent event);

	void onMapLayoutUpdated(MapsUpdateEvent event);

}
