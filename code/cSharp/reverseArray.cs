using System;

public static class ReverseArray
{
	public static void Main()
	{
		int[] arr = new int[] {1,2,3,4,5};
		int j = arr.Length - 1;

		for (int i = 0; i < j; i++)
		{
			int tmp = arr[j];
			arr[j] = arr[i];
			arr[i] = tmp;
			j -= 1;
		}

		foreach (int item in arr)
			Console.WriteLine(item);
	}
}
