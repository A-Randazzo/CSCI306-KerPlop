package levelPieces;

import gameEngine.Drawable;
import gameEngine.Moveable;
import gameEngine.InteractionResult;

public class Vampire extends GamePiece implements Moveable{
	public static int vampRange; // public static to be shared by all vampires and to be able to be changed in cross and stake
	private boolean isDead; // prevents from moving and interacting after has been killed by player

	public Vampire(int loc) {
		super('V', "Vampire - Jumps over obstacles to get to Player. Begins with a range of 2. Collect Crosses to decrease range", loc);
		vampRange = 2; // starting range
		isDead = false;
	}
	
	public InteractionResult interact(Drawable [] gameboard, int playerLocation) {
		if (isDead) { // skip if dead
			return InteractionResult.NONE;
		}
		int dist = Math.abs(playerLocation- super.getLocation()); // gets distance from player
		if (playerLocation == super.getLocation() && vampRange < 0) { // if player has stake and is on top of the vampire
			gameboard[playerLocation] = new Dust(); // replace the vampire with vampire dust
			isDead = true; // sets dead to true to prevent postmortem action
			return InteractionResult.GET_POINT; // get a point
		} else if (dist < vampRange + 1) { // if player is in range without the cross, hit the player
			return InteractionResult.HIT;
		}
		return InteractionResult.NONE;
	}
	
	public void move(Drawable[] gameBoard, int playerLocation) {
		if (isDead) { // skip if dead
			return;
		}
		int location = super.getLocation();
		int moveDist = 0; // starts with a move of zero, will be increased so vampire can jump over things
		if (location < playerLocation) {
			while (gameBoard[location + moveDist] != null && location + moveDist < playerLocation) { // loop to get vampire to jump over things to get closer to player without stepping into player position
				if (location + moveDist + 1 == playerLocation) {
					break;
				}
				moveDist++;
			}
			gameBoard[location] = null;
			super.setLocation(location + moveDist);
			gameBoard[super.getLocation()] = this; // makes sure that vampire is still on the board by using new location instead of location + moveDist, though don't think that can happen because it gets stopped by player
		}
		if (location > playerLocation) {
			while (gameBoard[location - moveDist] != null && location - moveDist > playerLocation) { // same loop, just for moving left
				if (location - moveDist - 1 == playerLocation) {
					break;
				}
				moveDist++;
			}
			gameBoard[location] = null;
			super.setLocation(location - moveDist);
			gameBoard[super.getLocation()] = this;
		}
		return;
	}

}
