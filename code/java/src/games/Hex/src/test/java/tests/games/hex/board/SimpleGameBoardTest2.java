package tests.games.hex.board;

import org.junit.Before;
import org.junit.Test;

import code.games.hex.board.SimpleGameBoard;
import code.games.hex.board.Tile;
import code.games.hex.gameMechanics.Move;
import code.games.hex.gameMechanics.PlayerColor;
import static org.junit.Assert.*;

public class SimpleGameBoardTest2 {

    private SimpleGameBoard board;
    private static final int SIZE = 10;


    @Before
    public void setUp() throws Exception {
        board = new SimpleGameBoard(SIZE);
    }

    @Test
    public void testSimpleGameBoardCopyColoredNodes1() {
        board.makeMove(new Move(2, 3), PlayerColor.RED);
        board.makeMove(new Move(3, 2), PlayerColor.BLUE);
        board.makeMove(new Move(1, 9), PlayerColor.RED);
        board.makeMove(new Move(9, 2), PlayerColor.RED);
        board.makeMove(new Move(6, 7), PlayerColor.BLUE);
        SimpleGameBoard copy = new SimpleGameBoard(board);
        assertNotNull(copy);
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                assertNotSame(board.getTileAt(i, j), copy.getTileAt(i, j));
                assertEquals(board.getTileAt(i, j), copy.getTileAt(i, j));
            }
        }
    }

    @Test
    public void testGetTileAt2() {
        board.makeMove(new Move(2, 3), PlayerColor.RED);
        Tile t = board.getTileAt(2, 3);
        assertNotNull(t);
        assertEquals("The Color of your tile was incorrect", t.getColor(), PlayerColor.RED);
    }

    @Test
    public void testGetTileAt3() {
        board.makeMove(new Move(1, 6), PlayerColor.BLUE);
        Tile t = board.getTileAt(1, 6);
        assertNotNull(t);
        assertEquals("The Color of your tile was incorrect", t.getColor(), PlayerColor.BLUE);
    }

    @Test
    public void testGetTileAt4() {
        Tile t = board.getTileAt(3, 2);
        assertNotNull(t);
        assertEquals("The Color of your tile was incorrect", t.getColor(), PlayerColor.BLANK);
    }

    @Test
    public void testMakeMove3() {
        board = new SimpleGameBoard(4);
        board.makeMove(new Move(3, 2), PlayerColor.BLUE);
        assertEquals("You are not changing the board's Tiles correctly", board
                .getTileAt(3, 2).getColor(), PlayerColor.BLUE);
    }

    @Test(expected = Throwable.class)
    public void testMakeMove4() {
        board = new SimpleGameBoard(4);
        board.makeMove(new Move(1, -3), PlayerColor.RED);
    }

    @Test(expected = Throwable.class)
    public void testMakeMove5() {
        board = new SimpleGameBoard(4);
        board.makeMove(new Move(6, 2), PlayerColor.RED);
    }

    @Test(expected = Throwable.class)
    public void testMakeMove6() {
        board = new SimpleGameBoard(4);
        board.makeMove(new Move(2, 7), PlayerColor.RED);
    }

}
