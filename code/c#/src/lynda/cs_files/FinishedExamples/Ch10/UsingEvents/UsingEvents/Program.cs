using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;

namespace UsingEvents
{
    public delegate void myEventHandler(string newValue);

    class EventExample
    {
        private string theValue;
        public event myEventHandler valueChanged;

        public string Val
        {
            set
            {
                this.theValue = value;
                this.valueChanged(theValue);
            }
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            EventExample myEvt = new EventExample();

            myEvt.valueChanged += new myEventHandler(myEvt_valueChanged);

            string str;
            do
            {
                str = Console.ReadLine();
                if (!str.Equals("exit"))
                    myEvt.Val = str;

            } while (!str.Equals("exit"));
        }

        static void myEvt_valueChanged(string newValue)
        {
            Console.WriteLine("The value changed to {0}", newValue);
        }
    }
}
