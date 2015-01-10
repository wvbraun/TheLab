// PropApp.cs - Using Properties 
// ----------------------------------------

using System; 

class Point
{
	int my_x; // my_x is private 
	int my_y; // my_y is private 
	
	public int x
	{
		get 
		{
			return my_x;
		}
		set 
		{
			my_x = value;
		}
	}
	public int y
	{
		get
		{
			return my_y;
		}
		set 
		{
			my_y = value;
		}
	}
}

class PropApp
{
	public static void Main()
	{
		Point starting = new Point();
		Point ending = new Point();
		
		starting.x = 1;
		starting.y = 4;
		ending.x = 10;
		ending.y = 11;
		
		Console.WriteLine("Point 1: ({0}, {1})", starting.x, starting.y);
		Console.WriteLine("Point 2: ({0}, {1})", ending.x, ending.y);
	}
}
