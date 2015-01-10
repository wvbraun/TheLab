using System;

public class MyClass
{
	public static void UseParams(params int[] ls)
	{
		for (int i=0; i < ls.Length; i++)
			Console.WriteLine(ls[i]);

		Console.WriteLine();
	}

	public static void UseParams1(params object[] ls)
	{
		for (int i=0; i < ls.Length; i++)
			Console.WriteLine(ls[i]);

		Console.WriteLine();
	}

	static void Main()
	{
		UseParams(1, 2, 3);
		UseParams1(1, 'a', "Test");

		// an array of objects can also be passed as long
		// as the array type matches the method being called
		int[] arr = new int[3] {10,11,12};
		UseParams(arr);

		object[] wut = new object[3] {10, 'a', "Test"};
		UseParams1(wut);
	}

}
