/**
 * @author Omar T
 *
 *
 */
package edu.iastate.cs228.hw1;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * The PredatorPrey class performs the predator-prey simulation over a grid
 * world with squares occupied by badgers, foxes, rabbits, grass, or none.
 *
 */
public class PredatorPrey {
	/**
	 * Update the new world from the old world in one cycle.
	 * 
	 * @param wOld
	 *            old world
	 * @param wNew
	 *            new world
	 */
	public static void updateWorld(World wOld, World wNew) {
		for (int curRow = 0; curRow < wOld.getWidth(); curRow++) {
			for (int curCol = 0; curCol < wOld.getWidth(); curCol++) {
				wNew.grid[curRow][curCol] = wOld.grid[curRow][curCol]
						.next(wNew);
			}
		}
		// For every life form (i.e., a Living object) in the grid wOld,
		// generate
		// a Living object in the grid wNew at the corresponding location such
		// that
		// the former life form changes into the latter life form.
		//
		// Employ the method next() of the Living class.
	}

	/**
	 * Repeatedly generates worlds either randomly or from reading files. Over
	 * each world, carries out an input number of cycles of evolution.
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		World even; // the world after an even number of cycles
		World odd; // the world after an odd number of cycles
		int numCycles = 0;
		int userCyclesInput = 0;
		int userWidth = 0;
		int trialCount = 1;
		String userInputFile = "";

		System.out.println("The Predator-Prey Simulator");
		Scanner scan = new Scanner(System.in);
		int userInput = 0;
		while (userInput != 3) {
			System.out
					.println("keys: 1 (random world) 2 (file input) 3 (exit) ");
			userInput = scan.nextInt();
			if (userInput == 1) {
				System.out.print("Trial " + trialCount++
						+ "\nRandom world\nEnter grid width: ");
				userWidth = scan.nextInt();
				even = new World(userWidth);
				odd = new World(userWidth);
				System.out.println("Enter the number of cycles: ");
				userCyclesInput = scan.nextInt();
				even.randomInit();
				System.out.println("\nInitial world:" + "\n\n"
						+ even.toString() + "\n\n");
				while (numCycles < userCyclesInput) {
					updateWorld(even, odd);
					numCycles++;
					if (numCycles == userCyclesInput) {
						break;
					}
					updateWorld(odd, even);
					numCycles++;
				}
				if (numCycles % 2 == 0) {
					System.out.println("Final world:" + "\n\n"
							+ even.toString() + "\n\n");
					numCycles = 0;
				} else if (numCycles % 2 == 1) {
					System.out.println("Final world:" + "\n\n" + odd.toString()
							+ "\n\n");
					numCycles = 0;
				}
			} else if (userInput == 2) {
				System.out.print("Trial " + trialCount++
						+ "\nWorld input from a file\nFile name: ");
				userInputFile = scan.next();
				System.out
						.print("\nPlease input an initial cycle output file name with it's file extention: ");
				even = new World(userInputFile);
				odd = new World(even.getWidth());
				even.write(scan.next());
				System.out.println("Enter the number of cycles: ");
				userCyclesInput = scan.nextInt();
				while (numCycles < userCyclesInput) {
					updateWorld(even, odd);
					numCycles++;
					if (numCycles == userCyclesInput) {
						break;
					}
					updateWorld(odd, even);
					numCycles++;
				}
				System.out
						.println("The world has run it's course. Please enter a final cycle output file name.");
				if (numCycles % 2 == 0) {
					even.write(scan.next());
					numCycles = 0;
				} else if (numCycles % 2 == 1) {
					odd.write(scan.next());
					numCycles = 0;
				}
			} else if (userInput == 3) {
				System.exit(0);
			}
		}
		scan.close();

		// Generate predator-prey simulations repeatedly like shown in the
		// sample run in the project description.
		//
		// 1. Enter 1 to generate a random world, 2 to read a world from an
		// input
		// file, and 3 to end the simulation. (An input file always ends with
		// the suffix .txt.)
		//
		// 2. Print out standard messages as given in the project description.
		//
		// 3. For convenience, you may define two worlds even and odd as below.
		// In an even numbered cycle (starting at zero), generate the world
		// odd from the world even; in an odd numbered cycle, generate even
		// from odd.

		// 4. Print out initial and final worlds only. No intermediate worlds
		// should
		// appear in the standard output. (When debugging your program, you can
		// print intermediate worlds.)
		//
		// 5. You may save some randomly generated worlds as your own test
		// cases.
		//
		// 6. It is not necessary to handle file input & output exceptions for
		// this
		// project. Assume data in an input file to be correctly formated.
	}
}
