package rulecheck;
/**
 * @author Niklas Karlsson 0703032191
 * 
 */
public class Colums implements Chain {

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
		// System.out.println("\n ..do the validation (colums)...");
		String ColumsINstring = makeStringColums();
		// validateAngle.setKeyWinner('?');

		if (ColumsINstring.contains("XXX"))
			validateAngle.setKeyWinner('X');
		else if (ColumsINstring.contains("OOO"))
			validateAngle.setKeyWinner('O');

		// validateAngle.setKeyWinner('?');

		if (validateAngle.getKeyWinner() == 'X') {
			// System.out.println("\n we have a col-winner!");

		} else if (validateAngle.getKeyWinner() == 'O') {
			// System.out.println("\n we have a col-winner!");

		} else {
			/*
			 * if (ColumsINstring.contains(" "))
			 * validateAngle.setKeyWinner(' '); else
			 * validateAngle.setKeyWinner('N');
			 */
			// System.out.println("\n we have no winner in this test.");
			nextInChain.winnerValidate(validateAngle);
		}
	}

	public String makeStringColums() {
		return makeStrings();
	}

	@Override
	public String makeStrings() {
		StringBuilder st = new StringBuilder(";");
		// System.out.println("\n alla komumner?:");
		for (int i = 0; i < validateAngle.getMarkers().length; i++) {
			for (int j = 0; j < validateAngle.getMarkers().length; j++) {
				if (j % validateAngle.getMarkers().length != 0) {
					st.append(validateAngle.getMarkers()[j][i]);

				} else {
					st.append(";");
					st.append(validateAngle.getMarkers()[j][i]);
				}

			}
		}
		// System.out.println(st.toString());
		return st.toString();
	}

}