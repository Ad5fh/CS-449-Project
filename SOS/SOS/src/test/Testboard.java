package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import game.board;

import game.board.Cell;
import game.board.GameState;

public class Testboard {
	private board b;

	@Before
	public void setUp() throws Exception {
		 
	}

	@After
	public void tearDown() throws Exception {
	}


	
    @Test
    public void testInitBoard() {
        
        assertEquals(GameState.PLAYING, GameState());
        assertEquals('B', b.getTurn());
        
        assertEquals(Cell.EMPTY, getCell(0,0));
        assertEquals(Cell.EMPTY, getCell(1,1));
        assertEquals(Cell.EMPTY, b.getCell(2,2));
    }


    private Object getCell(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	private Object GameState() {
		// TODO Auto-generated method stub
		return null;
	}

	

    

    @Test
    public void testMakeMove() {
       
        
        assertEquals(board.Cell.S, b.getCell(0,0));
        assertFalse(b.makeMove(0,0));
        assertEquals(board.Cell.S, b.getCell(0,0));
        assertTrue(b.makeMove(0,1));
        assertEquals(board.Cell.O, b.getCell(0,1));
        assertFalse(b.makeMove(-1,0));
        assertFalse(b.makeMove(3,3));
    }

}