using System;
using System.Text;
using System.Collections.Generic;

public static class RemoveDuplicates
{
	public static void removeDuplicates(string str)
	{
		int[] c = new int[255];
		for (int i = 0; i < str.Length; i++)
			c[str[i]]++;

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.Length; i++)
		{
			if (c[str[i]] == 1)
				sb.Append(str[i]);
		}
		Console.WriteLine(sb.ToString());
	}

	public static void blah(string str)
	{
		HashSet<char> found = new HashSet<char>();
		HashSet<char> duplicates = new HashSet<char>();

		foreach (char c in str)
		{
			if (!found.Add(c))
				duplicates.Add(c);
		}

		StringBuilder sb = new StringBuilder(str.Length);
		foreach (char c in str)
		{
			if (!duplicates.Contains(c))
				sb.Append(c);
		}

		Console.WriteLine(sb.ToString());
	}

	public static string removeDuplicateChars(string str)
	{
		string result = "";

		foreach (char val in str)
		{
			if (result.IndexOf(val) == -1)
			{
				result += val;
			}
		}
		return result;
	}
	
	public static void Main()
	{
		Console.WriteLine(removeDuplicateChars("hhhheeeeellllooo"));
	}
}
