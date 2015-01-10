// StatCon.cs - static constructors 
// ------------------------------------------------------------

using System; 

public class test 
{
	static public int sctr;
	public int ctr;
	
	public void routine()
	{
		Console.WriteLine("In the routine - ctr = {0} / sctr = {1}\n", ctr, sctr);
	}
	
	static test()
	{
		sctr = 100;
		Console.WriteLine("In Static Constructor - sctr = {0}\n", sctr);
	}
	
	public test()
	{
		ctr++;
		sctr++;
		Console.WriteLine("In Constructor - ctr = {0} / sctr = {1}\n", ctr, sctr);
	}
}

class StatCon 
{
	public static void Main()
	{
		Console.WriteLine("Start of Main method...");
		Console.WriteLine("Creating first object...");
		test first = new test();
		Console.WriteLine("Creating second object...");
		test second = new test();
		
		Console.WriteLine("Calling first routine...");
		first.routine();
		
		Console.WriteLine("Creating third object...");
		test third = new test();
		Console.WriteLine("Calling third routine...");
		third.routine();
		
		Console.WriteLine("Calling second routine...");
		second.routine();
		
		Console.WriteLine("End of Main Method");
	}
}
		