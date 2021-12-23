
//Name:Anna Zhao
//USC NetID:annaz
//CS 455 PA1
//Fall 2021
import java.util.Scanner;
import javax.swing.JFrame;

/**
 * class CoinSimViewer this class is used to show the GUI viewer
 * 
 */
public class CoinSimViewer {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		// set frame details
		frame.setSize(800, 500);
		frame.setTitle("CoinSim");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Scanner in = new Scanner(System.in);
		int tries=0;// tries is a variable used for trial number
		// error checking
		while (true) {
			System.out.println("Enter number of trials: ");
			tries = in.nextInt();
			if(tries> 0) { 
				break;
			}
			else if (tries <= 0) {
				// System.out.println("ERROR: Number entered must be greater than 0.");
			System.out.println("ERROR: Number entered must be greater than 0.");
			}
		}
		in.close();
		CoinSimComponent component = new CoinSimComponent(tries);
		frame.add(component);
		frame.setVisible(true);
		frame.setResizable(true);
	}
}
