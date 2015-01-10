// and.cs - Using AND and OR
// -------------------------------------------------------

using System; 

class andclass
{
	public static void Main()
	{
		int day = 1;
		char sex = 'f';
		
		Console.WriteLine("Starting tests... (day:{0}, sex{1})", day, sex);
		
		if ( day >=1 && day <=7) // day from 1 to 7?
		{
			Console.WriteLine("Day is from 1 to 7");
		}
		if (sex == 'm' || sex == 'f') // Male or Female?
		{
			Console.WriteLine("Sex is male or female");
		}
	}
}