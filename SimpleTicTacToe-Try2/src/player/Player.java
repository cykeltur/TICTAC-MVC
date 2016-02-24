/**
 * @author Niklas, Jan, Ulrika
 * 
 */
package player;

public class Player extends Human {
	public Player() {
		super();

	}

	private String name;
	private boolean winner;
	private char brickChar;
	private int Score = 0;

	// 1
	public boolean setName(String name) {

		this.name = name;
		super.setTheName(name);

		return true;

	}

	// 2
	public void setBrickChar(char brickChar) {
		this.brickChar = brickChar;
	}

	// 3
	public void resetWinner() {
		winner = false;
	}

	// 5
	public String getName() {
		super.getTheName();
		return name;
	}

	// 6
	public char getBrickChar() {
		return brickChar;
	}

	// 7
	public void setToWinner() {
		addScore();

		winner = true;

	}

	private void addScore() {
		Score = Score + 1;

	}

	// 10
	public int getScore() {

		return Score;
	}

	public int getTotalPoints() {

		return Score;
	}

}
