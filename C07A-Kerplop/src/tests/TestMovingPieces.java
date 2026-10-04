package tests;

import org.junit.jupiter.api.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import levelPieces.Dust;
import levelPieces.Human;
import levelPieces.Vampire;

public class TestMovingPieces {
	Drawable[] board;

	/*
	 * Test human movement
	 */
	@Test
	public void testHuman() {
		board = new Drawable[GameEngine.BOARD_SIZE];
		
		Human human = new Human(10);
		board[10] = human;
		
		// Check if human only moves one square and check if human can move both left and right
		boolean left = false;
		boolean right = true;
		int startLoc = 10;
		for (int i = 0; i < 100; i++) {
			human.move(board, 11);
			int loc = human.getLocation();
			if (startLoc - loc > 0) {
				left = true;
			}
			if (startLoc - loc < 0) {
				right = true;
			}
			assert(Math.abs(startLoc - loc) < 2);
			startLoc = loc;
		}
		assert(left==true);
		assert(right==true);
		
	}
	
	/*
	 * Test vampire movement
	 */
	@Test
	public void testVampire() {
		board = new Drawable[GameEngine.BOARD_SIZE];
		
		Vampire vamp = new Vampire(4);
		board[4] = vamp;
		
		// Check that vampire moves towards human
		vamp.move(board, 8);
		assert(vamp.getLocation() == 5);
		
		// Check that vampire jumps over obstacles
		board[6] = new Dust();
		board[7] = new Dust();
		board[8] = new Dust();
		board[9] = new Dust();
		
		vamp.move(board, 12);
		assert(vamp.getLocation() == 10);
	}

}
