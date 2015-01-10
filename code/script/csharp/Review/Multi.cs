// Multi.cs - Multiplication table for 5
// ---------------------------------------

using System;

class Multi
{
	public static void Main()
	{
		int p = 5;
		int n = 0;
		for ( int i = 0; i <= 50; i += 5)
		{
			Console.WriteLine("{0} * {1} = {2}", p, n, i);
			n++;
		}
	}
}