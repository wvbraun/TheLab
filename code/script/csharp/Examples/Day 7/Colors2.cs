// Colors2.cs 
// --------------------

using System; 

class Colors2
{
	enum Color : byte
	{
		red, 
		white, 
		blue
	}
	
	public static void Main()
	{
		Color myColor;
		byte roll; 
		
		Random rnd = new Random();
		
		for ( int ctr = 0; ctr < 10; ctr++ )
		{
			roll = (byte) (rnd.Next(0,3)); // random nbr from 0 to 2
			myColor = (Color) roll; 
			
			Console.WriteLine("Color is {0} ({1} of type {2})", 
							my Color, (byte) myColor, myColor.GetTypeCode());
		}
	}
}