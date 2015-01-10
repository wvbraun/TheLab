// Guess.cs - Pick a Number
// ----------------------------------------------------------

using System;
using System.Drawing;
using System.Text;

public class Guess
{
	private static int getRandomNumber (int nbr)
	{
		if (nbr > 0)
		{
			Random rnd = new Random();
			return (rnd.Next(0, nbr));
		}
		else
		{
			return 0;
		}
	}
	
	private static void WriteStats(string Guess, int nbr, string err)
	{
		Console.WriteLine("\n===================");
		Console.WriteLine("Current Guess: {0}", Guess);
		Console.WriteLine("Number of Guesses: {0}", nbr);
		if (err != "")
			Console.WriteLine(err);
		Console.WriteLine("Enter a number 1 to 10000");
		Console.WriteLine("=========================");
		
		return;
	}
	
	public static void Main(string[] args)
	{
		int WinningNumber = Guess.getRandomNumber(10000);
		int Guesses = 0;
		string Curr = "";
		int val = 0;
		string errMsg;
		
		bool cont = true;
		
		WriteStats(Curr, Guesses, (string) "");
		
		while (cont == true)
		{
			
			Console.Write("\nEnter Guess:");
			Curr = Console.ReadLine();
			
			try
			{
				val = Convert.ToInt32(Curr);
				
				// If a number was not entered, an exception will be
				// throw. Program flow will go to catch statement below. 
				
				Guesses += 1; // ad one to Guesses
				
				if (val<0 || val > 10000)
				{
					// bad value entered
					errMsg = "Number is out of range...Try again.";
					WriteStats(Curr, Guesses, errMsg);
				}
				else if (val < WinningNumber)
				{
					errMsg = "You guessed low... Try again.";
					WriteStats(Curr, Guesses,errMsg);
				}
				else if (val > WinningNumber)
				{
					errMsg = "You guessed high... Try again.";
					WriteStats(Curr, Guesses, errMsg);
				}
				else
				{
					Console.WriteLine("\n\nCurrent Guess: {0}\n", val);
					Console.WriteLine("Number of Guesses: {0}\n", Guesses);
					Console.WriteLine("You guessed correctly!!");
					cont = false;
				}
			}
			// Catch format errors...
			catch(FormatException)
			{
			errMsg = ("Please enter a valid number...");
			WriteStats(Curr, Guesses, errMsg);
			}	
		}
	}
}
					
		
		