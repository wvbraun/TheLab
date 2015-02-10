package code.games.hex.gameMechanics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import code.games.hex.board.Board;
import code.games.hex.board.Tile;
import code.games.hex.execptions.InvalidMoveException;
import code.games.hex.players.Player;

/**
 * StandardRules implementation, every game will probably use this.
 *
 *
 */
public class StandardRules implements Rules {
	
	private final Board board;
	
	private LinkedList<Player> players;
	private final int boardSize;
	private Player playerOne;
	private Player playerTwo;
	
	public StandardRules(Board board, Player one, Player two)
	{
		this.board = board;
		boardSize  = board.getSize();
		players    = new LinkedList<Player>();
		playerOne  = one;
		playerTwo  = two;
		players.add(one);
		players.add(two);
	}
	
	/**
	 * 
	 * @return a Queue of all Player(s) in turn order.
	 */
	public Queue<Player> getPlayers()
	{
		return players;
	}
	
	/**
	 * Checks the wins for the red and blue players. If a win exists for either
	 * of them, the winning player is returned. If the game is not yet won, null
	 * is returned. A tie would be indicated by PlayerColor.BLANK
	 * 
	 * @return the PlayerColor of the winning player, null if neither player has
	 *         won
	 */
	public PlayerColor checkForWins()
	{
		boolean playerOneConnected, playerTwoConnected;
		Tile playerOneStart, playerOneGoal, playerTwoStart, playerTwoGoal;
		
		PlayerColor playerOneColor = playerOne.getColor();
		PlayerColor playerTwoColor = playerTwo.getColor();
		PlayerColor color = null;
		
		loop:
			for (int start = 0; start < boardSize; ++start)
			{
				for (int goal = 0; goal < boardSize; ++goal)
				{
					playerOneConnected = false;
					playerTwoConnected = false;
					
					playerOneStart 	   = board.getTileAt(start, 0);
					playerOneGoal      = board.getTileAt(goal, boardSize - 1);
					playerTwoStart     = board.getTileAt(0, start);
					playerTwoGoal      = board.getTileAt(boardSize - 1, goal);
					
					if (playerOneStart.getColor() == playerOneColor && playerOneGoal.getColor() == playerOneColor)
					{
						playerOneConnected = areTilesConnected(board, playerOneStart, playerOneGoal, playerOneColor);
					}
					
					if (playerTwoStart.getColor() == playerTwoColor && playerTwoGoal.getColor() == playerTwoColor)
					{
						playerTwoConnected = areTilesConnected(board, playerTwoStart, playerTwoGoal, playerTwoColor);
					}
							
					if (playerOneConnected && playerTwoConnected)
					{
						color = PlayerColor.BLANK;
						break loop;
					}
					else if (playerOneConnected)
					{
						color = playerOneColor;
						break loop;
					}
					else if (playerTwoConnected)
					{
						color = playerTwoColor;
						break loop;
					}
				}
			}
		
		return color;
	}
	
	public static boolean areTilesConnected(Board board, Tile start, Tile goal, PlayerColor playerColor)
	{
		HashSet<Tile>    visitedTiles = new HashSet<Tile>();
		LinkedList<Tile> neighbors    = new LinkedList<Tile>()	;
		
		neighbors.add(start);
		
		while (!neighbors.isEmpty())
		{
			Tile 	  current 	   = neighbors.poll();
			if (current.getPoint().x < 0 || current.getPoint().x > board.getSize() - 1 || 
					current.getPoint().y < 0 || current.getPoint().y > board.getSize() - 1)
			{
				continue;
			}
			Set<Tile> neighborList = board.getNeighbors(current);
			visitedTiles.add(current);
			
			for (Tile neighbor : neighborList)
			{
				if (!visitedTiles.contains(neighbor) && !neighbors.contains(neighbor) && neighbor.getColor().equals(playerColor))
				{
					neighbors.add(neighbor);
				}
			}
			
			if (neighbors.contains(goal) && neighbors.size() == board.getSize())
			{
				return true;
			}
			if (visitedTiles.contains(goal) && visitedTiles.size() >= board.getSize())
			{
				return true;
			}
				
		}
		return false;
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
		
		return true;
	}
	
	/**
	 * Returns the next Player
	 * 
	 * @return Player - next player
	 */
	public Player getNextPlayer()
	{
		return players.peekLast();
	}
	
	/**
	 * Returns the current Player
	 * 
	 * @return Player - current player
	 */
	public Player getCurrentPlayer()
	{
		return players.peekFirst();
	}

	/**
	 * This method advances the turn and updates the board appropriately.
	 * 
	 * @return the current player after this method executes
	 */
	@Override
	public Player nextTurn() {
		players.add(getCurrentPlayer());
		return players.poll();
	}

	/**
	 * This method takes a move and modifies the board associated with these
	 * rules in order to execute that move. If the move is invalid, throw and
	 * InvalidMoveException
	 * 
	 * @param move
	 *            the Move to make
	 * @throws InvalidMoveException
	 *             when the move cannot be legally made
	 */
	@Override
	public void makeMove(Move move) throws InvalidMoveException 
	{
		int x = move.getX();
		int y = move.getY();
		
		if (x < 0 || y < 0 || x >= boardSize || y >= boardSize)
		{
			throw new InvalidMoveException("*** ERROR: Illegal Move [ " + getCurrentPlayer().getName() + " ] ***", move, InvalidMoveException.OUTSIDE_BOARD);
		}	
		if (!isLegalMove(move))
		{
			throw new InvalidMoveException("*** ERROR: Illegal Move [ " + getCurrentPlayer().getName() + " ] ***", move, InvalidMoveException.ALREADY_TAKEN);
		}
		
		else
		{
			board.makeMove(move, getCurrentPlayer().getColor());	
		}
	}

	/**
	 * Determines the possible moves that a player can legally make at query
	 * time.
	 * 
	 * @param player
	 *            The player querying.
	 * @return A list of possible moves.
	 */
	@Override
	public ArrayList<Move> getLegalMoves(Player player) {
		ArrayList<Move> moves = new ArrayList<Move>();
		
		for (int x = 0; x < boardSize; ++x)
		{
			for (int y = 0; y < boardSize; ++y)
			{
				Move move = new Move(x,y);
				if (isLegalMove(move))
				{
					moves.add(move);
				}
			}
		}
		
		return moves;
	}

}
