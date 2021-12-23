import java.util.Arrays;

// Name:Anna Zhao
// USC NetID:annaz
// CS 455 PA3
// Fall 2021

/**
 * VisibleField class This is the data that's being displayed at any one point
 * in the game (i.e., visible field, because it's what the user can see about
 * the minefield). Client can call getStatus(row, col) for any square. It
 * actually has data about the whole current state of the game, including the
 * underlying mine field (getMineField()). Other accessors related to game
 * status: numMinesLeft(), isGameOver(). It also has mutators related to actions
 * the player could do (resetGameDisplay(), cycleGuess(), uncover()), and
 * changes the game state accordingly.
 * 
 * It, along with the MineField (accessible in mineField instance variable),
 * forms the Model for the game application, whereas GameBoardPanel is the View
 * and Controller, in the MVC design pattern. It contains the MineField that
 * it's partially displaying. That MineField can be accessed (or modified) from
 * outside this class via the getMineField accessor.
 */
public class VisibleField {
	// ----------------------------------------------------------
	// The following public constants (plus numbers mentioned in comments below) are
	// the possible states of one
	// location (a "square") in the visible field (all are values that can be
	// returned by public method
	// getStatus(row, col)).

	// The following are the covered states (all negative values):
	public static final int COVERED = -1; // initial value of all squares
	public static final int MINE_GUESS = -2;
	public static final int QUESTION = -3;

	// The following are the uncovered states (all non-negative values):
	private static final int UNCOVERED = 0; // use UNCOVERED as the status that is not covered.

	// values in the range [0,8] corresponds to number of mines adjacent to this
	// square

	public static final int MINE = 9; // this loc is a mine that hasn't been guessed already (end of losing game)
	public static final int INCORRECT_GUESS = 10; // is displayed a specific way at the end of losing game
	public static final int EXPLODED_MINE = 11; // the one you uncovered by mistake (that caused you to lose)
	// ----------------------------------------------------------

	// <put instance variables here>
	private int[][] visibleField;// visibleField is created to have the given underlying mineField.
	private MineField mineField;// create a MineField object and name it as mineField.
	private int numMinesLeft = 0;// the number of mines left to guess

	/**
	 * Create a visible field that has the given underlying mineField. The initial
	 * state will have all the mines covered up, no mines guessed, and the game not
	 * over.
	 * 
	 * @param mineField the minefield to use for for this VisibleField
	 */
	public VisibleField(MineField mineField) {
		visibleField = new int[mineField.numRows()][mineField.numCols()];
		this.mineField = mineField;
		resetGameDisplay();

	}

	/**
	 * Reset the object to its initial state (see constructor comments), using the
	 * same underlying MineField.
	 */
	public void resetGameDisplay() {
		for (int i = 0; i < mineField.numRows(); i++) {
			for (int j = 0; j < mineField.numCols(); j++) {
				visibleField[i][j] = COVERED;
			}
		}

	}

	/**
	 * Returns a reference to the mineField that this VisibleField "covers"
	 * 
	 * @return the minefield
	 */
	public MineField getMineField() {
		return mineField;
	}

	/**
	 * Returns the visible status of the square indicated.
	 * 
	 * @param row row of the square
	 * @param col col of the square
	 * @return the status of the square at location (row, col). See the public
	 *         constants at the beginning of the class for the possible values that
	 *         may be returned, and their meanings. PRE: getMineField().inRange(row,
	 *         col)
	 */
	public int getStatus(int row, int col) {
		assert mineField.inRange(row, col);
		return visibleField[row][col];
	}

	/**
	 * Returns the the number of mines left to guess. This has nothing to do with
	 * whether the mines guessed are correct or not. Just gives the user an
	 * indication of how many more mines the user might want to guess. This value
	 * can be negative, if they have guessed more than the number of mines in the
	 * minefield.
	 * 
	 * @return the number of mines left to guess.
	 */
	public int numMinesLeft() {
		numMinesLeft = mineField.numMines();
		for (int i = 0; i < mineField.numRows(); i++) {
			for (int j = 0; j < mineField.numCols(); j++) {
				if (visibleField[i][j] == MINE_GUESS) {
					numMinesLeft--;
				}
			}
		}
		return numMinesLeft;

	}

	/**
	 * Cycles through covered states for a square, updating number of guesses as
	 * necessary. Call on a COVERED square changes its status to MINE_GUESS; call on
	 * a MINE_GUESS square changes it to QUESTION; call on a QUESTION square changes
	 * it to COVERED again; call on an uncovered square has no effect.
	 * 
	 * @param row row of the square
	 * @param col col of the square PRE: getMineField().inRange(row, col)
	 */
	public void cycleGuess(int row, int col) {
		assert getMineField().inRange(row, col);
		if (getStatus(row, col) == COVERED) {
			visibleField[row][col] = MINE_GUESS;
		} else if (getStatus(row, col) == MINE_GUESS) {
			visibleField[row][col] = QUESTION;
		} else if (getStatus(row, col) == QUESTION) {
			visibleField[row][col] = COVERED;
		}
	}

	/**
	 * Uncovers this square and returns false iff you uncover a mine here. If the
	 * square wasn't a mine or adjacent to a mine it also uncovers all the squares
	 * in the neighboring area that are also not next to any mines, possibly
	 * uncovering a large region. Any mine-adjacent squares you reach will also be
	 * uncovered, and form (possibly along with parts of the edge of the whole
	 * field) the boundary of this region. Does not uncover, or keep searching
	 * through, squares that have the status MINE_GUESS. Note: this action may cause
	 * the game to end: either in a win (opened all the non-mine squares) or a loss
	 * (opened a mine).
	 * 
	 * @param row of the square
	 * @param col of the square
	 * @return false iff you uncover a mine at (row, col) PRE:
	 *         getMineField().inRange(row, col)
	 */
	public boolean uncover(int row, int col) {
		assert getMineField().inRange(row, col);
		// uncover a mine, then change state to EXPLODER_MINED
		if (mineField.hasMine(row, col) == true) {
			visibleField[row][col] = EXPLODED_MINE;
			return false;
		} else {
			// call deepFirstSearch method to search nearby area
			deepFirstSearch(row, col);
			return true;
		}
	}

	/**
	 * Returns whether the game is over. (Note: This is not a mutator.)
	 * 
	 * @return boolean whether game over
	 */
	public boolean isGameOver() {
		// use totalLseft as total number of the col()*row()- mines().
		int totalLeft = mineField.numCols() * mineField.numRows() - mineField.numMines();
		// use count to record the uncovered grids,which must be smaller than the total
		// mines number.
		int count = 0;
		// case1:uncover mines and lose the game
		for (int i = 0; i < mineField.numRows(); i++) {
			for (int j = 0; j < mineField.numCols(); j++) {
				// if a square is a mine
				if (visibleField[i][j] == EXPLODED_MINE) {
					showAllResult();
					return true;
				}
				// if the square is uncovered
				else if (isUncovered(i, j)) {
					count++;
				}
			}
		}
		// case2:not uncover any mine and win the game
		if (count == totalLeft) {
			showResultWin();
			return true;
		}
		return false;
	}

	/**
	 * Returns whether this square has been uncovered. (i.e., is in any one of the
	 * uncovered states, vs. any one of the covered states).
	 * 
	 * @param row of the square
	 * @param col of the square
	 * @return whether the square is uncovered PRE: getMineField().inRange(row, col)
	 */
	public boolean isUncovered(int row, int col) {
		if (visibleField[row][col] >= UNCOVERED) {
			assert getMineField().inRange(row, col);
			return true;
		} else
			assert getMineField().inRange(row, col);
		return false;
	}

	// <put private methods here>
	/**
	 * Any mine-adjacent squares we reach will be uncovered, and form (possibly
	 * along with parts of the edge of the whole field) the boundary of this region.
	 * Does not uncover, or keep searching through, squares that have the status
	 * MINE_GUESS.
	 * 
	 * @param row
	 * @param col
	 */
	public void deepFirstSearch(int row, int col) {
		if (isUncovered(row, col) || visibleField[row][col] == MINE_GUESS)
			return;
		// get nearby square to see whether it has mines
		visibleField[row][col] = mineField.numAdjacentMines(row, col);
		// search the column and row nearby
		if (visibleField[row][col] == UNCOVERED) {
			for (int i = row - 1; i <= row + 1; i++) {
				for (int j = col - 1; j <= col + 1; j++) {
					if (mineField.inRange(i, j) && visibleField[i][j] == COVERED) {
						deepFirstSearch(i, j);

					}
				}
			}
		}
	}

	/**
	 * Used to show the result in testers.
	 * 
	 * @return row
	 */
	public String toString() {
		// use row to print the result
		String row = "";
		for (int i = 0; i < visibleField.length; i++) {
			row += Arrays.toString(visibleField[i]) + "\n";
		}
		return row;
	}

	/**
	 * If game is over with wrong uncovering, show all the result on displaying
	 * board. It will show the correct of guessed mines and the display of the mines
	 * in this game.
	 * 
	 * @return null
	 */
	private void showAllResult() {
		for (int i = 0; i < getMineField().numRows(); i++) {
			for (int j = 0; j < getMineField().numCols(); j++) {
				if (getMineField().hasMine(i, j) && visibleField[i][j] != MINE_GUESS
						&& visibleField[i][j] != EXPLODED_MINE) {
					visibleField[i][j] = MINE;
				} else if (getStatus(i, j) == MINE_GUESS && !getMineField().hasMine(i, j)) {
					visibleField[i][j] = INCORRECT_GUESS;
				}
			}
		}
	}

	/**
	 * This method means you win the game
	 * 
	 * @return null
	 */
	private void showResultWin() {
		for (int i = 0; i < getMineField().numRows(); i++) {
			for (int j = 0; j < getMineField().numCols(); j++) {
				if (getMineField().hasMine(i, j)) {
					visibleField[i][j] = MINE_GUESS;
				}
			}
		}
	}
}
