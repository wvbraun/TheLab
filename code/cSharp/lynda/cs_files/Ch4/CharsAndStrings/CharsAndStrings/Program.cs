using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace CharsAndStrings
{
    class Program
    {
        static void Main(string[] args)
        {
            char myChar = '8';
            string myString = "  This is a message with a \n newline and spaces and in it.  ";

            // Do some character tests
            Console.WriteLine("Calling char.IsUpper: {0}", char.IsUpper(myChar));
            Console.WriteLine("Calling char.IsDigit: {0}", char.IsDigit(myChar));
            Console.WriteLine("Calling char.IsLetter: {0}", char.IsLetter(myChar));
            Console.WriteLine("Calling char.IsPunctuation: {0}", char.IsPunctuation(myChar));
            Console.WriteLine("Calling char.IsWhiteSpace: {0}", char.IsWhiteSpace(myChar));
            Console.WriteLine("Calling char.ToUpper: {0}", char.ToUpper(myChar));
            Console.WriteLine("Calling char.ToLower: {0}", char.ToLower(myChar));
            Console.WriteLine();

            // do some string tests
            Console.WriteLine("Calling string.Trim: {0}", myString.Trim());
            Console.WriteLine("Calling string.ToUpper: {0}", myString.ToUpper());
            Console.WriteLine("Calling string.ToLower: {0}", myString.ToLower());
            Console.WriteLine("Calling string.IndexOf: {0}", myString.IndexOf("a"));
            Console.WriteLine("Calling string.LastIndexOf: {0}", myString.LastIndexOf("and"));

        }
    }
}
