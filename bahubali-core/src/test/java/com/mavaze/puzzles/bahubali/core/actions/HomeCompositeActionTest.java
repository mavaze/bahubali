package com.mavaze.puzzles.bahubali.core.actions;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mavaze.puzzles.bahubali.core.context.GameContextHolder;
import com.mavaze.puzzles.bahubali.core.listener.MenusUpdateEvent;
import com.mavaze.puzzles.bahubali.core.listener.StateChangeListener;

public class HomeCompositeActionTest {
	
	@Mock
	private StateChangeListener listener;
	
	@InjectMocks
	private HomeCompositeAction actionUnderTest;
	
	@Captor
	ArgumentCaptor<MenusUpdateEvent> menuEventCaptor;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testHomeCompositeActionMunuName() {
		assertEquals("Welcome to Bahubali !!!", actionUnderTest.getMenuName());
	}

	@Test
	public void testHomEcompositeActionExecutionFlow() {
		actionUnderTest.execute();
		
		// Verify that on execution, current action gets added as active action in Game Context
		assertEquals(GameContextHolder.getContext().getActiveAction(), actionUnderTest);

		verify(listener).onMenusLayoutUpdated(menuEventCaptor.capture());			
		
		// Verify that correct menus are set in their correct order
		MenusUpdateEvent event = menuEventCaptor.getValue();
		assertEquals("Welcome to Bahubali !!!", event.getMenuTitle());
		assertEquals("New Game", event.getMenus().get(0).getMenuName());
		assertEquals("Load Game", event.getMenus().get(1).getMenuName());
		assertEquals("Exit", event.getMenus().get(2).getMenuName());
	}
}
