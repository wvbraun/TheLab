package code.games.hex.players;

import java.awt.Point;
import java.util.List;

import code.games.hex.board.Board;
import code.games.hex.gameMechanics.Move;
import code.games.hex.gameMechanics.PlayerColor;

/**
 * A very simple AI with a very basic heuristic.
 */
public class BasicHexPlayer extends AbstractHexPlayer
{	
	/**
	 * BasicTrailsPlayer implements a very crude heuristic to determine moves to make.
	 * This is accomplished by starting with the (size - 1, size - 1) tile and trying to go 
	 * straight to its goal (either (0, size - 1) or (size - 1, 0).
	 * 
	 * @param c
	 * @param isPlayerOne
	 */
	public BasicHexPlayer(PlayerColor c, boolean isPlayerOne)
	{
		super(c, isPlayerOne);
	}
	
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
	@Override
	public Move getMove(Board board, List<Move> legalMoves)
	{
		Move move  = null;
		int  size  = board.getSize();
		
		loop:
			if (getIsPlayerOne())
			{
				for (int x = size - 1; x >= 0; --x)
				{
					for (int y = size - 1; y >= 0; --y)
					{
						Point point = board.getTileAt(x,y).getPoint();
						move		= new Move((int) point.getX(), (int) point.getY());
						
						if (legalMoves.contains(move))
						{
							break loop;
						}
					}
				}
			}
			else
			{
				for (int x = size - 1; x >= 0; --x)
				{
					for (int y = size - 1; y >= 0; --y)
					{
						Point point = board.getTileAt(y,x).getPoint();
						move		= new Move((int) point.getX(), (int) point.getY());
						
						if (legalMoves.contains(move))
						{
							break loop;
						}
					}
				}
			}

		return move;
	}

	/**
	 * 
	 * @return the String that this player wants to be called
	 */
	@Override
	public String getName() 
	{
		return "code.games.hex.players.BasicTrailsPlayer";
	}

}
