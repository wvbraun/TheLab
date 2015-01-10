using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConstAndEnums
{
    class Program
    {
        enum Temperatures
        {
            FREEZING = 32,
            LUKEWARM = 65,
            ROOMTEMP = 72,
            HOT = 105,
            BOILING = 212
        }

        static void Main(string[] args)
        {
            // constants are values that won't ever change during a program
            const int freezingPointDegF = 32;
            const int boilingPointDegF = 212;

            int myTemp = 65;

            if (myTemp > freezingPointDegF && myTemp < boilingPointDegF)
            {
                Console.WriteLine("At this temperature, water is a liquid");
            }
            else
            {
                Console.WriteLine("Water is not a liquid at this temperature");
            }

            if (myTemp > (int)Temperatures.FREEZING && myTemp < (int)Temperatures.BOILING)
            {
                Console.WriteLine("At this temperature, water is a liquid");
            }
            else
            {
                Console.WriteLine("Water is not a liquid at this temperature");
            }

            Console.ReadLine();
        }
    }
}
