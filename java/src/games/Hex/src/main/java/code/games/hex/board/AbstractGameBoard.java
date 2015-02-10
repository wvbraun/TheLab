package code.games.hex.board;

import java.util.Observable;

public abstract class AbstractGameBoard extends Observable implements Board {
	protected int size;

	/**
	 * Returns the number of Tiles along a side of the board.
	 * All boards should be square
	 * 
	 * @return int - the size of the board.
	 */
	public int getSize()
	{
		return size;
	}
}
