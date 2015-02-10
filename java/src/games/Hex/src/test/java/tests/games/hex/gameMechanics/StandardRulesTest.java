package tests.games.hex.gameMechanics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Queue;

import org.junit.Before;
import org.junit.Test;

import code.games.hex.board.AbstractGameBoard;
import code.games.hex.board.SimpleGameBoard;
import code.games.hex.execptions.InvalidMoveException;
import code.games.hex.gameMechanics.Move;
import code.games.hex.gameMechanics.PlayerColor;
import code.games.hex.gameMechanics.StandardRules;
import code.games.hex.players.Player;
import code.games.hex.players.SimpleRandomPlayer;


public class StandardRulesTest {

	private AbstractGameBoard board;

	@Before
	public void setUp() throws Exception {
		board = new SimpleGameBoard(4);
	}
	

	@Test(timeout = 1000)
	public void testGetPlayers() {
		StandardRules rules = new StandardRules(board, new SimpleRandomPlayer(PlayerColor.RED), new SimpleRandomPlayer(PlayerColor.BLUE));
		Queue<Player> players = rules.getPlayers();
		assertNotNull("Failure, players is null", players);
		assertEquals("Failures, players size incorrect", 2, players.size());
	}

	@Test(timeout = 1000)
	public void testStandardRules() {
		StandardRules rules = new StandardRules(board, new SimpleRandomPlayer(PlayerColor.RED), new SimpleRandomPlayer(PlayerColor.BLUE));
		assertNotNull("Failure, rules not initialized", rules);
	}

	@Test(timeout = 1000)
	public void testStandardRulesPlayerPlayer() {
		StandardRules rules = new StandardRules(board, new SimpleRandomPlayer(
				PlayerColor.RED), new SimpleRandomPlayer(PlayerColor.BLUE));
		assertNotNull("Failure, rules not initialized", rules);
		assertEquals("Failure, players size is incorrect", 2, rules
				.getPlayers().size());
	}


	@Test(timeout = 1000)
	public void testCheckForWinsRed() {
		StandardRules rules = new StandardRules(board, new SimpleRandomPlayer(PlayerColor.RED), new SimpleRandomPlayer(PlayerColor.BLUE));
		try {
			rules.makeMove(new Move(0,0));
			rules.makeMove(new Move(0,1));
			rules.makeMove(new Move(0,2));
			rules.makeMove(new Move(0,3));
			assertEquals(PlayerColor.RED, rules.checkForWins());
		} catch (InvalidMoveException e) {
			fail();
			e.printStackTrace();
		}
	}
		
	@Test(timeout = 1000)
	public void testAreTileConnectedRed()
	{
		StandardRules rules = new StandardRules(board, new SimpleRandomPlayer(PlayerColor.RED), new SimpleRandomPlayer(PlayerColor.BLUE));
		try {
			rules.makeMove(new Move(0, 0));
			rules.nextTurn();
			rules.makeMove(new Move(0, 1));
			rules.nextTurn();
			rules.makeMove(new Move(0, 2));
			rules.makeMove(new Move(0, 3));
			assertFalse(StandardRules.areTilesConnected(board, board.getTileAt(0, 0), board.getTileAt(0, 3), PlayerColor.RED));
			assertNull(rules.checkForWins());
		}
		 catch (InvalidMoveException e) {
				fail();
				e.printStackTrace();
			}
	}
	
	@Test(timeout = 1000)
	public void testAreTilesConnectedBlue() {
		StandardRules rules = new StandardRules(board, new SimpleRandomPlayer(PlayerColor.RED), new SimpleRandomPlayer(PlayerColor.BLUE));
		rules.nextTurn();
		try {
			rules.makeMove(new Move(0,0));
			rules.makeMove(new Move(1,0));
			rules.makeMove(new Move(2,0));
			
			assertFalse(StandardRules.areTilesConnected(board, board.getTileAt(-1, 0), board.getTileAt(4, 0), PlayerColor.BLUE));
			
			
		} catch (InvalidMoveException e) {
			fail();
			e.printStackTrace();
		}
	}
	
	@Test(timeout = 1000)
	public void testAreTilesConnectedBlue2() {
		StandardRules rules = new StandardRules(board, new SimpleRandomPlayer(PlayerColor.RED), new SimpleRandomPlayer(PlayerColor.BLUE));
		rules.nextTurn();
		try {
			rules.makeMove(new Move(0,0));
			rules.makeMove(new Move(1,0));
			rules.makeMove(new Move(2,0));
			rules.makeMove(new Move(3,0));
			
			assertTrue(StandardRules.areTilesConnected(board, board.getTileAt(0, 0), board.getTileAt(3, 0), PlayerColor.BLUE));
		} catch (InvalidMoveException e) {
			fail();
			e.printStackTrace();
		}
	}
	
	@Test(timeout = 1000)
	public void testAreTilesConnectedBlue3() {
		StandardRules rules = new StandardRules(board, new SimpleRandomPlayer(PlayerColor.RED), new SimpleRandomPlayer(PlayerColor.BLUE));
		rules.nextTurn();
		try {
			rules.makeMove(new Move(0,0));
			rules.makeMove(new Move(1,0));
			//rules.makeMove(new Move(2,0));
			//rules.makeMove(new Move(3,0));
			
			assertFalse(StandardRules.areTilesConnected(board, board.getTileAt(-1, 0), board.getTileAt(3, 0), PlayerColor.BLUE));
		} catch (InvalidMoveException e) {
			fail();
			e.printStackTrace();
		}
	}
	
	@Test(timeout = 1000)
	public void testAreTilesConnectedBlue4() {
		StandardRules rules = new StandardRules(board, new SimpleRandomPlayer(PlayerColor.RED), new SimpleRandomPlayer(PlayerColor.BLUE));
		rules.nextTurn();
		try {
			rules.makeMove(new Move(3,0));
			
			assertFalse(StandardRules.areTilesConnected(board, board.getTileAt(-1, 0), board.getTileAt(3, 0), PlayerColor.BLUE));
		} catch (InvalidMoveException e) {
			fail();
			e.printStackTrace();
		}
	}
	
	@Test(timeout = 1000)
	public void testCheckForWinsNone() {
		StandardRules rules = new StandardRules(board, new SimpleRandomPlayer(PlayerColor.RED), new SimpleRandomPlayer(PlayerColor.BLUE));
		try {
			rules.makeMove(new Move(0,0));
			rules.makeMove(new Move(0,1));
			rules.makeMove(new Move(0,2));	
			assertNull(rules.checkForWins());
		} catch (InvalidMoveException e) {
			fail();
			e.printStackTrace();
		}
	}

	@Test(timeout = 1000)
	public void testIsLegalMove1() {
		StandardRules rules = new StandardRules(board, new SimpleRandomPlayer(PlayerColor.RED), new SimpleRandomPlayer(PlayerColor.BLUE));
		try {
			rules.makeMove(new Move(0,0));
		} catch (InvalidMoveException e) {
			fail();

			e.printStackTrace();
		}
		assertFalse(rules.isLegalMove(new Move(0,0)));
	}
	
	@Test(timeout = 1000)
	public void testIsLegalMove2() {
		StandardRules rules = new StandardRules(board, new SimpleRandomPlayer(PlayerColor.RED), new SimpleRandomPlayer(PlayerColor.BLUE));		
		assertTrue(rules.isLegalMove(new Move(0,0)));
	}

	@Test(expected = InvalidMoveException.class, timeout = 10000)
	public void testMakeInvalidMove() throws InvalidMoveException {
		StandardRules rules = new StandardRules(board, new SimpleRandomPlayer(PlayerColor.RED), new SimpleRandomPlayer(PlayerColor.BLUE));
		rules.makeMove(new Move(1, 1));
		rules.makeMove(new Move(1, 1));
	}

	@Test(timeout = 1000)
	public void testNextTurn() {
		StandardRules rules = new StandardRules(board, new SimpleRandomPlayer(PlayerColor.RED), new SimpleRandomPlayer(PlayerColor.BLUE));
		Player currentPlayer = rules.getPlayers().peek();
		rules.nextTurn();
		assertNotSame("Next player and current player are the same",
				currentPlayer, rules.getPlayers().peek());
	}

	@Test(timeout = 1000)
	public void testGetNextPlayer() {
		StandardRules rules = new StandardRules(board, new SimpleRandomPlayer(PlayerColor.RED), new SimpleRandomPlayer(PlayerColor.BLUE));
		Player currentPlayer = rules.getPlayers().peek();
		Player nextPlayer = rules.getNextPlayer();
		assertNotSame("Players are the same", currentPlayer, nextPlayer);
	}
	

}
