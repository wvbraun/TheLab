package tests.games.hex.gameMechanics;

import org.junit.Before;
import org.junit.Test;

import code.games.hex.board.SimpleGameBoard;
import code.games.hex.execptions.InvalidMoveException;
import code.games.hex.gameMechanics.Move;
import code.games.hex.gameMechanics.OverwriteMove;
import code.games.hex.gameMechanics.OverwriteRules;
import code.games.hex.gameMechanics.PlayerColor;
import code.games.hex.players.CommandLinePlayer;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class OverwriteRulesTest {

    OverwriteRules    rules;
    SimpleGameBoard   board;
    CommandLinePlayer playerRed;
    CommandLinePlayer playerBlue;

    @Before
    public void setup() {
        board = new SimpleGameBoard(4);
        playerRed = new CommandLinePlayer(PlayerColor.RED);
        playerBlue = new CommandLinePlayer(PlayerColor.BLUE);
        rules = new OverwriteRules(board, playerRed, playerBlue);
    }

    @Test(timeout = 1000)
    public void testIsLegalMove1() {
        Move m = new Move(1, 2);
        assertTrue(rules.isLegalMove(m));
    }

    @Test(timeout = 1000)
    public void testIsLegalMove2() {
        OverwriteMove m = new OverwriteMove(1, 2);
        assertFalse(rules.isLegalMove(m));
    }

    @Test(timeout = 1000)
    public void testGetLegalMoves() {
        ArrayList<Move> testMoves = new ArrayList<Move>();
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                testMoves.add(new Move(i, j));
            }
        }

        ArrayList<Move> actual = rules.getLegalMoves(rules.getPlayers().peek());
        assertNotNull(actual);
        for (Move m : testMoves) {
            assertTrue(m.toString(), actual.contains(m));
        }

    }

    @Test(timeout = 1000)
    public void testGetLegalMoves2() throws InvalidMoveException {
        rules.makeMove(new Move(0, 0));
        rules.nextTurn();
        ArrayList<Move> testMoves = new ArrayList<Move>();
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                testMoves.add(new Move(i, j));
            }
        }
        testMoves.remove(0);
        testMoves.add(new OverwriteMove(0, 0));

        ArrayList<Move> actual = rules.getLegalMoves(rules.getPlayers().peek());

        assertNotNull(actual);
        for (Move m : testMoves) {
            assertTrue(m.toString(), actual.contains(m));
        }

    }

    @Test(timeout = 1000)
    public void testGetLegalMoves3() throws InvalidMoveException {
        rules.makeMove(new Move(0, 0));
        rules.nextTurn();
        rules.makeMove(new OverwriteMove(0, 0));
        rules.nextTurn();

        ArrayList<Move> testMoves = new ArrayList<Move>();
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                testMoves.add(new Move(i, j));
            }
        }

        testMoves.remove(0);
        testMoves.add(new OverwriteMove(0, 0));

        ArrayList<Move> actual = rules.getLegalMoves(rules.getPlayers().peek());
        assertNotNull(actual);
        for (Move m : testMoves) {
            assertTrue(m.toString(), actual.contains(m));
        }

    }

    @Test(timeout = 1000)
    public void testGetLegalMoves4() throws InvalidMoveException {
        rules.makeMove(new Move(0, 0));
        rules.nextTurn();
        rules.makeMove(new Move(0, 1));
        rules.nextTurn();
        ArrayList<Move> testMoves = new ArrayList<Move>();
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                testMoves.add(new Move(i, j));
            }
        }
        testMoves.remove(0);
        testMoves.remove(0);
        testMoves.add(new OverwriteMove(0, 1));
        ArrayList<Move> actual = rules.getLegalMoves(rules.getPlayers().peek());

        assertNotNull(actual);
        for (Move m : testMoves) {
            assertTrue(m.toString(), actual.contains(m));
        }

    }
}
