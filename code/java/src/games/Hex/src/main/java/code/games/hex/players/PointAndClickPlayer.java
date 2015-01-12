package code.games.hex.players;

import java.awt.AWTEvent;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.util.List;

import code.games.hex.board.Board;
import code.games.hex.gameMechanics.Move;
import code.games.hex.gameMechanics.PlayerColor;

/**
 * Allows for a GUI Player.
 *
 */
public class PointAndClickPlayer extends AbstractPlayer implements AWTEventListener
{
	private Point 		point;
	
	public PointAndClickPlayer(PlayerColor c) {
		super(c);
	}
	
	/**
	 * This method is the entry point for a Player.
	 * A player will be invoked with the getMove() method and
	 * given a copy of the board and the list of legal moves from the GameRunner.  
	 * It is then expected to return a Move from the list of legalMoves. If it does not
	 * do so it will forfeit. Which move is chosen varies from Player to Player depending on
	 * their strategy.
	 * 
	 * @param board
	 * @param legalMoves
	 * 
	 * @return Move - the desired move
	 */
	@Override
	public Move getMove(Board board, List<Move> legalMoves) 
	{
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		toolkit.addAWTEventListener(this, 0);
		
		while(point == null)
		//while (toolkit.getSystemEventQueue().peekEvent() == null)
		{
			try{
				Thread.sleep(10);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		int x = (int) point.getX();
		int y = (int) point.getY();
		point = null;
		toolkit.removeAWTEventListener(this);
		return new Move(x, y);
	}

	/**
	 * 
	 * @return String - the name of the player.
	 */
	@Override
	public String getName() 
	{
		return "code.games.hex.players.PointAndClickPlayer";
	}

	@Override
	public void eventDispatched(AWTEvent e)
	{
		if (e.getSource()instanceof Point)
		{
			point = (Point) e.getSource();
		}
	}

}
