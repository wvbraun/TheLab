using System;
using System.Collections; // we need to add this reference to use Files and Directory information
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ArrayLists
{
    class Program
    {
        static void Main(string[] args)
        {
            ArrayList myAL = new ArrayList();
            myAL.Add("one");
            myAL.Add(2);
            myAL.Add("three");
            myAL.Add(4);
            myAL.Insert(0, 1.25f);

            foreach (object o in myAL)
            {
                if ((o is int) || (o is float))
                    Console.WriteLine("{0}", o);
            }
            Console.ReadLine();
        }
    }
}
