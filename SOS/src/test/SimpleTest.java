package test;

import org.junit.Test;

import game.board.GameState;
import game.simple;

import static org.junit.Assert.*;

public class SimpleTest {

  @Test
  public void testCheckForWin() {
    // Create a 3x3 board
    simple board = new simple(3);

    // Test initial state
    assertEquals(GameState.PLAYING, board.getGameState());

    // Make some moves
    board.makeMove(0, 0);
    board.makeMove(1, 0);
    board.makeMove(0, 1);

    // Test blue wins
    board.makeMove(1, 1);
    board.makeMove(0, 2);
    assertEquals(GameState.B_WON, board.getGameState());

    // Reset board and make different moves
   
    board.makeMove(0, 0);
    board.makeMove(1, 0);
    board.makeMove(0, 1);

    // Test game still in progress
    board.makeMove(1, 1);
    assertEquals(GameState.PLAYING, board.getGameState());

    // Make more moves to result in a draw
    board.makeMove(2, 0);
    board.makeMove(1, 2);
    board.makeMove(2, 1);
    board.makeMove(2, 2);

    // Test draw state
    assertEquals(GameState.DRAW, board.getGameState());
  }
}
