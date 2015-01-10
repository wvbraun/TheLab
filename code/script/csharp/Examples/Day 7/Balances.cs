// Balances.cs - Using a basic array 
// ------------------------------

using System;

public class Balances 
{
	public static void Main()
	{
		decimal[] balances = new decimal[12]; // balance is declared as an array of decimal values. It contains 12 elements 
		
		decimal ttl = 0m;
		Random rnd = new Random();
		
		// put random values from 0 to 10000 into balances array
		
		for (int indx = 0; indx < 12; indx++)
		{
			balances[indx] = (decimal) (rnd.NextDouble() * 10000);
		}
		
		// values are initialized in balances 
		
		for (int indx = 0; indx < 12; indx++)
		{
			Console.WriteLine("=====================");
			Console.WriteLine("Total of Balances = {0}", ttl);
			Console.WriteLine("Average Balance = {0}", (ttl/12));
		}
	}
}