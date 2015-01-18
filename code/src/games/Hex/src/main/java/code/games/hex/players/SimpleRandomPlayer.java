package code.games.hex.players;

import java.util.List;
import java.util.Random;

import code.games.hex.board.Board;
import code.games.hex.gameMechanics.Move;
import code.games.hex.gameMechanics.PlayerColor;

/**
 * A random move AI.
 */
public class SimpleRandomPlayer extends AbstractPlayer
{
	
	public SimpleRandomPlayer(PlayerColor color)
	{
		super(color);
	}

	/**
	 * This method is the entry point for a Player.
	 * A player will be invoked with the getMove() method and
	 * given a copy of the board and the list of legal moves from the GameRunner.  
	 * It is then expected to return a Move from the list of legalMoves. If it does not
	 * do so it will forfeit. Which move is chosen varies from Player to Player depending on
	 * their strategy.
	 * 
	 * @param board
	 * @param legalMoves
	 * 
	 * @return Move - a random Move.
	 */
	@Override
	public Move getMove(Board board, List<Move> legalMoves)
	{
		Random random   = new Random();
		int randomIndex = random.nextInt(legalMoves.size());
		return legalMoves.get(randomIndex);
	}

	/**
	 * 
	 * @return String - the name of the player.
	 */
	@Override
	public String getName() {
		return "code.games.hex.players.SimpleRandomPlayer";
	}

}
