package rulecheck;
/**
 * @author Niklas Karlsson 0703032191
 * 
 */
public class Rows implements Chain {

	private Chain nextInChain;
	public BoardValues validateAngle;

	// Defines the next Object to receive the
	// data if this one can't use it

	public void setNextChain(Chain nextChain) {

		nextInChain = nextChain;

	}

	// Tries to validate the data, or passes it
	// to the Object defined in method setNextChain()

	public void winnerValidate(BoardValues validateAngle) {
		this.validateAngle = validateAngle;
		// System.out.println("\n ..do the validation (ROW)...");
		String RowsINstring = makeStringRows();

		if (RowsINstring.contains("XXX"))
			validateAngle.setKeyWinner('X');
		else if (RowsINstring.contains("OOO"))
			validateAngle.setKeyWinner('O');

		// validateAngle.setKeyWinner('?');

		if (validateAngle.getKeyWinner() == 'X') {
			// System.out.println("\n we have a row-winner!");

		} else if (validateAngle.getKeyWinner() == 'O') {
			// System.out.println("\n we have a row-winner!");

		} else {
			/*
			 * if (RowsINstring.contains(" ")) validateAngle.setKeyWinner(' ');
			 * else validateAngle.setKeyWinner('N');
			 */

			// System.out.println("\n we have no winner in this test.");
			nextInChain.winnerValidate(validateAngle);
		}

	}

	private String makeStringRows() {
		return makeStrings();
	}

	@Override
	public String makeStrings() {
		StringBuilder st = new StringBuilder(";");
		for (int i = 0; i < validateAngle.getMarkers().length; i++) {
			for (int j = 0; j < validateAngle.getMarkers().length; j++) {
				if (j % validateAngle.getMarkers().length != 0) {
					st.append(validateAngle.getMarkers()[i][j]);

				} else {
					st.append(";");
					st.append(validateAngle.getMarkers()[i][j]);
				}
			}
		}
		// System.out.println(st.toString());
		return st.toString();
	}

}