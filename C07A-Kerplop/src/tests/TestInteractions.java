package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import levelPieces.Cross;
import levelPieces.Glory;
import levelPieces.Human;
import levelPieces.Mouth;
import levelPieces.Stake;
import levelPieces.Vampire;

public class TestInteractions {
	Drawable[] board;

	/*
	 * Tests if hellmouth kills on same square as player
	 */
	@Test
	public void testHellmouth() {
		board = new Drawable[GameEngine.BOARD_SIZE];
		Mouth mouth = new Mouth(15);
		board[15] = mouth;
		
		// Check to make sure the hellmouth kills the player properly
		assertEquals(InteractionResult.KILL, mouth.interact(board, 15));
		
		// Check to make sure that hellmouth only kills player when they are on the same square
		for (int i = 0; i < 15; i++)
			assertEquals(InteractionResult.NONE, mouth.interact(board, i));
		for (int i = 16; i < GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, mouth.interact(board, i));
	}
	
	/*
	 * Tests for cross
	 */
	@Test
	public void testCross() {
		board = new Drawable[GameEngine.BOARD_SIZE];
		Vampire.vampRange = 2;
		
		Cross cross = new Cross(8);
		board[8] = cross;
		
		// Check for range not changing while player is not on cross spot
		for (int i = 0; i < 8; i++) { // Because cross always returns none, the only difference comes from the vampire range changing
			cross.interact(board, i);
			assertEquals(2, Vampire.vampRange);
		}
		for (int i = 9; i < GameEngine.BOARD_SIZE; i++) {
			cross.interact(board, i);
			assertEquals(2, Vampire.vampRange);
		}
		
		// Check if range decreases after cross is grabbed
		cross.interact(board, 8);
		assertEquals(1, Vampire.vampRange);
		
		// Check to make sure range doesn't move after cross space is stepped on again
		cross.interact(board, 8);
		assertEquals(1, Vampire.vampRange);
	}
	
	/*
	 * Tests for stake
	 */
	@Test
	public void testStake() {
		board = new Drawable[GameEngine.BOARD_SIZE];
		Vampire.vampRange = 2;
		
		Stake stake = new Stake(8);
		board[8] = stake;
		
		// Check for range not changing while player is not on stake spot
		for (int i = 0; i < 8; i++) { // Because stake always returns none, the only difference comes from the vampire range changing
			stake.interact(board, i);
			assertEquals(2, Vampire.vampRange);
		}
		for (int i = 9; i < GameEngine.BOARD_SIZE; i++) {
			stake.interact(board, i);
			assertEquals(2, Vampire.vampRange);
		}
		
		// Check if range decreases after stake is grabbed
		stake.interact(board, 8);
		assertEquals(-1, Vampire.vampRange);
	}
	
	/*
	 * Checks for Glory
	 */
	@Test
	public void testGlory() {
		board = new Drawable[GameEngine.BOARD_SIZE];
		
		Glory glory = new Glory(6);
		board[6] = glory;
		
		// Check to make sure that glory cannot hit to the left
		for (int i = 0; i < 300; i++) { // Extremely statistically unlikely for glory to miss player if she can hit in the spots next to her
			assertEquals(InteractionResult.NONE, glory.interact(board, 5));
		}
		// Becuase her target is random, we accurately cannot test if her attacks can hit player
	}
	
	/*
	 * Check human
	 */
	@Test
	public void testHuman() {
		board = new Drawable[GameEngine.BOARD_SIZE];
		
		Human human = new Human(6);
		board[6] = human;
		
		// Human always returns none, check to make sure it does
		assertEquals(InteractionResult.NONE, human.interact(board, 9));
	}
	
	/*
	 * Checks for vampire
	 */
	@Test
	public void testVampire() {
		board = new Drawable[GameEngine.BOARD_SIZE];
		
		Vampire vamp = new Vampire(7);
		board[7] = vamp;
		
		// Check if vampire hits all the squares in range 2
		for (int i = 5; i < 10; i++) {
			assertEquals(InteractionResult.HIT, vamp.interact(board, i));
		}
		
		// Check if vampire range changes correctly after a cross is picked up (range decreases by 1)
		Vampire.vampRange--;
		assertEquals(InteractionResult.NONE, vamp.interact(board, 5));
		assertEquals(InteractionResult.NONE, vamp.interact(board, 9));
		for (int i = 6; i < 9; i++) {
			assertEquals(InteractionResult.HIT, vamp.interact(board, i));
		}
		
		// Check if vampire is killed by player after player gets stake
		Vampire.vampRange = -1;
		assertEquals(InteractionResult.GET_POINT, vamp.interact(board, 7));
	}
}
