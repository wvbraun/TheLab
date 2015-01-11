using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace DefiningProperties
{
    class Wine
    {
        private string Name;
        private int year;
        private string Apellation;
        private decimal wholesalePrice;
        private const decimal retailMarkup = 1.35m;

        public decimal Price
        {
            get
            {
                return wholesalePrice * retailMarkup;
            }
            set
            {
                wholesalePrice = value;
            }
        }

        public string MenuDescription
        {
            // only a getter for this property, which is generated from private fields
            get { return year.ToString() + " " + Name + ", " + Apellation; }
        }

        public Wine(int y, string sName, string sApp, decimal wp) 
        {
            Name = sName;
            year = y;
            Apellation = sApp;
            wholesalePrice = wp;
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            // Create some new Wine objects
            Wine w1 = new Wine(2003, "Chateau Ste. Michelle Merlot", "Seven Hills", 23.50m);
            Wine w2 = new Wine(2005, "Mark Ryan Dissident", "Ciel du Cheval", 40.00m);

            // Write out the property values
            // Note that in these cases we are using the property getters
            Console.WriteLine("Wine 1: {0}, {1}", w1.MenuDescription, w1.Price);
            Console.WriteLine("Wine 2: {0}, {1}", w2.MenuDescription, w2.Price);
            Console.WriteLine();

            // change the wholesale price of one of the wines using the setter
            w2.Price = 45.0m;

            // write out the wine description, note how the retail price automatically changes
            Console.WriteLine("Wine 2: {0}, {1}", w2.MenuDescription, w2.Price);

            Console.ReadLine();
        }
    }
}
