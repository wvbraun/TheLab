using System; 

class die
{
	public static void Main()
	{
		int roll;
		int ctr;
		int one = 0;
		int two = 0;
		int three = 0;
		int four = 0; 
		int five = 0;
		int six = 0;
	
		
		Random rnd = new Random(); 
		roll = (int) rnd.Next(1,7);
		
		for (roll = 0, ctr = 0; roll <= 100; ctr++)
		{
			switch (roll)
			{
				case 1:

					one++;
					break;
				case 2:
					
					two++;
					break;
				case 3:
					
					three++;
					break;
				case 4:
					
					four++;
					break;
				case 5:
					
					five++;
					break;
				case 6:
					
					six++;
					break;
				default:
					Console.WriteLine("Roll is not 1 - 6");
					break;
			}
		}
		Console.WriteLine("One: {0}", one);
		Console.WriteLine("Two: {0}", two);
		Console.WriteLine("Three: {0}", three);
		Console.WriteLine("Four: {0}", four);
		Console.WriteLine("Five: {0}", five);
		Console.WriteLine("Six: {0}", six);
	}
}
				
		