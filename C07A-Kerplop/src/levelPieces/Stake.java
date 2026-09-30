package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Stake extends GamePiece{

	public Stake(int loc) {
		super('S', "Stake - Picking it up allows you to kill Vampires", loc);
	};
	
	public InteractionResult interact(Drawable [] gameboard, int playerLocation) {
		if (super.getLocation() == playerLocation) {
			Vampire.vampRange = -1;
			gameboard[playerLocation] = null;
		}
		return InteractionResult.NONE;
	}

}
