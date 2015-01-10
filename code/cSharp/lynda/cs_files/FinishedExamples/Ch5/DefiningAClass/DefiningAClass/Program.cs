using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace DefiningAClass
{
    class MyClass
    {
        int myInteger;
        string myMessage;
        public static int myStaticInt = 100;

        public int myFunction()
        {
            return myInteger;
        }

        public MyClass()
        {
            myInteger = 50;
            myMessage = "This is a string";
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            MyClass myC = new MyClass();

            Console.WriteLine("Calling myFunction: {0}", myC.myFunction());
            Console.WriteLine("Using a static member: {0}", MyClass.myStaticInt);

            Console.ReadLine();
        }
    }
}
