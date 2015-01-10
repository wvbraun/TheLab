// DestrApp.cs - Constructors 
// -----------------------------

using System;

public class test
{
	static public int sctr = 0;
	public int ctr = 0;
	
	public void routine()
	{
		Console.WriteLine("In the routine - ctr = {0} / sctr = {1}", ctr, sctr);
	}
	
	public test()
	{
		ctr++;
		sctr++;
		Console.WriteLine("In Constructor");
	}
	
	~test()
	{
		Console.WriteLine("In Destructor");
	}
}

class DestrApp
{
	public static void Main()
	{
		Console.WriteLine("Start of Main method");
		
		test first = new test();
		test second = new test();
		
		first.routine();
		
		test third = new test();
		third.routine();
		
		second.routine();
		
		Console.WriteLine("End of Main method");
	}
}