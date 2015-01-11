using System;

class Out
{
	static void Main()
	{
		int number = 20;
		int num;
		AddFive(number);
		Console.WriteLine(number);
		AddFive1(out num);
		Console.WriteLine(num);
	}

	static void AddFive(int number)
	{
		number += 5;
	}

	static void AddFive1(out int number)
	{
		number = 25;
	}
}
