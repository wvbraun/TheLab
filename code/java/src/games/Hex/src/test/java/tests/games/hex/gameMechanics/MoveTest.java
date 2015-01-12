package tests.games.hex.gameMechanics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import code.games.hex.gameMechanics.Move;

public class MoveTest {

	@Test(timeout = 100)
	public void testMove() {
		Move m = new Move(2, 3);
		assertNotNull(m);
	}

	@Test(timeout = 100)
	public void testGetX() {
		Move m = new Move(4, 3);
		assertEquals(4, m.getX());
	}

	@Test(timeout = 100)
	public void testGetY() {
		Move m = new Move(1, 2);
		assertEquals(2, m.getY());
	}

	@Test(timeout = 100)
	public void testEquals() {
		Move m = new Move(1, 2);
		Move m2 = new Move(1, 2);
		assertEquals("a move with the same X and Y should be equals", m, m2);
	}
}
