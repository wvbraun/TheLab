using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace CompileIssues
{
    class Program
    {
        static void Main(string[] args)
        {
            // Some common issues that cause compile problems and warnings:

            // Issue #1
            // string myString = "Hello World"

            // Issue #2
            // Console.WriteLine("Hello World);

            // Issue #3
            // ArrayList myAL = new ArrayList();

            // Issue #4
            //for (int i=0; i < 10; i++) {
            //{
            //  Console.WriteLine("i is {0}",i);
            //}

            // Issue #5
            // string anotherString = 'Hello World';

            // Issue #6
            // int[] myarray = { 0, 1, 2, 3, 4 };
            // myarray(2) = 10;

            // Issue #7
            // Console.Writeline("Hello World");

            // Issue #8
            // int i = 2500;
            // float f = 35.895f;
            // i = f;

            // Issue #9
            // int a = 5, b = 20;
            // if (a = b)
            // {
            //    Console.WriteLine("Equal numbers!");
            // }
        }

        // Issue #10
        /*
        static int func(int a)
        {
            if (a > 0)
                return 0;
            if (a < 0)
                return -1;
        }
        */
    }
}
