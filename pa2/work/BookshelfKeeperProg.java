
// Name: Anna Zhao
// USC NetID: annaz
// CSCI455 PA2
// Fall 2021
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/***
 * BookshelfKeeperProg is used to test BookshelfKeeper. use ScannerArray to read
 * input materials. If the input is invalid,then it will print error message.
 */
public class BookshelfKeeperProg {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> pileOfBooks = new ArrayList<Integer>();
		Bookshelf bsf = new Bookshelf(pileOfBooks);
		initArray(bsf, in);// call ScannerArray to init the bookshelf
		BookshelfKeeper bk = new BookshelfKeeper(bsf);
		ScannerArray(bsf, bk, in);// call ScannerArray to test the data
	}

	/**
	 * helper method, use to init the bookshelf
	 * 
	 * @param bsf
	 * @param in
	 */
	private static void initArray(Bookshelf bsf, Scanner in) {
		System.out.println("Please enter initial arrangement of books followed by newline:");
		String line = in.nextLine();
		@SuppressWarnings("resource")
		Scanner lineScanner = new Scanner(line);
		while (lineScanner.hasNext()) {
			int num = Integer.parseInt(lineScanner.next());
			if (num <= 0) {// if Height of a book is smaller than zero,exit program.
				System.out.println("ERROR: Height of a book must be positive.");
				System.out.println("Exiting Program.");
				System.exit(1);
			}
			bsf.addLast(num);
		}
		if (!bsf.isSorted()) {// if bookshelf is not sorted and heights are not in non-decreasing order ,exit
			System.out.println("ERROR: Heights must be specified in non-decreasing order.");
			System.out.println("Exiting Program.");
			System.exit(2);
		}
	}

	/**
	 * Use ScannerArray to scan in data
	 * 
	 * @param bsf refers to BookshelfKeeper
	 * @param in
	 * @throws java.util.NoSuchElementException
	 */

	private static void ScannerArray(Bookshelf bsf, BookshelfKeeper bk, Scanner in)
			throws java.util.NoSuchElementException {
		System.out.println(bk.toString());
		System.out.println("Type pick <index> or put <height> followed by newline. Type end to exit.");
		while (in.hasNextLine()) { // scan in other lines
			String line = in.nextLine();
			Scanner lineScanner = new Scanner(line);
			String runName = lineScanner.next(); // runName is used to put or pick method
			if (runName.equals("pick")) {
				int num = lineScanner.nextInt();
				pickWrong(bk, num);
				bk.pickPos(num);
				System.out.println(bk.toString());
			}
			if (runName.equals("put")) {
				int num = lineScanner.nextInt();
				putWrong(bk, num);
				bk.putHeight(num);
				System.out.println(bk.toString());
			}
			if (runName.equals("end")) {
				System.out.println("Exiting Program.");
				System.exit(0);
				break;
			}
			// wrong input
			if (!runName.equals("end") && !runName.equals("put") && !runName.equals("pick")) {
				otherWrong(bk, runName);
				break;
			}
		}
	}

	/**
	 * helper method, when do pick operation, num must be [0,bk.size()-1]
	 * 
	 * @param bk
	 * @param num, refer to position
	 */
	private static void pickWrong(BookshelfKeeper bk, int num) {
		if (num >= bk.getNumBooks() || num < 0) {// num must< bk's size and bigger than 0
			System.out.println("ERROR: Entered pick operation is invalid on this shelf.");
			System.out.println("Exiting Program.");
			System.exit(2);
		}
	}

	/**
	 * helper method, when do put operation, num must be bigger than 0
	 * 
	 * @param bk
	 * @param num, refer to height of book
	 */
	private static void putWrong(BookshelfKeeper bk, int num) {
		if (num <= 0) {// Height of a book must be positive
			System.out.println("ERROR: Height of a book must be positive.");
			System.out.println("Exiting Program.");
			System.exit(1);
		}
	}

	/**
	 * helper method, when do other operation
	 * 
	 * @param bk
	 * @param runName, refer to input string name
	 */
	private static void otherWrong(BookshelfKeeper bk, String runName) {
		System.out.println("ERROR: Invalid command. Valid commands are pick, put, or end.");
		System.out.println("Exiting Program.");
		System.exit(3);
	}
}
