using System;

namespace Enum
{
	public enum Days {Monday = 1, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday }

	class Program
	{
		static void Main()
		{
			Days day = Days.Monday;
			Console.WriteLine((int)day);
			Console.WriteLine(day);
		}
	}
}
