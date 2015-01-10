using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO; // need this for file and directory information

namespace PathOperations
{
    class Program
    {
        static void Main(string[] args)
        {
            // get the path to the documents folder from the Environment class
            string thePath = Environment.GetFolderPath(Environment.SpecialFolder.MyDocuments);
            thePath += @"\testfile.txt";

            // Exercise the Path class methods
            Console.WriteLine("The directory name is {0}", Path.GetDirectoryName(thePath));
            Console.WriteLine("The file name is {0}", Path.GetFileName(thePath));
            Console.WriteLine("File name without extension is {0}", Path.GetFileNameWithoutExtension(thePath));
            Console.WriteLine("Random file name for path is {0}", Path.GetRandomFileName());
        }
    }
}
