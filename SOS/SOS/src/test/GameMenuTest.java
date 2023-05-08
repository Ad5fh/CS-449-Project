package test;

import game.simple;
import game.GUI;
import org.junit.Test;



import static org.junit.Assert.*;

//Acceptance criteria 1.1

public class GameMenuTest {

	@Test
	public void testGUI() {
		GUI gui = new GUI(new simple(3));
		assertNotNull(gui);
		assertEquals("SOS Game", gui.getTitle());
		assertEquals(637, gui.getWidth());
		assertEquals(456, gui.getHeight());
		
	}
}

