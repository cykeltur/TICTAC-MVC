package view;
/**
 * @author Niklas Karlsson 0703032191
 * 
 */
import helpers.ScreenInfo;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;

import player.Player;
import playground.Playground;
import brickButton.BrickButton;

public class TicView {
	private static Scanner in;
	Player players[];
	int playgroundSize = 3; // we have this default...
	Playground playground = Playground.getInstance();

	public JFrame theGameWindow;
	private ArrayList<BrickButton> bricksGui = new ArrayList<BrickButton>();
	private int gridHights;
	private int gridWith;
	private int SizeOfPlayGround = 0;
	private String gameName;
	private String[] iDForButtons;

	// here is the first thing from the controller instruction:
	// "build up the GUI"
	public TicView(String[] playerNames) {
		setGameName("Tack-Tac-Toe Classic..");
		make2Players(playerNames); // we have this default...
		// now we have 2 players with the inputnames and one uniqe bric each
		// (char 'X' or 'O')
		makePlaygroundSise(); // just det it to 3x3..
		makeGui();
	}

	private void setGameName(String gameName) {
		this.gameName = gameName;
	}

	private void makePlaygroundSise() {
		setPlaygroundSize(3);
	}

	private void setPlaygroundSize(int i) {
		int playgroundSize = i;
		playground.setPlaygroundSize(i);

	}

	private void make2Players(String[] playerNamesFromInput) { // from the
																// build-up for
																// the game..
		players = new Player[2]; // a simple 2 array of players..
		char[] playersBricktypes = null;

		if (players.length == 2) {
			playersBricktypes = new char[] { 'X', 'O' };
		}

		for (int i = 0; i < players.length; i++) {
			players[i] = new Player();
		}

		// now we add "stringnames" to the players..
		for (int i = 0; i < players.length; i++) {
			players[i].setName(playerNamesFromInput[i]);
			players[i].setBrickChar(playersBricktypes[i]); // and then set the
															// bricktype (only 2
															// types..
		}
		// now we have 2 players with the inputnames and one uniqe bric each
		// (char 'X' or 'O')
	}

	public Player[] getNewPlayerNames() {
		return players;
	}

	public int getPlaygroundSize() {
		return playgroundSize;
	}

	public void makeGui() {
		SizeOfPlayGround = getPlaygroundSize() * getPlaygroundSize();
		System.out.println("SizeOfPlayGround " + SizeOfPlayGround);
		iDForButtons = playground.getFreeSpotsID().split(" ");
		System.out.println("length on iDForButtons = " + iDForButtons.length);
		populateBricksGui(SizeOfPlayGround);
		gridHights = bricksGui.size() / 2;
		gridWith = bricksGui.size() / 2;
		makeFrameTheGameWindow(gameName);
	}

	// Fyller på
	private void populateBricksGui(int SizeOfPlayGround) {
		// System.out.println("sixe of  iDForButtons[i] = " +
		// iDForButtons.length);
		for (int i = 0; i < SizeOfPlayGround; i++) {
			// System.out.println("populating button,  i =" + i +
			// " and iDForButtons[i] = " + iDForButtons[i]);
			bricksGui.add(new BrickButton(iDForButtons[i], players));
			// adding a button the with ID

		}
	}

	private void makeFrameTheGameWindow(String gameName) {
		theGameWindow = null;
		theGameWindow = new JFrame(gameName);
		theGameWindow.getContentPane().setBackground(new Color(0, 184, 46));
		theGameWindow.setVisible(true);
		theGameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// theGameWindow.setBounds(100, 100, 586, 468);
		theGameWindow.setSize((ScreenInfo.getScreenW() / 3),
				(ScreenInfo.getScreenH() / 2));
		theGameWindow.setLayout(new GridLayout(gridHights, gridWith));
		// theGameWindow.setResizable(false);

		for (JButton button : bricksGui) {
			theGameWindow.add(button);
		}
		// theGameWindow.pack();

	}

	public String indata() {
		// tar in indata "efter" nextline.
		String input = null;
		in = new Scanner(System.in);
		input = in.nextLine();
		in = null;
		return input;
	}

	public void placementNotOk() {
		System.out.println("ERROR_TYPO");
		playground.printFreeSpots();
	}

	public void setIDForButtons(String[] iDForButtons) {
		this.iDForButtons = iDForButtons;

	}

}
