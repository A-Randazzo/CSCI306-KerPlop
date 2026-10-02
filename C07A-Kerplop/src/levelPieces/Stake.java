package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Stake extends GamePiece{
	private boolean pickedUp; // To track if the stake has been picked up to not repeat the effect

	public Stake(int loc) {
		super('S', "Stake - Picking it up allows you to kill Vampires for points", loc);
	};
	
	public InteractionResult interact(Drawable [] gameboard, int playerLocation) {
		if (pickedUp) { // If it has been picked up, return none
			return InteractionResult.NONE;
		}
		if (super.getLocation() == playerLocation) { // if the player is on top of the stake, make vampires harmless and set pickedUp to true
			Vampire.vampRange = -1;
			gameboard[playerLocation] = null;
			pickedUp = true;
		}
		return InteractionResult.NONE;
	}

}
