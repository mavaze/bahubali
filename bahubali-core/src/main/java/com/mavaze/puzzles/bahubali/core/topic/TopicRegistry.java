package com.mavaze.puzzles.bahubali.core.topic;

import java.util.ArrayList;
import java.util.List;

public final class TopicRegistry {
	
	private static final TopicRegistry INSTANCE = new TopicRegistry();
	
	private List<Topic> topics = new ArrayList<>();
	
	private TopicRegistry() { }
	
	public static TopicRegistry getInstance() {
		return INSTANCE;
	}
	
	public void register(Topic topic) {
		topics.add(topic);
	}
	
	public List<Topic> getTopics() {
		return topics;
	}
	
	public Topic deriveTopic(int index) {
		return topics.get(index);
	}
	
}