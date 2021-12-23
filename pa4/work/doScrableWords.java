import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Name: Anna Zhao
//USC NetID: annaz
//CS 455 PA4
//Fall 2021
/*************************
 * A class that uses to clean and sort words.
 * @author anna
 *
 */
public class doScrableWords {
	private String word;
	public doScrableWords(String word) {
		this.word=word;
		
	}
	/**
	 * clean none 'a'--z' or A-Z words,
	 * 
	 * @param String s as input
	 * @return all possible chars as sl
	 **/
	public static String cleanWords(String s) {
		String sl = "";
		for (int i = 0; i < s.length(); i++) {
			char l = s.charAt(i);// cut all possible character as char l
			if ((l >= 'a' && l <= 'z') || (l >= 'A' && l <= 'Z')) {
				// add l to the output
				sl = sl + l;
			}
		}
		return sl;

	}

	/**
	 * sort words and return words after sorted
	 * 
	 * @param s sting that need input
	 * @return string ---the words after sorted in alpha order
	 **/
	public static String sortWords(String s) {
		char[] ch = new char[s.length()];
		// store all chars in String s into ch[]
		for (int i = 0; i < s.length(); i++) {
			ch[i] = s.charAt(i);
		}
		Arrays.sort(ch);
		String str = new String(ch);
		return str;

	}
	
}
