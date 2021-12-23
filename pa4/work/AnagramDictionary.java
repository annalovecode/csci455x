// Name: Anna Zhao
// USC NetID: annaz
// CS 455 PA4
// Fall 2021

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * A dictionary of all anagram sets. Note: the processing is case-sensitive; so
 * if the dictionary has all lower case words, you will likely want any string
 * you test to have all lower case letters too, and likewise if the dictionary
 * words are all upper case.
 */
public class AnagramDictionary {
	/**
	 * Representation invariant:
	 * 
	 * <put rep. invar. comment here> 1.each input character is case-sensitive. if
	 * input is lower case letters then you will likely want any string
     * you test to have all lower case letters too.
	 * 
	 */
	
	private Map<String, ArrayList<String>> anaMap;//create a map that uses to store all possible data 
	private Scanner scanner;// create a new scanner

	/**
	 * Create an anagram dictionary from the list of words given in the file
	 * indicated by fileName.
	 * 
	 * @param fileName the name of the file to read from
	 * @throws FileNotFoundException      if the file is not found
	 * @throws IllegalDictionaryException if the dictionary has any duplicate words
	 */
	public AnagramDictionary(String fileName) throws FileNotFoundException, IllegalDictionaryException {

		anaMap = new HashMap<String, ArrayList<String>>();
		File fn = new File(fileName);		// scan in the file
		scanner = new Scanner(fn);
		while (scanner.hasNext()) {
			String str = scanner.next();
			String words = doScrableWords.cleanWords(str);// get rid of none 'a'--'z' char and store it in words
			words = doScrableWords.sortWords(words);// sort chars
			if (!anaMap.containsKey(words)) {// if it doesn't contain the key words
				ArrayList<String> anagramArray = new ArrayList<String>(); // create an ArrayList called anagramArray to store the anagram
	            anagramArray.add(str); // add the word to anagramArray
	            anaMap.put(words, anagramArray); // put sortedWord and its corresponding anagramArray to HashMap anagramDict

			} else {
				 if (anaMap.get(words).contains(str)) { // if the word occurs more than 1 time
	                  // Illegal dictionary
	                  throw new IllegalDictionaryException("ERROR: Illegal dictionary: dictionary file has a duplicate word: " + str);
	               }
	               anaMap.get(words).add(str); // if the HashMap anaMap has sortedWord, and the word does not occur more than 1 time, then add the word to its corresponding anagramArray
	            }
			}

		}
	

	/**
	 * Get all anagrams of the given string. This method is case-sensitive. E.g.
	 * "CARE" and "race" would not be recognized as anagrams.
	 * 
	 * @param s string to process
	 * @return a list of the anagrams of s
	 */
	public ArrayList<String> getAnagramsOf(String s) {
		s = doScrableWords.cleanWords(s);
		s = doScrableWords.sortWords(s);
		if (anaMap.get(s) == null) {
			return new ArrayList<String>();
		} else
			return anaMap.get(s); 
	}

}
