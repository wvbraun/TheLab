// int_conv.cs
// storing bad values. Program generates errors and will not compile.
// -------------------------------------------------------------------

using System;

class int_conv
{
	public static void Main()
	{
		// declare two integers
		int val1, val2;    

		// declar an unsigned int
		uint pos_val;
		
		val1 = 1.5;
		val2 = 9876543210;
		pos_val = -123;
		
		Console.WriteLine("val1 is {0}", val1);
		Console.WriteLine("val2 is {0}", val2);
		Console.WriteLine("pos_val is {0}", pos_val);
	}
}