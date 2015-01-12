package code.games.hex.board;

import java.util.Observer;
import java.util.Set;

import code.games.hex.gameMechanics.Move;
import code.games.hex.gameMechanics.PlayerColor;

/**
 * Interface for the Hex Board.
 *
 */
public abstract interface Board {

	/**
	 * Returns the number of Tiles along a side of the board.
	 * All boards should be square.
	 * 
	 * @return int - the size of the board.
	 */
	public abstract int getSize();
	
	/**
	 * Returns the Tile located at the board location specified by
	 * the x and y coordinates.
	 * 
	 * @param x
	 * @param y
	 * @return Tile 
	 */
	public abstract Tile getTileAt(int x, int y);
	
	/**
	 * Returns a Set of the Tile neighboring the specific Tile.
	 * The set should have a size of no fewer than 4 and no more than 6.
	 * 
	 * @param tile
	 * @return Set<Tile>
	 */
	public abstract Set<Tile> getNeighbors(Tile tile);
	
	/**
	 * Sets the boards[x][y] Tile to the PlayerColor specified.
	 * 
	 * @param move
	 * @param playerColor
	 */
	public abstract void makeMove(Move move, PlayerColor playerColor);
	
	/**
	 * This method exists in the Observable class.
	 *  By making any implementor of this interface also extend Observable,
	 *  we can pass around and add observers to anything that implements Board.
	 */
	public abstract void addObserver(Observer observer);
}
