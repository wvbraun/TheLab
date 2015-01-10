using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace MethodOverriding
{
    class baseClass
    {
        public virtual void doSomething() 
        {
            Console.WriteLine("This is the baseClass saying hi!");
        }
    }

    class subClass : baseClass
    {
        public override void doSomething()
        {
            base.doSomething();
            Console.WriteLine("This is the subClass saying hi!");
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            baseClass obj1 = new subClass();

            obj1.doSomething();

            Console.ReadLine();
        }
    }
}
