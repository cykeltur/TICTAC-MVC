package testTheChain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import rulecheck.CheckWinner;

/**
 * Created by Abe on 21/01/16 and Niklas K.
 */
public class chainTesterTest {

	CheckWinner checkWinner = new CheckWinner();
	private char[][] markers = { { 'O', 'O', 'O' }, { 'X', 'X', ' ' },
			{ ' ', ' ', ' ' } };
	char predictedResult = 'O';

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