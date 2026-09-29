package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Mouth extends GamePiece{
	private String label;
	private int location;
	private InteractionResult result;

	public Mouth(int loc) {
		super('M', "Hellmouth - Kills the player if stepped on", loc);
		symbol = 'M';
		label = "Hellmouth - Kills the player if stepped on";
		location = loc;
		result = InteractionResult.NONE;
	}
	
	public InteractionResult interact(Drawable [] gameboard, int playerLocation) {
		if (this.location == playerLocation) {
			result = InteractionResult.KILL;
		}
		return result;
	}

}
