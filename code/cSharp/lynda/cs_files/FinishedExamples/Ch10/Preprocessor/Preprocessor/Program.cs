#define DEBUGCODE
#define JOE

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Preprocessor
{
    class Program
    {
        #region This is the main function
        static void Main(string[] args)
        {
#if DEBUGCODE
            Console.WriteLine("This is only in debug code");
#else
            Console.WriteLine("This only gets written out in non-debug code");
#endif

#if JOE
            Console.WriteLine("Joe was here!");
#endif

            Console.ReadLine();
        }
        #endregion
    }
}
