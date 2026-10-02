package levelPieces;

import java.util.Random;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Human extends GamePiece implements Moveable{
	private InteractionResult result;
	private Random r = new Random();
	

	public Human(int loc) {
		super('H', "Human - Moves left and right randomly", loc);
		result = InteractionResult.NONE;
	}
	
	public void move(Drawable[] gameBoard, int playerLocation) {
		int location = super.getLocation();
		int moveChoice = r.nextInt(2); // Gets 0 or 1 to dictate next move
		if (moveChoice == 0) { // move left
			if (gameBoard[location - 1] == null && location - 1 != playerLocation) { // if there is nothing in its path including player, move
				gameBoard[location] = null; // set board spot to null
				super.setLocation(location - 1); // sets location
				gameBoard[location - 1] = this; // puts self in correct board location
			}
		} else if (moveChoice == 1) { // move right, rest is same as above
			if (gameBoard[location + 1] == null && location + 1 != playerLocation) {
				gameBoard[location] = null;
				super.setLocation(location + 1);
				gameBoard[location + 1] = this;
			}
		}
	}
	
	public InteractionResult interact(Drawable [] gameboard, int playerLocation) {
		return result; // just return none, main action in the game is acting like a leap frog for the vampires
	}

}
