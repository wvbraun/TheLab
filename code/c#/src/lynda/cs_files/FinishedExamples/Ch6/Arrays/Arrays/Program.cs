using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Arrays
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] manyValues = { 1, 18, 745, 34, 16, 94, 73, 4, 17, 200 };
            Console.WriteLine("The fourth number is {0}", manyValues[3]);

            string[] myStrings = { "Joe", "Marini", "Teaches", "C#" };
            for (int i = 0; i < 4; i++)
            {
                Console.WriteLine("{0}", myStrings[i]);
            }

            int[] otherValues = manyValues;
            otherValues[3] = 0;
            Console.WriteLine("The fourth number is {0}", manyValues[3]);

            Array.Sort(manyValues);
            Console.WriteLine("The fourth number is {0}", manyValues[3]);

            Console.ReadLine();
        }
    }
}
