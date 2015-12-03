/**
 * @author Omar T
 *
 *
 */
package edu.iastate.cs228.hw1;

/*
 * This class is to be extended by the Badger, Fox, and Rabbit classes. 
 */
public abstract class Animal extends Living implements MyAge {
	protected int age; // age of the animal

	// Passes constructor to Living
	public Animal(World w, int r, int c, int a) {
		super(w, r, c);
		this.age = a;
	}

	@Override
	/**
	 * 
	 * @return age of the animal 
	 */
	public int myAge() {
		return age;
	}
}
