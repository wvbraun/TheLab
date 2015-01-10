// StatLine.cs - A class with two data members 
// ------------------------------------------------------------

class Point
{
	public int x; 
	public int y;
}

class Line
{
	static public Point origin = new Point();
	public Point ending = new Point();
}

class lineApp
{
	public static void Main()
	{
		Line line1 = new Line();
		Line line2 = new Line();
		
		// set line origin 
		Line.origin.x = 1; 
		Line.origin.y = 2;
		
		
		// set line1's ending values 
		line1.ending.x = 34;
		line2.ending.y = 4;
		
		// set line2's ending values 
		line2.ending.x = 7;
		line2.ending.y = 8;
		
		// print the values...
		System.Console.WriteLine("Line 1 start: ({0}, {1})", Line.origin.x, Line.origin.y);
		System.Console.WriteLine("Line 1 end: ({0}, {1})", line1.ending.x, line1.ending.y);
		System.Console.WriteLine("Line 2 start: ({0}, {1})", Line.origin.x, Line.origin.y);
		System.Console.WriteLine("Line 2 end: ({0}, {1})", line2.ending.x, line2.ending.y);
		
		// change value of line2's starting point
		Line.origin.x = 939;
		Line.origin.y = 747;
		
		// and the values again... 
		System.Console.WriteLine("Line 1 start: ({0}, {1})", Line.origin.x, Line.origin.y);
		System.Console.WriteLine("Line 1 end: ({0}, {1})", line1.ending.x, line1.ending.y);
		System.Console.WriteLine("Line 2 start: ({0}, {1})", Line.origin.x, Line.origin.y);
		System.Console.WriteLine("Line 2 end: ({0}, {1})", line2.ending.x, line2.ending.y);
	}
}