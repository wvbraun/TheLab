using System;

class App
{
	public static void Main()
	{
		// Declare variables 
		
		int radius = 4;
		const double PI = 3.14159;
		double area;
		
		// Do calculation 
		
		area = PI * radius * radius;
		
		// Print the results
		
		Console.WriteLine("Radius = {0}, PI = {1}", radius, PI);
		Console.WriteLine("The area is {0}", area);
	}
}