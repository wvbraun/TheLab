using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace MethodOverloading
{
    class Wine
    {
        public int Year;
        public string Name;
        public decimal price;

        public Wine(string s)
        {
            Name = s;
        }
        public Wine(string s, int y)
        {
            Name = s;
            Year = y;
        }
        public Wine(string s, decimal p, int y)
        {
            Name = s;
            price = p;
            Year = y;
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            Wine w1 = new Wine("Charles Shaw Merlot");
            Wine w2 = new Wine("Mark Ryan Dissident", 2004);
            Wine w3 = new Wine("Dom Perignon", 120.00m, 1994);

            Console.WriteLine("{0}", w1.Name);
            Console.WriteLine("{0} {1}", w2.Year, w2.Name);
            Console.WriteLine("{0} {1} {2}", w3.Year, w3.Name, w3.price);

            Console.ReadLine();
        }
    }
}
