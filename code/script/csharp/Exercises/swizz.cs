using System;

class swizz
{
	public static void Main()
	{
		string name = "John"; 
		
		switch (name)
		{
			case "Robert":
				Console.WriteLine("Name is Robert.");
				Console.WriteLine("Hi Bob");
				break;
			case "Richard":
				Console.WriteLine("Name is Richard.");
				Console.WriteLine("Hi Rich");
				break;
			case "Barbara":
				Console.WriteLine("Name is Barbara.");
				Console.WriteLine("Hi Barb.");
				break;
			case "Kalee":
				Console.WriteLine("Name is Kalee.");
				Console.WriteLine("You Go Girl!");
				break;
			default:
				Console.WriteLine("Hi {0}", name);
				break;
		}
	}
}
				
			