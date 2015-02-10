package code.games.sudoku;

/*
 An object of this class manages a particular cell of a sudoku puzzle.
 Its two main tasks are:
 -to insert a value into the cell it manages
 -to decide if it is legal to insert a given value in the cell it manages
 its cell can hold a given value only if:
 (1) the value is an empty cell value, or
 (2) the value is a legal digit value, and
 neither this cell's row, nor column, nor box has the same value

 */
class SudokuCell {
	private int boxSize;
	private int rowCount;
	private int columnCount;
	//notice that puzzle is static, this means that whenever any SudokuCell changes 
	//this puzzle, it will change it for all SudokuCells.
	private static SudokuPuzzle puzzle;
	// which row and column (of cells) this cell is in
	private int row, column;
	// which row and column (of boxes) this cell is in
	private int boxRow, boxColumn;

	public SudokuCell(SudokuPuzzle currentPuzzle, int row, int column) {
		//check to see if the row, column combination fall inside the currentPuzzle.
		if(row < currentPuzzle.getPuzzleSize() && column < currentPuzzle.getPuzzleSize()
				&& row >= 0 && column >= 0){
			puzzle = currentPuzzle;
			this.boxSize = puzzle.getBoxSize();
			this.rowCount = boxSize * boxSize;
			this.columnCount = boxSize * boxSize;
			this.row = row;
			this.column = column;
			this.boxRow = (row / boxSize) * boxSize;
			this.boxColumn = (column / boxSize)  * boxSize;
		}
		//if the row and column fall outside of the puzzle's size, then use -1 as the value
		//so we can check against -1 explicitly in isLegalToInsert
		else{
			this.row = -1;
			this.column = -1;
		}
	}

	// change this cell to store the given value
	public void insert(int value) {
		puzzle.set(row, column, value);
	}
	
	public int getRow(){
		return this.row;
	}
	
	public int getColumn(){
		return this.column;
	}

	/**
	 * isLegalToInsert takes a value and a puzzle and checks to see whether
	 * putting that value at this cell's location in the puzzle would be legal.
	 * In order to check this legality, isLegalToInsert must do four things.
	 * 
	 *  1. if either the row  = -1 or the column = -1 then this cell is outside the bounds
	 *     of the puzzle and the insertion is not legal.
	 *  2. assuming the cell is within the bounds of the puzzle, if the value given is
	 *     the empty value for this puzzle, then the insertion is legal. (This is because
	 *     the empty value should not violate any of the legality rules for the puzzle.)
	 *  3. if the value given is not a legal value for the puzzle (for example, 10 or -2 
	 *     for a sudoku on a 9x9 grid) then this move is not legal.
	 *  4. finally, if the attempted move passes 1. and 3. above and also passes
	 *     isLegalForRow, isLegalForColumn, and isLegalForBox, then it is a legal move.
	 * 
	 * @param value
	 * @param currentPuzzle
	 * @return true if the move is legal, and false otherwise
	 */
	public boolean isLegalToInsert(int value, SudokuPuzzle currentPuzzle) {
		puzzle = currentPuzzle;
	
		if (getRow() == -1 || getColumn() == -1)
		{
			return false;
		}
		else if (puzzle.isEmptyValue(value))
		{
			return true;
		}
		else if (!puzzle.isDigitLegal(value))
		{
			return false;
		}	
		else if ( (!isLegalForRow(value)) || (!isLegalForColumn(value)) || (!isLegalForBox(value)) )
		{
			return false;
		}
		
		
		return true;
	}

	/**
	 * Checks to see if the given digit is legal for this cell's row of the puzzle.
	 * A digit is legal for a row if that digit does not already appear in the row.
	 * 
	 * @param digit
	 * @return true if the digit is legal for the row and false otherwise
	 */
	private boolean isLegalForRow(int digit)
	{
		int size = rowCount;
		int col = getColumn();
		
		for (int row = 0; row < size; row++)
		{
			if (puzzle.get(row, col) == digit)
			{
				return false;
			}
		}
		
		return true;
	}

	/**
	 * Checks to see if the given digit is legal for this cell's column of the puzzle.
	 * A digit is legal for a column if that digit does not already appear in the column.
	 * 
	 * @param digit
	 * @return true if the digit is legal for the column and false otherwise
	 */
	private boolean isLegalForColumn(int digit)
	{
		int size = columnCount;
		int row = getRow();
		
		for (int col = 0; col < size; col++)
		{
			if (puzzle.get(row, col) == digit)
			{
				return false;
			}
		}
		
		return true;
	}

	/**
	 * Checks to see if the given digit is legal for this cell's box of the puzzle.
	 * A digit is legal for a box if that digit does not already appear in that box.
	 * 
	 * Note: Instances of your SudokuCell class have boxRow and boxColumn fields.  These fields,
	 * in combination with boxSize, may prove useful when trying to check digit against only
	 * the cells of the puzzle that are in this cell's box.
	 * 
	 * @param digit
	 * @return true if the digit is legal for the box and false otherwise
	 */
	private boolean isLegalForBox(int digit) 
	{
		int rowSize = boxRow + boxSize;
		int colSize = boxColumn + boxSize;
		
		for (int row = boxRow; row < rowSize; row++)
		{
			for (int col = boxColumn; col < colSize; col++)
			{
				if (puzzle.get(row, col) == digit)
				{
					return false;
				}
			}
		}
		
		return true;
	}
}
