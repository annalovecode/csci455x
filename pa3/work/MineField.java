import java.util.Arrays;
import java.util.Random;

// Name:Anna Zhao
// USC NetID:annaz
// CS 455 PA3
// Fall 2021

/**
 * MineField class with locations of mines for a game. This class is mutable,
 * because we sometimes need to change it once it's created. mutators:
 * populateMineField, resetEmpty includes convenience method to tell the number
 * of mines adjacent to a location.
 */
public class MineField {

	// <put instance variables here>
	private int numRows = 0;// use numRows as the total rows of the field
	private int numCols = 0;// use numCols as the total cols of the field
	private int numMines = 0;// use numMines as total mines that may be put in the field.
	private boolean mineField[][];// create a mineField as the same dimensions as the given array,populate it with
									// the mines in the array.
	private Random ra;// use ra as a random generator

	/**
	 * Create a minefield with same dimensions as the given array, and populate it
	 * with the mines in the array such that if mineData[row][col] is true, then
	 * hasMine(row,col) will be true and vice versa. numMines() for this minefield
	 * will corresponds to the number of 'true' values in mineData.
	 * 
	 * @param mineData the data for the mines; must have at least one row and one
	 *                 col, and must be rectangular (i.e., every row is the same
	 *                 length)
	 */
	public MineField(boolean[][] mineData) {
		numRows = mineData.length;
		numCols = mineData[0].length;
		mineField = new boolean[numRows][numCols];
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				mineField[i][j] = mineData[i][j];
				if (hasMine(i, j)) {
					numMines++;
				}
			}
		}

	}

	/**
	 * Create an empty minefield (i.e. no mines anywhere), that may later have
	 * numMines mines (once populateMineField is called on this object). Until
	 * populateMineField is called on such a MineField, numMines() will not
	 * correspond to the number of mines currently in the MineField.
	 * 
	 * @param numRows  number of rows this minefield will have, must be positive
	 * @param numCols  number of columns this minefield will have, must be positive
	 * @param numMines number of mines this minefield will have, once we populate
	 *                 it. PRE: numRows > 0 and numCols > 0 and 0 <= numMines < (1/3
	 *                 of total number of field locations).
	 */
	public MineField(int numRows, int numCols, int numMines) {
		assert numRows > 0 && numCols > 0;
		assert numMines >= 0;
		assert numMines < numRows * numCols / 3.0;
		this.numMines = numMines;
		this.numRows = numRows;
		this.numCols = numCols;

	}

	/**
	 * Removes any current mines on the minefield, and puts numMines() mines in
	 * random locations on the minefield, ensuring that no mine is placed at (row,
	 * col).
	 * 
	 * @param row the row of the location to avoid placing a mine
	 * @param col the column of the location to avoid placing a mine PRE:
	 *            inRange(row, col) and numMines() < (1/3 * numRows() * numCols())
	 */
	public void populateMineField(int row, int col) {
		assert inRange(row, col);
		assert numMines < numRows() * numCols() / 3;
		resetEmpty(); // remove current mines on the minefield
		ra = new Random();
		int currentMinesSum = numMines;// use currentMinesSum to indicate the number of total mines in every loop
		while (currentMinesSum > 0) {
			// generate random int row_a,col_a as the index of next possible mine
			int row_a = ra.nextInt(numRows());
			int col_a = ra.nextInt(numCols());
			// only if the square has no mine and is not the (row,col)
			if (row_a != row && col_a != col && mineField[row_a][col_a]==false) {
				mineField[row_a][col_a] = true;
				currentMinesSum--;
			}
		}
	}

	/**
	 * Reset the minefield to all empty squares. This does not affect numMines(),
	 * numRows() or numCols() Thus, after this call, the actual number of mines in
	 * the minefield does not match numMines(). Note: This is the state a minefield
	 * created with the three-arg constructor is in at the beginning of a game.
	 */
	public void resetEmpty() {
		mineField = new boolean[numRows][numCols];
	}

	/**
	 * Returns the number of mines adjacent to the specified mine location (not
	 * counting a possible mine at (row, col) itself). Diagonals are also considered
	 * adjacent, so the return value will be in the range [0,8]
	 * 
	 * @param row row of the location to check
	 * @param col column of the location to check
	 * @return the number of mines adjacent to the square at (row, col) PRE:
	 *         inRange(row, col)
	 */
	public int numAdjacentMines(int row, int col) {
		int count = 0;//// count is the number of mines adjacent to the specified mine location
		// use i to indicate the location above or blow a row , specifically, row-1
		// means 1 row above the specific row
		// use j to indicate the location above or blow a col, specifically, col-1 means
		// 1 col above the specific col, col+1 means 1 col blow the specific col
		for (int i = row - 1; i <= row + 1; i++) {
			for (int j = col - 1; j <= col + 1; j++) {
				if (inRange(i, j) && (i != row || j != col) && mineField[i][j]) {
					count++;
				}
			}

		}
		assert inRange(row, col);
		return count;
	}

	/**
	 * Returns true iff (row,col) is a valid field location. Row numbers and column
	 * numbers start from 0.
	 * 
	 * @param row row of the location to consider
	 * @param col column of the location to consider
	 * @return whether (row, col) is a valid field location
	 */
	public boolean inRange(int row, int col) {
		if (row >= 0 && col >= 0 && row < numRows() && col < numCols()) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the number of rows in the field.
	 * 
	 * @return number of rows in the field
	 */
	public int numRows() {
		return numRows;
	}

	/**
	 * Returns the number of columns in the field.
	 * 
	 * @return number of columns in the field
	 */
	public int numCols() {
		return numCols;
	}

	/**
	 * Returns whether there is a mine in this square
	 * 
	 * @param row row of the location to check
	 * @param col column of the location to check
	 * @return whether there is a mine in this square PRE: inRange(row, col)
	 */
	public boolean hasMine(int row, int col) {
		if (mineField[row][col]) {
			assert inRange(row, col);
			return true;
		}
		assert inRange(row, col);
		return false;
	}

	/**
	 * Returns the number of mines you can have in this minefield. For mines created
	 * with the 3-arg constructor, some of the time this value does not match the
	 * actual number of mines currently on the field. See doc for that constructor,
	 * resetEmpty, and populateMineField for more details.
	 * 
	 * @return numMines
	 */
	public int numMines() {
		return numMines;
	}

	// <put private methods here>
	/**
	 * Use this method to show the result in testers.
	 * 
	 * @return str
	 */
	public String toString() {
		// use str to print the result
		String str = "";
		for (int i = 0; i < mineField.length; i++) {
			str += Arrays.toString(mineField[i]) + "" + "\n";
		}
		return str;
	}

}
