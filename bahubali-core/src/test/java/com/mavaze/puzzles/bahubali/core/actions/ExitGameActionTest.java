package com.mavaze.puzzles.bahubali.core.actions;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mavaze.puzzles.bahubali.core.listener.StateChangeListener;

public class ExitGameActionTest {
	
	@Mock
	private StateChangeListener listener;
	
	@InjectMocks
	private ExitGameAction actionUnderTest;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testExitActionMunuName() {
		assertEquals("Exit", actionUnderTest.getMenuName());
	}
}
