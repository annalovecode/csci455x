import java.util.Dictionary;

// Name: Anna Zhao
// USC NetID: annaz
// CS 455 PA4
// Fall 2021
/**
 * This class has information about Scrabble scores for scrabble letters and
 * words.  Letters that occur more often in the English language are worth less (e.g., 'e' and 's' are each
 * worth 1 point), and letters that occur less often are worth more (e.g., 'q'
 * and 'z' are worth 10 points each). You may use hard-coded values in its data.
 * Here are all the letters values: (1 point)-A, E, I, O, U, L, N, S, T, R (2
 * points)-D, G (3 points)-B, C, M, P (4 points)-F, H, V, W, Y (5 points)-K (8
 * points)- J, X (10 points)-Q, Z This class should work for both upper and
 * lower case versions of the letters, e.g., 'a' and 'A' will have the same
 * score.
 * @author Anna
 *
 */
public class ScoreTable {
	/**
	 * Representation invariant:
	 * 
	 * <put rep. invar. comment here> 
	 * invariant:ascii code of A,Z,a
	 * 
	 */
	// TABLE is used to show there are 26 different letter
	private final int TABLE = 26;
	// ASCII_OF_A is 65
	private final int ASCII_OF_A = 65;
	// ASCII_of_Z is 90
	private final int ASCII_OF_Z = 90;
	// ASCII_OF_a is 97
	private final int ASCII_OF_a = 97;
	// word that used in scoreTable
	private String word;
	 //init an int table called worth
	private	int[] worth;
	//score worth value for different character
	private final int SCORE_WORD_WORTH_1= 1 ;
	private final int SCORE_WORD_WORTH_2= 2 ;
	private final int SCORE_WORD_WORTH_3= 3 ;
	private final int SCORE_WORD_WORTH_4= 4 ;
	private final int SCORE_WORD_WORTH_5= 5 ;
	private final int SCORE_WORD_WORTH_8= 8 ;
	private final int SCORE_WORD_WORTH_10= 10 ;
	public ScoreTable(String word) {
		this.word = word;
	}

	public int charScore(char letter) {
		// compare ASCII code with 'A' , use letterReal to indicate the number store in
		// dic.
		int letterReal = letter - ASCII_OF_A;
		int score = 1;
		// if letter is 'a'-'z',then letterReal will be no smaller than 'a'-'A'
		if (letterReal >= ASCII_OF_a - ASCII_OF_A) {
			letterReal = letter - ASCII_OF_A - (ASCII_OF_a - ASCII_OF_A);
			score = dictionary(letterReal);
			// return score;
		}
		// if letter is one of 'A'-'Z'
		if (letterReal < TABLE) {
			score = dictionary(letterReal);
			// return score;
		}
		return score;
	}

	/**
	 * this method is used to maintain a dictionary for the letter score
	 * 
	 * @param letterReal (int)
	 * @return worth[letterReal] (int), the score of each word.
	 */
	public int dictionary(int letterReal) {
		worth = new int[TABLE];
		worth[0] = SCORE_WORD_WORTH_1;// A
		worth[1] = SCORE_WORD_WORTH_3;// B
		worth[2] = SCORE_WORD_WORTH_3;// C
		worth[3] = SCORE_WORD_WORTH_2; // D
		worth[4] = SCORE_WORD_WORTH_1; // E
		worth[5] = SCORE_WORD_WORTH_4; // F
		worth[6] = SCORE_WORD_WORTH_2;// G
		worth[7] = SCORE_WORD_WORTH_4;// H
		worth[8] = SCORE_WORD_WORTH_1;// I
		worth[9] = SCORE_WORD_WORTH_8; // J
		worth[10] = SCORE_WORD_WORTH_5; // K
		worth[11] = SCORE_WORD_WORTH_1; // L
		worth[12] = SCORE_WORD_WORTH_3;// M
		worth[13] = SCORE_WORD_WORTH_1;// N
		worth[14] = SCORE_WORD_WORTH_1;// O
		worth[15] = SCORE_WORD_WORTH_3; // P
		worth[16] = SCORE_WORD_WORTH_10; // Q
		worth[17] = SCORE_WORD_WORTH_1; // R
		worth[18] = SCORE_WORD_WORTH_1;// S
		worth[19] = SCORE_WORD_WORTH_1;// T
		worth[20] = SCORE_WORD_WORTH_1;// U
		worth[21] = SCORE_WORD_WORTH_4; // V
		worth[22] = SCORE_WORD_WORTH_4; // W
		worth[23] = SCORE_WORD_WORTH_8; // X
		worth[24] = SCORE_WORD_WORTH_4; // Y
		worth[25] = SCORE_WORD_WORTH_10; // Z
		return worth[letterReal];
	}

	/***
	 * a method used to caculate all of the scores
	 * 
	 * @return sum ---total score for a word
	 */
	public int getScore() {
		int sum = 0;
		for (int i = 0; i < word.length(); i++) {
			sum += charScore(word.charAt(i));
		}
		return sum;
	}

}
