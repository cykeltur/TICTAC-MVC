import brickButton.TicTacActionListener;

public class Main {

	public static void main(String[] args) {
		/**
		 * @author Niklas Karlsson 0703032191
		 * 
		 */
		
		/*
		 * TODO: CORRECT MVC! (?) ACtionlistener (for model from view) that can
		 * handle click on exact ButtonID Designmönstret Observer/Observable
		 * används på lämpligt ställe !! (not done) EnumMap/Enum for change
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
		 * "Ytterligare ett designmönster används på motiverat ställe" = done!
		 * "Spelet innehåller ett gränssnitt (interface) på lämpligt ställe" = I
		 * think DONE (please look at chain)
		 * 
		 * add singleton in "playground"
		 * "Designmönstret Singleton används på lämpligt ställe" = DONE
		 * 
		 * add a char to imgpath "Enum används på lämpligt ställe" = done!
		 */
		// prompt the user1 to enter their name

		TicTacActionListener.runGame();

	}

}
