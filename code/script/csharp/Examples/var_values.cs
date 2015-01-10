// var_values.cs - A listing to assign and print the value of variables. 
// ---------------------------------------------------------------------

using System; 

class var_values
{
	public static void Main()
	{
		// declare first var
		int first_var;
		
		// delcare second var and assign a value to it.
		int second_var = 200;
		
		// assign a value to first var
		first_var = 5;
		
		// print values of variables
		Console.WriteLine("\nfirst_var contains the value {0}", first_var);
		Console.WriteLine("second_var contains the value {0}", second_var);
		
		// assign a new value to the variables... 
		first_var = 1010;
		second_var = 2020;
		
		// print new values...
		Console.WriteLine("\nfirst_var contains the value {0}", first_var);
		Console.WriteLine("second_var contains the value {0}", second_var);
	}
}