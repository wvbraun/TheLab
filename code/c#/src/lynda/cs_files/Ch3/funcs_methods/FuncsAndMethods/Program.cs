using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace FuncsAndMethods
{
    class Program
    {
        static void Main(string[] args)
        {
        	int res;

        	res = formula(14);
        	Console.WriteLine("The result is {0}", res);

        }

        static int formula(int val)
		{
			return (val * 2) / 3 + 15;
		}

    }
}
