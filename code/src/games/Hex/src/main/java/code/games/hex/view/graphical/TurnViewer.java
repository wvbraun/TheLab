package code.games.hex.view.graphical;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import code.games.hex.gameMechanics.GameRunner;
import code.games.hex.gameMechanics.PlayerColor;

/**
 * Represents who is the current player and the winner.
 *
 */
@SuppressWarnings("serial")
public class TurnViewer extends JPanel implements Observer
{
	private GameRunner  game;
	private PlayerColor color, current;

	public TurnViewer()
	{
		this(null,null);
	}
	
	/**
	 * Creates a triangle which indicates whose turn it is. 
	 * 
	 * @param color
	 * @param game
	 */
	public TurnViewer(PlayerColor color, GameRunner game)
	{
		this.color 	 = color;
		this.game  	 = game;
		this.current = null;
		setPreferredSize(new Dimension(30, 30));
	}
	
	/**
	 * Sets the color of the TurnViewer to the specified PlayerColor.
	 * 
	 * @param color
	 */
	public void setColor(PlayerColor color)
	{
		this.color = color;
	}
	
	/**
	 * Sets the Game to the specified GameRunner.
	 * 
	 * @param game
	 */
	public void setGame(GameRunner game)
	{
		this.game = game;
		game.addObserver(this);
	}
	
	/**
	 * This method is called whenever a repaint() is requested. 
	 * It should draw something that indicated whether it is the given player's turn. 
	 * For example if it is the given player's turn, draw a solid triangle. 
	 * If it is not the current player's turn, draw only the border for a triangle.
	 */
	public void paintComponent(Graphics g)
	{
		if (game != null)
		{
			super.paintComponent(g);
			Graphics2D graphics2D 	= (Graphics2D) g;
			Polygon    polygon 		= new Polygon(new int[] {0,  10,  0}, new int[] {0, 10, 20}, 3);
			
	
			if (game.isGameStopped() && color.equals(current))
			{
				switch (current)
				{
					case RED: 
						graphics2D.setColor(Color.RED);
						break;
					case ORANGE:
						graphics2D.setColor(Color.ORANGE);
						break;
					case YELLOW:
						graphics2D.setColor(Color.YELLOW);
						break;
					case GREEN:
						graphics2D.setColor(Color.GREEN);
						break;
					case BLUE:
						graphics2D.setColor(Color.BLUE);
						break;
					case PURPLE:
						graphics2D.setColor(Color.MAGENTA);
						break;
					default:
						break;
				}
				graphics2D.fillPolygon(polygon);
			}
			else if (color.equals(current))
			{
				graphics2D.setColor(Color.BLACK);
				graphics2D.fillPolygon(polygon);
			}		
			graphics2D.drawPolygon(polygon);
		}
	}
	
	/**
	 * Since a TurnViewer observes a GameRunner, this method will be called when the turn changes. 
	 * It should update the GUI to reflect the new current player.
	 */
	@Override
	public void update(Observable obs, Object obj) {
		if (obj instanceof PlayerColor)
		{
			current = (PlayerColor) obj;
			repaint();
		}
	}

}
