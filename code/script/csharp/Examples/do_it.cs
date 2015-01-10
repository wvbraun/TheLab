// do_it.cs - using the do statement
// get random numbers (from 1 to 10) until  a 5 is reached.
// -----------------------------------------------------------

using System;

class do_it
{
	public static void Main()
	{
		int ttl = 0; // variable to store the running total
		int nbr = 0; // variable to store individual numbers 
		int ctr = 0; // counter
		
		Random rnd = new Random(); // random number 
		
		do
		{
			// Get random number 
			nbr = (int) rnd.Next(1,11);
			
			ctr++;			// number of numbers counted
			ttl += nbr;		// add nbr to total of number 
			
			Console.WriteLine("Number {0} is {1}", ctr, nbr);
			
		} while (nbr != 5);
		
		Console.WriteLine("\n{0} numbers were read", ctr);
		Console.WriteLine("The total of the numbers is {0}", ttl);
		Console.WriteLine("The average of the numbers is {0}", ttl/ctr);
	}
}
		
		