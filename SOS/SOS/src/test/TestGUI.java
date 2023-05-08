package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.awt.*;

import game.GUI;



public class TestGUI {
	private GUI GUI;

	@Before
	public void setUp() throws Exception {
		 GUI = new GUI();
	}

	@After
	public void tearDown() throws Exception {
	}

	


    @Test
    public void test() {
        assertNotNull(GUI);

        // Test the JFrame properties
        assertEquals("SOS Game", GUI.getTitle());
        assertTrue(GUI.isResizable());
        assertFalse(GUI.isUndecorated());
        assertEquals(new Dimension(637, 456), GUI.getSize());
        
    }
    @Test
	public void testEmptyBoard() {	
		new GUI(); 
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
    
}

