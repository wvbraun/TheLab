using System;

class Ref
{
	// we create an int, assign 20 to it.
	// we then use the AddFive() method, which
	// should add 5 to the number, but it does not. 
	// The value we assign to the number is never carried
	// out of the function. 
	static void Main(string[] args)
	{
		int number = 20;
		AddFive(number);
		Console.WriteLine(number);
		// now we pass as ref
		AddFive1(ref number);
		Console.WriteLine(number);
	}

	static void AddFive(int number)
	{
		number += 5;
	}

	static void AddFive1(ref int number)
	{
		number += 5;
	}
}

