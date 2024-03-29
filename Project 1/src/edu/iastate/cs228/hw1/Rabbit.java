/**
 * @author Omar T
 *
 *
 */
package edu.iastate.cs228.hw1;

/*
 * A rabbit eats grass and lives no more than three years.
 */
public class Rabbit extends Animal {

	/**
	 * Creates a Rabbit object.
	 * 
	 * @param w
	 *            : world
	 * @param r
	 *            : row position
	 * @param c
	 *            : column position
	 * @param a
	 *            : age
	 */
	public Rabbit(World w, int r, int c, int a) {
		super(w, r, c, a);
	}

	@Override
	public String toString() {

		return "R" + age + " ";
	}

	// Rabbit occupies the square.
	@Override
	public State who() {
		// TODO
		return State.RABBIT;
	}

	/**
	 * A rabbit dies of old age or hunger, or it is eaten if there are as many
	 * foxes and badgers in the neighborhood.
	 * 
	 * @param wNew
	 *            world of the next cycle
	 * @return Living new life form occupying the same square
	 */
	@Override
	public Living next(World wNew) {
		int[] population = new int[NUM_LIFE_FORMS];
		census(population);

		if (age == RABBIT_MAX_AGE) {
			return new Empty(wNew, row, column);
		} else if (population[GRASS] < 1) {
			return new Empty(wNew, row, column);
		} else if (((population[BADGER] + population[FOX]) >= population[RABBIT])
				&& (population[FOX] > population[BADGER])) {
			return new Fox(wNew, row, column, 0);
		} else if (population[BADGER] > population[RABBIT]) {
			return new Badger(wNew, row, column, 0);
		} else {
			return new Rabbit(wNew, row, column, age + 1); // May
															// not
			// get
			// passed
			// original age plus
			// one
		}
		// See Living.java for an outline of the function.
		// See the project description for the survival rules for a rabbit.
	}
}
