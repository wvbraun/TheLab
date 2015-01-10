// Bday.cs - Using an enumeration, setting default values
// -------------------------------------------------

using System; 

public class Bday
{
	enum Month
	{
		January = 1,
		February = 2, 
		March = 3, 
		April = 4, 
		May = 5, 
		June = 6, 
		July = 7, 
		August = 8, 
		September = 9, 
		October = 10, 
		November = 11, 
		December = 12
	}
	
	struct birthday 
	{
		public Month bmonth; 
		public int bday;
		public int byear;
	}
	
	public static void Main()
	{
		birthday myBirthday;
		
		myBirthday.bmonth = Month.August;
		myBirthday.bday = 11;
		myBirthday.byear = 1981; 
		
		Console.WriteLine("My birthday is {0} {1}, {2}", myBirthday.bmonth, myBirthday.bday, myBirthday.byear);
	}
}