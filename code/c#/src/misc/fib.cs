using System;

public static class Fib
{
	public static int recursiveFib(int n)
	{
		if (n == 0 || n == 1)
			return n;
		else
			return (recursiveFib(n-1) + recursiveFib(n-2));
	}

	public static int iterativeFib(int n)
	{
		int a = 1;
		int b = 0;

		for (int i = 0; i < n; i++)
		{
			int tmp = a;
			a = tmp + b;
			b = tmp;
		}

		
		return b;
	}

	public static void Main()
	{
		Console.WriteLine(recursiveFib(7));
		Console.WriteLine(iterativeFib(7));
	}

}

