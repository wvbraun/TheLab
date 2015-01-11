using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace UsingExceptions
{
    class Program
    {
        static void Main(string[] args)
        {
            int x = 10;
            int y = 5;
            int result;

            try
            {
                result = x / y;
                Console.WriteLine("The result is: {0}", result);
            }
            catch
            {
                Console.WriteLine("An error occurred! Better check the code!");
            }
            finally
            {
                Console.WriteLine("Just proving that this code always runs.");
            }

            Console.ReadLine();

        }
    }
}
