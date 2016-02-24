package testTheChain;
/**
 * @author Niklas Karlsson 0703032191
 * 
 */
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import rulecheck.CheckWinner;

public class chainTester {

	CheckWinner checkWinner = new CheckWinner();
	private char[][] markers = { 
			{ 'O', 'O', ' ' }, 
			{ 'X', 'X', 'X' },
			{ ' ', ' ', ' ' } };
	char predictedResult = 'X';

	@Test
	public void TestChain() {
		char testWinnerChar = checkWinner.startTest(markers); // the
																// C.O.R.patern!!!!
																// :-)
		System.out.println("@Test checkWinner.startTest(markers):  = "
				+ testWinnerChar);
		assertEquals(predictedResult, testWinnerChar);

	}

}
