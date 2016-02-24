package rulecheck;
/**
 * @author Niklas Karlsson 0703032191
 * 
 */
//import junit.framework.Test;

public class CheckWinner {

	// private ArrayList<String> brickPlacements= new ArrayList<>();
	// char[][] markers;
	// define all of the objects in the chain

	Chain chainCalc1 = new Rows(); // make a (Chain-interface)
									// "AddNumbers"-object, and so on...
	Chain chainCalc2 = new Colums();
	Chain chainCalc3 = new Diagonals();
	Chain chainCalc4 = new SpaceOrFull();

	// and so on..

	public CheckWinner() {

		// tell each object where to forward the
		// data if it can't process the request

		chainCalc1.setNextChain(chainCalc2); // if calc1 can't do it send the
												// data to next..
		chainCalc2.setNextChain(chainCalc3);
		chainCalc3.setNextChain(chainCalc4);
		// and so on..

		// Define the data in the Numbers Object
		// and send it to the first Object in the chain

	}

	public char startTest(char[][] markers) {
		BoardValues BoardValueTest = new BoardValues(markers); // The tester..
		BoardValueTest.resetKeyWinner();

		chainCalc1.winnerValidate(BoardValueTest);
		if (BoardValueTest.getKeyWinner() != 'N'
				&& BoardValueTest.getKeyWinner() != ' ') {
			System.out.println("we have a winner!");
		} else {
			// System.out.println("no winner...");
		}
		return BoardValueTest.getKeyWinner(); // can be 'X','0','-','N' (N = No
												// winner, full..)

	}

}