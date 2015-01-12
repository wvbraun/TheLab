package code.games.sudoku;

/*
 An object of this class represents a sudoku puzzle with a grid,
 which here is implemented as a 2-dimensional array of ints
 in the range 0 to boxSize * boxSize (which equals puzzleSize),
 where 0 represents a blank (i.e. to show that the cell is empty).
 (note: boxSize must be at least 2, and for normal sudoku, boxSize = 3,
 but it can also be 4, but for boxSize >= 5, depth-first search is too
 slow.)

 */

class SudokuPuzzle 
{
	private int boxSize = 3;
	private int puzzleSize = boxSize * boxSize;
	private int rowCount = puzzleSize;
	private int columnCount = puzzleSize;
	private int[][] grid;

	public SudokuPuzzle() 
	{
		this(3);
	}
	
	public SudokuPuzzle(int boxSize)
	{
		this.setBoxSize(boxSize);
		grid = new int[rowCount][columnCount];
	}
	
	public void setBoxSize(int boxSize)
	{
		this.boxSize = boxSize;
		this.puzzleSize = boxSize * boxSize;
		this.rowCount = this.puzzleSize;
		this.columnCount = this.puzzleSize;
	}
	
	public int getBoxSize()
	{
		return this.boxSize;
	}
	
	public int getPuzzleSize()
	{
		return this.puzzleSize;
	}
	
	public int getColumnCount()
	{
		return this.columnCount;
	}
	
	public int getRowCount()
	{
		return this.rowCount;
	}

	// report whether a particular value is an empty cell value
	public boolean isEmptyValue(int value)
	{
		return (value == getEmptyValue());
	}

	// report whether a particular value is a legal digit value
	public boolean isDigitLegal(int value)
	{
		return ((value >= 1) && (value <= puzzleSize));
	}

	// report the value that represents an empty cell's value
	public int getEmptyValue() 
	{
		return 0;
	}

	// report a particular cell's value
	public int get(int row, int column) 
	{
		return grid[row][column];
	}

	// set a particular cell's value
	public void set(int row, int column, int value)
	{
		grid[row][column] = value;
	}
	
	/**
	 * Checks to see if the value at row, column of the puzzle is the empty
	 * value and returns true if it is and false otherwise. The isEmptyValue
	 * method may be useful when writing isEmpty.
	 * 
	 * @param row
	 * @param column
	 * @return true if the value of the puzzle at row, grid is the empty value
	 *         and false otherwise
	 */
	public boolean isEmpty(int row, int column) 
	{	
		int value = get(row, column);
		return isEmptyValue(value);
	}

	/**
	 * Checks to see if there is an empty value in the puzzle and returns
	 * true if there is and false otherwise.
	 * 
	 * @return true if the puzzle has an empty cell and false otherwise
	 */
	public boolean hasEmptyCell() 
	{
		int colSize = getRowCount();
		int rowSize = getColumnCount();
		
		for (int row = 0; row < rowSize; row++)
		{
			for (int col = 0; col < colSize; col++)		
			{
				if (isEmpty(row, col))
				{
					return true;
				}
			}
		}
		
		return false;
	}

	/**
	 * getEmptyCell checks to see if there is a an empty value in the
	 * puzzle and, if there is, returns a SudokuCell corresponding to
	 * that spot.
	 * 
	 * @return a SudokuCell if there is an empty spot in the puzzle, and null otherwise
	 */
	
	public SudokuCell getEmptyCell() 
	{
		int rowSize = getColumnCount();
		int colSize = getRowCount();
		
		if (hasEmptyCell())
		{
			for (int row = 0; row < rowSize; row++)
			{
				for (int col = 0; col < colSize; col++)
				{
					if (isEmpty(row, col))
					{
						SudokuCell cell = new SudokuCell(this, row, col);
						return cell;
					}
				}
			}
		}
		
		return null;
	}
	
	public int[][] getPuzzle()
	{
		return grid;
	}
	
	public boolean setPuzzle(int[][] grid)
	{
		if(grid.length == grid[0].length && Math.sqrt(grid.length) == ((int) Math.sqrt(grid.length)))
		{
			for(int i = 0; i < grid.length; i++)
			{
				for(int j = 0; j < grid.length; j++)
				{
					if(grid[i][j] < 0 || grid[i][j] > grid.length)
					{
						return false;
					}
				}
			}
			this.grid = grid;
			this.setBoxSize((int) Math.sqrt(grid.length));
			return true;
		}
		return false;
	}
	
	// display this sudoku puzzle
	public void show() 
	{
		boolean extraDigits = false;
		int numExtraDigits = 0;
		if(this.puzzleSize > 9)
		{
			extraDigits = true;
			numExtraDigits = this.puzzleSize;
		}
		printLine("ends", numExtraDigits);
		for (int row = 0; row < rowCount; row++) 
		{
			if(row % boxSize == 0 && row != 0)
			{
				printLine("mid", numExtraDigits);
			}
			for (int column = 0; column < columnCount; column++) 
			{
				if(column % boxSize == 0)
				{
					System.out.print("| ");
				}
				if (isEmpty(row, column)|| this.grid[row][column] == 0)
				{
					if(extraDigits)
					{
						System.out.print(' ');
					}
					System.out.print(' ');
				}
				else
				{
					System.out.print(grid[row][column]);
					if(extraDigits && grid[row][column] < 10)
					{
						System.out.print(' ');
					}
				}
				System.out.print(' ');
			}
			System.out.println('|');
		}
		printLine("ends", numExtraDigits);
	}

	// display a line
	private void printLine(String lineLocation, int numExtraDigits) {
		if(lineLocation.equals("mid")){
			System.out.print('|');
			for (int column = 0; column < (2 * (columnCount + boxSize) - 1 + numExtraDigits); column++){
				System.out.print('-');
			}
			System.out.println('|');
		}
		else if(lineLocation.equals("ends")){
			System.out.print(' ');
			for (int column = 0; column < (2 * columnCount + boxSize) + boxSize - 1 + numExtraDigits; column++){
				System.out.print('-');
			}
			System.out.println();
		}
	}
}