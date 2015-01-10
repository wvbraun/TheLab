package palantir;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MatrixSolver {
	
	public static void Solve(Matrix matrix)
	{
		int max = matrix.numberOfSameRows();	
		
		for (int start = 0; start < matrix.getColumnCount(); start++)
		{
			for (int n = 1; (n + start) <= matrix.getColumnCount(); n++)
			{
				Matrix newMatrix = matrix;
				newMatrix.flipNColumns(start, n);
				
				int same = newMatrix.numberOfSameRows();				
				if (same > max)
				{
					max = same;
				}
			}
		}
		System.out.println(max);
	}

	public static void main(String[] args) 
	{
		FileInputStream file = null;
		Scanner reader = null;
		Matrix matrix;
		String line;
		int m, n;

		try
		{
			
			file = new FileInputStream(args[0]);
			reader = new Scanner(file);
			
			m = reader.nextInt();
			n = reader.nextInt();
			matrix = new Matrix(m,n);
			reader.nextLine();
			
			int i = 0;
			while (reader.hasNext())
			{
				line = reader.nextLine();
				matrix.insertRow(i, line);
				i++;
			}
			
			Solve(matrix);
		}
		catch (FileNotFoundException ex)
		{
			Logger.getLogger(Matrix.class.getName()).log(Level.SEVERE, null, ex);
		}
		finally
		{
			try
			{
				reader.close();
				file.close();
			}
			catch (IOException ex)
			{
				Logger.getLogger(Matrix.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
}
