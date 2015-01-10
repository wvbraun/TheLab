using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace DoubleVsDecimal
{
    class Program
    {
        static void Main(string[] args)
        {
        	double twentieth = 0.2f;
        	double one = 1.0f;

        	Console.WriteLine("{0}", one - twentieth);

        	decimal one_twenty = 0.2m;
        	decimal realOne = 1.0m;

        	Console.WriteLine("{0}", realOne - one_twenty);

        }
    }
}
