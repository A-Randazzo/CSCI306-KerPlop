package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Cross extends GamePiece{
	private boolean pickedUp; // To track if the cross has been picked up to not repeat the effect

	public Cross(int loc) {
		super('C', "Cross - Picking it up decreases the range of Vampires", loc);
		pickedUp = false;
	};
	
	public InteractionResult interact(Drawable [] gameboard, int playerLocation) {
		if (pickedUp) {
			return InteractionResult.NONE;
		}
		if (super.getLocation() == playerLocation) {
			Vampire.vampRange--;
			gameboard[playerLocation] = null; // Remove the cross from the board
			pickedUp = true; // Sets to true to prevent more interactions in the future
		}
		return InteractionResult.NONE;
	}

}
