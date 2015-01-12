package code.games.hex.board;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

import code.games.hex.gameMechanics.Move;
import code.games.hex.gameMechanics.PlayerColor;

/**
 * Represents the standard game board
 *
 */
public class SimpleGameBoard extends AbstractGameBoard
{
	private Tile[] 	 goalNodes;
	private Tile[][] boardState;
	
	/**
	 * Creates a two dimensional array of blank Tiles, as well as creating goal nodes.
	 * It does this by going through each Tile of boardState and initially sets this 
	 * Tile's color to blank. 
	 * 
	 * @param size
	 */
	public SimpleGameBoard(int size)
	{
		this.size 		  = size;
		this.boardState   = new Tile[size][size];
		this.goalNodes    = new Tile[4];
		this.goalNodes[0] = new Tile(PlayerColor.RED, new Point(0, -1));
	    this.goalNodes[2] = new Tile(PlayerColor.RED, new Point(0, size));
	    this.goalNodes[1] = new Tile(PlayerColor.BLUE, new Point(-1, 0));
	    this.goalNodes[3] = new Tile(PlayerColor.BLUE, new Point(size, 0));
	    
	    // populate board with blank tiles
	    for (int i = 0; i < size; i++)
	    {
	    	for (int j = 0; j < size; j++)
	    	{
	    		this.boardState[i][j] = new Tile(PlayerColor.BLANK, new Point(i, j));
	    	}
	    }
	}
	
	public SimpleGameBoard(SimpleGameBoard other)
	{
		this(other.getSize());
	}

	/**
	 * Returns the Tile located at the board location specified by
	 * the x and y coordinates.
	 * 
	 * @param x
	 * @param y
	 * @return Tile 
	 */
	@Override
	public Tile getTileAt(int x, int y) 
	{
		Tile tile = null;
		
		if (x == -1)
		{
			tile = goalNodes[1];
		}
		if (x == size)
		{
			tile = goalNodes[3];
		}
		if (y == -1)
		{
			tile = goalNodes[0];
		}
		if (y == size)
		{
			tile = goalNodes[2];
		}
		if ((x >= 0) && (x < size) && (y >= 0) && (y < size))
		{
			tile = boardState[x][y];
		}
		
		return tile;
	}

	/**
	 * Returns a Set of the Tile neighboring the specific Tile.
	 * The set should have a size of no fewer than 4 and no more than 6.
	 * 
	 * @param tile
	 * @return Set<Tile>
	 */
	@Override
	public Set<Tile> getNeighbors(Tile tile)
	{
		Set<Tile> neighbors = new HashSet<>();
		
		int 	  x 		= (int) tile.getPoint().getX();
		int 	  y			= (int) tile.getPoint().getY();
		
		if (x == -1)
		{
			for (int i = 0; i < size; ++i)
			{
				neighbors.add(getTileAt(0, i));
			}
		}
		else if (x == size)
		{
			for (int i = 0; i < size; ++i)
			{
				neighbors.add(getTileAt(size - 1, i));
			}
		}
		else if (y == -1)
		{
			for (int i = 0; i < size; ++i)
			{
				neighbors.add(getTileAt(i, 0));
			}
		}
		else if (y == size)
		{
			for (int i = 0; i < size; ++i)
			{
				neighbors.add(getTileAt(i, size - 1));
			}
		}
		else
		{	
			neighbors.add(getTileAt(x - 1, y));
			neighbors.add(getTileAt(x + 1, y));
			neighbors.add(getTileAt(x - 1, y + 1));
			neighbors.add(getTileAt(x + 1, y - 1));
			neighbors.add(getTileAt(x, y - 1));
			neighbors.add(getTileAt(x, y + 1));
		}
		
		return neighbors;
	}
	

	/**
	 * Sets the boards[x][y] Tile to the PlayerColor specified.
	 * 
	 * @param move
	 * @param playerColor
	 */
	@Override
	public void makeMove(Move move, PlayerColor playerColor) {
		int x = move.getX();
		int y = move.getY();
		
		boardState[x][y].setColor(playerColor);
	}

}
