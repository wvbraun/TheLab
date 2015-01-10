// even.cs - Using the while with the break and continue commands
// ---------------------------------------------------------------

using System; 

class even
{
	public static void Main()
	{
		int ctr = 0;
		
		while (true)
		{
			ctr++;
			
			if (ctr > 10)
			{
				break;
			}
			else if ( (ctr % 2) == 1)
			{
				continue;
			}
			else
			{
				Console.WriteLine("...{0}...", ctr);
			}
		}
		Console.WriteLine("Done!");
	}
}
		