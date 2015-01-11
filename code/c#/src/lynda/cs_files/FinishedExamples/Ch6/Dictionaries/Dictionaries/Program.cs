using System;
using System.Collections; // we need to add this reference to use Files and Directory information
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Dictionaries
{
    class Program
    {
        static void Main(string[] args)
        {
            Hashtable myHT = new Hashtable();
            myHT.Add("SFO", "San Francisco Airport");
            myHT.Add("SEA", "Seattle Tacoma Airport");
            myHT["IAD"] = "Washintgon Dulles Airport";

            Console.WriteLine("Value for key {0} is {1}", "SEA", myHT["SEA"]);

            Console.WriteLine("There are {0} items", myHT.Count);

            //myHT.Remove("SFO");
            if (myHT.ContainsKey("SFO")) {
                Console.WriteLine("Value for key {0} is {1}", "SFO", myHT["SFO"]);
            }

            Console.ReadLine();
        }
    }
}
