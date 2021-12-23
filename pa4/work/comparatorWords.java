import java.util.Comparator;

/**
 * create comparator implements Comparator higher score will be front If they
 * are the same, they will be sorted in alpha order.
 *
 */
public class comparatorWords implements Comparator<String> {
	/**
	 * compare a& b ,if they are the same, they will be sorted in alpha order.
	 * @param a
	 * @param b
	 * @return ------the one that comes firsts
	 */
	public int compare(String a, String b) {
		ScoreTable aTable = new ScoreTable(a);
		ScoreTable bTable = new ScoreTable(b);
		int scoreOfA = aTable.getScore();
		int scoreOfB = bTable.getScore();
		if (scoreOfA != scoreOfB) {
			return scoreOfB - scoreOfA;
		} else {
			return a.compareTo(b);
		}
	}
}
