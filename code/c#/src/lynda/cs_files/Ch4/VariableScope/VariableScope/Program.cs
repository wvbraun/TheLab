using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace VariableScope
{
    class Program
    {
        static void Main(string[] args)
        {
        	for (int i = 0; i < 10; i++)
			{
				int var1 = 20;
				Console.WriteLine("The value of var1 at pass {0} is {1}", i, var1);
			}
            
        }
    }
}
