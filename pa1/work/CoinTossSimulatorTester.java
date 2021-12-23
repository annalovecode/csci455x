// Name:Anna Zhao
// USC NetID:annaz
// CS 455 PA1
// FALL 2021
/**
 * class CoinTossSimulatorTester use it to test the result of CointTossSimulator
 * instance variables:
 * 
 * @param tries      --simulator times
 * @param cts.getNumTrials() --- experiment times static variables:MAX_INT
 */
public class CoinTossSimulatorTester {
	// MAX_INT :largest number of int value
	private static final int MAX_INT = 2147483647;

	public static void main(String[] args) {
		CoinTossSimulator cts = new CoinTossSimulator();
		
		// constructing tester and initialize tries and cts.getNumTrials()
		int tries = 0;
		System.out.println("After constructor:");
		System.out.println("Number of trials [exp:" + 0 + "]: " + cts.getNumTrials());
		System.out.println("Two-head tosses: " + cts.getTwoHeads());
		System.out.println("Two-tail tosses: " + cts.getTwoTails());
		System.out.println("One-head one-tail tosses: " + cts.getHeadTails());
		System.out.println("Tosses add up correctly? " + (cts.getNumTrials() == cts.getTwoTails()+cts.getHeadTails()+cts.getTwoHeads()));
		
		// tries =1
		tries = 1;
		cts.run(tries);
		System.out.println("After run" + "(" + tries + "):");
		System.out.println("Number of trials [exp:" + 1 + "]: " + cts.getNumTrials());
		System.out.println("Two-head tosses: " + cts.getTwoHeads());
		System.out.println("Two-tail tosses: " + cts.getTwoTails());
		System.out.println("One-head one-tail tosses: " + cts.getHeadTails());
		System.out.println("Tosses add up correctly? " + (cts.getNumTrials() == cts.getTwoTails()+cts.getHeadTails()+cts.getTwoHeads()));
		
		// tries=10
		tries = 10;
		cts.run(tries);
		System.out.println("After run" + "(" + tries + "):");
		System.out.println("Number of trials [exp:" + 11 + "]: " + cts.getNumTrials());
		System.out.println("Two-head tosses: " + cts.getTwoHeads());
		System.out.println("Two-tail tosses: " + cts.getTwoTails());
		System.out.println("One-head one-tail tosses: " + cts.getHeadTails());
		System.out.println("Tosses add up correctly? " + (cts.getNumTrials() == cts.getTwoTails()+cts.getHeadTails()+cts.getTwoHeads()));
		
		// tries=100
		tries = 100;
		cts.run(tries);
		System.out.println("After run" + "(" + tries + "):");
		System.out.println("Number of trials [exp:" + 111 + "]: " + cts.getNumTrials());
		System.out.println("Two-head tosses: " + cts.getTwoHeads());
		System.out.println("Two-tail tosses: " + cts.getTwoTails());
		System.out.println("One-head one-tail tosses: " + cts.getHeadTails());
		System.out.println("Tosses add up correctly? " + (cts.getNumTrials() == cts.getTwoTails()+cts.getHeadTails()+cts.getTwoHeads()));

		// tries=2000
		tries = 2000;
		cts.run(tries);
		System.out.println("After run" + "(" + tries + "):");
		System.out.println("Number of trials [exp:" + 2111 + "]: " + cts.getNumTrials());
		System.out.println("Two-head tosses: " + cts.getTwoHeads());
		System.out.println("Two-tail tosses: " + cts.getTwoTails());
		System.out.println("One-head one-tail tosses: " + cts.getHeadTails());
		System.out.println("Tosses add up correctly? " + (cts.getNumTrials() == cts.getTwoTails()+cts.getHeadTails()+cts.getTwoHeads()));

		// call reset method and get the result
		cts.reset();
		System.out.println("After reset:");
		System.out.println("Number of trials [exp:" + 0 + "]: " + cts.getNumTrials());
		System.out.println("Two-head tosses: " + cts.getTwoHeads());
		System.out.println("Two-tail tosses: " + cts.getTwoTails());
		System.out.println("One-head one-tail tosses: " + cts.getHeadTails());
		System.out.println("Tosses add up correctly? " + (cts.getNumTrials() == cts.getTwoTails()+cts.getHeadTails()+cts.getTwoHeads()));

		tries = 1000;
		cts.run(tries);
		System.out.println("After run" + "(" + tries + "):");
		System.out.println("Number of trials [exp:" + 1000 + "]: " + cts.getNumTrials());
		System.out.println("Two-head tosses: " + cts.getTwoHeads());
		System.out.println("Two-tail tosses: " + cts.getTwoTails());
		System.out.println("One-head one-tail tosses: " + cts.getHeadTails());
		System.out.println("Tosses add up correctly? " + (cts.getNumTrials() == cts.getTwoTails()+cts.getHeadTails()+cts.getTwoHeads()));

		// other tests output
		tries = 100;
		cts.run(tries);
		System.out.println("After run" + "(" + tries + "):");
		System.out.println("Number of trials [exp:" + 1100 + "]: " + cts.getNumTrials());
		System.out.println("Two-head tosses: " + cts.getTwoHeads());
		System.out.println("Two-tail tosses: " + cts.getTwoTails());
		System.out.println("One-head one-tail tosses: " + cts.getHeadTails());
		System.out.println("Tosses add up correctly? " + (cts.getNumTrials() == cts.getTwoTails()+cts.getHeadTails()+cts.getTwoHeads()));
		
		tries = MAX_INT;
		cts.run(tries);
		System.out.println("After run" + "(" + tries + "):");
		System.out.println("Number of trials [exp:" + MAX_INT + "]: " + cts.getNumTrials());
		System.out.println("Two-head tosses: " + cts.getTwoHeads());
		System.out.println("Two-tail tosses: " + cts.getTwoTails());
		System.out.println("One-head one-tail tosses: " + cts.getHeadTails());
		System.out.println("Tosses add up correctly? " + (cts.getNumTrials() == cts.getTwoTails()+cts.getHeadTails()+cts.getTwoHeads()));
	}

}
