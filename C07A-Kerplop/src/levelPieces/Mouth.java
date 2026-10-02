package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Mouth extends GamePiece{
	private InteractionResult result;

	public Mouth(int loc) {
		super('M', "Hellmouth - Kills the player if stepped on", loc);
	}
	
	public InteractionResult interact(Drawable [] gameboard, int playerLocation) {
		result = InteractionResult.NONE;
		if (super.getLocation() == playerLocation) { // If the player is on top of the hellmouth, return kill
			result = InteractionResult.KILL;
		}
		return result;
	}

}
