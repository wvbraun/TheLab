using System;

namespace Blah
{
	public enum Days {Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday }

	class Program
	{
		static void Main()
		{
			Days day = Days.Monday;
			Console.WriteLine((int)day);
			Console.WriteLine("{0}\n", day);

			// string representation
			string[] values = Enum.GetNames(typeof(Days));

			foreach(string s in values)
				Console.WriteLine(s);
		}
	}
}
