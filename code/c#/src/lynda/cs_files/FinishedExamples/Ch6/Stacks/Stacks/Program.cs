using System;
using System.Collections; // we need to add this reference to use Files and Directory information
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Stacks
{
    class Program
    {
        static void Main(string[] args)
        {
            Stack myStack = new Stack();

            myStack.Push("item 1");
            myStack.Push("item 2");
            myStack.Push("item 3");
            Console.WriteLine("{0} Items on the stack", myStack.Count);

            // Have a peek at the top item
            Console.WriteLine("{0}", myStack.Peek());

            myStack.Pop(); // pops "item 3" off the top
            // now "item 2" is the top item
            Console.WriteLine("{0}", myStack.Peek());

            myStack.Clear(); // get rid of everything
            Console.WriteLine("{0} Items on the stack", myStack.Count);

            Console.ReadLine();
        }
    }
}
