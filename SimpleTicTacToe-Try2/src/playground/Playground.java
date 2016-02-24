package playground;
/**
 * @author Niklas Karlsson 0703032191
 * 	       Abe on 21/01/16 fixed the separation playground and start
 * 
 */
import java.util.Observable;

import ourException.OurException;
import player.Player;
import rulecheck.CheckWinner;
import brickButton.BrickButton;
import brickButton.TicTacActionListener;

public class Playground extends Observable {

	private static Playground instance = null;
	private static TicTacActionListener ALinstance = null;
	private int size;
	private int sizeFromStart;
	private char[][] markers; // Själva markörplatserna på brädet.
	private char winner = 0;
	private String playBoard;
	private final String FREE_BRICKS = "Lediga platser : ";
	private char brickTurnChar = 'X';
	private char brickToPlace;
	private int[] ID;

	protected Playground() {

	}

	// Tar fram våran instans av AL:n och lägger till observeraren BrickButton
	// på våran Playground.
	
	public static TicTacActionListener getALInstance(Player[] players,
			BrickButton brickButton) {
		if (ALinstance == null) {
			ALinstance = new TicTacActionListener(players);

		}
		instance.addObserver(brickButton);
		return ALinstance;
	}

	public void updateButtonImage(int[] iD, char brickToPlace) {
		ID = iD;
		this.brickToPlace = brickToPlace;
		setChanged();
		notifyObservers();

	}

	public char getValue(int[] ID, char oldbrick) {
		System.out.println("inne i getValue med " + ID.length + " i längd och "
				+ ID[0] + ID[1]);
		System.out.println("är denna ID null? = ");
		if (this.ID == null) {
			System.out.println("true");
		} else
			System.out.println("false");
		if (this.ID == ID) {
			System.out.println("return brickToPlace :" + brickToPlace);
			return brickToPlace;
		}
		System.out.println("nopp return (the old): " + oldbrick);
		return oldbrick;
	}

	// Singleton-usage; bara en instans av Playground skapas, resten
	// refererar(?) bara till den om de vill ha egna.
	public static Playground getInstance() {
		if (instance == null) {
			instance = new Playground();
		}
		// instance.addObserver(new BrickButton());
		return instance;
	}

	public void setPlaygroundSize(int playgroundSize) {

		size = playgroundSize;
		sizeFromStart = size;
		setMarkersSize(size);
	}

	private void setMarkersSize(int size) {
		int row = size;
		int col = size;
		markers = new char[row][col];
		clearMarker();
	}

	private void clearMarker() {
		for (int r = 0; r < markers.length; r++) {
			for (int c = 0; c < markers[r].length; c++) {
				markers[r][c] = ' ';
			}
		}
	}

	public void resetBoard() {
		clearMarker();
	}

	public void resetWinner() {
		winner = 0;
	}

	public void updateGUI() {
		clearConsole();
		print();

	}

	public void print() {
		makePlayground(size);
		System.out.format(playBoard);
	}

	private void makePlayground(int size) {

		StringBuilder str = new StringBuilder("");

		boolean UnEavenRow = false;
		for (int varv = 0; varv < ((size * 2) - 1); varv++) { // antal rader..

			for (int box = 0; box < (size); box++) {

				if (!UnEavenRow && box != size - 1) {
					str.append(markers[varv / 2][box] + "|");

				} else if (!UnEavenRow && box == size - 1) {
					str.append(markers[varv / 2][box] + "");

				} else if (UnEavenRow && box != size - 1) {
					str.append("-+");
				} else {
					str.append("-");
				}

			}
			if (!UnEavenRow) {
				// str.substring(str.length()-1);
				str.append("%n");
				UnEavenRow = true;
			} else {
				// str.substring(str.length()-3);
				str.append("%n");
				UnEavenRow = false;
			}

		}

		str.append("");
		playBoard = str.toString();

	}

	private void clearConsole() {
		for (int i = 0; i < 2; i++) {
			System.out.println("\n");
		}
	}

	public boolean isTherAWinnerOrFull() {

		if (isWinnerFromString()) {
			return true;
		}
		if (isMarkersFullFromString()) {
			return true;
		}
		return false;
	}

	// Om
	public boolean isMarkersFullFromString() {
		if (getWinnerCharBricFromString() != ' ') {
			return true;
		}

		return false;
	}

	// Kolla ifall någon vunnit.
	public boolean isWinnerFromString() {
		if (getWinnerCharBricFromString() == 'N'
				|| getWinnerCharBricFromString() == ' ') {
			return false;
		}

		return true;
	}

	public char getWinnerCharBricFromString() {

		CheckWinner checkWinner = new CheckWinner();
		char winnerChar = checkWinner.startTest(markers); // the
															// C.O.R.patern!!!!
															// :-)
		// System.out.println("winnerChar " + winnerChar);
		return winnerChar;
	}

	//
	//
	//
	// private String makeStringDiagonals() {
	// StringBuilder st = new StringBuilder(";");
	// for (int q = 0; q < markers.length * markers.length; q++) {
	// for (int i = 0; i < markers.length; i++) {
	// for (int j = 0; j < markers.length; j++) {
	// if (markers.length - 1 - i - j >= 0
	// && markers.length - (j + q) > 0) {
	// st.append(markers[j + q][markers.length - 1 - i - j]);
	// }
	// }
	// st.append(";");
	// }
	//
	// }
	// // System.out.println("troligen klar med HELA \\ diagonalerna..");
	// // över d\
	// st.append("&");
	// for (int i = 0; i < markers.length; i++) {
	// for (int j = 0; j + i < markers.length; j++) {
	// st.append(markers[j][j + i]);
	// }
	// st.append(";");
	// }
	// st.append("&");
	// // System.out.println("\nUNDRE d\\ kandidater?:");
	// for (int i = 0; i < markers.length; i++) {
	// for (int j = 0; j + i < markers.length; j++) {
	// st.append(markers[j + i][j]);
	// }
	// st.append(";");
	// }
	//
	// return st.toString();
	// }
	//
	// private String makeStringRows() {
	// StringBuilder st = new StringBuilder(";");
	// //
	// System.out.println("________\nvanligt: alla rader MEN med ; efter varje rad /eller varje tre:a i raden");
	// for (int i = 0; i < markers.length; i++) {
	// for (int j = 0; j < markers.length; j++) {
	// if (j % markers.length != 0) {
	// st.append(markers[i][j]);
	//
	// } else {
	// st.append(";");
	// st.append(markers[i][j]);
	// }
	//
	// }
	//
	// }
	// return st.toString();
	// }
	//
	//
	// private String makeStringColums() {
	// StringBuilder st = new StringBuilder(";");
	// // System.out.println("\n alla komumner?:");
	// for (int i = 0; i < markers.length; i++) {
	// for (int j = 0; j < markers.length; j++) {
	// if (j % markers.length != 0) {
	// st.append(markers[j][i]);
	//
	// } else {
	// st.append(";");
	// st.append(markers[j][i]);
	// }
	//
	// }
	// }
	// return st.toString();
	// }
	//

	public void setMarkersToDefault() {
		int row = sizeFromStart;
		int col = sizeFromStart;
		markers = null;
		markers = new char[row][col];
		size = sizeFromStart;
		clearMarker();
	}

	public void printFreeSpots() {
		System.out.println(FREE_BRICKS);
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				if (markers[row][col] == ' ') {
					System.out.print(row + "," + col + "  ");
				}
			}
			System.out.println(" ");
		}
	}

	public String getFreeSpotsID() {
		StringBuilder sb = new StringBuilder("");
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				if (markers[row][col] == ' ') {
					sb.append(row + "," + col + " ");
				}
			}
			// sb.append(" ");
		}
		String IDInString = sb.toString();
		IDInString = IDInString.trim();
		System.out.println("ID i en string = " + IDInString);
		return IDInString;
	}

	// Placeringsmetoden. Vi kollar att det är giltig plats.
	public boolean placeBric(char BricType, int[] iD) throws OurException {
		// System.out.println(bricInput);
		// Pattern pattern = Pattern.compile("num,num");
		// bricInput.matches("^[0,0-99,99].*")
		// if (!bricInput.matches("^[0-99,0-99]+$")) { // kontrollerar först om
		// det
		// // var siffra som matades in
		// throw new OurException("try again");
		//
		// } else {
		// String[] placementString = bricInput.split(",");
		// int[] placement = new int[placementString.length];
		// for (int i = 0; i < placementString.length; i++) {
		// placement[i] = Integer.parseInt(placementString[i]);
		// }// nu har vi en kordinat.. [x,y] i int-format..

		// System.out.println(Arrays.toString(placement));
		int[] placement = iD;
		if (placement[0] <= placement[1] && placement[1] > (markers.length - 1)) { // försöker
																					// vi
			// placera
			// utanför?
			System.out.println("utanför?");
			throw new OurException("try again");
		}
		if (placement[1] <= placement[0] && placement[0] > (markers.length - 1)) { // försöker
																					// vi
			// placera
			// utanför?
			throw new OurException("try again");
		}
		// Om platsen är tom...
		if (checkIfBoxEmty(placement)) {
			markers[placement[0]][placement[1]] = BricType;
		} else {
			throw new OurException("try again");
		}
		toggleBricChar();
		return true;
		// }
	}

	// Toggla mellan X och O
	private void toggleBricChar() {
		if (brickTurnChar == 'X')
			brickTurnChar = 'O';
		else
			brickTurnChar = 'X';

	}

	private boolean checkIfBoxEmty(int[] placement) {
		if (markers[placement[0]][placement[1]] == ' ') {
			return true;
		}
		return false;
	}

	// gettern som är X eller O.
	public char getBrickTurnChar() {
		return brickTurnChar;
	}

	// public void setTakenID() {
	//
	// }

}
