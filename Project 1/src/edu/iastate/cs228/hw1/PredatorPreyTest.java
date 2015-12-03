/**
 * @author Omar T
 *
 *
 */
package edu.iastate.cs228.hw1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PredatorPreyTest {
	World w0, w1;

	public void setUpBeforeClass() throws Exception {
		w0 = new World("public1.txt");
		w1 = new World(w0.getWidth());
	}

	private static void updateWorld(World wOld, World wNew) {
		for (int curRow = 0; curRow < wOld.getWidth(); curRow++) {
			for (int curCol = 0; curCol < wOld.getWidth(); curRow++) {
				wNew.grid[curRow][curCol] = wOld.grid[curRow][curCol]
						.next(wNew);
			}
		}
	}

	@Test
	public void testUpdateWorld() {
		updateWorld(w0, w1);
		assertEquals(State.GRASS, w1.grid[0][0].who());
		assertEquals(State.BADGER, w1.grid[0][1].who());
		assertEquals(State.FOX, w1.grid[0][2].who());
		assertEquals(State.FOX, w1.grid[1][0].who());
		assertEquals(State.FOX, w1.grid[1][1].who());
		assertEquals(State.RABBIT, w1.grid[1][2].who());
		assertEquals(State.FOX, w1.grid[2][0].who());
		assertEquals(State.GRASS, w1.grid[2][1]);
		assertEquals(State.EMPTY, w1.grid[2][2]);
	}
}
