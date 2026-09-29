package levelPieces;

import java.util.Random;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

/*Theoretically this seems to work correctly :)
 * My only question is, can the player exist in the same spot as glory?*/

public class Glory extends GamePiece{
	private Random r = new Random();
	private int pos = 0; //to hold where glory is attacking
	
	public Glory(int loc) {
		super('G', "Glory - An erratic goddess that randomly chooses a spot to her right to attack", loc);
	}
	
	public InteractionResult interact(Drawable [] gameboard, int playerLocation) {
		pos = r.nextInt(gameboard.length - super.getLocation()) + super.getLocation(); //generated random number between Glory's position and the right end of the board
		if (playerLocation == pos) {
			return InteractionResult.HIT;
		}
		return InteractionResult.NONE;
	}
}
