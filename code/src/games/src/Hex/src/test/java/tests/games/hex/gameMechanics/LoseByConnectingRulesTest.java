package tests.games.hex.gameMechanics;

import static org.junit.Assert.*;

import java.util.Queue;

import org.junit.Before;
import org.junit.Test;

import code.games.hex.board.AbstractGameBoard;
import code.games.hex.board.SimpleGameBoard;
import code.games.hex.execptions.InvalidMoveException;
import code.games.hex.gameMechanics.LoseByConnectingRules;
import code.games.hex.gameMechanics.Move;
import code.games.hex.gameMechanics.PlayerColor;
import code.games.hex.players.Player;
import code.games.hex.players.SimpleRandomPlayer;

public class LoseByConnectingRulesTest {

	private AbstractGameBoard board;	

	@Before
	public void setUp() throws Exception {
		board = new SimpleGameBoard(4);
	}

	@Test(timeout = 1000)
	public void testGetPlayers() {
		LoseByConnectingRules rules = new LoseByConnectingRules(board, new SimpleRandomPlayer(PlayerColor.RED), new SimpleRandomPlayer(PlayerColor.BLUE));
		Queue<Player> players = rules.getPlayers();
		assertNotNull("Failure, players is null", players);
		assertEquals("Failures, players size incorrect", 2, players.size());
	}

	@Test(timeout = 1000)
	public void testLoseByConnectingRules() {
		LoseByConnectingRules rules = new LoseByConnectingRules(board, new SimpleRandomPlayer(PlayerColor.RED), new SimpleRandomPlayer(PlayerColor.BLUE));
		assertNotNull("Failure, rules not initialized", rules);
	}

	@Test(timeout = 1000)
	public void testLoseByConnectingRulesPlayerPlayer() {
		LoseByConnectingRules rules = new LoseByConnectingRules(board, new SimpleRandomPlayer(
				PlayerColor.RED), new SimpleRandomPlayer(PlayerColor.BLUE));
		assertNotNull("Failure, rules not initialized", rules);
		assertEquals("Failure, players size is incorrect", 2, rules
				.getPlayers().size());
	}

	@Test(timeout = 1000)
	public void testCheckForWinsBlue() {
		LoseByConnectingRules rules = new LoseByConnectingRules(board, new SimpleRandomPlayer(PlayerColor.RED), new SimpleRandomPlayer(PlayerColor.BLUE));
		try {
			rules.makeMove(new Move(0,0));
			rules.makeMove(new Move(0,1));
			rules.makeMove(new Move(0,2));
			rules.makeMove(new Move(0,3));
			rules.makeMove(new Move(1,3));
			assertEquals(PlayerColor.BLUE, rules.checkForWins());
		} catch (InvalidMoveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(timeout = 1000)
	public void testCheckForWinsNone() {
		LoseByConnectingRules rules = new LoseByConnectingRules(board, new SimpleRandomPlayer(PlayerColor.RED), new SimpleRandomPlayer(PlayerColor.BLUE));
		try {
			rules.makeMove(new Move(0,0));
			rules.makeMove(new Move(0,1));
			rules.makeMove(new Move(0,2));	
			assertNull(rules.checkForWins());
		} catch (InvalidMoveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(timeout = 1000)
	public void testIsLegalMove1() {
		LoseByConnectingRules rules = new LoseByConnectingRules(board, new SimpleRandomPlayer(PlayerColor.RED), new SimpleRandomPlayer(PlayerColor.BLUE));
		try {
			rules.makeMove(new Move(0,0));
			} catch (InvalidMoveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertFalse(rules.isLegalMove(new Move(0,0)));
	}
	
	@Test(timeout = 1000)
	public void testIsLegalMove2() {
		LoseByConnectingRules rules = new LoseByConnectingRules(board, new SimpleRandomPlayer(PlayerColor.RED), new SimpleRandomPlayer(PlayerColor.BLUE));		
		assertTrue(rules.isLegalMove(new Move(0,0)));
	}

	@Test(expected = InvalidMoveException.class, timeout = 10000)
	public void testMakeInvalidMove() throws InvalidMoveException {
		LoseByConnectingRules rules = new LoseByConnectingRules(board, new SimpleRandomPlayer(PlayerColor.RED), new SimpleRandomPlayer(PlayerColor.BLUE));
		rules.makeMove(new Move(1, 1));
		rules.makeMove(new Move(1, 1));
	}

	@Test(timeout = 1000)
	public void testNextTurn() {
		LoseByConnectingRules rules = new LoseByConnectingRules(board, new SimpleRandomPlayer(PlayerColor.RED), new SimpleRandomPlayer(PlayerColor.BLUE));
		Player currentPlayer = rules.getPlayers().peek();
		rules.nextTurn();
		assertNotSame("Next player and current player are the same",
				currentPlayer, rules.getPlayers().peek());
	}

	@Test(timeout = 1000)
	public void testGetNextPlayer() {
		LoseByConnectingRules rules = new LoseByConnectingRules(board, new SimpleRandomPlayer(PlayerColor.RED), new SimpleRandomPlayer(PlayerColor.BLUE));
		Player currentPlayer = rules.getPlayers().peek();
		Player nextPlayer = rules.getNextPlayer();
		assertNotSame("Players are the same", currentPlayer, nextPlayer);
	}

}
