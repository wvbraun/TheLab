using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace FuncParamModifiers
{
    class Program
    {
        static void SquareAndRoot(double num, out double sq, out double sqrt)
        {
            sq = num * num;
            sqrt = Math.Sqrt(num);
        }

        static void Main(string[] args)
        {
            double n = 9.0;
            double theSquare, theRoot;

            SquareAndRoot(n, out theSquare, out theRoot);
            Console.WriteLine("The square of {0} is {1} and its square root is {2}", n, theSquare, theRoot);
            
            Console.ReadLine();
        }
    }
}
