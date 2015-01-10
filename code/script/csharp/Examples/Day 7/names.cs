// Names.cs - Using a 2d array
// -----------------------------------

using System;

public class Names
{
	public static void Main()
	{
		char[][] name = new char [3][];
		
		name[0] = new char[7] {'B', 'r','a', 'd', 'l', 'e', 'y'};
		name[1] = new char[2] {'L', '.'};
		name[2] = new char[5] {'J', 'o', 'n', 'e', 's'};
		
		Console.WriteLine("Display the sizes of the arrays...\n");
		Console.WriteLine("Length of name array{0}", name.Length);
		
		for { int ctr = 0; ctr < name.Length; ctr++)
		{
			Console.WriteLine("Length of name[{0}] is {1}", ctr, name[ctr].Length);
		}
// --------------------------------------------------------------------------------

		Console.WriteLine("\nDisplaying the content of the name array...");
		
		for ( int ctr = 0; ctr < name.Length; ctr++)
		{
			Console.Write("\n"); // new line
			for ( int ctr2 = 0; ctr2 < name[ctr].Length; ctr2++)
			{
				Console.Write("{0}", name[ctr][ctr2]);
			}
		}
		Console.WriteLine("\n...Done displaying");
	}
}