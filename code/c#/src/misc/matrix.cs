using System;

public static class Matrix
{
	public static int findPath(int [][] mat)
	{
		for (int r = 0; r < mat.Length; r++)
		{
			int [] cols = mat[r];
			for (int c = 0; c < cols.Length; c++)
			{
				if (mat[r,c] == 1)
					Console.WriteLine(r,c);
			}
		}
	}

	public static void Main()
	{
		int [][] mat = new int [][] {new int[] {0,0}, new int[] {1, 0}, 
			new int[]{0,0}, new int[]{0,0}, new int[]{0,0}, new int[]{0,0},
			new int[]{0,1}, new int[]{0,0}};
		Console.WriteLine(findPath(mat));
	}
}
	
