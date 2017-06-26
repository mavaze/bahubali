package com.mavaze.puzzles.bahubali.core.actions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mavaze.puzzles.bahubali.core.context.GameContextHolder;

public class BackActionTest {
	
	private BackAction actionUnderTest;
	
	@Mock
	private Action backAction;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		actionUnderTest = new BackAction(backAction);
	}
	
	@Test
	public void testBackActionMunuName() {
		assertEquals("Back", actionUnderTest.getMenuName());
	}
	
	@Test
	public void testBackActionPostExecutionFlow() {
		actionUnderTest.execute();
		// Verify that backaction execute() gets called
		verify(backAction).execute();
		// Verify that back action doesn't set itself in Game Context
		assertNull(GameContextHolder.getContext().getActiveAction());
	}

}
