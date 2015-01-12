package code.games.hex.players;

import java.util.List;
import java.util.Scanner;

import code.games.hex.board.Board;
import code.games.hex.gameMechanics.Move;
import code.games.hex.gameMechanics.PlayerColor;
import code.games.hex.view.textual.CommandLineView;

/**
 * A command line Player.
 */
public class CommandLinePlayer extends AbstractPlayer 
{
	public CommandLinePlayer(PlayerColor color) {
		super(color);
		this.scanner = new Scanner(System.in);
	}

	private Scanner scanner;
	
	/**
	 * The getMove for a CommandLinePlayer prompts the user for a x and a y and
	 * make a Move with that x and y.
	 * 
	 * @param board
	 *            this Game Board
	 * @param legalMoves
	 *            an ArrayList of legal moves
	 * @return the Move created from the keyboard prompt
	 */
	@Override
	public Move getMove(Board board, List<Move> legalMoves) {
		System.out.print(CommandLineView.boardToString(board));
		System.out.print(this.getColor() + " to move: ");

		System.out.println("Input the x coordinate of your move: ");
		int x = scanner.nextInt();
		System.out.println("Input the y coordinate of your move: ");
		int y = scanner.nextInt();

		return new Move(x, y);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getName() 
	{
		return "code.games.hex.players.CommandLinePlayer";
	}

}
