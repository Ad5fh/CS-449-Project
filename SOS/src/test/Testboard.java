package test;

import static org.junit.Assert.*;

import org.junit.Test;

import game.board;

public class Testboard {

    @Test
    public void testInitBoard() {
        board b = new board(3);
        assertEquals(board.GameState.PLAYING, b.getGameState());
        assertEquals('B', b.getTurn());
        
        assertEquals(board.Cell.EMPTY, b.getCell(0,0));
        assertEquals(board.Cell.EMPTY, b.getCell(1,1));
        assertEquals(board.Cell.EMPTY, b.getCell(2,2));
    }


    @Test
    public void testSetCell() {
        board b = new board(3);
        b.setCell(0, 0, board.Cell.S);
        
        b.setCell(1, 1, board.Cell.O);
        
        b.setCell(-1, -1, board.Cell.S);
        assertNull(b.getCell(-1,-1));
    }

    @Test
    public void testSwitchTurn() {
        board b = new board(3);
        assertEquals('B', b.getTurn());
        b.switchTurn();
        assertEquals('R', b.getTurn());
        b.switchTurn();
        assertEquals('B', b.getTurn());
    }

    @Test
    public void testMakeMove() {
        board b = new board(3);
        
        assertEquals(board.Cell.S, b.getCell(0,0));
        assertFalse(b.makeMove(0,0));
        assertEquals(board.Cell.S, b.getCell(0,0));
        assertTrue(b.makeMove(0,1));
        assertEquals(board.Cell.O, b.getCell(0,1));
        assertFalse(b.makeMove(-1,0));
        assertFalse(b.makeMove(3,3));
    }

}

