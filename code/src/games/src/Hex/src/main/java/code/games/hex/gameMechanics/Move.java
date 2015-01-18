package code.games.hex.gameMechanics;

import java.awt.Point;

/**
 * Represents a player's move as a Point
 * 
 */
public class Move {
	
	private int x;
	private int y;
	
	/**
	 * Move Constructor, x becomes the x-coordinate of this move and y becomes the y-coordinate
	 * @param x
	 * @param y
	 */
	public Move(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public Move(Point point)
	{
		this((int) point.getX(), (int) point.getY());
	}
	
	/**
	 * return the x coordinate of the Move object
	 * 
	 * @return int representing the x-coordinate of the move on the board
	 */
	public int getX()
	{
		return x;
	}

	/**
	 * returns the y coordinate of the Move object
	 * 
	 * @return int representing the y-coordinate of the move on the board
	 */
	public int getY()
	{
		return y;
	}
	
	@Override
	public boolean equals(Object other)
	{
		if (this == other)
		{
			return true;
		}
		
		if (null == other || getClass() != other.getClass())
		{
			return false;
		}
		
		Move move = (Move) other;
	
		if (getX() != move.getX() || getY() != move.getY())
		{
			return false;
		}
		
		return true;
	}
	
	@Override 
	public String toString()
	{
		return "Move [x = " + getX() + ", y = " + getY() + "]";
	}
}
