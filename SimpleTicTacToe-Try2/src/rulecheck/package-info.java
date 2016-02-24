/**
 * 
 */
/**
 * @author Niklas Karlsson 0703032191
 * 
 * 
 * <h1>This is the Pattern: Chain Of Responsebility</h1>
 * <p>
 * we use this from Playground, the Playgrounds Ask a checkWinner-object if there is something interesting on the board, </br>
 * by make a checkWinner object and then call the method: startTest(markers), with Playgrounds "markers" ( the boards char[][] )</br>
 * <p>
 * FIRST :</br>
 * we have the "core interface" : Chain (this is the interface for all the rule-classes) </br>
 * 	setNextChain(Chain nextChain)</br>
 * 		that is for order the chain and the "only" the "custom/specific chain" know is the second "link" in the chain. :-)</br>
 *  winnerValidate(BoardValues validateAngle);</br>
 *  	Is for "check the board -if statement" (should we return the winner or else jump to next "link" (the "NextChain")</br>
 *  makeStrings();</br>
 *  	is a simple way to transform the markers/bricks from the playground for the "winner validate" so it can look for a winner pattern"</br>
 *  <p>
 *  
 * 
 * SECOND:</br>
 * we have the class BoardValues, the class that "jumps in the chain"..</br>
 *	with BoardValues(char[][] markers)</br>
 *		that only save the markers "locally" to work with.</br>
 *	The get and setKeyWinner() return:s/set the char keyWinner, [values ' ' or 'X' or 'O' or 'N' (N = No winner/full board) ]</br>
 *<p>
 *
 * SO:</br>
 * CheckWinner, when a object instantiate it first</br>
 * make 4 chain-object (the link in the chain)  </br>
 * 		"check Rows"(chainCalc1), "check Colums"(chainCalc2), "check Diagonal's"(chainCalc3), "is board full"(chainCalc4).</br>
 * Then</br>
 * set the ORDER of the link in the chain</br>
 * "first check Rows", then if no winner, "check Colums", then if no winner, "check Diagonal's", and if no winner check if the "is board full"..</br>
 * 		NOTE: important to remember the last link, It is responsible to return some sort result!</br>
 * Then, when the ORDER is set, we take the "markers" (char[][]) that we set from the playground(by calling the startTest), and</br> 
 * make a BoardValueTest-object that holds the markers and has a variable for "is there a winner":  "KeyWinner".</br>
 * <p>
 * then we put the BoardValueTest in the first chain (calling the method : winnerValidate( BoardValueTest)</br>
 * the BoardValueTest jumps thru the chain until we "get a hit", and then we look for the returning result..</br>
 * by returning the BoardValueTest.getKeyWinner(), to the playground.  </br>
 * </br> 
 *
 */
package rulecheck;