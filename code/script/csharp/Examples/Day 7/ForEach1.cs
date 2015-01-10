// ForEach1.cs - Initializing an Array
// ----------------------------------------

using System;

public class ForEach1
{
	public static void Main()
	{
		char[] name = new char[] {'B', 'r', 'a', 'd', 'l', 'e', 'y'};
		
		Console.WriteLine("Display content of name array...");
		
		foreach( char x in name)
		{
			Console.Write("{0}", x);
		}
		Console.WriteLine("\n...Done.");
	}
}