using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO; // need this namespace to work with files and directories

namespace ExistingDir
{
    class Program
    {
        static void Main(string[] args)
        {
            string thePath = Environment.GetFolderPath(Environment.SpecialFolder.MyDocuments);

            // Check to see if a directory exists
            bool dirExists = Directory.Exists(thePath);
            if (dirExists)
                Console.WriteLine("The directory exists.");
            else
                Console.WriteLine("The directory does not exist.");
            Console.WriteLine();

            // Write out the names of the files in the directory
            string[] files = Directory.GetFiles(thePath);
            foreach (string s in files)
            {
                Console.WriteLine("Found file: " + s);
            }
            Console.WriteLine();

            // Get information about each fixed disk drive
            Console.WriteLine("Drive Information:");
            foreach (DriveInfo d in DriveInfo.GetDrives())
            {
                if (d.DriveType == DriveType.Fixed)
                {
                    Console.WriteLine("Drive Name: {0}", d.Name);
                    Console.WriteLine("Free Space: {0}", d.TotalFreeSpace);
                    Console.WriteLine("Drive Type: {0}", d.DriveType);
                    Console.WriteLine();
                }
            }

            Console.ReadLine();
        }
    }
}
