package levelPieces;

import java.util.Random;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

/*Theoretically this seems to work correctly :)
 * My only question is, can the player exist in the same spot as glory?*/

public class Glory extends GamePiece{
	private Random r = new Random();
	
	public Glory(int loc) {
		super('G', "Glory - An erratic goddess that randomly chooses a spot to her right to attack", loc);
	}
	
	public InteractionResult interact(Drawable [] gameboard, int playerLocation) {
		int pos = r.nextInt(gameboard.length - super.getLocation()) + super.getLocation(); //generated random number between Glory's position and the right end of the board
		if (playerLocation == pos) { // If Glory's random target is where the player is, hit the player
			return InteractionResult.HIT;
		}
		return InteractionResult.NONE;
	}
}
