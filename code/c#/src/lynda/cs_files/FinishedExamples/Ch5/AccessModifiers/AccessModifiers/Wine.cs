using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace AccessModifiers
{
    class Wine
    {
        public string Name;
        public decimal Price;
        public string Description;

        private decimal discount;

        public Wine(string wineName, decimal price) {
            Name = wineName;
            Price = price;
            discount = 0.0m;
        }
    }
}
