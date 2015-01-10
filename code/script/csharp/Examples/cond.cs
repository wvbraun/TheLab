// cond.cs - The conditional Operator
// -------------------------------------------

using System;

class cond
{
	public static void Main()
	{
		int Val1 = 1;
		int Val2 = 0;
		int result;
		
		result = (Val1 == Val2) ? 1 : 0;
		// condition ? if_true : if_ false
		
		Console.WriteLine("The result is {0}", result);
	}
}