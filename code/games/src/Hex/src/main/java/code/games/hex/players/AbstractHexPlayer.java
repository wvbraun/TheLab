package code.games.hex.players;

import code.games.hex.gameMechanics.PlayerColor;

/**
 * Abstract class for AI Players.
 */
public abstract class AbstractHexPlayer extends AbstractPlayer 
{
	private boolean isPlayerOne;
	
	public AbstractHexPlayer(PlayerColor c, boolean isPlayerOne) {
		super(c);
		this.isPlayerOne = isPlayerOne;
	}
	
	protected boolean getIsPlayerOne()
	{
		return isPlayerOne;
	}

}
