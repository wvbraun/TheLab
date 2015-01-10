// Char.cs

// A list to print out a number of characters and their numbers. 
//--------------------------------------------------------------

using System; 

class Chars
{
	public static void Main()
	{
		int ctr;
		char ch;
		
		Console.WriteLine("\nNumber    Value\n");
		
		for (ctr = 63; ctr <= 94; ctr = ctr +1)
		{
		
			ch = (char) ctr;
			Console.WriteLine("{0} is {1}", ctr, ch);
		}
	}
}