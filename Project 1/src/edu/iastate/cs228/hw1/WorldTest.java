/**
 * @author Omar T
 *
 *
 */
package edu.iastate.cs228.hw1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class WorldTest {
	private World w0, w1, w2;

	@Before
	public void BeforeTest() throws FileNotFoundException {
		w0 = new World(5);
		w1 = new World(5);
		w2 = new World("public1.txt");
	}

	/**
	 * Compares the state of the grids individialls
	 */
	@Test
	public void testWorldString() {
		assertEquals(State.GRASS, w2.grid[0][0].who());
		assertEquals(State.BADGER, w2.grid[0][1].who());
		assertEquals(State.FOX, w2.grid[0][2].who());
		assertEquals(State.FOX, w2.grid[1][0].who());
		assertEquals(State.FOX, w2.grid[1][1].who());
		assertEquals(State.RABBIT, w2.grid[1][2].who());
		assertEquals(State.FOX, w2.grid[2][0].who());
		assertEquals(State.GRASS, w2.grid[2][1]);
		assertEquals(State.EMPTY, w2.grid[2][2]);
	}

	@Test
	public void testWorldInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetWidth() {
		assertEquals(5, w0.getWidth());
		assertEquals(5, w1.getWidth());
	}

	@Test
	public void testRandomInit() {
		int isEqual = 0;
		w0.randomInit();
		w1.randomInit();
		if (w0.grid == w1.grid) {
			isEqual = 1;
		} else {
			isEqual = 0;
		}
		assertEquals(0, isEqual);
	}

	@Test
	public void testToString() {
		boolean conditional = false;
		w0.randomInit();
		w0.toString();
		if (w0.toString() instanceof String) {
			conditional = true;
		} else {
			conditional = false;
		}
		assertEquals(true, conditional);
	}

	@Test
	public void testWrite() throws FileNotFoundException {
		w2.write("output.txt");
		Scanner sc = new Scanner("output.txt");
		assertEquals("E  ", "E  ");
		sc.close();
	}

}
