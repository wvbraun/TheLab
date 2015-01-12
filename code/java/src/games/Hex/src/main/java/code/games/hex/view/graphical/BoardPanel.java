package code.games.hex.view.graphical;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import code.games.hex.board.Board;
import code.games.hex.board.Tile;
import code.games.hex.gameMechanics.PlayerColor;

/**
 * Represents the board through use of a JPanel.
 *
 */
@SuppressWarnings("serial")
public class BoardPanel extends JPanel implements ActionListener, Observer
{	
	private int 		radius, xOffset, yOffset;
	
	private Board 		board;
	private PlayerColor oneColor;
	private PlayerColor twoColor;
	
	public BoardPanel()
	{
		this(null, null, null);
	}

	/**
	 *  This should set up the graphical representation of the tiles from the data given by the board object.
	 *  This constructor should also set up all subscribers for the various events. 
	 *  This way the board will be prepared to be updated when a player selects a move. 
	 *  
	 * @param board
	 * @param oneColor
	 * @param twoColor
	 */
	public BoardPanel(Board board, PlayerColor oneColor, PlayerColor twoColor)
	{
		this.board 	   = board;
		this.oneColor  = oneColor;
		this.twoColor  = twoColor;
	}
	
	/**
	 * Sets player one's PlayerColor to the specified PlayerColor
	 * 
	 * @param oneColor
	 */
	public void setOneColor(PlayerColor oneColor)
	{
		this.oneColor  = oneColor;
	}
	
	public void setRadius(int size)
	{
		if (size < 4)
		{
			radius  = 100;
			xOffset = 100;
			yOffset = 100;
		}
		else if (size < 8)
		{
			radius  = 60;
			xOffset = 60;
			yOffset = 60;
		}
		else if (size < 9)
		{
			radius  = 50;
			xOffset = 50;
			yOffset = 50;
		}
		else if (size < 11)
		{
			radius  = 40;
			xOffset = 40;
			yOffset = 40;
		}
		else if (size < 15)
		{
			radius  = 30;
			xOffset = 30;
			yOffset = 30;
		}
		else if (size < 21)
		{
			radius  = 20;
			xOffset = 20;
			yOffset = 20;
		}
		else if (size < 25)
		{
			radius  = 17;
			xOffset = 17;
			yOffset = 17;
		}
		else if (size < 28)
		{
			radius  = 15;
			xOffset = 15;
			yOffset = 15;
		}
		else if (size < 41)
		{
			radius  = 10;
			xOffset = 10;
			yOffset = 10;
		}
		else if (size < 51)
		{
			radius  = 8;
			xOffset = 8;
			yOffset = 8;
		}
		else if (size < 80)
		{
			radius  = 5;
			xOffset = 5;
			yOffset = 5;
		}
		else if (size < 100)
		{
			radius  = 4;
			xOffset = 4;
			yOffset = 4;
		}
		
	}
	
	/**
	 * Sets player two's PlayerColor to the specified PlayerColor
	 * 
	 * @param twoColor
	 */
	public void setTwoColor(PlayerColor twoColor)
	{
		this.twoColor  = twoColor;
	}
	
	/**
	 * Sets the Board to the specified Board.
	 * 
	 * @param board
	 */
	public void setBoard(Board board)
	{
		this.board     = board;
	}
	
	/**
	 * paintComponent is called when a repaint is requested. 
	 * This method should draw all of the hexes of the board and the goal zones on the screen.
	 */
	public void paintComponent(Graphics g)
	{	
		if (board != null)
		{
			int size = board.getSize();
			
			for (int x = 0; x < size; ++x)
			{
				for (int y = 0; y < size; ++y)
				{
					HexTile tilePanel;
					Tile tile  = board.getTileAt(x, y);
					int xCoord = (int) (xOffset + y*Math.sqrt(3)*0.5* radius + x*Math.sqrt(3)*radius);
					int yCoord = (int) (yOffset + y*1.5 * radius);
					
					if (x == 0 && y == 0)
					{
						tilePanel = new HexTile(xCoord, yCoord, radius, tile, 5, twoColor, oneColor);
					}
					else if (x == 0 && y == (size - 1))
					{
						tilePanel = new HexTile(xCoord, yCoord, radius, tile, 6, twoColor, oneColor);
					}
					else if (x == (size - 1) && y == (size - 1))
					{
						tilePanel = new HexTile(xCoord, yCoord, radius, tile, 7, twoColor, oneColor);
					}
					else if (x == (size - 1) && y == 0)
					{
						tilePanel = new HexTile(xCoord, yCoord, radius, tile, 8, twoColor, oneColor);
					}
					else if (y == 0)
					{
						tilePanel = new HexTile(xCoord, yCoord, radius, tile, 1, oneColor);
					}
					else if (x == (size - 1))
					{
						tilePanel = new HexTile(xCoord, yCoord, radius, tile, 2, twoColor);
					}
					else if (y == (size - 1))
					{
						tilePanel = new HexTile(xCoord, yCoord, radius, tile, 3, oneColor);
					}
					else if (x == 0)
					{
						tilePanel = new HexTile(xCoord, yCoord, radius, tile, 4, twoColor);
					}
					else
					{
						tilePanel = new HexTile(xCoord, yCoord, radius, tile);
					}
					
					tilePanel.paint(g);
					tilePanel.addActionListener(this);
					add(tilePanel);
				}
			}
		}
	}

	/**
	 * Since HexPanel is an Observer of an AbstractGameBoard, update is called
	 * whenever the board changes. This triggers a repaint of this panel 
	 * and the color will be updated appropriately.
	 * 
	 */
	@Override
	public void update(Observable obs, Object obj) {
		if (obj instanceof Board)
		{
			board = (Board) obj;
			repaint();
		}
	}

	/**
	 * actionPerformed receives mouse clicks and makes a MoveEvent
	 * with the board coordinates. This event is sent to all AWTEventListeners(), 
	 * which should at this point only be the current player.
	 *  
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() instanceof HexTile)
		{
			HexTile   tile = (HexTile) e.getSource();
			MoveEvent move = new MoveEvent(new Point(tile.getBoardX(), tile.getBoardY()), 0);
			for (AWTEventListener l : Toolkit.getDefaultToolkit().getAWTEventListeners())
			{
				l.eventDispatched(move);
			}	
		}
		
	}

}
