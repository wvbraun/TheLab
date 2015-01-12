package code.games.hex.execptions;

import code.games.hex.gameMechanics.Move;

/**
 * InvalidMoveException
 */
@SuppressWarnings("serial")
public class InvalidMoveException extends Exception {

	public static final int OUTSIDE_BOARD = 0;
	public static final int ALREADY_TAKEN = 1;
	private int 			problem = -1;
	
	private Move 			move;

	/**
	 * InvalidMoveException is the exception thrown when a player makes
	 * and invalid move as determined by the game rules.
	 * 
	 * @param exception String describing what exception was thrown
	 * @param move Move that was the problem
	 * @param problem int used to flag what caused the exception
	 */
	public InvalidMoveException(String exception, Move move, int problem) {
		super(exception);
		this.move = move;
		this.problem = problem;
	}

	/**
	 * getProblem returns an int corresponding to the problem.
	 * that was caused.
	 * 
	 * @return int
	 */
	public int getProblem() {
		return this.problem;
	}

	/**
	 * getMove returns the problematic move.
	 * 
	 * @return Move the problematic move
	 */
	public Move getMove() {
		return this.move;
	}
}
