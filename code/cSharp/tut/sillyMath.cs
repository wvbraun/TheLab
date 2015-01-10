using System;


// method overloading

class SillyMath
{
	public static int Plus(int num1, int num2)
	{
		return Plus(num1, num2, 0);
	}

	public static int Plus(int num1, int num2, int num3)
	{
		return Plus(num1, num2, num3, 0);
	}

	public static int Plus(int x, int y, int z, int a)
	{
		return x + y + z + a;
	}

	public static void Main()
	{
		int x = 10;
		int y = 20;
		Console.WriteLine(Plus(x, y));
	}
}
	

