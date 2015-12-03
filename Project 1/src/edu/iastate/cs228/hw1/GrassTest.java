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

public class GrassTest {
	private Grass g;
	private World w;

	@Before
	public void BeforeTest() throws FileNotFoundException {
		w = new World("public1.txt");
		g = (Grass) w.grid[2][2];
	}

	@Test
	public void testWho() {
		assertEquals(State.GRASS, g.who());
	}

	@Test
	public void testNext() {
		assertEquals(State.GRASS, g.next(w).who());
	}
}
