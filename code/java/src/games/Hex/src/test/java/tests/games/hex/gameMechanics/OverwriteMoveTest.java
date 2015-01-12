package tests.games.hex.gameMechanics;

import org.junit.Test;

import code.games.hex.gameMechanics.OverwriteMove;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class OverwriteMoveTest {

    @Test
    public void testOverwriteMove() throws ClassNotFoundException {
        OverwriteMove m = new OverwriteMove(3, 4);
        assertNotNull(m);
        assertEquals(Class.forName("edu.indiana.cs.c212.gameMechanics.OverwriteMove"), m.getClass());
        assertEquals(3, m.getX());
        assertEquals(4, m.getY());
    }

}
