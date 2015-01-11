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
        	int val = 50;

        	if (val == 50)
        		Console.WriteLine("val = 50");
			else if (val > 50)
				Console.WriteLine("val is greater than 50");

        }
    }
}
