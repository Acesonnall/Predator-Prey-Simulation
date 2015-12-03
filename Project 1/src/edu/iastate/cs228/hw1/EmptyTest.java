/**
 * @author Omar T
 *
 *
 */
package edu.iastate.cs228.hw1;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

/**
 * Empty Test Class
 * 
 * @author O
 *
 */
public class EmptyTest {
	private Empty e;
	private World w;

	/**
	 * Builds constructor
	 * 
	 * @throws FileNotFoundException
	 */
	@Before
	public void BeforeTest() throws FileNotFoundException {
		w = new World("public1.txt");
		e = (Empty) w.grid[2][1];
	}

	/**
	 * Tests return state
	 */
	@Test
	public void testWho() {
		assertEquals(State.EMPTY, e.who());
	}

	/**
	 * Tests next state
	 */
	@Test
	public void testNext() {
		assertEquals(State.FOX, e.next(w).who());
	}
}
