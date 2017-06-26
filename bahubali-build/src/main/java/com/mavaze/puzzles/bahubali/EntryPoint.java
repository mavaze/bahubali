package com.mavaze.puzzles.bahubali;

import com.mavaze.puzzles.bahubali.classic.topic.ClassicTopic;
import com.mavaze.puzzles.bahubali.core.controller.ScreenController;
import com.mavaze.puzzles.bahubali.core.topic.TopicRegistry;
import com.mavaze.puzzles.bahubali.thrones.topic.ThronesTopic;

public class EntryPoint {

	private EntryPoint() {
		throw new IllegalAccessError("Main class");
	}

	public static void main(String[] args) {

		// Register topics
		TopicRegistry.getInstance().register(new ClassicTopic());
		TopicRegistry.getInstance().register(new ThronesTopic());

		// Start screen and play
		new ScreenController().start();
	}
}