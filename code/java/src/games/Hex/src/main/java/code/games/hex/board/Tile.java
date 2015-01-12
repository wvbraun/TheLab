package code.games.hex.board;

import java.awt.Point;

import code.games.hex.gameMechanics.PlayerColor;

/**
 * Represents a Hex Tile, implemented similarly to a LinkedList.
 *
 */
public class Tile {
	
	private Tile 		parent;
	private Point 		point;
	private double      f, g, h;
	private PlayerColor color;

	
	public Tile(Tile tile)
	{
		this(tile.getColor(), tile.getPoint());
	}
	
	public Tile(PlayerColor color, Point point)
	{
		this.f      = 0;
		this.g      = 0;
		this.color  = color;
		this.parent = null;
		this.point  = new Point((int) point.getX(), (int) point.getY());
	}
	
	public PlayerColor getColor()
	{
		return color;
	}
	
	public Point getPoint()
	{
		return point;
	}
	
	public double getF()
	{
		return f;
	}
	
	public double getG()
	{
		return g;
	}
	
	public double getH()
	{
		return h;
	}
	
	public Tile getParent()
	{
		return parent;
	}
	
	public void setF(double f)
	{
		this.f = f;
	}
	
	public void setG(double g)
	{
		this.g = g;
	}
	
	public void setH(double h)
	{
		this.h = h;
	}
	
	public void setParent(Tile parent)
	{
		this.parent = parent;
	}
	
	public void setColor(PlayerColor color)
	{
		this.color = color;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((point == null) ? 0 : point.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tile other = (Tile) obj;
		if (color != other.color)
			return false;
		if (point == null) {
			if (other.point != null)
				return false;
		} else if (!point.equals(other.point))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return point + " " + color ;
	}
	
	

}
