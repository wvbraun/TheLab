using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ExceptionObject
{
    class Program
    {
        static void Main(string[] args)
        {
            int x = 10;
            int y = 0;
            int result;

            try
            {
                result = x / y;
                Console.WriteLine("The result is: {0}", result);
            }
            catch (System.DivideByZeroException e)
            {
                Console.WriteLine("Whoops! You tried to divide by zero!");
                Console.WriteLine(e.Message);
            }
            finally
            {
                Console.WriteLine("Just proving that this code always runs.");
            }

            Console.ReadLine();
        }
    }
}
