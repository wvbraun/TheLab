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

        void myFunction()
        {
            Console.WriteLine("In my function");
        }

        public MyClass() {
            myInteger = 0;
            myMessage = "";
        }
    }
}
