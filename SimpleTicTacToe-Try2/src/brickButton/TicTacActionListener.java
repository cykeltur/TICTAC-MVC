package brickButton;

import helpers.HelperMethods;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ourException.OurException;
import player.Player;
import playground.Playground;
import view.TicView;
import view.TicView2;
/**
 * @author Niklas Karlsson 0703032191
 * 		   Abe on 21/01/16 fixed the separation playground and start.
 */
public class TicTacActionListener implements ActionListener {

	private static TicTacActionListener instance = null;
	private int[] ID;
	private String IDString = null;
	private Playground playground = Playground.getInstance();
	private Player[] players;
	private char brickToPlace;
	public static boolean gameOver;
	static String name1 = null;
	static String name2 = null;
	static int setector = 2;
	static TicView view;
	static TicView2 view2;

	public static TicTacActionListener getInstance(Player[] players,
			BrickButton brickButton) {
		if (instance == null) {
			instance = new TicTacActionListener(players);

		}
		return instance;
	}

	public TicTacActionListener(Player[] players) {
		this.players = players;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ACTION PERFORMED");
		if (gameOver) {
			// view.theGameWindow.dispatchEvent(new
			// WindowEvent(view.theGameWindow, WindowEvent.WINDOW_CLOSING));
			if (setector == 0) {
				view.theGameWindow.dispose();
			} else if (setector == 1) {
				System.out.println(setector);
				view2.f.dispose();
			}
			playground.resetBoard();
			playground.print();
			System.out.println("Time for a new game!");
			runGame();
			gameOver = false;
		}
		// Om brädet INTE har fyllts eller har en vinnare så
		else if (!playground.isTherAWinnerOrFull()) {
			System.out.println("INNE I ELSEN");
			BrickButton theClick = (BrickButton) e.getSource();
			// thecling.inK;
			// JButton clickedButtonObject = (JButton)e.getSource();
			// Vi tar emot ID:t på klicket
			ID = theClick.getIDinKlicker();
			System.out.println("ID ÄR " + ID);
			System.out.println("game over ÄR " + gameOver);

			System.out.println("click ID : " + ID);
			// Vi sparar char som är X eller O. Sedan försöker vi placera X/O
			// med placeBric på specifierad plats.
			brickToPlace = playground.getBrickTurnChar();
			System.out.println("BricktoPlace: " + brickToPlace);
			System.out.println("ID: " + ID);
			System.out
					.println("here do we thr  the exception..try/catch:ing (normal infotext..) :-)");
			try {
				playground.placeBric(brickToPlace, ID);
				IDString = "";
				// Tar upp de två värdena i arrayen och lägger i string med ,
				// mellan.
				for (int i = 0; i < ID.length; i++) {
					IDString = IDString + ID[i] + ",";
				}
				IDString = IDString.substring(0, (IDString.length() - 1));
				System.out.println("ID = " + IDString);
				System.out.println("brick type : " + brickToPlace);
				System.out
						.println("- this is sent to all the observers from the observerble: "
								+ brickToPlace + ID[0] + ID[1]);

				playground.updateButtonImage(ID, brickToPlace);
				System.out.println("UPPDATERAT BILDEN");
				playground.print();
			} catch (OurException e1) {
				JOptionPane.showMessageDialog(new JFrame("Please tryagain"),
						"OurException: \n Please try again",
						"Please try again", JOptionPane.WARNING_MESSAGE);
				e1.printStackTrace();
			}

			// kolla om någon vunnit eller om det är fullt, om char är X vinner
			// den spelaren som hade X (player 1).
			if (playground.isTherAWinnerOrFull()) {
				HelperMethods.Beep();
				System.out.println("we can have a winnercandidate!");
				if (playground.getWinnerCharBricFromString() == 'X') {
					System.out.println("the winner is X");
					System.out.println(getPlayerNameWithBrik(playground
							.getWinnerCharBricFromString()));
					JOptionPane.showMessageDialog(
							new JFrame("Game stop"),
							"the winner is: "
									+ getPlayerNameWithBrik(playground
											.getWinnerCharBricFromString()));
					gameOver = true;
					playground.resetBoard();
					playground.print();

				} else if (playground.getWinnerCharBricFromString() == 'O') {
					System.out.println("the winner is O");
					System.out.println(getPlayerNameWithBrik(playground
							.getWinnerCharBricFromString()));
					JOptionPane.showMessageDialog(
							new JFrame("Game stop"),
							"the winner is: "
									+ getPlayerNameWithBrik(playground
											.getWinnerCharBricFromString()));
					gameOver = true;
					playground.resetBoard();
					playground.print();
				} else if (playground.getWinnerCharBricFromString() == 'N') {
					System.out.println("NO winner!");
					JOptionPane.showMessageDialog(new JFrame("Game stop"),
							"NO winner!");
					gameOver = true;
					playground.resetBoard();
					playground.print();
				}
			}
		} else {
			System.out.println("the game is finished..");

		}
	}

	private String getPlayerNameWithBrik(char bric) {
		for (Player player : players) {
			if (player.getBrickChar() == bric) {
				return player.getName();
			}
		}
		return "no name!";

	}

	public char getValue(int[] ID, char oldbrick) {
		if (this.ID == ID)
			return brickToPlace;
		return oldbrick;
	}

	public static void runGame() {
		/*
		 * stage "1".. ask for players name
		 */
		// Vid start av spelet har spelare inget namn, de kan välja att mata in
		// något eller vara blankt.
		if (name1 == null || name1.equalsIgnoreCase("")) {
			name1 = JOptionPane.showInputDialog(new JFrame("Player X"),
					"P1-What's your name?");
			if (name1 == null) {
				System.out.println("LET'S SHUT IT DOWN");
				System.exit(0);
			}

			// Namn tilldelas om inget specifierats.
			else if (name1.equals("")) { // if no name = defalt name..
				name1 = "Player 1";

			}

		}
		// player2
		if (name2 == null || name2.equalsIgnoreCase("")) {
			name2 = JOptionPane.showInputDialog(new JFrame("Player O"),
					"P2-What's your name?");
			if (name2 == null) {
				System.out.println("SHUT DOWN");
				System.exit(0);

			}

			else if (name2.equals("")) {
				name2 = "Player 2";
			}

		}

		System.out.println(name1);
		System.out.println(name2);
		// make a array of the playerString-names
		String[] playersNames = { name1, name2 };

		// GUI selector..
		Object[] options = { "Classic View", "Retro view" }; // only for the
																// view
																// selector-button-text
		setector = JOptionPane.showOptionDialog(new JFrame("GUI-selector"),
				"select a GUI?", "GUI-selector", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, // do not use a custom Icon
				options, // the titles of buttons
				options[0]); // default button title
		System.out.println("setector : " + setector);

		// now start the game!
		if (setector == 0) {
			view = new TicView(playersNames); // run/instansiate the view 1 with
												// 2 name
		} else if (setector == 1) {
			view2 = new TicView2(playersNames); // run/instansiate the view 2
												// with 2 name
		}
	}

}
