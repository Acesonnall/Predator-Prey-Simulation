package edu.iastate.cs228.hw1;

/**
 * Grass remains if more than rabbits in the neighborhood;
 * otherwise, it is eaten. 
 *
 */
public class Grass extends Living 
{
	public Grass (World w, int r, int c) 
	{
		// TODO 
	}
	
	public State who()
	{
		// TODO  
		return null; 
	}
	
	/**
	 * Grass can be eaten out by too many rabbits in the neighborhood. Rabbits may also 
	 * multiply fast enough to take over Grass. 
	 */
	public Living next(World wNew)
	{
		// TODO 
		// 
		// See Living.java for an outline of the function. 
		// See the project description for the survival rules for grass. 
		return null; 
	}
}
