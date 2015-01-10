// Circle.cs - Overloading the area method 
// --------------------------------------------------

using System; 

public class Circle
{
	public int x;
	public int y; 
	public double radius;
	private const float PI = 3.14159F;
	
	public double Area() // Uses values from data members 
	{
		return Area(radius);
	}
	
	public double Area( double rad )
	{
		double theArea;
		theArea = PI * rad * rad ;
		Console.WriteLine("The area for radius ([0}) is {1}", rad, theArea);
		return theArea;
	}
	
	public double Area(int x1, int y1, double rad)
	{
		return Area(rad);
	}
	
	public double Area( int x1, int y1, int x2, int y2)
	{
		int x_diff;
		int y_diff;
		double rad;
		
		x_diff = x2 - x1;
		y_diff = y2 - y1;
		
		rad = (double) Math.Sqrt((x_diff * x_diff) + (y_diff * y_diff));
		
		return Area(rad);
	}
	
	public Circle()
	{
		x = 0;
		y = 0;
		radius = 0.0;
	}
}

class CircleApp
{
	public static void Main()
	{
		Circle myCirlce = new Circle();
		
		Console.WriteLine("Passing nothing...");
		myCirlce.Area(); // calls the Area method of the myCircle object
		
		Console.WriteLine("\nPassing a radius of 3...");
		myCirlce.Area(3);
		
		Console.WriteLine("\nPassing a center of (2,4) and a radius of 3...");
		myCirlce.Area(2,4,3);
		
		Console.WriteLine("\nPassing center of (2,3) and a point of (4,5)...");
		myCirlce.Area(2,3,4,5);
	}
}
	
	
	
	
	
