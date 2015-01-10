using System;

class Param
{
	static void Main()
	{
		GreetPersons(0);
		GreetPersons(25, "John", "Jane", "Tarzan");
	}

	static void GreetPersons(int wut, params string[] names)
	{
		foreach(string name in names)
			Console.WriteLine("Hello, {0}", name);
	}
}
