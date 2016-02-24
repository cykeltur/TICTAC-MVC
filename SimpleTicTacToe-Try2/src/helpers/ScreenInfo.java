package helpers;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Niklas Karlsson 0703032191 All the Screen-helper (and Mouse)
 * 
 */
public class ScreenInfo {

	public static int getScreenW() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int width = d.width;
		System.out.println("Screen width = " + d.width);
		System.out.println("Screen height = " + d.height);
		return width;
	}

	public static int getScreenH() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int height = d.height;
		System.out.println("Screen width = " + d.width);
		System.out.println("Screen height = " + d.height);

		return height;
	}

	public static void makeHandCurser(JPanel inPanel) {
		Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
		inPanel.setCursor(cursor);
	}

	public static void makeWaitCurser(JPanel inPanel) {
		Cursor cursor = new Cursor(Cursor.WAIT_CURSOR);
		inPanel.setCursor(cursor);
	}

	public static void makeNormalCurser(JPanel inPanel) {
		Cursor cursor = new Cursor(Cursor.DEFAULT_CURSOR);
		inPanel.setCursor(cursor);
	}

	/**
	 * @param labelRemainingRowle
	 * 
	 */
	public static void makeHandCurser(JLabel labelRemainingRowle) {
		Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
		labelRemainingRowle.setCursor(cursor);

	}

}
