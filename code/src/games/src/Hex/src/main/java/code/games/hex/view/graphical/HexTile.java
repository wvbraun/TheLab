package code.games.hex.view.graphical;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import code.games.hex.board.Tile;
import code.games.hex.gameMechanics.PlayerColor;

/**
 * Represents the HexTiles with a JButton
 *
 */
@SuppressWarnings("serial")
public class HexTile extends JButton {

	private int			x, y, radius, borderTile; 
	
	private Tile 		tile;
	private Polygon 	hex, border1, border2;
	private PlayerColor color1, color2;
	
	public HexTile(int x, int y, int radius, Tile tile)
	{
		this(x, y, radius, tile, 0, PlayerColor.BLANK);
	}
	
	public HexTile(int x, int y, int radius, Tile tile, int borderTile, PlayerColor color)
	{
		this(x, y, radius, tile, borderTile, color, PlayerColor.BLANK);
	}
	
	public HexTile(int x, int y, int radius, Tile tile, int borderTile, PlayerColor color1, PlayerColor color2)
	{
		this.x  		  = x;
		this.y            = y;
		this.hex          = new Polygon();
		this.tile 		  = tile;
		this.radius 	  = radius;
		this.color1 	  = color1;
		this.color2       = color2;
		this.border1      = new Polygon();
		this.border2	  = new Polygon();
		this.borderTile   = borderTile;
	}
	
	/** 
	 * Returns a boolean which determines if the
	 * tile contains the point located at x,y
	 * 
	 * @param x an int representing the Points x coordinate
	 * @param y an int representing the Points y coordinate
	 * @return boolean
	 */
	public boolean contains(int x, int y)
	{
		return contains(new Point(x, y));
	}
	
	/**
	 * Returns a boolean which determines if the 
	 * tile contains the point
	 * 
	 * @param p a point representing a point on the board
	 * @return boolean
	 */
	public boolean contains(Point p)
	{
		return hex.contains(p);
	}
	
	/** 
	 * Returns an int which represents the tiles x location 
	 * on the board
	 * @return final int
	 */
	
	public final int getBoardX()
	{
		return (int) tile.getPoint().getX();
	}
	
	/**
	 * Returns an int which represents the tiles y location
	 * on the board
	 * @return final int
	 */
	public final int getBoardY()
	{
		return (int) tile.getPoint().getY();
	}
	
	/** 
	 * Sets the HexTile's radius 
	 * and then repaints the tile
	 * 
	 * @param radius
	 */
	public void setRadius(int radius)
	{
		this.radius = radius;
		repaint();
	}
	
	protected void processMouseEvent(MouseEvent e)
	{
		if (contains(e.getPoint()))
		{
			super.processMouseEvent(e);
		}
	}
	
	public void paint(Graphics g)
	{
		int    		x, y, n;
		double 		theta;
		
		PlayerColor tileColor = tile.getColor();
		Graphics2D  graphic2D = (Graphics2D) g;
		graphic2D.setStroke(new BasicStroke(3));
		
		for (n=0; n<6; ++n)	
		{
			/*
			 * To make the hexagon tiles we need to add 6 points
			 * to our Polygon, each point can be determined by::
			 * 	n = 0 thru 6:
			 *    x = cos(n(pi/3)(pi/2))
			 *    y = sin(n(pi/3)(pi/2))
			 */
			theta = n * (Math.PI / 3) + (Math.PI / 2);
			x     = (int) (radius * 0.95 * Math.cos(theta) + this.x);
			y	  = (int) (radius * 0.95 * Math.sin(theta) + this.y);
			hex.addPoint(x, y);
		}
		
		/*
		 * For our isBorderTile:
		 * 	0 - not a border tile
		 *  1 - north border
		 *  2 - east  border
		 *  3 - south border
		 *  4 - west  border
		 *  5 - north left  corner
		 *  6 - south left corner
		 *  7 - south right corner
		 *  8 - north right  corner
		 */

		
		if (borderTile == 1)
		{
			for (n = 2; n < 5; ++n)
			{
				theta = n * (Math.PI / 3) + (Math.PI / 2);
				x 	  = (int) (radius * 0.99 * Math.cos(theta) + this.x);
				y 	  = (int) (radius * 0.99 * Math.sin(theta) + this.y);
				border1.addPoint(x,y);
			}
		}
		else if (borderTile == 2)
		{
			for (n = 3; n < 6; ++n)
			{	
				theta = n * (Math.PI / 3) + (Math.PI / 2);
				x 	  = (int) (radius * 0.99 * Math.cos(theta) + this.x);
				y  	  = (int) (radius * 0.99 * Math.sin(theta) + this.y);
				border1.addPoint(x,y);
			}
		}
		else if (borderTile == 3)
		{
			for (n = 0; n < 2; ++n)
			{
				theta = n * (Math.PI / 3) + (Math.PI / 2);
				x 	  = (int) (radius * Math.cos(theta) + this.x);
				y 	  = (int) (radius * Math.sin(theta) + this.y);
				border1.addPoint(x,y);
			}
			n = 5;
			theta = n * (Math.PI / 3) + (Math.PI / 2);
			x 	  = (int) (radius * 0.99 * Math.cos(theta) + this.x);
			y 	  = (int) (radius * 0.99 * Math.sin(theta) + this.y);
			border1.addPoint(x,y);
		}
		else if (borderTile == 4)
		{
			for (n = 0; n < 3; ++n)
			{
				theta = n * (Math.PI / 3) + (Math.PI / 2);
				x 	  = (int) (radius * 0.99 * Math.cos(theta) + this.x);
				y 	  = (int) (radius * 0.99 * Math.sin(theta) + this.y);
				border1.addPoint(x,y);
			}
		}
		else if (borderTile == 5)
		{
			for (n = 0; n < 5; ++n)
			{
				theta = n * (Math.PI / 3) + (Math.PI / 2);
				x     = (int) (radius * 0.99 * Math.cos(theta) + this.x);
				y     = (int) (radius * 0.99 * Math.sin(theta) + this.y);
				border2.addPoint(x,y);
			}
			switch (color2)
			{
			case RED:
				graphic2D.setColor(Color.RED);
				break;
			case ORANGE:
				graphic2D.setColor(Color.ORANGE);
				break;
			case YELLOW:
				graphic2D.setColor(Color.YELLOW);
				break;
			case GREEN:
				graphic2D.setColor(Color.GREEN);
				break;
			case BLUE:
				graphic2D.setColor(Color.BLUE);
				break;
			case PURPLE:
				graphic2D.setColor(Color.MAGENTA);
				break;	
			default:
				graphic2D.setColor(Color.BLACK);
				break;	
			}
			graphic2D.drawPolygon(border2);
		}
		else if (borderTile == 6)
		{
			for (n = 0; n < 3; ++n)
			{	
				theta = n * (Math.PI / 3) + (Math.PI / 2);
				x 	  = (int) (radius * 0.99 * Math.cos(theta) + this.x);
				y  	  = (int) (radius * 0.99 * Math.sin(theta) + this.y);
				border1.addPoint(x,y);
			}			
			for (n = 5; n < 7; ++n)
			{
				theta = n * (Math.PI / 3) + (Math.PI / 2);
				x 	  = (int) (radius * 0.99 * Math.cos(theta) + this.x);
				y     = (int) (radius * 0.99 * Math.sin(theta) + this.y);
				border1.addPoint(x,y);
			}
			
			switch (color1)
			{
			case RED:
				graphic2D.setColor(Color.RED);
				break;
			case ORANGE:
				graphic2D.setColor(Color.ORANGE);
				break;
			case YELLOW:
				graphic2D.setColor(Color.YELLOW);
				break;
			case GREEN:
				graphic2D.setColor(Color.GREEN);
				break;
			case BLUE:
				graphic2D.setColor(Color.BLUE);
				break;
			case PURPLE:
				graphic2D.setColor(Color.MAGENTA);
				break;	
			default:
				graphic2D.setColor(Color.BLACK);
				break;	
			}
			graphic2D.drawPolygon(border1);
			
		}
		else if (borderTile == 7)
		{
			for (n = 3; n < 6; ++n)
			{	
				theta = n * (Math.PI / 3) + (Math.PI / 2);
				x 	  = (int) (radius * 0.99 * Math.cos(theta) + this.x);
				y 	  = (int) (radius * 0.99 * Math.sin(theta) + this.y);
				border2.addPoint(x,y);
			}			
			for (n = 0; n < 2; ++n)
			{
				theta = n * (Math.PI / 3) + (Math.PI / 2);
				x 	  = (int) (radius * 0.99 * Math.cos(theta) + this.x);
				y 	  = (int) (radius * 0.99 * Math.sin(theta) + this.y);
				border2.addPoint(x,y);
			}
			n = 5;
			theta = n * (Math.PI / 3) + (Math.PI / 2);
			x 	  = (int) (radius * 0.99 * Math.cos(theta) + this.x);
			y 	  = (int) (radius * 0.99 * Math.sin(theta) + this.y);
			border2.addPoint(x,y);
			
			switch (color2)
			{
			case RED:
				graphic2D.setColor(Color.RED);
				break;
			case ORANGE:
				graphic2D.setColor(Color.ORANGE);
				break;
			case YELLOW:
				graphic2D.setColor(Color.YELLOW);
				break;
			case GREEN:
				graphic2D.setColor(Color.GREEN);
				break;
			case BLUE:
				graphic2D.setColor(Color.BLUE);
				break;
			case PURPLE:
				graphic2D.setColor(Color.MAGENTA);
				break;	
			default:
				graphic2D.setColor(Color.BLACK);
				break;	
			}
			
			graphic2D.drawPolygon(border2);
		}
		else if (borderTile == 8)
		{
			for (n = 2; n < 6; ++n)
			{
				theta = n * (Math.PI / 3) + (Math.PI / 2);
				x 	  = (int) (radius * 0.99 * Math.cos(theta) + this.x);
				y 	  = (int) (radius * 0.99 * Math.sin(theta) + this.y);
				border1.addPoint(x,y);
			}
			switch (color1)
			{
			case RED:
				graphic2D.setColor(Color.RED);
				break;
			case ORANGE:
				graphic2D.setColor(Color.ORANGE);
				break;
			case YELLOW:
				graphic2D.setColor(Color.YELLOW);
				break;
			case GREEN:
				graphic2D.setColor(Color.GREEN);
				break;
			case BLUE:
				graphic2D.setColor(Color.BLUE);
				break;
			case PURPLE:
				graphic2D.setColor(Color.MAGENTA);
				break;	
			default:
				graphic2D.setColor(Color.BLACK);
				break;	
			}

			graphic2D.drawPolygon(border1);
		}

		if (borderTile > 0 && borderTile < 5)
		{
			switch (color1)
			{
			case RED:
				graphic2D.setColor(Color.RED);
				break;
			case ORANGE:
				graphic2D.setColor(Color.ORANGE);
				break;
			case YELLOW:
				graphic2D.setColor(Color.YELLOW);
				break;
			case GREEN:
				graphic2D.setColor(Color.GREEN);
				break;
			case BLUE:
				graphic2D.setColor(Color.BLUE);
				break;
			case PURPLE:
				graphic2D.setColor(Color.MAGENTA);
				break;	
			default:
				graphic2D.setColor(Color.BLACK);
				break;	
			}
			
			graphic2D.drawPolygon(border1);
		}
		
		switch (tileColor)
		{
			case RED:
				graphic2D.setColor(Color.RED);
				break;
			case ORANGE:
				graphic2D.setColor(Color.ORANGE);
				break;
			case YELLOW:
				graphic2D.setColor(Color.YELLOW);
				break;
			case GREEN:
				graphic2D.setColor(Color.GREEN);
				break;
			case BLUE:
				graphic2D.setColor(Color.BLUE);
				break;
			case PURPLE:
				graphic2D.setColor(Color.MAGENTA);
				break;	
			default:
				graphic2D.setColor(Color.WHITE);
				break;	
		}
		
		graphic2D.fillPolygon(hex);		
	}
}
