package palantir;



public class Matrix {
	private int Rows;
	private int Columns;
	private char[][] Grid;
	
	public Matrix()
	{
		this(3, 3);
	}
	
	public Matrix(int rows, int columns)
	{
		Rows = rows;
		Columns = columns;
		Grid = new char[rows][columns];
	}
	
	public int getRowCount()
	{
		return Rows;
	}
	
	public int getColumnCount()
	{
		return Columns;
	}
	
	public void insertRow(int r, String row)
	{
		for (int c = 0; c < Columns; c++)
		{
			char item = row.charAt(c);
			Grid[r][c] = item;
		}
	}
		
	public void flipNColumns(int start, int n)
	{
		int maxCol = start + n;
		for (int col = start; col < maxCol; col++)
		{
			for (int row = 0; row < Rows; row++)
			{
				if (Grid[row][col] == 'P')
				{
					Grid[row][col] = 'T';
					continue;
				}
				Grid[row][col] = 'P';
			}
		}
	}
	
	public int numberOfSameRows()
	{
		int total = 0;

		for (int row = 0; row < Rows; row++)
		{
			if (SameRow(row))
			{
				total++;
			}
		}

		return total;
	}
	
	public boolean SameRow(int row)
	{
		char first = Grid[row][0];
		for (int col = 1; col < Columns; col++)
		{
			if (Grid[row][col] != first)
			{
				return false;
			}
		}
		
		return true;
	}
}
