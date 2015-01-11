using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;


namespace UsingDelegates
{
    public delegate int NumberFunction (int x);

    class Program
    {
        static void Main(string[] args)
        {
            NumberFunction f = Square;
            Console.WriteLine("result of the delegate is {0}", f(5));

            // now change the delgate
            f = Cube;
            Console.WriteLine("result of the delegate is {0}", f(5));

            Console.ReadLine();
        }

        static int Square(int num)
        {
            return num * num;
        }

        static int Cube(int num)
        {
            return num * num * num;
        }
    }
}
