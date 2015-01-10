using System;
using System.Collections.Generic;

public static class SingleDuplicate
{
	/*
	public static int filter(int [] arr)
	{
		for (int i = 0; i < arr.Length; i++)
		{
			if (arr[Math.Abs(arr[i])] >= 0)
				arr[Math.Abs(arr[i])] = -arr[Math.Abs(arr[i])];
			else
				Console.WriteLine("Duplicate Found " + Math.Abs(arr[i]).ToString() + "\n");
		}
	}
	*/

	public static void duplicate(int[] arr)
	{
		HashSet<int> hs = new HashSet<int>();
		
		foreach (int item in arr)
		{
			if (hs.Contains(item)) 
				Console.WriteLine("found: {0}", hs.);
			else
				hs.Add(item);
		}
	}

	public static void Main()
	{
		int[] arr = {9,5,4,3,2,1,4,10};
		duplicate(arr);
	}
}
