// NameApp.cs - Namespaces and the using keyword
// ------------------------------------------

using System; 

class name 
{
	public string first;
	public string last;
}

class NameApp
{
	public static void Main()
	{
		// Create a name object
		name you = new name();
		
		Console.Write("Enter your first name and press enter: ");
		you.first = Console.ReadLine();
		Console.Write("Enter your last name and press enter: ");
		you.last = Console.ReadLine();
		
		Console.WriteLine("\nData has been entered.....");
		Console.WriteLine("You claim to be {0} {1}", you.first, you.last);
	}
}