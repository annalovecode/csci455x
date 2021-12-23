// Name: Anna Zhao
// USC NetID: annaz
// CS 455 PA4
// Fall 2021

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A Rack of Scrabble tiles
 */

public class Rack {
	/**
	 * Representation invariant:
	 * 
	 * <put rep. invar. comment here> 1.each possible combination should only pick the character from the input words
	 * 
	 */
	private String letter = "";// use letter as an instant value to store letters
	private ArrayList<String> subset;// an arrayList to store all the subsets from rack
	
	/**
	 * public method of the Rack
	 */
	public Rack(String letter) {
		this.letter = letter;
	}

	/**
	 * Finds all subsets of the multiset starting at position k in unique and mult.
	 * unique and mult describe a multiset such that mult[i] is the multiplicity of
	 * the char unique.charAt(i). PRE: mult.length must be at least as big as
	 * unique.length() 0 <= k <= unique.length()
	 * 
	 * @param unique a string of unique letters
	 * @param mult   the multiplicity of each letter from unique.
	 * @param k      the smallest index of unique and mult to consider.
	 * @return all subsets of the indicated multiset. Unlike the multiset in the
	 *         parameters,
	 * @author Claire Bono
	 */
	private static ArrayList<String> allSubsets(String unique, int[] mult, int k) {
		ArrayList<String> allCombos = new ArrayList<>();
		if (k == unique.length()) { // multiset is empty
			allCombos.add("");
			return allCombos;
		}
		// get all subsets of the multiset without the first unique char
		ArrayList<String> restCombos = allSubsets(unique, mult, k + 1);

		// prepend all possible numbers of the first char (i.e., the one at position k)
		// to the front of each string in restCombos. Suppose that char is 'a'...

		String firstPart = ""; // in outer loop firstPart takes on the values: "", "a", "aa", ...
		for (int n = 0; n <= mult[k]; n++) {
			for (int i = 0; i < restCombos.size(); i++) { // for each of the subsets
															// we found in the recursive call
				// create and add a new string with n 'a's in front of that subset
				allCombos.add(firstPart + restCombos.get(i));
			}
			firstPart += unique.charAt(k); // append another instance of 'a' to the first part
		}

		return allCombos;
	}

	/**
	 * a public method for allSubsets, so that people can call it from other place
	 * Repeated character is allowed
     * e.g. aab -> b, a, ab, aa, aab | abc -> c, b, a, bc, ac, ab, abc
	 * @param mult
	 * @param k
	 * @return
	 */
	public ArrayList<String> getAllSubsets() {
		// public int[] getMult(String letter) {
		Map<String, Integer> wordMap = new HashMap<String, Integer>();// init a map named wordMap
		// traverse input and see if the map contains letter of the input.
		for (int t = 0; t < letter.length(); t++) {
			String s = String.valueOf(letter.charAt(t));
			if (wordMap.containsKey(s)) {
				Integer mul = wordMap.get(s);
				mul++;
				wordMap.put(s, mul++);
			} else {
				wordMap.put(s, 1);
			}
		}
		// create an array named mult
		int[] mult = new int[wordMap.keySet().size()];
		int i = 0;
		String unique = "";
		// traverse wordMap and put it in mult
		for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
			unique += entry.getKey();
			mult[i] = entry.getValue();
			i++;
		}
		return new ArrayList<String>(allSubsets(unique, mult, 0));

	}
}
