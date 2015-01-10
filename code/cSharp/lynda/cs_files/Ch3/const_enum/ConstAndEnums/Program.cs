using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConstAndEnums
{
    class Program
    {

    	enum Temps 
		{
			FREEZING = 32,
			LUKEWARM = 65,
			ROOMTEMP = 72,
			HOT 	 = 105,
			BOILING  = 212
		}

        static void Main(string[] args)
        {

        	int temp = int.Parse(args[0]);

        	if (temp > (int)Temps.FREEZING && temp < (int)Temps.BOILING)
				Console.WriteLine("At this temp, water is a liquid.");
			else
				Console.WriteLine("Water is not a liquid");


        }
    }
}
