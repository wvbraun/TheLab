// while99.cs - counts from 99 to 1. 
// -----------------------------------------------------------------

using System; 

class while99
{
	public static void Main()
	{
		
		int nbr = 99; // counter 
		
		while (nbr >= 1)
		{
			Console.WriteLine("{0}", nbr);
			nbr -= 1;
		}
	}
}
		
