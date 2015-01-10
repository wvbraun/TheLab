using System;

/*
class Frequent 
{
	public static int Main(int[] a)
	{
		var cnt = new Dictionary<int, int>();
		foreach (int val in a) {
			if (cnt.ContainsKey(val)) {
				cnt[value]++;
			} else {
				cnt.Add(value, 1);
			}
		}
		
		int mostCommonValue, highestCount = 0;
		foreach (KeyValuePair<int, int> pair in cnt) {
			if (pair.Value > highestCount) {
				mostCommonValue = pair.Key;
				highestCount = pair.Value;
			}
		}
		return mostCommonValue;
	}
}

*/

class Frequent 
{
	public static int mostCommon(int[] a)
	{
		int[] arr = a;
		int c = 1, maxCount = 1, maxValue = 0;
		int res = 0;
		for (int i = 0; i < arr.Length; i++)
		{
			maxValue = arr[i];
			for (int j = 0; j < arr.Length; j++)
			{
				if (maxValue == arr[j] && j != i)
				{
					c++;
					if (c > maxCount)
					{
						maxCount = c;
						res = arr[i];
					}
				} else {
					c = 1;
				}
			}
		}
		return res;
	}

	public static int Main()
	{
		int[] x = new int[10] {1, 2, 2, 2, 3, 3, 2, 1, 1, 2};
		return mostCommon(x);
	}
}
