package rulecheck;
/**
 * @author Niklas Karlsson 0703032191
 * 
 */
public class BoardValues {

	private char[][] markers = null;

	private char keyWinner = 'N';

	public BoardValues(char[][] markers) {
		this.markers = markers;
		// this.keyWinner = keyWinner;
	}

	// just standard getter and setter..

	public char getKeyWinner() {
		return keyWinner;
	}

	public void setKeyWinner(char keyWinner) {
		this.keyWinner = keyWinner;
	}

	public void resetKeyWinner() {
		setKeyWinner('N');
	}

	public char[][] getMarkers() {
		return markers;
	}

	public void setMarkers(char[][] markers) {
		this.markers = markers;
	}
}