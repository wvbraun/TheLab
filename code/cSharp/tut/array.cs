using System;
using System.Collections;

class Wut
{
	static void Main()
	{
		string[] names = new string[2];

		names[0] = "John Doe";
		names[1] = "Jane Doe";

		foreach(string s in names)
			Console.WriteLine(s);

		int[] numbers = {4, 3, 8, 0, 5};
		// could also be done like:
		// int[] numbers = new int[5] {4, 3, 8, 0, 5};

		foreach(int i in numbers)
			Console.WriteLine(i);

		Console.WriteLine();
		Array.Sort(numbers);

		foreach(int i in numbers)
			Console.WriteLine(i);

		Console.WriteLine();
		Array.Reverse(numbers);
		foreach(int i in numbers)
			Console.WriteLine(i);
	}
}

