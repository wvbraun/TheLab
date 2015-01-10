using System;

public static class Rectangle
{
	public static int CalcArea(int width, int height)
	{
		return width * height;
	}
}

public class Rectangle1
{
	private int width, height;

	public Rectangle(int width, int height)
	{
		this.width = width;
		this.height = height;
	}

	public void OutputArea()
	{
		Console.WriteLine("Area output: {0}", Rectangle1.CalcArea(this.width, this.height);
	}

	public static int CalcArea(int w, int h)
	{
		return w * h;
	}
}
