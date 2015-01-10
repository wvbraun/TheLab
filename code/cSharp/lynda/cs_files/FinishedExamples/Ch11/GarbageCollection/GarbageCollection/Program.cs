using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace GarbageCollection
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Allocated memory is: {0}", GC.GetTotalMemory(false));
            Console.WriteLine();
            Console.ReadLine();

            byte[] myArray = new byte[100000];

            Console.WriteLine("Allocated memory is: {0}", GC.GetTotalMemory(false));
            Console.WriteLine();
            Console.ReadLine();

            GC.Collect();

            Console.WriteLine("Allocated memory is: {0}", GC.GetTotalMemory(false));
            Console.WriteLine();
            Console.ReadLine();

        }
    }
}
