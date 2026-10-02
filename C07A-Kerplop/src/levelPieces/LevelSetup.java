package levelPieces;

import gameEngine.*;
import java.util.ArrayList;

public class LevelSetup {
	private ArrayList<Moveable> movingPieces;
	private ArrayList<GamePiece> interactingPieces;
	private Drawable[] board;
	private int playerStartLoc;
	private GamePiece nextGamePiece;
	private Moveable nextMoveable;
	
	
	public LevelSetup() {
		board  = new Drawable[GameEngine.BOARD_SIZE];
		interactingPieces = new ArrayList<GamePiece>();
		movingPieces = new ArrayList<Moveable>();
	}
	
	public Drawable[] getBoard() {
		return board;
	}
	
	public void createLevel(int levelNum){
		if (levelNum == 1) {
			level1();
		} else if (levelNum == 2) {
			level2();
		}
		return;
	}
	
	public ArrayList<Moveable> getMovingPieces() {
		return movingPieces;
	}
	
	public ArrayList<GamePiece> getInteractingPieces() {
		return interactingPieces;
	}
	
	public int getPlayerStartLoc() {
		return playerStartLoc;
	}
	
	private void level1() { // mainly testing level
		playerStartLoc = 7;
		for (int i = 0; i < GameEngine.BOARD_SIZE; i++) {
			board[i] = null;
		}
		board[5] = new Dust(); // static vampire dust for spooky scary atmosphere
		nextGamePiece = new Mouth(6); // makes a new hellmouth at index 6
		board[6] = nextGamePiece;
		interactingPieces.add(nextGamePiece);
		nextMoveable = new Human(10); // new human at index 10
		board[10] = nextMoveable;
		movingPieces.add(nextMoveable);
		nextGamePiece = new Stake(9); // new stake at index 9
		board[9] = nextGamePiece;
		interactingPieces.add(nextGamePiece);
		nextGamePiece = new Cross(8); // new cross at index 8
		board[8] = nextGamePiece;
		interactingPieces.add(nextGamePiece);
		
		Vampire vamp = new Vampire(3); // new vampire at index 3
		board[3] = vamp;
		interactingPieces.add(vamp);
		movingPieces.add(vamp);
		
		vamp = new Vampire(16); // new vampire at index 16
		board[16] = vamp;
		interactingPieces.add(vamp);
		movingPieces.add(vamp);
	}
	
	private void level2() { // level where the player has to get the cross to get to the stake without dying to be able to kill the vampires
		playerStartLoc = 17;
		
		// Empty out everything to reset board
		for (int i = 0; i < GameEngine.BOARD_SIZE; i ++) {
			board[i] = null;
		}
		movingPieces.clear();
		interactingPieces.clear();
		
		Cross cross = new Cross(20); // new cross player has to grab
		board[20] = cross;
		interactingPieces.add(cross);
		
		Mouth mouth = new Mouth(19); // new hellmouth to guard the cross
		board[19] = mouth;
		interactingPieces.add(mouth);
		
		Glory glory = new Glory(15); // glory shoots at player while player is getting cross (might lead to unwinnable games, but is close enough that it probably won't happen often)
		board[15] = glory;
		interactingPieces.add(glory);
		
		Stake stake = new Stake(12); // new stake, guarded by vampires
		board[12] = stake;
		interactingPieces.add(stake);
		
		Vampire vamp = new Vampire(6); // new vampire, is the one the player has to get past to get the stake
		board[6] = vamp;
		interactingPieces.add(vamp);
		movingPieces.add(vamp);
		
		vamp = new Vampire(1); // new vampire that is just there to give two points
		board[1] = vamp;
		interactingPieces.add(vamp);
		movingPieces.add(vamp);
	}
}
