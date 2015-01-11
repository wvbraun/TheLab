using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace CustomExceptions
{
    public class NoJoesException : Exception
    {
        public NoJoesException() : base("We don't allow no Joes in here!")
        {
            this.HelpLink = "http://www.joemarini.com/";
        }
    }

    class Program
    {
        static string GetName()
        {
            string s = Console.ReadLine();
            if (s.Equals("Joe"))
                throw new NoJoesException();

            return s;
        }

        static void Main(string[] args)
        {
            string theName;

            try
            {
                theName = GetName();
                Console.WriteLine("Hello {0}", theName);
            }
            catch (NoJoesException nje)
            {
                Console.WriteLine(nje.Message);
                Console.WriteLine("For help, visit: {0}", nje.HelpLink);
            }
            finally
            {
                Console.WriteLine("Have a nice day!");
            }

            Console.ReadLine();
        }
    }
}
