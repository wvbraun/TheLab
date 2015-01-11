using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConditionalCode
{
    class Program
    {
        static void Main(string[] args)
        {
            int theVal = 50;

            if (theVal == 50) 
            {
                Console.WriteLine("firstVar is 50");
            }
            else if (theVal == 51)
            {
                Console.WriteLine("firstVar is 51");
            }
            else
            {
                Console.WriteLine("firstVar is something else");
            }

            Console.ReadLine();
        }
    }
}
