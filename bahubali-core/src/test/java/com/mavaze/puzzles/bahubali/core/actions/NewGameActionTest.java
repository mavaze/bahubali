package com.mavaze.puzzles.bahubali.core.actions;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mavaze.puzzles.bahubali.core.context.GameContextHolder;
import com.mavaze.puzzles.bahubali.core.listener.MenusUpdateEvent;
import com.mavaze.puzzles.bahubali.core.listener.StateChangeListener;
import com.mavaze.puzzles.bahubali.core.listener.StatisticsUpdateEvent;
import com.mavaze.puzzles.bahubali.core.topic.Topic;
import com.mavaze.puzzles.bahubali.core.topic.TopicRegistry;

public class NewGameActionTest {
	
	@Mock
	private StateChangeListener listener;
	
	@InjectMocks
	private NewGameAction actionUnderTest;
	
	@Mock
	private BackAction backAction;
	
	@Captor
	ArgumentCaptor<MenusUpdateEvent> menuEventCaptor;
	
	@BeforeClass
	public static void setUpOnce() {
		Topic topic = mock(Topic.class);
		when(topic.getMenuName()).thenReturn("Classic");
		TopicRegistry.getInstance().register(topic);
	}
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		actionUnderTest.builder().backAction(backAction).build();
	}
	
	@Test
	public void testNewGameActionMunuName() {
		assertEquals("New Game", actionUnderTest.getMenuName());
	}
	
	@Test
	public void tesNewGameActionExecutionFlow() {
		actionUnderTest.execute();
		assertEquals(actionUnderTest, GameContextHolder.getContext().getActiveAction());
		verify(listener).onMenusLayoutUpdated(menuEventCaptor.capture());		
		assertEquals("Select Theme", menuEventCaptor.getValue().getMenuTitle());
		assertEquals("Classic", menuEventCaptor.getValue().getMenus().get(0).getMenuName());
	}

	@Test
	public void testNewGameActionPostExecutionFlow() {
		// First execute() to let topics variable set
		actionUnderTest.execute();
		// Now verify topic selection flow
		actionUnderTest.postExecute("1");
		assertEquals("Classic", GameContextHolder.getContext().getActiveTopic().getMenuName());
		verify(listener).onStatisticsUpdated(any(StatisticsUpdateEvent.class));
		assertEquals("Enter player name", GameContextHolder.getContext().getActiveAction().getMenuName());
	}
	
	@Test
	public void testNewGameActionPostExecutionBackActionFlow() {
		// First execute() to let topics variable set
		actionUnderTest.execute();
		// Now verify back selection flow
		actionUnderTest.postExecute("2");
		verify(backAction).execute();
	}
	
	@Test(expected=NumberFormatException.class)
	public void testNewGameActionPostExecutionWrongActionFlow() {
		// First execute() to let topics variable set
		actionUnderTest.execute();
		// Now verify wrong selection flow
		actionUnderTest.postExecute("5");
	}
}
