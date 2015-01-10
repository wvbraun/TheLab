// ifelse.cs - using the if.... else statement
// ------------------------------------------------

using System; 

class ifelse
{
	public static void Main()
	{
		char gender = 'x';
		
		if (gender == 'm' || gender == 'f')
		{
			Console.WriteLine("The gender is valid");
		}
		else
		{
			Console.WriteLine("The gender value, {0}, is not valid", gender);
		}
			Console.WriteLine("The if statement is now over!");
	}
}