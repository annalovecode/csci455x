// Name: Anna Zhao
// USC NetID: annaz
// CSCI455 PA2
// Fall 2021

/**
 * Class BookshelfKeeper
 *
 * Enables users to perform efficient putPos or pickHeight operation on a
 * bookshelf of books kept in non-decreasing order by height, with the
 * restriction that single books can only be added or removed from one of the
 * two *ends* of the bookshelf to complete a higher level pick or put operation.
 * Pick or put operations are performed with minimum number of such adds or
 * removes.
 */
public class BookshelfKeeper {

	/**
	 * Representation invariant:
	 * 
	 * the list of numbers entered for initial arrangement of the bookshelf are all
	 * positive and in non-decreasing order.
	 * 
	 */

	// <add instance variables here>
	Bookshelf bookshelf;// use totalOperation to indicate all operations.
	private int totalOperation;// use totalOperation to indicate all operations.
	private int pickPos;// use pickPos to indicate one operation of picking nums at position
	private int putHeight;// use putHeight to indicate one operation of putHeight at position
	private static final int EMPTY = 0;// invariant,represent the bookshelf is empty.
	private static final int ONE_OPERATION = 1;// invariant, represent do one operation in bookshelf
	private boolean flag = true;// use flag to distinguish between two operations.

	/**
	 * Creates a BookShelfKeeper object with an empty bookshelf
	 */
	public BookshelfKeeper() {
		bookshelf = new Bookshelf();
		pickPos = 0;
		putHeight = 0;
		totalOperation = 0;
		assert isValidBookshelfKeeper();
	}

	/**
	 * Creates a BookshelfKeeper object initialized with the given sorted bookshelf.
	 * Note: method does not make a defensive copy of the bookshelf.
	 *
	 * PRE: sortedBookshelf.isSorted() is true.
	 */
	public BookshelfKeeper(Bookshelf sortedBookshelf) {
		bookshelf = sortedBookshelf;
		pickPos = 0;
		putHeight = 0;
		totalOperation = 0;
		assert isValidBookshelfKeeper();
	}

	/**
	 * Removes a book from the specified position in the bookshelf and keeps
	 * bookshelf sorted after picking up the book.
	 * 
	 * Returns the number of calls to mutators on the contained bookshelf used to
	 * complete this operation. This must be the minimum number to complete the
	 * operation.
	 * 
	 * PRE: 0 <= position < getNumBooks()
	 */
	public int pickPos(int position) {
		Bookshelf temperBookshelf = new Bookshelf();
		flag = false;
		if (getNumBooks() == EMPTY) {// case when the bookshelf size ==0
			assert isValidBookshelfKeeper();
			return EMPTY;
		}
		int midPos = getNumBooks() / 2;// use midPos to indicate the middle index of the bookshelf
		if (position < midPos) {// case when position < middle position
			assert isValidBookshelfKeeper();
			return helperPickLessThanMid(position, temperBookshelf);
		} else {
			assert isValidBookshelfKeeper();
			return helperPickMoreThanMid(position, temperBookshelf);
		}
	}

	/**
	 * Inserts book with specified height into the shelf. Keeps the contained
	 * bookshelf sorted after the insertion.
	 * 
	 * Returns the number of calls to mutators on the contained bookshelf used to
	 * complete this operation. This must be the minimum number to complete the
	 * operation.
	 * 
	 * PRE: height > 0
	 */
	public int putHeight(int height) {
		Bookshelf temperBookshelf = new Bookshelf();
		flag = true;
		int midPos = getNumBooks() / 2;// use midPos to indicate the middle index of the bookshelf
		int position = 0;
		if (getNumBooks() == EMPTY) {// empty bookshelf
			bookshelf.addLast(height);
			totalOperation += ONE_OPERATION;
			putHeight = ONE_OPERATION;
			assert isValidBookshelfKeeper();
			return putHeight;
		}
		// If the input height already exists in bookshelf
		if (checkHeight(bookshelf, height)) {
			position = putNotDistinctBook(bookshelf, height);
		} else {
			position = putDistinctBook(bookshelf, height);
		}
		if (position <= midPos) {// position <=middle position
			putHeight = helperHeightLessThanMid(height, position, temperBookshelf);
			assert isValidBookshelfKeeper();
			return putHeight;
		} else {
			putHeight = helperHeightMoreThanMid(height, position, temperBookshelf);
			assert isValidBookshelfKeeper();
			return putHeight;
		}
	}

	/**
	 * Returns the total number of calls made to mutators on the contained bookshelf
	 * so far, i.e., all the ones done to perform all of the pick and put operations
	 * that have been requested up to now.
	 */
	public int getTotalOperations() {
		assert isValidBookshelfKeeper();
		return totalOperation;
	}

	/**
	 * Returns the number of books on the contained bookshelf.
	 */
	public int getNumBooks() {
		assert isValidBookshelfKeeper();
		return bookshelf.size();
	}

	/**
	 * Returns string representation of this BookshelfKeeper. Returns a String
	 * containing height of all books present in the bookshelf in the order they are
	 * on the bookshelf, followed by the number of bookshelf mutator calls made to
	 * perform the last pick or put operation, followed by the total number of such
	 * calls made since we created this BookshelfKeeper.
	 * 
	 * Example return string showing required format: “[1, 3, 5, 7, 33] 4 10”
	 * 
	 */
	public String toString() {
		int printValue = 0;
		if (!flag) {// the operation is pickPos
			printValue = pickPos;
		} else {// the operation is putHeight
			printValue = putHeight;
		}
		String printString = bookshelf.toString() + " " + printValue + " " + totalOperation;
		assert isValidBookshelfKeeper();
		return printString;
	}

	/**
	 * Returns true iff the BookshelfKeeper data is in a valid state. (See
	 * representation invariant comment for details.)
	 */
	private boolean isValidBookshelfKeeper() {
		if (bookshelf.isSorted()) {
			return true;
		}
		return false;
	}

	// add any other private methods here
	/**
	 * Helper method, use it to clean the temporBookshelf and add all books of
	 * temporBookshelf into Bookshelf
	 * 
	 * @param tmp
	 * @param useAddFrontOrNot check if codes need to use addFront()
	 * @return m runtime of bookshelf.addFront() or addLast()
	 */
	private int temperBookshelfCleanHelper(Bookshelf tmp, boolean useAddFrontOrNot) {
		int m = 0;
		if (useAddFrontOrNot) {// check if codes need to use addFront()
			while (tmp.size() != EMPTY) {
				int pickedOne = tmp.removeLast();
				bookshelf.addFront(pickedOne);
				m++;
			}
		} else {
			while (tmp.size() != EMPTY) {
				bookshelf.addLast(tmp.removeLast());
				m++;
			}
		}
		return m;
	}

	/**
	 * helper method: do putHeight() method when the position falls into [0,mid]
	 * 
	 * @param height,           the height of the input book
	 * @param position,possible input position
	 * @param temperBookshelf
	 * @return runtime operation of bookshelf
	 */
	private int helperHeightLessThanMid(int height, int position, Bookshelf temperBookshelf) {
		int heightOfIndexZero = bookshelf.getHeight(0);
		int i = 0;
		if (height > heightOfIndexZero) {
			for (int j = 0; j < position; j++) {
				temperBookshelf.addLast(bookshelf.removeFront());
				i++;
			}
			bookshelf.addFront(height);// do one operation of bookshelf
			int j = temperBookshelfCleanHelper(temperBookshelf, true);
			i = i + j + ONE_OPERATION;
		} else {
			bookshelf.addFront(height);
			i = ONE_OPERATION;
		}
		putHeight = i;// update putHeight
		totalOperation = totalOperation + i;// update totalOperation
		return i;
	}

	/**
	 * helper method: do putHeight() method when the position falls into
	 * (mid,bookshelfSize()-1]
	 * 
	 * @param height,           the height of the input book
	 * @param position,possible input position
	 * @param temperBookshelf
	 * @return runtime operation of bookshelf
	 */
	private int helperHeightMoreThanMid(int height, int position, Bookshelf temperBookshelf) {
		int heightOfLastIndex = bookshelf.getHeight(bookshelf.size() - 1);
		int i = 0;
		if (height < heightOfLastIndex) {
			for (int j = bookshelf.size() - 1; j >= position; j--) {
				temperBookshelf.addLast(bookshelf.removeLast());
				i++;
			}
			bookshelf.addLast(height);// do one operation of bookshelf
			int j = temperBookshelfCleanHelper(temperBookshelf, false);
			i = i + j + ONE_OPERATION;
		} else {
			bookshelf.addLast(height);
			i = ONE_OPERATION;
		}
		putHeight = i;// update putHeight
		totalOperation = totalOperation + i;// update totalOperation
		return i;
	}

	/**
	 * helper method: do pickPos() method when the position falls into [0,mid]
	 * 
	 * @param position,possible input position
	 * @param temperBookshelf
	 * @return runtime operation of bookshelf
	 */
	private int helperPickLessThanMid(int position, Bookshelf temperBookshelf) {
		int i = 0;
		int t = 0;
		for (i = 0; i < position; i++) {
			temperBookshelf.addLast(bookshelf.removeFront());
			t++;
		}
		bookshelf.removeFront();// do one operation of bookshelf
		int j = temperBookshelfCleanHelper(temperBookshelf, true);
		pickPos = t + j + ONE_OPERATION;
		totalOperation += t + j + ONE_OPERATION;
		return pickPos;
	}

	/**
	 * helper method: do pickPos() method when the position falls into
	 * (mid,bookshelf.size()-1]
	 * 
	 * @param position,possible input position
	 * @param temperBookshelf
	 * @return runtime operation of bookshelf
	 */
	private int helperPickMoreThanMid(int position, Bookshelf temperBookshelf) {
		int j = 0;
		int i = 0;
		for (j = getNumBooks() - 1; j > position; j--) {
			temperBookshelf.addLast(bookshelf.removeLast());
			i++;
		}
		bookshelf.removeLast();// do one operation of bookshelf
		int m = temperBookshelfCleanHelper(temperBookshelf, false);
		pickPos = m + i + ONE_OPERATION;
		totalOperation = totalOperation + m + i + ONE_OPERATION;
		return j;
	}

	/**
	 * check if the book ready to be input already in the bookshelf
	 * 
	 * @param bookshelf
	 * @param height    the height of the input book
	 * @return true if the book ready to be input already in the bookshelf
	 */
	private boolean checkHeight(Bookshelf bookshelf, int height) {
		for (int i = 0; i <= getNumBooks() - 1; i++) {
			if (height == bookshelf.getHeight(i)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * if put a book already in the bookshelf
	 * 
	 * @param bookshelf
	 * @param height    the height of the input book
	 * @return position ,the possible input position
	 */
	private int putNotDistinctBook(Bookshelf bookshelf, int height) {
		int first = 0;
		int last = 0;
		int position = 0;
		for (int i = 0; i <= getNumBooks() - 1; i++) {// find from the 0 index
			if (height == bookshelf.getHeight(i)) {
				first = i;
				break;
			}
		}
		for (int j = getNumBooks() - 1; j >= 0; j--) {// find from the last index
			if (height == bookshelf.getHeight(j)) {
				last = j;
				break;
			}
		}
		if (first <= getNumBooks() - last - 1) {
			position = first;
		} else {
			position = last + 1;
		}
		return position;
	}

	/**
	 * if put a new book in the bookshelf ,the book not exists in the bookshelf
	 * 
	 * @param bookshelf
	 * @param height    the height of the input book
	 * @return position ,the possible input position
	 */
	private int putDistinctBook(Bookshelf bookshelf, int height) {
		int position = 0;
		if (bookshelf.getHeight(getNumBooks() - 1) < height) { // position is the last one
			position = getNumBooks();
		} else {
			for (int i = 0; i <= getNumBooks() - 1; i++) {// position is not the last one
				if (bookshelf.getHeight(i) > height) {
					position = i;
					break;
				}
			}
		}
		return position;
	}

}
