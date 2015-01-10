// Unchecked.cs
// -----------------------------------------------------

using System; 

class Unchecked
{
	public static void Main()
	{
	
		int val1 = 2147483647;
		int val2; 
		
		unchecked
		{
			val2 = val1 + 1;
		}
		
		Console.WriteLine("val1 is {0}", val1);
		Console.WriteLine("val2 is {0}", val2);
	}
}