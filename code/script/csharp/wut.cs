using System; 

class wut
{

	// What we are looking for:
	// The sum of all numbers divisible by three 
	// plus the sum of all numbers divisible by five.
	// We cannot forget that numbers divisible by both three and five will be included in this. 
	// Therefore, we must also subtract the sum of all numbers divisible by fifteen( 3 * 5 = 15)

	// According to arithmetic sum progression formula: 
	// any number divisible by n can be written as:
	// n * N * (N + 1) / 2 : w/ N = the total amount of integers.

	

	public static double Sumz(int n, int j)
	{
		return n * (j/n) * ((j/n)+1) / 2;	
	}
		
	public static void Main()
	{
		//int N = 999; 
		//int three = 3; 
		//int five = 5;
		//int fifteen = 15; 

		//Console.WriteLine("{0}", Sumz(999,3
		
		double total = Sumz(999, 3) + Sumz(999, 5) - Sumz(999, 15);
		Console.WriteLine("{0}", total);
	}
}