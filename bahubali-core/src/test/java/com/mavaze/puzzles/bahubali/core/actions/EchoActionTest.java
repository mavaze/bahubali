package com.mavaze.puzzles.bahubali.core.actions;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mavaze.puzzles.bahubali.core.context.GameContextHolder;
import com.mavaze.puzzles.bahubali.core.listener.MenusUpdateEvent;
import com.mavaze.puzzles.bahubali.core.listener.StateChangeListener;

public class EchoActionTest {
	
	@Mock
	private StateChangeListener listener;
	
	private EchoAction actionUnderTest;
	
	@Mock
	private Action nextAction;
	
	@Captor
	ArgumentCaptor<MenusUpdateEvent> eventCaptor;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		actionUnderTest = (EchoAction) new EchoAction("dummy message").builder().listener(listener).build();
	}
	
	@Test
	public void testHomeCompositeActionMunuName() {
		assertEquals("dummy message", actionUnderTest.getMenuName());
	}
	
	@Test
	public void testEchoActionExecutionFlow() {
		actionUnderTest.execute();
		verify(listener).onMenusLayoutUpdated(eventCaptor.capture());		
		assertEquals("dummy message", eventCaptor.getValue().getMenuTitle());
		assertEquals(actionUnderTest, GameContextHolder.getContext().getActiveAction());
	}
	
	@Test
	public void testEchoActionPostExecutionFlowWithoutNextAction() {
		actionUnderTest.postExecute("");
		verify(nextAction, never()).execute();
	}
	
	@Test
	public void testEchoActionPostExecutionFlowWithNextAction() {
		actionUnderTest.builder().nextAction(nextAction).build();
		actionUnderTest.postExecute("");
		verify(nextAction).execute();
	}

}
