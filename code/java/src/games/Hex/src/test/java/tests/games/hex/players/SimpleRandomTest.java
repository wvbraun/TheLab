package tests.games.hex.players;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import code.games.hex.board.SimpleGameBoard;
import code.games.hex.gameMechanics.Move;
import code.games.hex.gameMechanics.PlayerColor;
import code.games.hex.gameMechanics.StandardRules;
import code.games.hex.players.SimpleRandomPlayer;

public class SimpleRandomTest {

    SimpleRandomPlayer random;
    StandardRules rules;
    SimpleGameBoard board;
    SimpleRandomPlayer random2;
    @Before
    public void setup(){
        random = new SimpleRandomPlayer(PlayerColor.RED);
        random2 = new SimpleRandomPlayer(PlayerColor.BLUE);
        board = new SimpleGameBoard(4);
        rules = new StandardRules(board, random, random);
    }
    @Test
    public void testGetName() {
        assertEquals("Simple Random", random.getName());
    }

    @Test
    public void testSimpleRandom() {
        assertNotNull(random);
    }

    @Test
    public void testGetMove() {
        ArrayList<Move> legalMoves = rules.getLegalMoves(random);
        Move m = random.getMove(new SimpleGameBoard(board), legalMoves);
        assertTrue(legalMoves.contains(m));
    }

    @Test
    public void testGetColor1() {
        assertEquals(PlayerColor.RED, random.getColor());
    }
    @Test
    public void testGetColor2() {
        assertEquals(PlayerColor.BLUE, random2.getColor());
    }
    @Test
    public void testGetColor3() {
        assertNotNull(random.getColor());
    }

}
