// Project Euler Problem 1 
// Multiples of 3 and 5 
// If we list all the natural numbers below 10 that are multiples of 3 or 5, 
// we get 3, 5, 6 and 9. The sum of these multiples is 23.
// Find the sum of all the multiples of 3 or 5 below 1000.
// -----------------------------------------------------------------------------------

using System; 

class wtf
{
	public static void Main ()
	{
		int sum;
		for ( int i = 0 ; i < 1000 ; i++)
		{
			if ( i % 3 == 0 || i % 5 == 0)
			{
				sum += i;
			}
		}
		Console.WriteLine("{0}", sum);
		
		for ( int j = 0; j < 1000; j+= 3) { ; }
		for ( int r = 0; r < 1000 ; r+=5 ) { ; }
		for ( int s = 0; s < 1000 ; s+=15) { ; }
		
		int q = (j + r) - s;
		Console.WriteLine("{0}", q);
	}
}

	
		