package com.cellularautomata.automaton;

import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.cellularautomata.automaton.Automaton;
import com.cellularautomata.generator.Vector;

/**
 * The <code>AutomatonTest</code> class is responsible for testing the
 * <code>testInitializeVectorMap()</code> method of the <code>Automaton</code> class.
 * @author Rainer Pons
 */

public class AutomatonTest {
	/**
	 * The map we wish to set up and test.
	 */
	Map<Integer, Vector> map;

	/**
	 * Sets up the associative array we wish to test as if it were generated by local update rule 30
	 * and a sparse initial seed of length nine.
	 */
	@Before
	public void setUp() {
		map = new HashMap<Integer, Vector>();
		map.put(0, new Vector("000010000"));
		map.put(1, new Vector("000111000"));
		map.put(2, new Vector("001100100"));
		map.put(3, new Vector("011011110"));
		map.put(4, new Vector("110010001"));
		map.put(5, new Vector("101111011"));
		map.put(6, new Vector("101000010"));
		map.put(7, new Vector("101100111"));
		map.put(8, new Vector("101011100"));
	}

	/**
	 * Asserts that each key-value pair is generated correctly.
	 */
	@Test
	public void testInitializeVectorMap() {
		Map<Integer, Vector> expectedMap = map;
		Map<Integer, Vector> actualMap = Automaton.initializeVectorMap(30, new Vector("000010000"));

		for (Map.Entry<Integer, Vector> entry : expectedMap.entrySet()) {
			String expected = entry.getValue().getState();
			String actual = actualMap.get(entry.getKey()).getState();
			Assert.assertEquals(expected, actual);
		}
	}
}