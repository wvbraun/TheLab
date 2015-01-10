// Constr.cs - Constructors 
// -----------------------------------

using System; 

public class myClass
{
	static public int sctr = 0;
	public int ctr = 0;
	
	public void routine()
	{
		Console.WriteLine("In the routine - ctr = {0}/ sctr = {1}\n", ctr, sctr);
	}
	
	public myClass()
	{
		ctr++;
		sctr++;
		Console.WriteLine("In Constructor - ctr = {0} / sctr = {1}\n", ctr, sctr);
	}
}

class TestApp
{
	public static void Main()
	{
		Console.WriteLine("start of Main method...");
		
		Console.WriteLine("Creating first object...");
		myClass first = new myClass();
		Console.WriteLine("Creating second object...");
		myClass second = new myClass();
		
		Console.WriteLine("Calling first routine...");
		first.routine();
		
		Console.WriteLine("Creating third object...");
		myClass third = new myClass();
		Console.WriteLine("Calling third routine...");
		third.routine();
		
		Console.WriteLine("Calling second routine...");
		second.routine();
		
		Console.WriteLine("End of Main Method");
	}
}
		