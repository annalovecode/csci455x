import java.util.ArrayList;
import java.util.Arrays;
// Name: Anna Zhao
// USC NetID: annaz
// CSCI455 PA2
// Fall 2021

/**
 * Class Bookshelf Implements idea of arranging books into a bookshelf. Books on
 * a bookshelf can only be accessed in a specific way so books don’t fall down;
 * You can add or remove a book only when it’s on one of the ends of the shelf.
 * However, you can look at any book on a shelf by giving its location (starting
 * at 0). Books are identified only by their height; two books of the same
 * height can be thought of as two copies of the same book.
 */

public class Bookshelf {

	/**
	 * Representation invariant:
	 * 
	 * <put rep. invar. comment here> 1.For each element in Bookshelf
	 * pileOfBooks,use 'height' as a indicator of each book. height must bigger than
	 * 0.
	 * 
	 */

	// <add instance variables here>
	ArrayList<Integer> pileOfBooks;

	/**
	 * Creates an empty Bookshelf object i.e. with no books
	 */
	public Bookshelf() {
		pileOfBooks = new ArrayList<Integer>();
		assert isValidBookshelf();
	}

	/**
	 * Creates a Bookshelf with the arrangement specified in pileOfBooks. Example
	 * values: [20, 1, 9].
	 * 
	 * PRE: pileOfBooks contains an array list of 0 or more positive numbers
	 * representing the height of each book.
	 */
	public Bookshelf(ArrayList<Integer> pileOfBooks) {
		this.pileOfBooks = new ArrayList<Integer>(pileOfBooks);
		assert isValidBookshelf();

	}

	/**
	 * Inserts book with specified height at the start of the Bookshelf, i.e., it
	 * will end up at position 0.
	 * 
	 * PRE: height > 0 (height of book is always positive)
	 */
	public void addFront(int height) {
		int firstIndex = 0;
		pileOfBooks.add(firstIndex, height);
		assert isValidBookshelf();

	}

	/**
	 * Inserts book with specified height at the end of the Bookshelf.
	 * 
	 * PRE: height > 0 (height of book is always positive)
	 */
	public void addLast(int height) {
		// lastIndex refers to the last index of the bookshelf .
		int lastIndex = pileOfBooks.size() - 1;
		pileOfBooks.add(lastIndex + 1, height);
		assert isValidBookshelf();

	}

	/**
	 * Removes book at the start of the Bookshelf and returns the height of the
	 * removed book.
	 * 
	 * PRE: this.size() > 0 i.e. can be called only on non-empty BookShelf
	 */
	public int removeFront() {
		int firstIndex = 0;
		// removedFrontBook to get the height of the removed book height.
		int removedFrontBook = pileOfBooks.get(firstIndex);
		pileOfBooks.remove(firstIndex);
		assert isValidBookshelf();
		return removedFrontBook;

	}

	/**
	 * Removes book at the end of the Bookshelf and returns the height of the
	 * removed book.
	 * 
	 * PRE: this.size() > 0 i.e. can be called only on non-empty BookShelf
	 */
	public int removeLast() {
		// initialize removedLastBook
		int removedLastBook = 0;
		// use lastIndex to indicate the book at the end of the bookshelf.
		int lastIndex;
		lastIndex = pileOfBooks.size() - 1;
		removedLastBook = pileOfBooks.get(lastIndex);
		pileOfBooks.remove(lastIndex);
		assert isValidBookshelf();
		return removedLastBook;
	}

	/*
	 * Gets the height of the book at the given position.
	 * 
	 * PRE: 0 <= position < this.size()
	 */
	public int getHeight(int position) {
		int height = 0;
		height = pileOfBooks.get(position);
		assert isValidBookshelf();
		return height;

	}

	/**
	 * Returns number of books on the this Bookshelf.
	 */
	public int size() {
		assert isValidBookshelf();
		return pileOfBooks.size();

	}

	/**
	 * Returns string representation of this Bookshelf. Returns a string with the
	 * height of all books on the bookshelf, in the order they are in on the
	 * bookshelf, using the format shown by example here: “[7, 33, 5, 4, 3]”
	 */
	public String toString() {
		assert isValidBookshelf();
		return pileOfBooks.toString();

	}

	/**
	 * Returns true iff the books on this Bookshelf are in non-decreasing order.
	 * (Note: this is an accessor; it does not change the bookshelf.)
	 */
	public boolean isSorted() {
		if (pileOfBooks.size() > 0) {
			int firstIndex = 0;
			int previous = pileOfBooks.get(firstIndex);
			for (Integer book : pileOfBooks) {
				if (book.compareTo(previous) < 0) {
					assert isValidBookshelf();
					return false;
				}
				previous = book;
			}
		}
		assert isValidBookshelf();
		return true;
	}

	/**
	 * Returns true iff the Bookshelf data is in a valid state. (See representation
	 * invariant comment for more details.)
	 */
	private boolean isValidBookshelf() {
		int i = 0;
		for (Integer book : pileOfBooks) {
			if (book > 0) {
				i++;
			}
		}
		if (i == pileOfBooks.size()) {
			return true;
		}
		return false;
	}
}
