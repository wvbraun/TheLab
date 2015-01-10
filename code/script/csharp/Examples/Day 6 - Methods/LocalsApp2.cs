// LocalsApp2.cs - Local Variables 
// -------------------------------------

using System;

class loco
{
	public int x;
	
	public void count_x()
	{
		int x; 
		
		Console.WriteLine("In count_x method. Print X values...");
		for (x = 0; x <= 10; x++)
		{
			Console.Write("{0} -", x);
		}
		
		Console.WriteLine("\nDone looping. x = {0}", x);
		Console.WriteLine("The data member x's value: {0}", this.x);
		Console.WriteLine("At the end of count_x method.");
	}
}

class LocalsApp
{
	public static void Main()
	{
		loco Locals = new loco();
		
		int x = 999;
		Locals.x = 555;
		
		Console.WriteLine("\nIn Main(), x = {0}", x);
		Console.WriteLine("Locals.x = {0}", Locals.x);
		Console.WriteLine("Calling Method");
		Locals.count_x();
		Console.WriteLine("\nBack From Method");
		Console.WriteLine("Locals.x = {0}", Locals.x);
		Console.WriteLine("In Main(), x = {0}", x);
	}
}
		