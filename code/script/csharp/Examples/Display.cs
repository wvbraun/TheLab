// Display.cs - printing with WriteLine and Write
// -------------------------------------------------

using System;

class Display
{
	public static void Main()
	{
	
		int iNbr = 321;
		double dNbr = 123.45; 
		
		Console.WriteLine("First WriteLine Line");
		Console.WriteLine("Second WriteLine Line");
		
		Console.Write("First Write Line");
		Console.Write("Second Write Line");
		
		// passing literal parameters
		Console.WriteLine("\nWriteLine: Parameter = {0}", 123);
		Console.Write("Write: Parameter = {0}", 456);
		
		// passing variables
		Console.WriteLine("\nWriteLine: val1 = {0} val2 = {1}", iNbr, dNbr);
		Console.Write("Write: val1 = {0} val2 = {1}", iNbr, dNbr);
	}
}