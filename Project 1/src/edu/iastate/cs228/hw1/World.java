/**
 * @author Omar T
 *
 *
 */
package edu.iastate.cs228.hw1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * The world is represented as a square grid of size width X width.
 *
 */
public class World {
	private int width; // grid size: width X width

	public Living[][] grid; // Instantiates new grid object

	/**
	 * Default constructor reads from a file
	 */
	public World(String inputFileName) throws FileNotFoundException {
		// Creating a grid from the file
		//
		// Assumption: The input file is in correct format.
		// Reads the first line to determine the width of the grid.
		// Scans in input file
		Scanner scan = new Scanner(new File(inputFileName));
		// Scans first line in "inputFileName"
		String i = scan.nextLine();
		// Will scan strings in first line in while loop
		Scanner scan2 = new Scanner(i);
		// Increments width while there is a String
		while (scan2.hasNext()) {
			String dump = scan2.next();
			width++;
		}
		scan.close();
		scan2.close();

		// Instantiates grid object
		grid = new Living[width][width];
		Scanner scan3 = new Scanner(new File(inputFileName));
		// Fills grid in accordance to the input file
		for (int curRow = 0; curRow < width; curRow++)
			for (int curCol = 0; curCol < width; curCol++) {
				int age = 0;
				String dump = scan3.next();
				if (dump.endsWith("0") || dump.endsWith("1")
						|| dump.endsWith("2") || dump.endsWith("3")
						|| dump.endsWith("4") || dump.endsWith("5")
						|| dump.endsWith("6")) {
					age = Integer.parseInt(dump.substring(1));
				} else {

				}
				if (dump.startsWith("G")) {
					grid[curRow][curCol] = new Grass(this, curRow, curCol);
				} else if (dump.startsWith("E")) {
					grid[curRow][curCol] = new Empty(this, curRow, curCol);
				} else if (dump.startsWith("B")) {
					grid[curRow][curCol] = new Badger(this, curRow, curCol, age);
				} else if (dump.startsWith("F")) {
					grid[curRow][curCol] = new Fox(this, curRow, curCol, age);
				} else if (dump.startsWith("R")) {
					grid[curRow][curCol] = new Rabbit(this, curRow, curCol, age);
				}
			}
		scan3.close();
	}

	/**
	 * Constructor that builds a w X w grid without initializing it.
	 * 
	 * @param width
	 *            the grid
	 */
	public World(int w) {
		// Sets user assigned width (w) to the width to be used by the grid
		width = w;
		// Creates grid dimensions without initializing the grid
		grid = new Living[w][w];
	}

	/**
	 * Gets width of grid
	 * 
	 * @return width
	 */
	public int getWidth() {
		// TODO
		return width;
	}

	/**
	 * Initialize the world by randomly assigning to every square of the grid
	 * one of BADGER, FOX, RABBIT, GRASS, or EMPTY.
	 * 
	 * Every animal starts at age 0.
	 */
	public void randomInit() {
		Random generator = new Random();

		// Fills grid randomly
		for (int curRow = 0; curRow < width; curRow++)
			for (int curCol = 0; curCol < width; curCol++) {
				// Generator randomly chooses a number between 0 and 4 and fills
				// grid accordingly
				int rand = generator.nextInt(5);
				if (rand == 0) {
					grid[curRow][curCol] = new Badger(this, curRow, curCol, 0);
				} else if (rand == 1) {
					grid[curRow][curCol] = new Empty(this, curRow, curCol);
				} else if (rand == 2) {
					grid[curRow][curCol] = new Fox(this, curRow, curCol, 0);
				} else if (rand == 3) {
					grid[curRow][curCol] = new Grass(this, curRow, curCol);
				} else if (rand == 4) {
					grid[curRow][curCol] = new Rabbit(this, curRow, curCol, 0);
				}
			}
	}

	/**
	 * Output the world grid. For each square, output the first letter of the
	 * living form occupying the square. If the living form is an animal, then
	 * output the age of the animal followed by a blank space; otherwise, output
	 * two blanks.
	 */
	@Override
	public String toString() {
		String[][] sGrid = new String[width][width];

		for (int curRow = 0; curRow < width; curRow++)
			for (int curCol = 0; curCol < width; curCol++) {
				if (grid[curRow][curCol].who() == State.BADGER) {
					sGrid[curRow][curCol] = grid[curRow][curCol].toString();
				} else if (grid[curRow][curCol].who() == State.EMPTY) {
					sGrid[curRow][curCol] = "E" + "  ";
				} else if (grid[curRow][curCol].who() == State.FOX) {
					sGrid[curRow][curCol] = grid[curRow][curCol].toString();
				} else if (grid[curRow][curCol].who() == State.GRASS) {
					sGrid[curRow][curCol] = "G" + "  ";
				} else if (grid[curRow][curCol].who() == State.RABBIT) {
					sGrid[curRow][curCol] = grid[curRow][curCol].toString();
				}
			}
		StringBuilder sb = new StringBuilder();
		for (String[] i1 : sGrid) {
			sb.append(Arrays.toString(i1)).append('\n');
		}
		return sb.toString().replaceAll("[\\[\\],]", "");
	}

	/**
	 * Write the world grid to an output file. Also useful for saving a randomly
	 * generated world for debugging purpose.
	 * 
	 * @throws FileNotFoundException
	 */
	public void write(String outputFileName) throws FileNotFoundException {
		String[][] sGrid = new String[width][width];

		for (int curRow = 0; curRow < width; curRow++)
			for (int curCol = 0; curCol < width; curCol++) {
				if (grid[curRow][curCol].who() == State.BADGER) {
					sGrid[curRow][curCol] = grid[curRow][curCol].toString();
				} else if (grid[curRow][curCol].who() == State.EMPTY) {
					sGrid[curRow][curCol] = "E" + "  ";
				} else if (grid[curRow][curCol].who() == State.FOX) {
					sGrid[curRow][curCol] = grid[curRow][curCol].toString();
				} else if (grid[curRow][curCol].who() == State.GRASS) {
					sGrid[curRow][curCol] = "G" + "  ";
				} else if (grid[curRow][curCol].who() == State.RABBIT) {
					sGrid[curRow][curCol] = grid[curRow][curCol].toString();
				}
			}
		int count = 0;
		PrintWriter writer = new PrintWriter(new File(outputFileName));
		for (int curRow = 0; curRow < width; curRow++) {
			for (int curCol = 0; curCol < width; curCol++) {
				if (count < width - 1) {
					writer.print(sGrid[curRow][curCol]);
					count++;
				} else {
					writer.println(sGrid[curRow][curCol]);
					count = 0;
				}
			}
		}
		writer.close();
		// 1. Open the file.
		//
		// 2. Write to the file. The five life forms are represented by
		// characters
		// B, E, F, G, R. Leave one blank space in between. Examples are given
		// in
		// the project description.
		//
		// 3. Close the file.
	}
}
