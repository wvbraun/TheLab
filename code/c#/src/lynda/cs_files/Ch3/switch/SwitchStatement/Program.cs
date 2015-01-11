using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace SwitchStatement
{
    class Program
    {
        static void Main(string[] args)
        {
			if (args == null)
			{
				Console.WriteLine("Please enter an integer");
			}

			// try to convert arg to an int using int.Parse()
			// will throw error if arg is not an int.

			int num;
			bool test = int.TryParse(args[0], out num);
			if (test == false)
			{
				Console.WriteLine("Please enter a number");
			}

			switch (num)
			{
				case 50:
					Console.WriteLine("Value is 50");
					break;
				case 51:
					Console.WriteLine("Value is 51");
					break;
				case 52:
					Console.WriteLine("Value is 52");
					break;
				default:
					Console.WriteLine("Something else...");
					break;
			}

        }
    }
}
