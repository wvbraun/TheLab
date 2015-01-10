// Outter.cs - Using output variables. 
// ------------------------------------------

using System; 

class nbr 
{
	public void math_routines( double x, 
							 out double half, 
							 out double squared, 
							 out double cubed )
	{
		half = x/2;
		squared = x * x;
		cubed = x*x*x;
	}
}

class Outter
{
	public static void Main()
	{
		nbr doit = new nbr();
		
		double nbr = 600;
		double Half_nbr, Squared_nbr, Cubed_nbr;
		
		doit.math_routines( nbr, out Half_nbr, out Squared_nbr, out Cubed_nbr); 
		Console.WriteLine("After method -> nbr = {0}", nbr);
		Console.WriteLine("				Half_nbr = {0}", Half_nbr);
		Console.WriteLine("				Squared_nbr = {0}", Squared_nbr);
		Console.WriteLine("				Cubed_nbr = {0}", Cubed_nbr);
	}
}