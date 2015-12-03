/**
 * @author Omar T
 *
 *
 */
package edu.iastate.cs228.hw1;

/**
 * Empty squares are competed by various forms of life.
 */
public class Empty extends Living {
	public Empty(World w, int r, int c) {
		super(w, r, c);
	}

	/**
	 * Returns state
	 */
	@Override
	public State who() {
		// TODO
		return State.EMPTY;
	}

	/**
	 * An empty square will be occupied by a neighboring Badger, Fox, Rabbit, or
	 * Grass, or remain empty.
	 * 
	 * @param wNew
	 *            world of the next life cycle.
	 * @return Living life form in the next cycle.
	 */
	@Override
	public Living next(World wNew) {
		int[] population = new int[NUM_LIFE_FORMS];
		census(population);

		if (population[RABBIT] > 1) {
			return new Rabbit(wNew, row, column, 0);
		} else if (population[FOX] > 1) {
			return new Fox(wNew, row, column, 0);
		} else if (population[BADGER] > 1) {
			return new Badger(wNew, row, column, 0);
		} else if (population[GRASS] > 0) {
			return new Grass(wNew, row, column);
		} else {
			return new Empty(wNew, row, column);
		}
		// See Living.java for an outline of the function.
		// See the project description for corresponding survival rules.
	}
}
