package code.games.hex.view.textual;

import java.util.ArrayList;
import java.util.Scanner;

import code.games.hex.board.Board;
import code.games.hex.gameMechanics.GameRunner;
import code.games.hex.gameMechanics.PlayerColor;

/**
 * Allows for a CommandLine game.
 *
 */
public class CommandLineView {
	/**
	 * Runs the game from the command line
	 * 
	 * @param scanner
	 */
	public static GameRunner setup(Scanner scanner)
	{		
		for (int i = 0; i < GameRunner.getPlayersList().size(); i++) {
			System.out.println("(" + i + ") " + GameRunner.getPlayersList().get(i));
		}
		String red = "edu.indiana.cs.c212.players.SimpleRandom";
		String blue = "edu.indiana.cs.c212.players.SimpleRandom";
		int boardSize = 7;

		System.out.println("Choose the red player (input a number): ");
		red = GameRunner.getPlayersList().get(scanner.nextInt());
		System.out.println("Choose the blue player (input a number): ");
		blue = GameRunner.getPlayersList().get(scanner.nextInt());
		System.out.println("What size of board do you want to play on?");
		boardSize = scanner.nextInt();

		System.out.println("Which rules do you want to use?");
		for (int i = 0; i < GameRunner.getRuleSets().size(); i++) {
			System.out.println("(" + i + ") " + GameRunner.getRuleSets().get(i));
		}
		String ruleSet = scanner.next();		
		GameRunner game = new GameRunner(boardSize, red, blue, ruleSet, PlayerColor.RED, PlayerColor.BLUE);
		game.run();
		
		return game;
	}

	public static String boardToString(Board b) {
		int size = b.getSize();
		String[] firsthex = { "  ____", " /    \\", "/      \\", "\\      /",
				" \\____/" };
		String[] firsthexcol = { "____", "    \\", "      \\", "      /",
				"____/" };
		String[] bottomhex = { " /    \\", "/      \\", "\\      /", " \\____/" };
		String[] bottomhexcol = { "    \\", "      \\", "      /", "____/" };

		ArrayList<StringBuilder> wholeboard = new ArrayList<StringBuilder>();

		// add first hex
		for (String s : firsthex)
			wholeboard.add(new StringBuilder(s));
		printName(0, 0, 0, 2, wholeboard, b);

		// add all the vertical hexes
		for (int i = 1; i < size; i++) {
			for (String s : bottomhex) {
				wholeboard.add(new StringBuilder(s));
			}
			printName(0, i, 0, (i * 4) + 2, wholeboard, b);
		}
		wholeboard.add(new StringBuilder("      \\"));
		wholeboard.add(new StringBuilder("       \\"));

		// advance to the next column and do that for all the cols
		for (int col = 1; col < size; col++) {
			int skip = ((col + 1) * 2) - 2;
			for (String s : firsthexcol) {
				wholeboard.get(skip).append(s);
				skip++;
			}
			printName(col, 0, 6 + ((col - 1) * 6), skip - 3, wholeboard, b);
			for (int row = 1; row < size; row++) {
				for (String s : bottomhexcol) {
					wholeboard.get(skip).append(s);
					skip++;
				}
				printName(col, row, 6 + ((col - 1) * 6), skip - 3, wholeboard,
						b);
			}
			// add the trailing space
			StringBuilder row1 = new StringBuilder("");
			StringBuilder row2 = new StringBuilder("");

			for (int colOffset = 0; colOffset <= col; colOffset++) {
				row1.append("      ");
				row2.append("      ");
			}
			row1.append("\\");
			row2.append(" \\");
			wholeboard.add(row1);
			wholeboard.add(row2);
		}

		wholeboard.remove(wholeboard.size() - 1);
		wholeboard.remove(wholeboard.size() - 1);

		for (StringBuilder s : wholeboard) {
			s.insert(0, " \t");
			s.append(" ");
		}

		String blueMessage = "BLUE GOAL";
		StringBuilder redMessage = new StringBuilder();
		for (int i = 0; i < size / 2; i++) {
			redMessage.append("      ");
		}
		redMessage.append("RED GOAL\n");
		int line = wholeboard.size() / 2 - 4;
		StringBuilder curLine = wholeboard.get(line);
		for (char c : blueMessage.toCharArray()) {
			curLine = wholeboard.get(line);
			curLine.setCharAt(0, c);
			line++;
		}
		line = wholeboard.size() / 2;
		for (char c : blueMessage.toCharArray()) {
			curLine = wholeboard.get(line);
			curLine.append("\t" + c);
			line++;
		}

		StringBuilder ans = new StringBuilder();

		ans.append(redMessage);
		for (StringBuilder s : wholeboard)
			ans.append(s.toString() + "\n");

		ans.append(redMessage);
		return "\n" + ans.toString();
	}

	private static void printName(int x, int y, int xOffset, int yOffset,
			ArrayList<StringBuilder> wholeboard, Board board) {
		printCoord(x, y, xOffset, yOffset + 1, wholeboard);
		if (board.getTileAt(x, y).getColor() == PlayerColor.BLUE) {
			StringBuilder sb = wholeboard.get(yOffset);
			sb.setCharAt(xOffset + 2, 'B');
			sb.setCharAt(xOffset + 3, 'L');
			sb.setCharAt(xOffset + 4, 'U');
			sb.setCharAt(xOffset + 5, 'E');
		}
		if (board.getTileAt(x, y).getColor() == PlayerColor.RED) {
			StringBuilder sb = wholeboard.get(yOffset);
			sb.setCharAt(xOffset + 2, 'R');
			sb.setCharAt(xOffset + 3, 'E');
			sb.setCharAt(xOffset + 4, 'D');
		}
	}
	
	private static void printCoord(int x, int y, int xOffset, int yOffset,
			ArrayList<StringBuilder> wholeboard) {		
			StringBuilder sb = wholeboard.get(yOffset);
			String coord = "(" +  x + "," + y + ")";
			sb.replace(xOffset + 1, xOffset + coord.length() + 1, coord);					
	}

}
