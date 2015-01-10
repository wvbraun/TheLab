using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Loops
{
    class Program
    {
        static void Main(string[] args)
        {
            int myVal = 15;

            // basic while loop
            Console.WriteLine("Basic while() loop:");
            while (myVal < 20) {
                Console.WriteLine("myVal is currently {0}", myVal);
                // careful! Always make sure that the loop has some way to exit
                // or you'll end up with an Infinite Loop!
                myVal += 3;
            }
            Console.WriteLine();

            // the do-while loop
            Console.WriteLine("The  do-while() loop:");
            do
            {
                Console.WriteLine("myVal is currently {0}", myVal);
                myVal += 3;
            } while (myVal < 20);
            Console.WriteLine();

            // the for loop
            Console.WriteLine("The for loop:");
            for (int i = 0; i < myVal; i += 5)
            {
                Console.WriteLine("i is currently {0}", i);
            }
            Console.WriteLine();

            // using the continue and break keywords
            Console.WriteLine("Using break and continue :");
            for (int i = 0; i < 10; i++)
            {
                if (i == 5)
                    continue; // skip the rest of the loop

                if (i == 9)
                    break;

                Console.WriteLine("i is currently {0}", i);
            }

            Console.ReadLine();
        }
    }
}
