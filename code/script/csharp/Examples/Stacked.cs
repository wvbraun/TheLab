// Stacked.cs - Using the if...else statement 
// ----------------------------------------------------

using System;

class Stacked
{
	static void Main()
	{
		char gender = 'x';
		
		if (gender == 'm')
		{
			Console.WriteLine("The gender is male");
		}
		else if ( gender == 'f')
		{
			Console.WriteLine("The gender is female");
		}
		else
		{
			Console.WriteLine("The gender value, {0}, is not valid", gender);
		}
		Console.WriteLine("The if statement is now over!");
	}
}