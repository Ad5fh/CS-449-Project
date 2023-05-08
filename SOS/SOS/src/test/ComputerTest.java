package test;
import game.board.GameState;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ComputerTest {

    private game.board board;

    @Before
    public void setUp() {
        board = new game.board(3);
    }

    @Test
    public void testInitBoard() {
        board.initBoard();
        assertEquals(0, board.bluePoints);
        assertEquals(0, board.redPoints);
        assertEquals(board.currentGameState, board.currentGameState);
        assertEquals('B', board.getTurn());
        assertEquals(0, board.totalMoves);
        
    }

    @Test
    public void testGetCell() {
        board.setCell(0, 0, board.Cell.S);
        assertEquals(board.Cell.S, board.getCell(0, 0));
        assertNull(board.getCell(3, 3));
    }

    @Test
    public void testSetCell() {
        board.setCell(0, 0, board.Cell.S);
        assertEquals(board.Cell.S, board.getCell(0, 0));
    }

    @Test
    public void testMakeMove() {
        assertTrue(board.makeMove(0, 0));
        assertFalse(board.makeMove(0, 0));
        assertEquals('R', board.getTurn());
    }

    @Test
    public void testUpdateState() {
        board.setCell(0, 0, board.Cell.S);
        board.setCell(0, 1, board.Cell.O);
        board.setCell(0, 2, board.Cell.S);
        board.setCell(1, 0, board.Cell.S);
        board.setCell(1, 1, board.Cell.S);
        board.setCell(1, 2, board.Cell.O);
        board.setCell(2, 0, board.Cell.S);
        board.setCell(2, 1, board.Cell.O);
        board.setCell(2, 2, board.Cell.S);
        board.updateState();
        assertEquals(board.currentGameState.B_WON, board.getGameState());
    }
}


