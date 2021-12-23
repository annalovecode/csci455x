import java.util.Random;

// Name:Anna Zhao
// USC NetID:annaz
// CS 455 PA1
// Fall 2021

/**
 * class CoinTossSimulator
 * 
 * Simulates trials of repeatedly tossing two coins and allows the user to
 * access the cumulative results.
 * 
 * NOTE: we have provided the public interface for this class. Do not change the
 * public interface. You can add private instance variables, constants, and
 * private methods to the class. You will also be completing the implementation
 * of the methods given.
 * 
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 * 
 */
public class CoinTossSimulator {
	/**
	 * instance variable:a random generator naming generator;
	 */
	private Random generator;
	/**
	 * instance variable:an array,length is 2. use coin[0] as one of the coins, use
	 * coin[1] as the other.
	 */
	private int[] coin;
	/**
	 * instance variable:
	 * getTwoHeads stands for two heads,
	 * getTwoTails stands for two tails and
	 * getOneHeadAndTail stands for one head and a tail.
	 * gteNumTrials is the number of trials.
	 * inner variable, feature[]
     *  is an array,length is 3. capture the feature of two
	 * coins. 
	 */
    private int getTwoHeads = 0;
    private int getOneHeadAndTail = 0;
    private int getTwoTails = 0;
    private int getNumTrials = 0;
    private int feature[];
	/**
	 * Creates a coin toss simulator with no trials done yet.
	 */
	public CoinTossSimulator() {
		generator =new Random();
		coin = new int[2];
		feature = new int[3];
	}

	/**
	 * Runs the simulation for numTrials more trials. Multiple calls to this method
	 * without a reset() between them *add* these trials to the current simulation.
	 * 
	 * @param numTrials number of trials to for simulation; must be >= 1
	 */
	public void run(int numTrials) {
		int add = 0;// inner variable,add up to generate number.
	     /*
		  * feature[0] stands for two heads,
		  * feature[2] stands for two tails and
		  * feature[1] stands for one head and a tail.
		  */
		feature[0] = 0;
		feature[1] = 0;
		feature[2] = 0;
		for (int i = 0; i < numTrials; i++) {
			coin[0] = generator.nextInt(2);
			coin[1] = generator.nextInt(2);
			add = coin[0] + coin[1];
			if (add == 0) {
				feature[0]++;
			} else if (add == 2) {
				feature[2]++;
			} else if (add == 1) {
				feature[1]++;
			}
		}
		getTwoHeads += feature[0];
		getOneHeadAndTail += feature[1];
		getTwoTails += feature[2];
		
	}

	/**
	 * Get number of trials performed since last reset.
	 * 
	 * @return getTwoHeads + getTwoTails + getHeadTails;
	 */
	public int getNumTrials() {
		getNumTrials = getTwoHeads + getTwoTails + getOneHeadAndTail;
		return getNumTrials;
	}

	/**
	 * Get number of trials that came up two heads since last reset.
	 * 
	 * @return getTwoHeads :two heads number
	 */
	public int getTwoHeads() {
		return getTwoHeads; // DUMMY CODE TO GET IT TO COMPILE
	}

	/**
	 * Get number of trials that came up two tails since last reset.
	 * 
	 * @return getTwoTails:two tails number
	 */
	public int getTwoTails() {
		return getTwoTails; // DUMMY CODE TO GET IT TO COMPILE
	}

	/**
	 * Get number of trials that came up one head and one tail since last reset.
	 * 
	 * @return getOneHeadAndTail:one head and a tail number
	 */
	public int getHeadTails() {
		return getOneHeadAndTail; // DUMMY CODE TO GET IT TO COMPILE
	}

	/**
	 * Resets the simulation, so that subsequent runs start from 0 trials done.
	 */
	public void reset() {
		getNumTrials = 0;
		getTwoHeads = 0;
		getTwoTails = 0;
		getOneHeadAndTail = 0;
	}

}
