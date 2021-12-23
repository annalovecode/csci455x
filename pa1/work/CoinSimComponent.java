import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

/**
 * this is the CoinSimComponent that extends JComponent and used to draw the
 * diagram.
 * 
 * 
 */
public class CoinSimComponent extends JComponent {

	/**
	 * invariant: BOTTOM:bottom margin,TOP:top margin, BAR_WIDTH:the width of each
	 * bar , color of each bar
	 * :TWOHEAD_COLOR:red,ONEHEAD_COLOR:green,TWOTAIL_COLOR:blue instance variables:
	 * cts: a CoinTossSimulator.
	 */
	private static final int BOTTOM = 20;// bottom margin of the picture
	private static final int TOP = 20;// top margin of the picture
	private static final int BAR_WIDTH = 50;// width of each bar
	private CoinTossSimulator cts;// use object in CoinTossSimulator
	private static final Color TWOHEAD_COLOR = Color.RED;// use red color to represent the color of two heads
	private static final Color ONEHEAD_COLOR = Color.GREEN;// use green color to represent the color of one head and a
															// // tail
	private static final Color TWOTAIL_COLOR = Color.BLUE;// use blue color to represent the color of two tails
	private static final long serialVersionUID = 1L;

	/**
	 * run coin toss simulator and apply the result initialize bottom and bar width
	 * 
	 * @param tries
	 */
	public CoinSimComponent(int tries) {
		super();
		cts = new CoinTossSimulator();
		cts.run(tries);
	}

	/**
	 * override paintComponent method
	 * 
	 * @param Graphics g
	 * 
	 */
	@Override
	public void paintComponent(Graphics g) {
		// recover graphic2D
		Graphics2D g2 = (Graphics2D) g;
		// get the width and height as moving the mouse and resizing the window
		double Width = g.getClipBounds().getMaxX();
		double Height = g.getClipBounds().getMaxY();
		// construct a rectangle and draw it
		String label = " "; // suppose this is the label you want to display
		Font font = g2.getFont();
		FontRenderContext context = g2.getFontRenderContext();
		Rectangle2D labelBounds = font.getStringBounds(label, context);
		// get label height and width
		int widthOfLabel = (int) labelBounds.getWidth();
		int heightOfLabel = (int) labelBounds.getHeight();
		// get scale
		double scale = (Height - BOTTOM - TOP - heightOfLabel) / cts.getNumTrials();
		// draw bar1----two heads situation
		Bar bar1 = new Bar(BOTTOM, (int) Width / 4 - BAR_WIDTH / 2, BAR_WIDTH, cts.getTwoHeads(), scale, TWOHEAD_COLOR,
				"Two Heads: " + cts.getTwoHeads() + " ("
						+ Math.round((float) cts.getTwoHeads() / cts.getNumTrials() * 100) + "%)");
		//bar1.draw(g2);
		// draw bar2----a head and a tail situation
		Bar bar2 = new Bar(BOTTOM, (int) Width / 2 - BAR_WIDTH / 2, BAR_WIDTH, cts.getHeadTails(), scale, ONEHEAD_COLOR,
				"A Head and a Tail: " + cts.getHeadTails() + " ("
						+ Math.round((float) cts.getHeadTails() / cts.getNumTrials() * 100) + "%)");
		//bar2.draw(g2);
		// draw bar3-----two tails situation
		Bar bar3 = new Bar(BOTTOM, (int) Width / 4 * 3 - BAR_WIDTH / 2, BAR_WIDTH, cts.getTwoTails(), scale,
				TWOTAIL_COLOR, "Two Tails: " + cts.getTwoTails() + " ("
						+ Math.round((float) cts.getTwoTails() / cts.getNumTrials() * 100) + "%)");
		bar1.draw(g2);
		bar2.draw(g2);
		bar3.draw(g2);

	}
}
