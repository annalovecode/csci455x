// Name:anna zhao
// USC NetID:annaz
// CS 455 PA1
// Fall 2021

// we included the import statements for you
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
 * Bar class A labeled bar that can serve as a single bar in a bar graph. The
 * text for the label is centered under the bar.
 * 
 * NOTE: we have provided the public interface for this class. Do not change the
 * public interface. You can add private instance variables, constants, and
 * private methods to the class. You will also be completing the implementation
 * of the methods given.
 * 
 */
public class Bar {
	/**
	 * instance variables:
	 * 
	 * @param bottom         location of the bottom of the bar
	 * @param left           location of the left side of the bar
	 * @param width          width of the bar (in pixels)
	 * @param heightInPixels total amount of height
	 *                       heightInPixels=scale*applicationHeight
	 * @param label          the label under the bar
	 */
	/**
	 * invariant: heightInPixels=scale*applicationHeight
	 * 
	 * @param STRING_COLOR: the color of the string text
	 */
	private int width;
	private int heightInPixels;
	private int bottom;
	private int left;
	private Color color;
	private static final Color STRING_COLOR = Color.BLACK;
	private String label;

	/**
	 * Creates a labeled bar. You give the height of the bar in application units
	 * (e.g., population of a particular state), and then a scale for how tall to
	 * display it on the screen (parameter scale).
	 * 
	 * @param bottom            location of the bottom of the bar
	 * @param left              location of the left side of the bar
	 * @param width             width of the bar (in pixels)
	 * @param applicationHeight height of the bar in application units
	 * @param scale             how many pixels per application unit
	 * @param color             the color of the bar
	 * @param label             the label under the bar
	 */
	public Bar(int bottom, int left, int width, int applicationHeight, double scale, Color color, String label) {
		this.bottom = bottom;
		this.left = left;
		this.width = width;
		heightInPixels = (int) Math.round(scale * applicationHeight);
		this.color = color;
		this.label = label;
	}

	/**
	 * Draw the labeled bar.
	 * 
	 * @param g2 the graphics context
	 */
	public void draw(Graphics2D g2) {
		// draw the labels
		Font font = g2.getFont();
		FontRenderContext context = g2.getFontRenderContext();
		Rectangle2D labelBounds = font.getStringBounds(label, context);
		int widthOfLabel = (int) labelBounds.getWidth();
		int heightOfLabel = (int) labelBounds.getHeight();
		// draw the bar
		Rectangle rec = new Rectangle(left,
				(int) (g2.getClipBounds().getMaxY() - heightInPixels - heightOfLabel - bottom), width, heightInPixels);
		g2.draw(rec);
		// set the string color as black
		g2.setColor(color);
		g2.fill(rec);
		g2.setColor(STRING_COLOR);
		// draw label string
		// according to the instruction, it should be like
		g2.drawString(label, left - widthOfLabel / 4, (int) (g2.getClipBounds().getMaxY() - bottom));

	}
}
