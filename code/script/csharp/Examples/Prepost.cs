// Prepost.cs - Using pre- versus post-increment operators 
// --------------------------------------------------------
using System;

class Prepost
{
	public static void Main()
	{
		int Val1 = 0;
		int Val2 = 0;
		
		Console.WriteLine("Val1 = {0} val2 = {1}", Val1, Val2);
		Console.WriteLine("Val1 (Pre) = {0} Val2 (Post) = {1}", ++Val1, Val2++);
		Console.WriteLine("Val1 (Pre) = {0} Val2 (Post) = {1}", ++Val1, Val2++);
		Console.WriteLine("Val1 (Pre) = {0} Val2 (Post) = {1}", ++Val1, Val2++);
	}
}
		
		