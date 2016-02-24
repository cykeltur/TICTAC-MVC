package rulecheck;
/**
 * @author Niklas Karlsson 0703032191
 * 
 */
public class SpaceOrFull implements Chain {

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
		// System.out.println("\n ..do the validation...");
		String DiagonalsINstring = makeStringDiagonals();
		String RowsINstring = makeStringRows();
		String ColumINstring = makeStringColums();

		if (DiagonalsINstring.contains(" ") || RowsINstring.contains(" ")
				|| ColumINstring.contains(" "))
			validateAngle.setKeyWinner(' ');
		else
			validateAngle.setKeyWinner('N');

		// System.out.println("\n we have no winner anyware :-(");

	}

	private String makeStringDiagonals() {
		StringBuilder st = new StringBuilder(";");
		for (int q = 0; q < validateAngle.getMarkers().length
				* validateAngle.getMarkers().length; q++) {
			for (int i = 0; i < validateAngle.getMarkers().length; i++) {
				for (int j = 0; j < validateAngle.getMarkers().length; j++) {
					if (validateAngle.getMarkers().length - 1 - i - j >= 0
							&& validateAngle.getMarkers().length - (j + q) > 0) {
						st.append(validateAngle.getMarkers()[j + q][validateAngle
								.getMarkers().length - 1 - i - j]);
					}
				}
				st.append(";");
			}

		}
		// System.out.println("troligen klar med HELA \\ diagonalerna..");
		// över d\
		st.append("&");
		for (int i = 0; i < validateAngle.getMarkers().length; i++) {
			for (int j = 0; j + i < validateAngle.getMarkers().length; j++) {
				st.append(validateAngle.getMarkers()[j][j + i]);
			}
			st.append(";");
		}
		st.append("&");
		// System.out.println("\nUNDRE d\\ kandidater?:");
		for (int i = 0; i < validateAngle.getMarkers().length; i++) {
			for (int j = 0; j + i < validateAngle.getMarkers().length; j++) {
				st.append(validateAngle.getMarkers()[j + i][j]);
			}
			st.append(";");
		}
		// System.out.println(st.toString());
		return st.toString();
	}

	private String makeStringRows() {
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

	private String makeStringColums() {
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