import brickButton.TicTacActionListener;

public class Main {

	public static void main(String[] args) {
		/**
		 * @author Niklas Karlsson 0703032191
		 * 
		 */
		
		/*
		 * TODO: CORRECT MVC! (?) ACtionlistener (for model from view) that can
		 * handle click on exact ButtonID Designm�nstret Observer/Observable
		 * anv�nds p� l�mpligt st�lle !! (not done) EnumMap/Enum for change
		 * 'X'/'O' to a image of an X/O
		 * 
		 * make a testclass for the C.O.R
		 * 
		 * view 2! (we can just "cnage the background color, or change this in a
		 * thread every 10 second)
		 * 
		 * DONE: change so if we change the playground the observer change the
		 * button: (thru the ENUM char to image) Inherit from Exception OK add
		 * the C.O.R to the checker!! :-)
		 * "Ytterligare ett designm�nster anv�nds p� motiverat st�lle" = done!
		 * "Spelet inneh�ller ett gr�nssnitt (interface) p� l�mpligt st�lle" = I
		 * think DONE (please look at chain)
		 * 
		 * add singleton in "playground"
		 * "Designm�nstret Singleton anv�nds p� l�mpligt st�lle" = DONE
		 * 
		 * add a char to imgpath "Enum anv�nds p� l�mpligt st�lle" = done!
		 */
		// prompt the user1 to enter their name

		TicTacActionListener.runGame();

	}

}
