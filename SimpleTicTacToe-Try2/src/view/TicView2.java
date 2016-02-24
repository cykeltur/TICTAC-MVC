package view;
/**
 * @author Niklas K
 * 
 */
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;

import player.Player;
import playground.Playground;
import brickButton.BrickButton;

public class TicView2 implements MouseListener {
	private static Scanner in;
	Player players[];
	int playgroundSize = 3; // we have this default...
	Playground playground = Playground.getInstance();

	public JFrame theGameWindow;
	private ArrayList<BrickButton> bricksGui = new ArrayList<BrickButton>();

	private BrickButton brickButtonDummy;
	private int gridHights;
	private int gridWith;
	private int SizeOfPlayGround = 0;
	private String gameName;
	private String[] iDForButtons;

	public Frame f;

	int n, m;
	int flag = 1; // X and O
	private Graphics g;
	private boolean isNOTfirstTime = false;
	private char brick;

	public TicView2(String[] playerNames) {
		setGameName("Retro view");
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

		f = new Frame(gameName + "  -- Click to start.. --");
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(600, 600);
		g = f.getGraphics();
		g.drawLine(200, 0, 200, 600);
		g.drawLine(400, 0, 400, 600);
		g.drawLine(0, 200, 600, 200);
		g.drawLine(0, 400, 600, 400);
		f.addMouseListener(this);

		// makeFrameTheGameWindow(gameName);
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

	public void placementNotOk() {
		System.out.println("ERROR_TYPO");
		playground.printFreeSpots();
	}

	public void setIDForButtons(String[] iDForButtons) {
		this.iDForButtons = iDForButtons;

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		g = f.getGraphics();
		g.drawLine(200, 0, 200, 600);
		g.drawLine(400, 0, 400, 600);
		g.drawLine(0, 200, 600, 200);
		g.drawLine(0, 400, 600, 400);

		int x = e.getX();
		int y = e.getY();
		if (isNOTfirstTime) {
			brick = playground.getBrickTurnChar();
			if (brick == 'X')
				flag = 1;
			if (brick == 'O')
				flag = 0;
			String cordinate = "1,1";

			if (flag == 1) // X
			{

				if (x < 200 && y < 200) {
					m = 0;
					n = 0;
					System.out.println(cordinate = "0,0");
				}
				if ((x > 200 && x < 400) && (y < 200)) {
					m = 200;
					n = 0;
					System.out.println(cordinate = "0,1");
				}
				if ((x > 400 && x < 600) && (y < 200)) {
					m = 400;
					n = 0;
					System.out.println(cordinate = "0,2");
				}
				if (x < 200 && (y > 200 && y < 400)) {
					m = 0;
					n = 200;
					System.out.println(cordinate = "1,0");
				}
				if ((x > 200 && x < 400) && (y > 200 && y < 400)) {
					m = 200;
					n = 200;
					System.out.println(cordinate = "1,1");
				}
				if ((x > 400 && x < 600) && (y > 200 && y < 400)) {
					m = 400;
					n = 200;
					System.out.println(cordinate = "1,2");
				}
				if (x < 200 && (y > 400 && y < 600)) {
					m = 0;
					n = 400;
					System.out.println(cordinate = "2,0");
				}
				if ((x > 200 && x < 400) && (y > 400 && y < 600)) {
					m = 200;
					n = 400;
					System.out.println(cordinate = "2,1");
				}
				if ((x > 400 && x < 600) && (y > 400 && y < 600)) {
					m = 400;
					n = 400;
					System.out.println(cordinate = "2,2");
				}

			}

			if (flag == 0) // O
			{

				if (x < 200 && y < 200) {
					m = 0;
					n = 20;
					System.out.println(cordinate = "0,0");
				}
				if ((x > 200 && x < 400) && (y < 200)) {
					m = 200;
					n = 20;
					System.out.println(cordinate = "0,1");
				}
				if ((x > 400 && x < 600) && (y < 200)) {
					m = 400;
					n = 20;
					System.out.println(cordinate = "0,2");
				}
				if (x < 200 && (y > 200 && y < 400)) {
					m = 0;
					n = 200;
					System.out.println(cordinate = "1,0");
				}
				if ((x > 200 && x < 400) && (y > 200 && y < 400)) {
					m = 200;
					n = 200;
					System.out.println(cordinate = "1,1");
				}
				if ((x > 400 && x < 600) && (y > 200 && y < 400)) {
					m = 400;
					n = 200;
					System.out.println(cordinate = "1,2");
				}
				if (x < 200 && (y > 400 && y < 600)) {
					m = 0;
					n = 400;
					System.out.println(cordinate = "2,0");
				}
				if ((x > 200 && x < 400) && (y > 400 && y < 600)) {
					m = 200;
					n = 400;
					System.out.println(cordinate = "2,1");
				}
				if ((x > 400 && x < 600) && (y > 400 && y < 600)) {
					m = 400;
					n = 400;
					System.out.println(cordinate = "2,2");
				}

			}
			String[] cordString = cordinate.split(",");
			int[] cortint = new int[cordString.length];

			brickButtonDummy = new BrickButton(cordinate, players);
			brickButtonDummy.setIDinKlicker(cortint);
			System.out.println("clicked on " + cordinate);

			try {

				brickButtonDummy.doClick(1);
			} catch (Exception e1) {
				System.out.println("test fault!!!");
				e1.printStackTrace();
			}
			if (flag == 1 && (brick != playground.getBrickTurnChar())) // X
			{
				System.out.println("brick when flagga 1(X) is " + brick);
				System.out.println("playground.getBrickTurnChar = "
						+ playground.getBrickTurnChar());
				g.setColor(Color.red);
				g.drawLine(m, n, m + 199, n + 199);
				g.drawLine(m + 199, n, m, n + 199);
			}
			if (flag == 0 && (brick != playground.getBrickTurnChar())) // O
			{
				System.out.println("brick when flagga 0(O) is " + brick);
				System.out.println("playground.getBrickTurnChar = "
						+ playground.getBrickTurnChar());
				g.setColor(Color.orange);
				g.drawOval(m + 10, n + 10, 169, 169);
			}

		}

		isNOTfirstTime = true;
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
