// RefVars.cs - reference vs by value variables.
// -----------------------------------------------

using System; 

class nbr
{
	public double squareByVal( double x)
	{
		x *= x; 
		return x;
	}
	
	public double squareByRef( ref double x)
	{
		x *= x;
		return x;
	}
}

class RefVars
{
	public static void Main()
	{
		nbr doit = new nbr();
		
		double nbr1 = 3; 
		double retVal = 0;
		
		// Calling method with a by value paramter:
		Console.WriteLine("Before square -> nbr1 = {0}, retVal = {1}", nbr1	, retVal);
		
		retVal = doit.squareByVal(nbr1);
		
		Console.WriteLine("After square -> nbr1 = {0}, retVal = {1}", nbr1, retVal);
		
		Console.WriteLine("\n--------\n");
		
		// Calling method with a by reference parameter; 
		retVal = 0; // reset return value to zero
		
		Console.WriteLine("Before square -> nbr1 = {0}, retVal = {1}", nbr1, retVal);
		
		retVal = doit.squareByRef (ref nbr1);
		
		Console.WriteLine("After square -> nbr1 = {0}, retVal = {1}", nbr1, retVal);
	}
}
		