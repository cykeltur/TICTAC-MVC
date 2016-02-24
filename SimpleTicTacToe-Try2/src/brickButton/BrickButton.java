package brickButton;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import ourException.OurException;
import player.Player;
import playground.Playground;
import theEnum.CharToImg;
/**
 * @author Niklas Karlsson 0703032191
 * 
 */
public class BrickButton extends JButton implements Observer {

	//private String ID;
	private int[] IDinKlicker;

	public int[] getIDinKlicker() {
		return IDinKlicker;
	}

	public void setIDinKlicker(int[] IDinKlicker) {
		IDinKlicker = IDinKlicker;
	}

	private char observedChar = 'D'; // just for the startingpoint..

	public BrickButton(String ID, Player[] players) {
		// this.ID = ID;
		CharToImg image1Path;
		image1Path = CharToImg.valueOf(String.valueOf(observedChar));
		ImageIcon buttonImg = new ImageIcon(
				BrickButton.class.getResource(image1Path.getImgPath()));

		if (!ID.matches("^[0-99,0-99]+$")) { // kontrollerar först om det
			// var siffra som matades in
			try {
				throw new OurException("try again");
			} catch (OurException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("ID = " + ID);
			String[] cordIDString = ID.split(",");
			
			IDinKlicker = new int[cordIDString.length];
			for (int i = 0; i < cordIDString.length; i++) {
				IDinKlicker[i] = Integer.parseInt(cordIDString[i]);
				System.out.println("intarray :" + IDinKlicker[i]);
			}// nu har vi en kordinat.. [x,y] i int-format..
		}
		// and to use the ENUM :
		// CharToImg.valueOf("X")
		// oneBric = new JButton("-");
		this.IDinKlicker = IDinKlicker;

		setText(ID);
		setIcon(buttonImg);
		setEnabled(true);
		setForeground(Color.black);
		setBackground(Color.white);
		setBorderPainted(true);
		// oneBric.setToolTipText("Click to set your brick here..");
		setToolTipText(""
				+ "<html><body style=\"text-align: center; font-family:comic sans ms,cursive; background-color:White\">"
				+ "<b>Click to: <br>" + "-Place&nbsp;your&nbsp;Brick</b><br>"
				+ "&nbsp;</body></html>");
		setOpaque(false);

		addActionListener(Playground.getALInstance(players, this));

	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Playground) {
			System.out
					.println("this is the ID for a button (clicket or not clicked) : "
							+ IDinKlicker[0] + IDinKlicker[1]);
			System.out
					.println("IDinKlicke, is this the button för the change?");
			observedChar = ((Playground) o).getValue(IDinKlicker, observedChar);
			System.out.println("inne i Observer brick:" + IDinKlicker[0] + ""
					+ IDinKlicker[1] + " : " + observedChar);
			CharToImg image1Path;
			image1Path = CharToImg.valueOf(String.valueOf(observedChar));
			ImageIcon buttonImg = new ImageIcon(
					BrickButton.class.getResource(image1Path.getImgPath()));
			setIcon(buttonImg);

			validate();
			revalidate();
			repaint();
			System.out.println("PAINTED");

		} else {
			System.out.println("ELSE CASE");
			observedChar = 'D';
		}
	}

}
