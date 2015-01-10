using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace HelloWorldProject
{
    class Program
    {
        static void Main(string[] args) {

            Console.WriteLine("Hello World!");
            Console.WriteLine("What is your name?");
            string str = Console.ReadLine();
            Console.WriteLine("Hello, " + str);

            int secs = 60 * 60 * 24 * 365;
            Console.WriteLine("There are {0} seconds in a year", secs);
        }
    }
}
