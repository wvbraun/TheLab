// PointApp.cs - A structure with two data members 
// ------------------------------------------

using System; 

struct Point 
{
	public int x;
	public int y;
}

class PointApp
{
	public static void Main()
	{
		Point starting = new Point();
		Point ending = new Point();
		
		starting.x = 1;
		starting.y = 4;
		ending.x = 10;
		ending.y = 11;
		
		Console.WriteLine("Point 1: ({0},{1})", starting.x, starting.y);
		Console.WriteLine("Point 2: ({0}, {1})", ending.x, ending.y);
	}
}