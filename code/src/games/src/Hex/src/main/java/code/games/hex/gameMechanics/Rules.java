package code.games.hex.gameMechanics;

import java.util.ArrayList;
import java.util.Queue;

import code.games.hex.execptions.InvalidMoveException;
import code.games.hex.players.Player;

/**
 * Interface for Hex Rules
 */
public interface Rules {
	/**
	 * 
	 * @return a Queue of all Player(s) in turn order.
	 */
	public Queue<Player> getPlayers();

	/**
	 * Checks the wins for the red and blue players. If a win exists for either
	 * of them, the winning player is returned. If the game is not yet won, null
	 * is returned. A tie would be indicated by PlayerColor.BLANK
	 * 
	 * @return the PlayerColor of the winning player, null if neither player has
	 *         won
	 */
	public PlayerColor checkForWins();

	/**
	 * Takes a move and checks legality, returning whether or not the move can
	 * be executed by the current player. Rules should police whether a player
	 * can make a move.  Just because a player wants to go somewhere doesn't mean
	 * they get to, and isLegalMove is the check against this.  For example, in the
	 * standard rules for Trails a player cannot move to a tile on the board that
	 * another player has already moved to.
	 * @param m
	 *            The move to check legality on.
	 * @return true or false
	 */
	public boolean isLegalMove(Move m);

	/**
	 * This method advances the turn and updates the board appropriately.
	 * 
	 * @return the current player after this method executes
	 */
	public Player nextTurn();

	/**
	 * Returns the next Player
	 * 
	 * @return Player - next player
	 */
	public Player getNextPlayer();
	
	/**
	 * Returns the current Player
	 * 
	 * @return Player - current player
	 */
	public Player getCurrentPlayer();

	/**
	 * This method takes a move and modifies the board associated with these
	 * rules in order to execute that move. If the move is invalid, throw and
	 * InvalidMoveException
	 * 
	 * @param m
	 *            the Move to make
	 * @throws InvalidMoveException
	 *             when the move cannot be legally made
	 */
	public void makeMove(Move m) throws InvalidMoveException;

	/**
	 * Determines the possible moves that a player can legally make at query
	 * time.
	 * 
	 * @param player
	 *            The player querying.
	 * @return A list of possible moves.
	 */
	public ArrayList<Move> getLegalMoves(Player player);
}
