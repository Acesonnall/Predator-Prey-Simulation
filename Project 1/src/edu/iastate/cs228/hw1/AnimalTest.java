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

public class AnimalTest {
	private Animal an; // Initialize animal
	private World w; // Initialize world

	/**
	 * Builds constructor
	 * 
	 * @throws FileNotFoundException
	 */
	@Before
	public void BeforeTest() throws FileNotFoundException {
		w = new World("public1.txt");
		an = (Badger) w.grid[0][1];
	}

	/**
	 * Tests age
	 */
	@Test
	public void testMyAge() {
		assertEquals(0, an.age);
	}

}
