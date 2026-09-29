package levelPieces;

import java.util.Random;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Human extends GamePiece implements Moveable{
	private String label;
	private int location;
	private InteractionResult result;
	private Random r = new Random();
	private int moveChoice;

	public Human(int loc) {
		super('H', "Human - Moves randomly and is killed by vampires", loc);
		symbol = 'H';
		label = "Human - Moves randomly and is killed by vampires";
		location = loc;
		result = InteractionResult.NONE;
	}
	
	public void move(Drawable[] gameBoard, int playerLocation) {
		moveChoice = r.nextInt(2);
		if (moveChoice == 0) {
			if (gameBoard[location - 1] == null && location - 1 != playerLocation) {
				gameBoard[location] = null;
				this.setLocation(location--);
				gameBoard[location] = this;
			}
		} else if (moveChoice == 1) {
			if (gameBoard[location + 1] == null && location + 1 != playerLocation) {
				gameBoard[location] = null;
				this.setLocation(location++);
				gameBoard[location] = this;
			}
		}
	}
	
	public InteractionResult interact(Drawable [] gameboard, int playerLocation) {
		return result;
	}

}
