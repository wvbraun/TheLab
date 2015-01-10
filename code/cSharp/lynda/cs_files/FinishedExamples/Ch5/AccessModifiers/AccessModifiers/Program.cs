using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace AccessModifiers
{
    class Program
    {
        static void Main(string[] args)
        {
            Wine w1 = new Wine("Mark Ryan Dissident", 52.00m);
            Wine w2 = new Wine("DeLille Chaleur Estate", 75.00m);

            w1.Description = "Dark and brooding";
        }
    }
}
