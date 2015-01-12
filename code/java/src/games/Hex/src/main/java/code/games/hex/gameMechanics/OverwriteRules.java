package code.games.hex.gameMechanics;

import code.games.hex.board.Board;
import code.games.hex.board.Tile;
import code.games.hex.players.Player;

/**
 * Implements the Rules for an OverwriteMove
 *
 */
public class OverwriteRules extends StandardRules
{
	private Board board;
	
	public OverwriteRules(Board board, Player one, Player two)
	{
		super(board, one, two);
		this.board = board;
	}
	
	/**
	 * Takes a move and checks legality, returning whether or not the move can
	 * be executed by the current player. Rules should police whether a player
	 * can make a move.  Just because a player wants to go somewhere doesn't mean
	 * they get to, and isLegalMove is the check against this.  For example, in the
	 * standard rules for Trails a player cannot move to a tile on the board that
	 * another player has already moved to.
	 * @param move
	 *            The move to check legality on.
	 * @return true or false
	 */
	public boolean isLegalMove(Move move)
	{
		PlayerColor tileColor;
		Tile tile;
		int x, y;
		
		x = move.getX();
		y = move.getY();
		
		tile = board.getTileAt(x, y);	
		tileColor = tile.getColor();
		
		if (tileColor != PlayerColor.BLANK)
		{
			return false;
		}
		
		if (x < 0 || y < 0 || x >= board.getSize() || y >= board.getSize())
		{
			return false;
		}
		
		return true;
	}

}
