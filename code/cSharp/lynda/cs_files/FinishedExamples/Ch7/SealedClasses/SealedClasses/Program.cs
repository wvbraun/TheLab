using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace SealedClasses
{
    class myExampleClass
    {
        public static string myMethod(int arg1)
        {
            return String.Format("You sent me the number {0}", arg1);
        }
    }

    class mySubClass : myExampleClass
    {
    }

    class Program
    {
        static void Main(string[] args)
        {
        }
    }
}
