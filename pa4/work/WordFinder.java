import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// Name: Anna Zhao
// USC NetID: annaz
// CS 455 PA4
// Fall 2021
/**
 * This class contains the main method. This class will have a main that's
 * responsible for processing the command-line argument, and handling any error
 * processing. It will probably also have the main command loop. Most of the
 * other functionality will be delegated to other object(s) created in main and
 * their methods.
 * 
 * @author anna zhao
 *
 */
public class WordFinder {

	public static void main(String[] args) {
		String dic;
		if (args.length > 0) {
			dic = args[0];// choose anagramDictionary---if not exist, choose sowpods.txt
		} else {
			dic = "sowpods.txt";
		}
		AnagramDictionary ana = anaInit(dic);
		System.out.println("Type . to quit.");
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		while (true) {// a loop ---execute when it is true
			System.out.print("Rack? ");
			String letter = in.next();
			if (letter.equals(".")) {// break when it meets .
				break;
			} else {
				String letterCleaned = doScrableWords.cleanWords(letter);// clean letters that is not a part of 'a'-'z' or'A'-'Z'
				Rack rack = new Rack(letterCleaned);// pass the cleaned letter to rack
				Sorter sorter = new Sorter(rack, ana);// call sorter ,sort rack
				// create an arrayList to store the sorted words
				ArrayList<String> sortedArrs = new ArrayList<String>(sorter.wordSort());
				System.out.println("We can make " + sortedArrs.size() + " words from \"" + letter + "\"");
				if (sortedArrs.size() > 0) {
					printScrabble(sortedArrs);
				}
			}
		}
	}
/**************************************************helper methods**************************************************/
	/**
	 * print out exception message of AnagramDictionary when it throws exceptions.
	 * @param: string dic -----dictionaryName
	 * @return: new AnagramDictionary object
	 */
	private static AnagramDictionary anaInit(String dic) {
		try {
			return new AnagramDictionary(dic);
		} catch (IllegalDictionaryException e) {
			System.out.println(e.getMessage());
			System.out.println("Exiting program.");
			System.exit(0);
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: Dictionary file \"" + dic + "\" does not exist.");
			System.out.println("Exiting program.");
			System.exit(0);
		}
		return null;
	}

	/**
	 * get score of a input string according to the scoreTable 
	 * a helper method of printScrabble method
	 * @param s
	 * @return score
	 */
	private static int getScore(String s) {
		ScoreTable st = new ScoreTable(s);
		int score = st.getScore();
		return score;
	}

	/**
	 * print score of each character and the character itself.
	 * @param arraylist<String> arr
	 * 
	 */
	private static void printScrabble(ArrayList<String> arr) {
		System.out.println("All of the words with their scores (sorted by score):");
		for (int i = 0; i < arr.size(); i++) {
			int score = getScore(arr.get(i));
			System.out.println(score + ": " + arr.get(i));
		}
	}

}
