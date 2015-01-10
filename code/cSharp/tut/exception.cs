using System;
using System.Collections;

namespace WutWut
{
	class Program
	{
		static void Main()
		{
			int[] numbers = new int[2];

			try
			{
				numbers[0] = 23;
				numbers[1] = 32;
				numbers[2] = 42;

				foreach(int i in numbers)
					Console.WriteLine(i);
			}
			catch
			{
				Console.WriteLine("Something went wrong!");
			}
		}
	}
}
