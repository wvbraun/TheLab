using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace UsingInterfaces
{
    interface ITalkative
    {
        void SayHello();
        void SayGoodBye();
    }

    class myExampleClass : ITalkative
    {
        public myExampleClass()
        {
        }

        public void SayHello()
        {
            Console.WriteLine("Saying hello!");
        }

        public void SayGoodBye()
        {
            Console.WriteLine("Saying goodbye!");
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            myExampleClass myEC = new myExampleClass();

            myEC.SayHello();
            myEC.SayGoodBye();

            Console.ReadLine();
        }
    }
}
