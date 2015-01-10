using System;
using System.Collections.Generic;

public static class MostCommonString
{
	public static void findCommon(string str)
	{
		Dictionary<char, int> dict = new Dictionary<char, int>();
		int max = 0;

		foreach (char c in str)
		{
			int i;
			dict.TryGetValue(c, out i);
			i++;
			if (i > max)
				max = i;
			dict[c] = i;
		}

		foreach (KeyValuePair<char, int> chars in dict)
		{
			if (chars.Value == max)
				Console.WriteLine("{0}: {1}", chars.Key, chars.Value);
		}
	}

	public static void Main()
	{
		findCommon("abbbbbcccdd");
	}
}
