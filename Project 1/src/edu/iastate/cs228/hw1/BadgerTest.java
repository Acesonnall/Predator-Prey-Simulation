package edu.iastate.cs228.hw1;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

/**
 * Badger Test Class
 * 
 * @author O
 *
 */
public class BadgerTest {
	private Badger b;
	private World w;

	/**
	 * Builds constructor
	 * 
	 * @throws FileNotFoundException
	 */
	@Before
	public void BeforeTest() throws FileNotFoundException {
		w = new World("public1.txt");
		b = (Badger) w.grid[0][1];
	}

	/**
	 * Tests return state
	 */
	@Test
	public void testWho() {
		assertEquals(State.BADGER, b.who());
	}

	/**
	 * Tests next state
	 */
	@Test
	public void testNext() {
		assertEquals(State.FOX, b.next(w).who());
	}

	/**
	 * Checks if returns a string
	 */
	@Test
	public void testToString() {
		assertEquals("B0 ", b.toString());
	}

}
