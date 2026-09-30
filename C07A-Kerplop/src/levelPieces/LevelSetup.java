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
//		} else if (levelNum == 2) {
//			level2();
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
	
	private void level1() {
		playerStartLoc = 7;
		for (int i = 0; i < GameEngine.BOARD_SIZE; i++) {
			board[i] = null;
		}
		board[5] = new Dust();
		nextGamePiece = new Mouth(6);
		board[6] = nextGamePiece;
		interactingPieces.add(nextGamePiece);
		nextMoveable = new Human(10);
		board[10] = nextMoveable;
		movingPieces.add(nextMoveable);
		nextGamePiece = new Glory(15);
		board[15] = nextGamePiece;
		interactingPieces.add(nextGamePiece);
		nextGamePiece = new Vampire(3);
		board[3] = nextGamePiece;
		interactingPieces.add(nextGamePiece);
		nextGamePiece = new Stake(9);
		board[9] = nextGamePiece;
		interactingPieces.add(nextGamePiece);
		nextGamePiece = new Cross(8);
		board[8] = nextGamePiece;
		interactingPieces.add(nextGamePiece);
		
	}
	
//	private void level2() {
//		
//	}
}
