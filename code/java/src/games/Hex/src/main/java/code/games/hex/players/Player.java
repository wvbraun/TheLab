package code.games.hex.players;

import java.util.List;

import code.games.hex.board.Board;
import code.games.hex.gameMechanics.Move;
import code.games.hex.gameMechanics.PlayerColor;

/**
 * Interface for Hex Player.
 */
public interface Player {

	/**
	 * This method returns the color of this player, usually RED or BLUE
	 * @return the PlayerColor of this player
	 */
	public PlayerColor getColor();

	/**
	 * This method is the entry point for a Player.
	 * A player will be invoked with the getMove() method and
	 * given a copy of the board and the list of legal moves from the GameRunner.  
	 * It is then expected to return a Move from the list of legalMoves. If it does not
	 * do so it will forfeit. Which move is chosen varies from Player to Player depending on
	 * their strategy.
	 * @param board
	 * @param legalMoves
	 * @return a Move representing the desired action of this Player
	 */
	public Move getMove(Board board, List<Move> legalMoves);

	/**
	 * 
	 * @return the String that this player wants to be called
	 */
	public String getName();
}
