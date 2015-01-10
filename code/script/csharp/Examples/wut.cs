using System; 

class hello
{
	public static void Main()
	{
		Console.Write("What is your name?: ");
		string name = Console.ReadLine();
		Console.Write("Hello, {0}!", name);
	}
}