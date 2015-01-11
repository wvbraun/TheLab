using System;

public class ReverseString
{
	public static string Reverse(string text) 
	{
		if (text == null)
			return null;

		char[] array = text.ToCharArray();
		int len = text.Length - 1;
		Array.Reverse(array);
		/*for (int i = 0; i < len; i++) {
			char c = array[i];
			array[i] = array[len];
			array[len] = c;
		}*/

		return new String(array);
	}

	public static void Main()
	{
		string str = Reverse("hello");
		Console.WriteLine(str);
	}
}

