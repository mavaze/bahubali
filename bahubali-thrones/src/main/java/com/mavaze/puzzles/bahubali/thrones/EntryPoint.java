package com.mavaze.puzzles.bahubali.thrones;

import com.mavaze.puzzles.bahubali.core.topic.Topic;
import com.mavaze.puzzles.bahubali.core.topic.TopicRegistry;
import com.mavaze.puzzles.bahubali.topic.ThronesTopic;

public class EntryPoint {
	
	static {
		Topic thronesTopic = new ThronesTopic();
		TopicRegistry.getInstance().register(thronesTopic);
		System.out.println("Topic registered");
	}
	
}
