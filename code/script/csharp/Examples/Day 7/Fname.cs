// Fname.cs - Initializing an Array
// ----------------------------

using System;

public class Fname
{
	public static void Main()
	{
		char[] name = new char[] {'B', 'r', 'a', 'd', 'l', 'e', 'y', (char) 0 };
		
		Console.WriteLine("Display content of name array...");
		
		int ctr = 0;
		while (name[ctr] != 0)
		{
			Console.Write("{0}", name[ctr]);
			ctr++;
		}
		Console.WriteLine("\n...Done.");
	}
}