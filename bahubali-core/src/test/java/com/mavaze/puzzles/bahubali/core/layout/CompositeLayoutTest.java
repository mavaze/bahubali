package com.mavaze.puzzles.bahubali.core.layout;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import com.mavaze.puzzles.bahubali.core.listener.MenusUpdateEvent;

public class CompositeLayoutTest {
	
	private TextLayout layoutUnderTest;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		layoutUnderTest = new CompositeLayout();
	}
	
	@Test
	public void testMenusArePlacedCorrectlyByMenusLayout() {
		MenusUpdateEvent event = new MenusUpdateEvent("Title");
		event.addMenu(() -> "First Menu");
		
		Map<String, Object> state = new HashMap<>();
		state.put(MenusLayout.KEY, event);
		layoutUnderTest.updateState(state);
		
		assertEquals('T', layoutUnderTest.getCharacterAt(5, 44));
		assertEquals('1', layoutUnderTest.getCharacterAt(5, 46));
		
		assertEquals('\u0000', layoutUnderTest.getCharacterAt(5, 45));
	}
	
	@Test
	public void testStatisticsArePlacedCorrectlyByStatisticsLayout() {
		Map<String, Object> stats = Collections.singletonMap("Player Name", "Mayuresh");
		
		Map<String, Object> state = new HashMap<>();
		state.put(StatisticsLayout.KEY, stats);
		layoutUnderTest.updateState(state);
		
		assertEquals('P', layoutUnderTest.getCharacterAt(5, 33));
		assertEquals('M', layoutUnderTest.getCharacterAt(20, 33)); // In next test, this should be cleared
		assertEquals('\u0000', layoutUnderTest.getCharacterAt(5, 32));
		
		// New statistics event should clear previous screen
		stats = Collections.singletonMap("A", "B");
		state.put(StatisticsLayout.KEY, stats);
		layoutUnderTest.updateState(state);
		assertEquals('\u0000', layoutUnderTest.getCharacterAt(20, 33));
	}

}
