package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Cross extends GamePiece{

	public Cross(int loc) {
		super('C', "Cross - Picking it up decreases the range of Vampires", loc);
	};
	
	public InteractionResult interact(Drawable [] gameboard, int playerLocation) {
		if (super.getLocation() == playerLocation) {
			Vampire.vampRange--;
			gameboard[playerLocation] = null;
		}
		return InteractionResult.NONE;
	}

}
