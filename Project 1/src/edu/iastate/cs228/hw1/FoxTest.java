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
public class FoxTest {
	private Fox f;
	private World w;

	/**
	 * Builds constructor
	 * 
	 * @throws FileNotFoundException
	 */
	@Before
	public void BeforeTest() throws FileNotFoundException {
		w = new World("public1.txt");
		f = (Fox) w.grid[0][2];
	}

	/**
	 * Tests return state
	 */
	@Test
	public void testWho() {
		assertEquals(State.FOX, f.who());
	}

	/**
	 * Tests return next state
	 */
	@Test
	public void testNext() {
		assertEquals(State.EMPTY, f.next(w).who());
	}

	/**
	 * Checks if string is returned
	 */
	@Test
	public void testToString() {
		assertEquals("F0 ", f.toString());
	}

}
