// Name: Anna Zhao
// USC NetID: annaz
// CS 455 PA4
// Fall 2021
import java.io.IOException;

/**
 * This class reports problems with the dictionary file.
 */
public class IllegalDictionaryException extends IOException {
	/**
	 * add a serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	public IllegalDictionaryException() {
	}

	public IllegalDictionaryException(String message) {
		super(message);
	}
}
