package test;



import game.board.GameState;
import game.general;

import org.junit.Test;
import static org.junit.Assert.*;

public class GeneralTest {
    @Test
    public void testCheckForWin() {
        // Test case 1: Blue wins
        general general = new general(3);
        
        general.checkForWin();
        assertEquals(GameState.B_WON, general.getGameState());

        // Test case 2: Red wins
        general = new general(3);
        
        general.checkForWin();
        assertEquals(GameState.R_WON, general.getGameState());

        // Test case 3: Draw
        general = new general(3);
        
        general.checkForWin();
        assertEquals(GameState.DRAW, general.getGameState());
    }
}

