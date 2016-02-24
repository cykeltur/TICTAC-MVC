package helpers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import player.Player;

/**
 * Created by NIK1114 on 2015-10-07.
 * http://www.designmantic.com/logo-design/samples
 *
 * make a object of GuiHighScore(String 2D-ScoreInArray)
 * (and the GUI just print the ScoreInArray..)
 * the cells is:
 * "Score", "Name", "Date"
 * in String[]... ScoreInArray
 *
 */
/**
 * @author Niklas Karlsson 0703032191, this in a ScoreBoardmaker, but it need some inputs
 * 
 *
 */

public class GuiHighScore extends JFrame {
	JPanel jp = new JPanel();

	JTable jT;

	/**
	 * @param title
	 * @param ScoreInArray
	 *            "title" is the name on the Jframe ScoreInArray ia a variable
	 *            2D array like following: "Score", "Name", "Date"
	 */
	public GuiHighScore(String title, String[]... ScoreInArray) {
		setTitle("TheGame - HighScore");
		setVisible(true);
		setSize(500, 250);
		// setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBackground(Color.white);

		// getContentPane().setBackground( Color.white );
		// jb.setIcon(new ImageIcon("...."));
		// jb.setBackground(Color.white);

		// correct way:
		// jb.setIcon(new ImageIcon(this.getClass().getResource("logo1.png")));
		// wrong way, "Test":
		// jb.setIcon(new ImageIcon("C:\\location\\logo1.png")); //is under "
		// C:\location\"

		// adderar en capsel!
		Box box = Box.createVerticalBox();

		add(box);

		JLabel label = new JLabel(title);
		Font f = label.getFont();
		// bold
		label.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
		label.setFont(f.deriveFont(f.getStyle() | Font.ITALIC));
		// unbold
		// label.setFont(f.deriveFont(f.getStyle() & ~Font.BOLD));

		label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		box.add(label);
		String[] name = { "Score", "Name", "Date" };
		Object[][] cells = ScoreInArray; // the 2Darray!

		jT = new JTable(cells, name);
		// jT.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(box);
		c.add(new JScrollPane(jT), BorderLayout.CENTER);

		add(jp);

		validate();

	}

	/**
	 * @param players
	 *            this call the "addToScoreFile" and play winner music..
	 */
	public void sendUpToScore(ArrayList<Player> players) {
		for (Player p : players) {
			addToScoreFile(p.getName(), p.getTotalPoints());
		}
		Sound.playSound_advance(Sound.WINNER);
	}

	/**
	 * @param name
	 * @param score
	 *            this add the Score and the players to a File: YGame.txt
	 */
	public static void addToScoreFile(String name, int score) {

		String oldData = HelperMethods.readFile("YGame.txt");
		StringBuilder sb = new StringBuilder(oldData);
		Date date = new Date();
		SimpleDateFormat sdf;
		sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String stringDate = sdf.format(date);
		sb.append(score + "@" + name + "@" + stringDate + ";"); // "\t"
		String scoreArray[] = sb.toString().split(";");
		List<String> scoreList = Arrays.asList(scoreArray);

		// Collections.sort(scoreList);
		// Collections.reverse(scoreList);
		Collections.sort(scoreList, new Comparator<String>() {
			@Override
			public int compare(String arg0, String arg1) {
				int index0 = arg0.indexOf('@');
				int index1 = arg1.indexOf('@');
				String a1 = arg1.substring(0, index1);
				String a0 = arg0.substring(0, index0);
				int a1Int = Integer.parseInt(a1);
				int a0Int = Integer.parseInt(a0);
				return (a1Int > a0Int) ? 1 : -1;
				// return arg1.compareTo(arg0);
			}
		});
		sb = new StringBuilder("");
		for (String user : scoreList) {
			sb.append(user + ";");
		}
		String newData = sb.toString();
		try {
			HelperMethods.writeFile("YGame.txt", newData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// -----------
}