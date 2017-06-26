package com.mavaze.puzzles.bahubali.core.actions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mavaze.puzzles.bahubali.core.character.Player;
import com.mavaze.puzzles.bahubali.core.context.GameContextHolder;
import com.mavaze.puzzles.bahubali.core.listener.MenusUpdateEvent;
import com.mavaze.puzzles.bahubali.core.listener.StateChangeListener;
import com.mavaze.puzzles.bahubali.core.listener.StatisticsUpdateEvent;
import com.mavaze.puzzles.bahubali.core.topic.Topic;

public class CreatePlayerActionTest {
	
	@Mock
	private StateChangeListener listener;
	
	@InjectMocks
	private CreatePlayerAction actionUnderTest;
	
	@Captor
	ArgumentCaptor<MenusUpdateEvent> menuEventCaptor;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		GameContextHolder.getContext().setActivePlayer(null);
		
		Topic topic = mock(Topic.class);
		GameContextHolder.getContext().setActiveTopic(topic);

		@SuppressWarnings("serial")
		Action topicAction = new AbstractAction<Topic>() {
			@Override public String getMenuName() {
				return "Topic Action";
			}
		}; 
		
		when(topic.getPlayerActions()).thenReturn(Collections.singletonList(topicAction));
	}
	
	@Test
	public void testCreatePlayerActionMunuName() {
		assertEquals("Enter player name", actionUnderTest.getMenuName());
	}
	
	@Test
	public void testCreatePlayerActionExecutionFlow() {
		actionUnderTest.execute();
		assertEquals(actionUnderTest, GameContextHolder.getContext().getActiveAction());		
		verify(listener).onMenusLayoutUpdated(menuEventCaptor.capture());		
		assertEquals("Enter player name", menuEventCaptor.getValue().getMenuTitle());
	}
	
	@Test
	public void testCreatePlayerActionPostExecutionFlow() {
		assertNull(GameContextHolder.getContext().getActivePlayer());
		
		actionUnderTest.postExecute("mayuresh");
		
		verify(listener).onStatisticsUpdated(any(StatisticsUpdateEvent.class));
		
		Player player = GameContextHolder.getContext().getActivePlayer();
		assertNotNull(player);
		assertEquals("mayuresh", player.getMenuName());
		assertEquals("Topic Action", player.getActions().get(0).getMenuName());
	}

}
