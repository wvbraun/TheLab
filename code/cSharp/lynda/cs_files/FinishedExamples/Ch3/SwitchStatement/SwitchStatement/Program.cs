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
            int theVal = 50;

            switch (theVal)
            {
                case 50:
                    Console.WriteLine("The value is 50");
                    break;
                case 51:
                    Console.WriteLine("The value is 51");
                    break;
                case 52:
                    Console.WriteLine("The value is 52");
                    break;
                default:
                    Console.WriteLine("The value is something else");
                    break;
            }
        }
    }
}
