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

public class TicView2_old2 {
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

	public TicView2_old2(String[] playerNames) {
		setGameName("Tack-Tac-Toe..");
		make2Players(playerNames); // we have this default...
		makePlaygroundSise(); // we have this default...
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

	private void make2Players(String[] playerNamesFromInput) {
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
	}

	public Player[] getNewPlayerNames() {
		return players;
	}

	public int getPlaygroundSize() {
		return playgroundSize;
	}

	public void makeGui() {
		// SizeOfPlayGround = 9;
		SizeOfPlayGround = getPlaygroundSize() * getPlaygroundSize();
		System.out.println("SizeOfPlayGround " + SizeOfPlayGround);
		iDForButtons = playground.getFreeSpotsID().split(" ");
		System.out.println("length on iDForButtons = " + iDForButtons.length);
		populateBricksGui(SizeOfPlayGround);
		gridHights = bricksGui.size() / 2;
		gridWith = bricksGui.size() / 2;
		makeFrameTheGameWindow(gameName);
	}

	private void populateBricksGui(int SizeOfPlayGround) {
		// System.out.println("sixe of  iDForButtons[i] = " +
		// iDForButtons.length);
		for (int i = 0; i < SizeOfPlayGround; i++) {
			// System.out.println("populating button,  i =" + i +
			// " and iDForButtons[i] = " + iDForButtons[i]);
			bricksGui.add(new BrickButton(iDForButtons[i], players));

		}
	}

	private void makeFrameTheGameWindow(String gameName) {
		theGameWindow = null;
		theGameWindow = new JFrame(gameName);
		theGameWindow.getContentPane().setBackground(new Color(220, 250, 250));
		theGameWindow.setVisible(true);
		theGameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theGameWindow.setBounds(100, 100, 200, 200);
		theGameWindow.setSize((ScreenInfo.getScreenW()),
				(ScreenInfo.getScreenH()));
		theGameWindow.setLayout(new GridLayout(gridHights, gridWith));
		theGameWindow.setResizable(true);
		theGameWindow.pack();
		for (JButton button : bricksGui) {
			theGameWindow.add(button);
		}
		theGameWindow.pack();

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
