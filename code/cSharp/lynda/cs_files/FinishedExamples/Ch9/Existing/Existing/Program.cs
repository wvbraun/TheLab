using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO; // we need to add this reference to use Files and Directory information

namespace Existing
{
    class Program
    {
        static void Main(string[] args)
        {
            bool fileExists = false;
            string thePath = Environment.GetFolderPath(Environment.SpecialFolder.MyDocuments);
            string theFile = thePath + @"\testfile.txt";

            fileExists = File.Exists(theFile);

            if (fileExists)
            {
                Console.WriteLine("The file exists");
            }
            else
            {
                Console.WriteLine("The file does not exist, creating it");
                File.Create(theFile);
            }

            if (fileExists)
            {
                Console.WriteLine("It was created on {0}", File.GetCreationTime(theFile));
                Console.WriteLine("It was last accessed on {0}", File.GetLastAccessTime(theFile));

                Console.WriteLine("Moving the file...");
                File.Move(theFile, thePath + @"\newfile.txt");
            }

            Console.ReadLine();
        }
    }
}
