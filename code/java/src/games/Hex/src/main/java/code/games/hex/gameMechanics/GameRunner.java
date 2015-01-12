package code.games.hex.gameMechanics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.Scanner;

import code.games.hex.board.Board;
import code.games.hex.board.SimpleGameBoard;
import code.games.hex.execptions.InvalidMoveException;
import code.games.hex.players.AStarHexPlayer;
import code.games.hex.players.BasicHexPlayer;
import code.games.hex.players.CommandLinePlayer;
import code.games.hex.players.Player;
import code.games.hex.players.PointAndClickPlayer;
import code.games.hex.players.SimpleRandomPlayer;
import code.games.hex.view.graphical.GraphicalBoardView;
import code.games.hex.view.textual.CommandLineView;

/**
 * The Controller for Hex.
 *
 */
public class GameRunner extends Observable implements Runnable
{
	private static boolean isCLI;
	
	private 	   Board   board;
	private        Rules   rules;
	private        Player  playerOne;
	private        Player  playerTwo;
	private 	   boolean gameStopped;
		
	public GameRunner(int boardSize, String one, String two, String ruleSet, PlayerColor oneColor, PlayerColor twoColor)
	{
		gameStopped = false;
		board 		= new SimpleGameBoard(boardSize);
		playerOne 	= createPlayer(one, oneColor, true);
		playerTwo 	= createPlayer(two, twoColor, false);
		rules 		= createRules(ruleSet, board, playerOne, playerTwo);
	
	}
	
	/**
	 * Returns a Player with a specified Type and PlayerColor
	 * 
	 * 
	 * @param playerType - the desired Player Type
	 * @param color   
	 * @param isPlayerOne - used in AI players in order to correctly draw the border
	 * 
	 * @return Player
	 */
	private Player createPlayer(String playerType, PlayerColor color, boolean isPlayerOne)
	{
		Player player;
		
		switch (playerType)
		{
			case "Random Player":
				player = new SimpleRandomPlayer(color);
				break;
			case "CommandLine Player":
				player = new CommandLinePlayer(color);
				break;
			case "Clickable Player":
				player = new PointAndClickPlayer(color);
				break;
			case "Basic AI":
				player = new BasicHexPlayer(color, isPlayerOne);
				break;	
			case "A* AI":
				player = new AStarHexPlayer(color, isPlayerOne);
				break;
			default:
				player = new SimpleRandomPlayer(color);
				break;
		}
		
		return player;
	}
	
	/**
	 * Returns a Rule specified by the ruleSet
	 * 
	 * @param ruleSet
	 * @param board
	 * @param one
	 * @param two
	 * 
	 * @return Rules
	 */
	private static Rules createRules(String ruleSet, Board board, Player one, Player two)
	{
		Rules rules;
		
		switch (ruleSet)
		{
			case "Standard Rules":
				rules = new StandardRules(board, one, two);
				break;
			case "Overwrite Rules":
				rules = new OverwriteRules(board, one, two);
				break;
			case "Lose By Connecting Rules":
				rules = new LoseByConnectingRules(board, one, two);
				break;	
			default:
				rules = new StandardRules(board, one, two);
				break;
		}
		
		return rules;
	}
	
	/**
	 * Returns a boolean representing if the game is stopped or running.
	 * 
	 * @return boolean
	 */
	public boolean isGameStopped()
	{
		return gameStopped;
	}
	
	/**
	 * Returns the current Board
	 * 
	 * @return Board
	 */
	public Board getBoard()
	{
		return board;
	}
	
	/**
	 * Returns a List of Strings which represent all available
	 * Player types.
	 * 
	 * @return List<String> - all available Players
	 */
	public static List<String> getPlayersList()
	{
		return new ArrayList<String>(Arrays.asList(
				"Clickable Player",
				"Random Player",
				"Basic AI",
				"A* AI"));		
	}
	
	/**
	 * Returns the current Player
	 * 
	 * @return Player - the current player.
	 */
	public Player getCurrentPlayer()
	{
		return rules.getCurrentPlayer();
	}
	
	/**
	 * Returns a List of Strings which represent all
	 * available Rules
	 * 
	 * @return List<String> - all available rules
	 */
	public static List<String> getRuleSets()
	{
		return new ArrayList<String>(Arrays.asList(
				"Standard Rules",
				"Lose By Conneting Rules",
				"Overwrite Rules")); 
	}
	
	/**
	 * Used to tell the game to stop.
	 * 
	 */
	public void stopGame()
	{
		gameStopped = true;
	}
	
	/**
	 * Used to abstract the logic contained within the Run() method.
	 * 
	 * 	 i) Determine if the board is full, if so stop the game. 
	 *  ii) Notify the TurnViewer to change to the next Player.
	 * iii) Notify the Board to fill the move
	 *  iv) Determine if their is a winner, if so stop the game.
	 *  
	 * @param player
	 * @param color      
	 * @param legalMoves
	 * @param isAI       - is this an ai?
	 */
	private void playerRun(Player player, PlayerColor color, List<Move> legalMoves, Boolean isAI)
	{
		if (isCLI)
		{
			System.out.println(player);
			System.out.println(rules);
		}
		
		if (legalMoves == null)
		{
			stopGame();
			
			if (isCLI)
			{
				System.out.println(CommandLineView.boardToString(board));
				System.out.println("Tie!");	
			}
		}
		else
		{		
			setChanged();
			notifyObservers(color);
			Move move = player.getMove(board, legalMoves);
			
			try 
			{
				rules.makeMove(move);
				
				if (isCLI)
				{
					System.out.println(CommandLineView.boardToString(board));
					System.out.println(color + " " + move);
				}
				
				setChanged();
				notifyObservers(board);

				PlayerColor winner = rules.checkForWins();

				if (winner == color)
				{
					stopGame();
					setChanged();
					notifyObservers(color);
					
					if (isCLI)
					{
						System.out.println(CommandLineView.boardToString(board));
						System.out.println(color + " wins!");
					}
				}
				else
				{
					rules.nextTurn();
				}
			} 
			catch (InvalidMoveException e)
			{
				e.printStackTrace();
			}
			
			if (isAI)
			{
				try 
				{
					Thread.sleep(200);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * Used to make the game run by determining the type of player 
	 * used.
	 */
	@Override
	public void run() 
	{
		setChanged();
		notifyObservers(board);
		
		while (!gameStopped)
		{
			Player	 	player 	   = getCurrentPlayer();
			PlayerColor	color      = player.getColor();
			String 		name       = player.getName();
			List<Move>  legalMoves = rules.getLegalMoves(player);

			switch (name)
			{
				case "code.games.hex.players.CommandLinePlayer":
					playerRun(player, color, legalMoves, false);
					break;
				case "code.games.hex.players.PointAndClickPlayer":
					playerRun(player, color, legalMoves, false);
					break;
				case "code.games.hex.players.SimpleRandomPlayer":
					playerRun(player, color, legalMoves, true);
					break;
				case "code.games.hex.players.BasicTrailsPlayer":
					playerRun(player, color, legalMoves, true);
					break;
				case "code.games.hex.players.AStarTrailsPlayer":
					playerRun(player, color, legalMoves, true);
					break;
			}
		}
	}
	
	/**
	 * Main method for GameRunner. Running the game with gui 
	 * allows for a gui game, with cli allows for cli. 
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		if (args[0].equals("cli"))
		{
			GameRunner.isCLI = true;
			CommandLineView.setup(new Scanner(System.in));
		}
		else
		{
			Thread t = new Thread(new GraphicalBoardView());
			t.start();
		}
	}
}
