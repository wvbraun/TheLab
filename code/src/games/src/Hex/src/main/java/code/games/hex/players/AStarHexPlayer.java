	package code.games.hex.players;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import code.games.hex.board.Board;
import code.games.hex.board.Tile;
import code.games.hex.gameMechanics.Move;
import code.games.hex.gameMechanics.PlayerColor;

/**
 * A* AI Player.
 */
public class AStarHexPlayer extends AbstractHexPlayer
{
	private Tile 			 	  start, goal;
	private LinkedList<Tile> 	  movesToMake, movesMade;
	private List<ArrayList<Tile>> invalidGoals;
	
	/**
	 * I made an improvement over my Basic AI, edu.indiana.cs.c212.players.BasicTrailsPlayer.java,
	 * with a new AI, edu.indiana.cs.c212.players.AStarTrailsPlayer.java. The new AI implements an
	 * A* search algorithm to determine the best possible path. Each time getMove() is called, 
	 * it determines if the path is still the best path (meaning the other player has not blocked it).
	 * If the path has been blocked, we recalculate the start and goal tiles and then perform an A* search
	 * to compute the path. If we are unable to find a good path after size^2 attempts, we implement a brute
	 * force algorithm (same as the Basic AI) in order to find an open tile; this is not an optimal solution,
	 * but I do not have time to perfect the AI. 
	 * 
	 * @param color
	 * @param isPlayerOne
	 */
	public AStarHexPlayer(PlayerColor color, boolean isPlayerOne)
	{
		super(color, isPlayerOne);
		
		movesToMake  = new LinkedList<>();
		movesMade 	 = new LinkedList<>();
		invalidGoals = new ArrayList<ArrayList<Tile>>();
	}
	
	private LinkedList<Tile> aStar(Board board, Tile start, Tile goal)
	{
		LinkedList<Tile> closedSet = new LinkedList<>();
		LinkedList<Tile> openSet   = new LinkedList<>(Arrays.asList(start));		
		
		while (!openSet.isEmpty())
		{
			Tile current = getLowestF(openSet);
			
			if (current.getPoint().equals(goal.getPoint()))
			{
				return reconstructPath(current, start);
			}
			
			openSet.remove(current);
			closedSet.add(current);
			Set<Tile> neighbors = board.getNeighbors(current);
			
			for (Tile neighbor : neighbors)
			{
				if (closedSet.contains(neighbor) || (neighbor.getColor() != getColor() && neighbor.getColor() != PlayerColor.BLANK))
				{
					continue;
				}
				
				double  tempG  = current.getG() + 1;
				boolean isBest = false;
				
				if (!openSet.contains(neighbor))
				{
					isBest = true;
					neighbor.setH(distBetween(neighbor, goal));
					openSet.add(neighbor);
				}
				else if (tempG < neighbor.getG())
				{
					isBest = true;
				}
				
				if (isBest)
				{
					neighbor.setParent(current);
					neighbor.setG(tempG);
					neighbor.setF(neighbor.getG() + neighbor.getH());
				}
			}
		}
		
		return null;
	}
	
	/**
	 * Go through each tile in tiles and return the 
	 * one with the lowest F value, meaning this is the best tile to go to.
	 * 
	 * @param LinkedList<Tile> tiles
	 * @return Tile lowestF
	 */
	private Tile getLowestF(LinkedList<Tile> tiles)
	{
		Tile lowestTile = tiles.poll();
		
		for (Tile tile : tiles)
		{
			if (tile.getF() < lowestTile.getF())
			{
				lowestTile = tile;
			}
		}
		
		return lowestTile;
	}
	
	/**
	 * Returns a LinkedList of Tiles which is computed similarly to
	 * a LinkedList insert. This is done by starting with the current Tile
	 * and adding that to the totalPath. Then, we set current to the parent
	 * of current. 
	 * 
	 * @param Tile current
	 * @param Tile start
	 * @return LinkedList<Tile> totalPath
	 */
	private LinkedList<Tile> reconstructPath(Tile current, Tile start)
	{
		LinkedList<Tile> totalPath = new LinkedList<Tile>();
		
		if (getIsPlayerOne())
		{
			while (!current.getPoint().equals(start.getPoint()))
			{
				totalPath.addFirst(current);
				current = current.getParent();
			}
			totalPath.addFirst(start);
		}
		else
		{
			while (!current.getPoint().equals(start.getPoint()))
			{
				totalPath.addLast(current);
				current = current.getParent();
			}
			totalPath.addLast(start);
		}
		return totalPath;
	}
	
	/**
	 * Returns the square of a number.
	 * 
	 * @param double 
	 * @return double 
	 */
	private double square(double n)
	{
		return n * n;
	}
	
	/**
	 * Computes the euclidean distance between two Tiles. 
	 * 
	 * @param Tile start
	 * @param Tile goal
	 * @return double
	 */
	private double distBetween(Tile start, Tile goal)
	{
		return Math.sqrt(square(goal.getPoint().getX() - start.getPoint().getX()) +
						 square(goal.getPoint().getY() - start.getPoint().getY()));
	}

	/**
	 * Determines the new start and goal
	 * 
	 * @param Board board
	 * @param List<Move> legalMoves
	 */
	private void calcGoals(Board board, List<Move> legalMoves)
	{
		Tile resultStart = null;
		Tile resultGoal  = null;
		
		int size = board.getSize();
		double tmp		   = 0;
		double distBetween = 0;
		
		if (getIsPlayerOne())
		{		
			if (start == null)
			{
				for (int x = 0; x < size; ++x)
				{
					for (int y = 0; y < size; ++y)
					{
						Tile tmpStart = new Tile(getColor(), new Point(x, 0));
						Tile tmpGoal  = new Tile(getColor(), new Point(y, size - 1));
							 tmp   = distBetween(tmpStart, tmpGoal);
							 
					    if ((distBetween == 0 || tmp < distBetween)
					    		&& legalMoves.contains(new Move(tmpStart.getPoint().x, tmpStart.getPoint().y))
					    		&& legalMoves.contains(new Move(tmpGoal.getPoint().x, tmpGoal.getPoint().y)))
					    {
					    	distBetween = tmp;
					    	resultStart 	= tmpStart;
					    	resultGoal 	    = tmpGoal;
					    }  				
					}
				}
			}
			else
			{	
				for (int x = 0; x < size; ++x)
				{
					for (int y = 0; y < size; ++y)
					{
						Tile tmpStart = new Tile(getColor(), new Point(x, 0));
						Tile tmpGoal  = new Tile(getColor(), new Point(y, size - 1));
							 tmp   = distBetween(tmpStart, tmpGoal);
							 
					    if ((distBetween == 0 || tmp < distBetween)
					    		&& legalMoves.contains(new Move(tmpStart.getPoint().x, tmpStart.getPoint().y))
					    		&& legalMoves.contains(new Move(tmpGoal.getPoint().x, tmpGoal.getPoint().y)))
					    {
					    	distBetween = tmp;
					    	resultStart 	= tmpStart;
					    	resultGoal 	    = tmpGoal;
					    }  				
					}
				}
				
				for (Tile tmpStart : board.getNeighbors(start))
				{
					for (int y = 0; y < size; ++y)
					{
						Tile tmpGoal = new Tile(getColor(), new Point(y, size - 1));
						tmp   = distBetween(tmpStart, tmpGoal);
						
						if ((distBetween == 0 || tmp < distBetween)
					    		&& (tmpStart.getColor().equals(getColor()) || tmpStart.getColor().equals(PlayerColor.BLANK))
					    		&& legalMoves.contains(new Move(tmpGoal.getPoint().x, tmpGoal.getPoint().y))
					    		&& !invalidGoals.contains(new ArrayList<Tile>(Arrays.asList(tmpStart, tmpGoal))))
					    {
					    	distBetween = tmp;
					    	resultStart = tmpStart;
					    	resultGoal  = tmpGoal;
					    }  			
					}
				}
				
				for (Tile tmpStart : movesMade)
				{
					for (int y = 0; y < size; ++y)
					{
						Tile tmpGoal = new Tile(getColor(), new Point(y, size - 1));
						tmp   = distBetween(tmpStart, tmpGoal);
						
						if ((distBetween == 0 || tmp < distBetween) 
								&& legalMoves.contains(new Move(tmpGoal.getPoint().x, tmpGoal.getPoint().y))
								&& !invalidGoals.contains(new ArrayList<Tile>(Arrays.asList(tmpStart, tmpGoal))))
					    {
					    	distBetween = tmp;
					    	resultStart = tmpStart;
					    	resultGoal  = tmpGoal;
					    }  			
					}
				}
			}
		}
		else
		{
			if (start == null)
			{
				for (int x = 0; x < size; ++x)
				{
					for (int y = 0; y < size; ++y)
					{
						Tile tmpStart = new Tile(getColor(), new Point(0, x));
						Tile tmpGoal  = new Tile(getColor(), new Point(size - 1, y));
							 tmp   = distBetween(tmpStart, tmpGoal);
							 
					    if ((distBetween == 0 || tmp < distBetween)
					    		&& legalMoves.contains(new Move(tmpStart.getPoint().x, tmpStart.getPoint().y))
					    		&& legalMoves.contains(new Move(tmpGoal.getPoint().x, tmpGoal.getPoint().y)))
					    {
					    	distBetween = tmp;
					    	resultStart = tmpStart;
					    	resultGoal  = tmpGoal;
					    }  				
					}
				}
			}
			else
			{
				for (int x = 0; x < size; ++x)
				{
					for (int y = 0; y < size; ++y)
					{
						Tile tmpStart = new Tile(getColor(), new Point(0, x));
						Tile tmpGoal  = new Tile(getColor(), new Point(size - 1, y));
							 tmp   = distBetween(tmpStart, tmpGoal);
							 
					    if ((distBetween == 0 || tmp < distBetween)
					    		&& legalMoves.contains(new Move(tmpStart.getPoint().x, tmpStart.getPoint().y))
					    		&& legalMoves.contains(new Move(tmpGoal.getPoint().x, tmpGoal.getPoint().y)))
					    {
					    	distBetween = tmp;
					    	resultStart = tmpStart;
					    	resultGoal  = tmpGoal;
					    }  				
					}
				}
				
				for (Tile tmpStart : board.getNeighbors(start))
				{
					for (int y = 0; y < size; ++y)
					{
						Tile tmpGoal = new Tile(getColor(), new Point(size - 1, y));
						tmp   = distBetween(tmpStart, tmpGoal);
						
						if ((distBetween == 0 || tmp < distBetween)
					    		&& legalMoves.contains(new Move(tmpStart.getPoint().x, tmpStart.getPoint().y))
					    		&& legalMoves.contains(new Move(tmpGoal.getPoint().x, tmpGoal.getPoint().y)))
					    {
					    	distBetween = tmp;
					    	resultStart = tmpStart;
					    	resultGoal  = tmpGoal;
					    }  			
					}
				}
				
				for (Tile tmpStart : movesMade)
				{
					for (int y = 0; y < size; ++y)
					{
						Tile tmpGoal = new Tile(getColor(), new Point(size - 1, y));
						tmp   = distBetween(tmpStart, tmpGoal);
						
						if ((distBetween == 0 || tmp < distBetween)
					    		&& legalMoves.contains(new Move(tmpStart.getPoint().x, tmpStart.getPoint().y))
					    		&& legalMoves.contains(new Move(tmpGoal.getPoint().x, tmpGoal.getPoint().y)))
					    {
					    	distBetween = tmp;
					    	resultStart = tmpStart;
					    	resultGoal  = tmpGoal;
					    }  	
					}
				}
			}
		}
		start = resultStart;
		goal  = resultGoal;
	}
	
	/**
	 * Returns true if the opponent has not made a move in our best path. 
	 * Returns false otherwise. 
	 * 
	 * @param List<Move> legalMoves
	 * @return boolean
	 */
	private boolean pathStillClear(List<Move> legalMoves)
	{
		boolean isClear = true;
		
		if (movesToMake == null || movesToMake.isEmpty())
		{
			isClear = false;
		}
		
		else if (!legalMoves.contains(new Move(movesToMake.getFirst().getPoint())))
		{
			isClear = false;
		}
		else
		{
			for (Tile tile : movesToMake)
			{
				if (!tile.getColor().equals(getColor()) && !tile.getColor().equals(PlayerColor.BLANK))
				{
					isClear = false;
					break;
				}
			}
		}
		
		return isClear;
	}	
	
	/**
	 * Returns a Move which is determined by a brute force 
	 * algorithm to select the next Move. This is nearly 
	 * identical to BasicTrailsPlayer's getMove().
	 * 
	 * @param Board board
	 * @param List<Move> legalMoves
	 * @return Move
	 */
	private Move bruteForce(Board board, List<Move> legalMoves)
	{
		int  size  = board.getSize();
		Move move  = null;
		
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
		int size 		= board.getSize();
		boolean needBruteForce = false;
		Move move 	 	= null;
		Tile tile		= null;
			
		int i = 0;
		while(!pathStillClear(legalMoves))
		{
			invalidGoals.add(new ArrayList<Tile>(Arrays.asList(start, goal)));
			calcGoals(board, legalMoves);
			
			if (i > (size * size) || start == null || goal == null)
			{
				needBruteForce = true;
				break;
			}

			movesToMake = aStar(board, start, goal);
			++i;
		}
		
		if (needBruteForce)
		{
			move = bruteForce(board, legalMoves);
			tile = new Tile(getColor(), new Point(move.getX(), move.getY()));
			needBruteForce = false;
		}
		else
		{
			tile = movesToMake.poll();
			move = new Move(tile.getPoint().x, tile.getPoint().y);

			start = tile;
		}

		movesMade.add(tile);
		return move;
	}

	/**
	 * 
	 * @return the String that this player wants to be called
	 */
	@Override
	public String getName() 
	{
		return "code.games.hex.players.AStarTrailsPlayer";
	}

}
