// file_type.cs 
// --------------------------------------------------------

using System;

class file_type
{
	public static void Main()
	{
	
		char file_type = 'm'; 
		
		if ( file_type == 's')
		{
			Console.WriteLine("The filer is single.");
		}
		else if ( file_type == 'm')
		{
			Console.WriteLine("The filer is married filling at the single rate.");
		}
		else if ( file_type == 'j')
		{
			Console.WriteLine("The filer is married filing at the joint rate.");
		}
		
		Console.WriteLine("Done.");
	}
}