using System;

class Variables
{
	public static void Main()
	{
		// Declare variables 
		
		int radius = 4; 
		const double PI = 3.14159;
		double circum, area; 
		
		// Do Calculations 
		
		area = PI * radius * radius;
		circum = 2 * PI * radius;
		
		// Print the results 
		
		Console.WriteLine("Radius = {0}, PI = {1}", radius, PI);
		Console.WriteLine("The area is {0}", area);
		Console.WriteLine(csc"The circumference is {0}", circum);
	}
}