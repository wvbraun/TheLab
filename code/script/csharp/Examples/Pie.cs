// Pie.cs - Using the modulus operator 
// ---------------------------------------
using System;

class Pie
{
	public static void Main()
	{
		int PiecesForMe = 0;
		int PiecesOfPie = 0;
		
		PiecesOfPie = 3*6;
		PiecesForMe = PiecesOfPie % 13;
		
		Console.WriteLine("Pieces of Pie = {0}", PiecesOfPie);
		Console.WriteLine("Pieces For Me = {0}", PiecesForMe);
	}
}