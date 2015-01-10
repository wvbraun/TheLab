// line2.cs - A class with two data members 
// ------------------------------------------------

class Point 
{
	public int x;
	public int y; 
}

class Line
{
	public Point starting = new Point();
	public Point ending = new Point();
	public double len;
}

class lineApp
{
	public static void Main()
	{
		Line myLine = new Line();
		
		myLine.starting.x = 1;
		myLine.starting.y = 4; 
		myLine.ending.x = 10;
		myLine.ending.y = 11;
		myLine.len = System.Math.Sqrt(
			(myLine.ending.x - myLine.starting.x) *
			(myLine.ending.x - myLine.starting.x)	+
			(myLine.ending.y - myLine.starting.y) *
			(myLine.ending.y - myLine.starting.y) );
			
		System.Console.WriteLine("Point 1: ({0}, {1})", myLine.starting.x, myLine.starting.y);
		System.Console.WriteLine("Point 2: ({0}, {1})", myLine.ending.x, myLine.ending.y);
		System.Console.WriteLine("Line Length: {0}", myLine.len);
	}
}
	