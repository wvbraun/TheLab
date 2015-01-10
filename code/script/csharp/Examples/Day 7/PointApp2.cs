// PointApp2.cs - A structure with two data members 
// ------------------------------------------

using System; 

struct Point 
{
	public int x;
	public int y;
	
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
//		public Point() // parameterless constructors not allowed! 
//		{
//			this.x = 0;
//			this.y = 0;
//		}
}

class PointApp
{
	public static void Main()
	{
		Point point1 = new Point();
		Point point2 = new Point(8, 8);
		
		point1.x = 1; 
		point1.y = 4; 
		
		Console.WriteLine("Point 1: ({0}, {1})", point1.x, point1.y);
		Console.WriteLine("Point 2: ({0}, {1})", point2.x, point2.y);
	}
}