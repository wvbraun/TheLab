// File:	WR01App.cs
// Desc:	Week One In Review
// 			This program presents a menu and lets the user select a 
//			choice from a menu. Based on this choice, the program then
// 			executes a set of code that either manipulates a shape 
// 			or exits the program. 
// -----------------------------------------------------------------------

using System;

// ---------------------------------------------------
/// <summary>
/// This is a point structure. It is for storing and 
/// working with an (x,y) value. 
/// </summary>
struct point
{
	public int x;
	public int y;
	
	// A constructor that sets the x and y values 
	public point( int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}

// -----------------------------------------------------
/// <summary>
/// This class encapsulates line functionality 
/// <see>point</see>
/// </summary>
class line
{
	private point lineStart;
	private point lineEnd;
	
	public point start
	{
		get { return lineStart;}
		set
		{
			if (value.x < 0)
				lineStart.x = 0;
			else 
				lineStart.x = value.x;
			if (value.y < 0)
				lineStart.y = 0;
			else
				lineStart.y = value.y;
		}
	}
	public point end
	{
		get {return lineEnd;}
		set 
		{
			if (value.x < 0)
				lineEnd.x = 0;
			else
				lineEnd.x = value.x;
			if (value.y < 0)
				lineEnd.y = 0;
			else
				lineEnd.y = value.y;
		}
	}
	
	public double length()
	{
		int x_diff;
		int y_diff;
		double length;
		
		x_diff = end.x - start.x;
		y_diff = end.y - start.y;
		
		length = (double) Math.Sqrt((x_diff * x_diff) + (y_diff * y_diff));
		return (length);
	}
		
	public void DisplayInfo()
	{
		Console.WriteLine("\n\n-----------------------");
		Console.WriteLine("			Line stats:");
		Console.WriteLine("----------------------------");
		Console.WriteLine(" Length:		{0:f3}", length());
		Console.WriteLine(" Start Point: ({0}, {1})", start.x, start.y);
		Console.WriteLine(" End Point:	({0}, {1})", end.x, end.y);
		Console.WriteLine("---------------------------\n");
	}
	
	public line()
	{
		lineStart = new point();
		lineEnd = new point();
	}
}

//-------------------------------------------------------------------
/// <summary>
/// This class encapsulates square functionality 
/// <see>line</see>
/// </summary>
class square
{
	private line squareHeight;
	private line squareWidth;
	
	public line height 
	{
		get { return squareHeight; }
		set
		{
			squareHeight.start = value.start;
			squareHeight.end = value.end;
		}
	}
	public line width 
	{
		get {return squareWidth;}
		set 
		{
			squareWidth.start = value.start;
			squareWidth.end = value.end;
		}
	}
	
	public double area()
	{
		double total;
		
		total = (width.length() * height.length());
		return (total);
	}
	
	public double border()
	{
		double total;
		
		total = ((2 * width.length()) + (2 * (height.length())));
		return (total);
	}
	
	public void DisplayInfo()
	{
		Console.WriteLine("\n\n---------------------------------");
		Console.WriteLine("			Square stats:");
		Console.WriteLine("-----------------------------------");
		Console.WriteLine("Area:		{0:f3}", area());
		Console.WriteLine("Border:		{0:f3}", border());
		Console.WriteLine("WIDTH points: ({0}, {1}) to ({2}, {3})", 
			width.start.x, width.start.y, width.end.x, width.end.y);
		Console.WriteLine("			Length: {0:f3}", width.length());
		Console.WriteLine("HEIGHT Points: ({0}, {1}) to ({2}, {3})",
			height.start.x, height.start.y, height.end.x, height.end.y);
		Console.WriteLine("			Length: {0:f3}", height.length());
		
		Console.WriteLine("--------------------------------\n");
	}
	
	public square()
	{
		squareHeight = new line();
		squareWidth = new line();
		
			point tmpPoint = new point(0,0);
			
		width.start = tmpPoint; 
		width.end = tmpPoint;
		height.start = tmpPoint;
		height.end = tmpPoint;
	}
}

// --------------------------------------------------------------------
/// <summary>
/// This class encapsulates circle functionality
///<see>line</line>
/// </summary>
class circle
{
	private point circleCenter;
	private long circleRadius;
	
	public point center
	{
		get {return circleCenter;}
		set
		{
			circleCenter.x = value.x;
			circleCenter.y = value.y;
		}
	}
	public long radius
	{
		get { return circleRadius; }
		set { circleRadius = value; }
	}
	
	public double area()
	{
		double total;
		
		total = 3.14159 * radius * radius; 
		return (total);
	}
	
	public double circumference()
	{
		double total;
		
		total = 2 * 3.14159 * radius;
		return (total);
	}
	
	public void DisplayInfo()
	{
		Console.WriteLine("\n\n--------------------------");
		Console.WriteLine("		Circle stats:");
		Console.WriteLine("----------------------------");
		Console.WriteLine("Area: 		{0:f3}", area());
		Console.WriteLine(" Circumference: {0:f3}", circumference());
		Console.WriteLine(" Center Points: ({0},{1})", center.x, center.y);
		Console.WriteLine(" Radius:			{0:f3}", radius);
		Console.WriteLine("-------------------------------\n");
	}
	
	public circle()
	{
		circleCenter = new point();
		
		center = new point(0,0);
		radius = 0;
	}
}

class WR01App
{
	///<summary>
	/// Main() routine that starts the application
	/// </summary>
	public static void Main()
	{
		int menuChoice = 99;
		
		do
		{
			menuChoice = GetMenuChoice();
			
			switch (menuChoice)
			{
				case 0: break;
				case 1: WorkWithLine();
					break;
				case 2: WorkWithCircle();
					break;
				case 3: WorkWithSquare();
					break;
				case 4: WorkWithTriangle();
					break;
				default: Console.WriteLine("\n\nError...Invalid menu option.");
					break;
			}
			
			if (menuChoice != 0)
			{
				Console.Write("\nPress <ENTER> to continue...");
				Console.ReadLine();
			}
			
		} while (menuChoice != 0);
	}
		
	/// <summary>
	/// Displays a menu of choices.
	/// </summary>
	static void DisplayMenu()
	{
		Console.WriteLine("\n			Menu");
		Console.WriteLine("===========================\n");
		Console.WriteLine(" A - Working with Lines");
		Console.WriteLine(" B - Working with Circles");
		Console.WriteLine(" C - Working with Squares");
		Console.WriteLine(" D - Working with Triangles");
		Console.WriteLine(" Q - Quit\n");
		Console.WriteLine("=============================\n");
	}
		
	/// <summary>
	/// Get a choice from the user and verifies that it is valid. 
	/// Returns a numeric value to indicate which selection was made. 
	/// </summary>
	static int GetMenuChoice()
	{
		int option = 0;
		bool cont = true;
		string buf; 
			
		while (cont == true)
		{
			DisplayMenu();
			Console.Write(" Enter Choice: ");
			buf = Console.ReadLine();
				
			switch (buf)
			{
				case "a":
				case "A": option = 1;
					cont = false;
					break;
				case "b":
				case "B": option = 2;
					cont = false; 
					break;
				case "c":
				case "C": option = 3;
					cont = false;
					break;
				case "d":
				case "D": option = 4;
					cont = false;
					break;
				case "q":
				case "Q": option = 0;
					cont = false;
					break;
				default:
					Console.WriteLine("\n\n--> {0} is not valid <--\n\n", buf);
					break;
			}
		}
		return option;
	}
		
	/// <summary>
	/// Method to perform code for Working with Line.
	/// </summary>
	static void WorkWithLine()
	{
		line myLine = new line();
			
		point tmpPoint = new point(0,0);
		myLine.start = tmpPoint; 
			
		tmpPoint.x = 3;
		tmpPoint.y = 3;
		myLine.end = tmpPoint;
			
		myLine.DisplayInfo();
	}
		
	/// <summary>
	/// Method to perform code for Working with Circle.
	/// </summary>
	static void WorkWithCirlce()
	{
		circle myCircle = new circle();
			
		myCirlce.center = new point(1,1);
		myCircle.radius = 10;
			
		myCircle.DisplayInfo();
	}
		
	/// <summary>
	/// Method to perform code for Working with Squares.
	/// </summary>
	static void WorkWithSquare()
	{
		square mySquare = new square();
			
		mySquare.width.start = new point(1,0);
		mySquare.width.end = new point(10,0);
		mySquare.height.start = new point(0,2);
		mySquare.height.end = new point(0,8);
			
		mySquare.DisplayInfo();
	}
		
	/// <summary>
	/// Method to perform code for Working with Triangles. 
	/// </summary>
	static void WorkWithTriangle()
	{
		Console.WriteLine("\n\nDo Triangle Stuff...\n\n");
	}
}
				