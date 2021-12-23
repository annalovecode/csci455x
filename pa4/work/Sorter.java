import java.util.ArrayList;
import java.util.Collections;

// Name: Anna Zhao
// USC NetID: annaz
// CS 455 PA4
// Fall 2021
public class Sorter {
	/**
	 * Representation invariant:
	 * <put rep. invar. comment here> 
	 * 1. mini-length of the word that can be sort has to be bigger or equal to 2
	 * 
	 */
	// instance variables
	private Rack rack;// input rack
	private AnagramDictionary ana;// the dictionary needed to be preprocessed
	private static final int MINI_LENGTH = 2;// mini-length of the word need to be >= 2
	private ArrayList<String> newList;//an arrayList that stores the total list after sort

	/**
	 * public Sorter method, init it.
	 * @param rack
	 * @param ana
	 */
	public Sorter(Rack rack, AnagramDictionary ana) {
		this.rack = rack;
		this.ana = ana;
		newList = new ArrayList<String>();
	}
	
/***
 * a method that sort the word.
 * @return ArrayList<string> newList
 */
	public  ArrayList<String> wordSort() {
		getWords();
		Collections.sort(newList, new comparatorWords());
		return newList;
	}

	/**
	 * a helper method of wordSort, use it to  get all possible word combines in rack.
	 */
	private void getWords() {
		ArrayList<String> allCombos = new ArrayList<String>(rack.getAllSubsets());
		for (int i = 0; i < allCombos.size(); i++) {
			if (allCombos.get(i).length() >= MINI_LENGTH) {
				ArrayList<String> anagram = new ArrayList<String>(ana.getAnagramsOf(allCombos.get(i)));
				if (anagram.size() > 0) {
					for (int j = 0; j < anagram.size(); j++) {
						newList.add(anagram.get(j));
					}
				}
			}
		}
	}

}
