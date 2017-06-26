package com.mavaze.puzzles.bahubali.core.actions;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.Before;
import org.junit.BeforeClass;
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

public class PlayerCompositeActionTest {
	
	@Mock
	private StateChangeListener listener;
	
	@InjectMocks
	private PlayerCompositeAction actionUnderTest;
	
	@Captor
	ArgumentCaptor<MenusUpdateEvent> menuEventCaptor;
	
	@BeforeClass
	public static void setUpOnce() {
		Player player = mock(Player.class);
		Action action = spy(AbstractAction.class);
		when(action.getMenuName()).thenReturn("Topic Action");
		when(player.getActions()).thenReturn(Collections.singletonList(action));
		GameContextHolder.getContext().setActivePlayer(player);
	}
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testPlayerCompositeActionMunuName() {
		assertEquals("Player Actions", actionUnderTest.getMenuName());
	}
	
	@Test
	public void testPlayerCompositeActionExecutionFlow() {
		actionUnderTest.execute();
		
		// Verify that on execution, current action gets added as active action in Game Context
		assertEquals(GameContextHolder.getContext().getActiveAction(), actionUnderTest);
		
		verify(listener).onMenusLayoutUpdated(menuEventCaptor.capture());			
		
		// Verify that correct menus are set in their correct order
		MenusUpdateEvent event = menuEventCaptor.getValue();
		assertEquals("Player Actions", event.getMenuTitle());
		assertEquals("Topic Action", event.getMenus().get(0).getMenuName());
		assertEquals("Save and Quit", event.getMenus().get(1).getMenuName());
	}
	
	@Test
	public void testPlayerCompositeActionPostExecutionFlow() {
		// Let execute() initialize the context
		actionUnderTest.execute();
		
		actionUnderTest.postExecute("1");
		verify(GameContextHolder.getContext().getActivePlayer().getActions().get(0)).execute();
	}

}
