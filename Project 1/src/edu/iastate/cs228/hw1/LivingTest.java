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

public class LivingTest {
	private World w0;

	@Before
	public void BeforeTest() throws FileNotFoundException {
		w0 = new World("public1.txt");
	}

	@Test
	public void testCensus() throws Exception {
		int emptyGrid[] = new int[5];
		int gridToPass[] = { 1, 0, 2, 1, 0 };
		w0.grid[0][0].census(emptyGrid);

		for (int i = 0; i < 5; i++) {
			assertEquals(gridToPass[i], emptyGrid[i]);
		}
	}
}
