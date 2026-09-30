package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Vampire extends GamePiece{
	public static int vampRange;
	int dist; //distance from vampire

	public Vampire(int loc) {
		super('V', "Vampire - Begins with a range of 2. Collect Crosses to decrease range", loc);
		vampRange = 2;
	}
	
	public InteractionResult interact(Drawable [] gameboard, int playerLocation) {
		dist = Math.abs(playerLocation- super.getLocation()); 
		if (playerLocation == super.getLocation() && vampRange < 0) {
			gameboard[playerLocation] = new Dust();
			return InteractionResult.GET_POINT;
		} else if (dist < vampRange + 1) {
			return InteractionResult.HIT;
		}
		return InteractionResult.NONE;
	}

}
