using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;

namespace ReadingWritingData
{
    class Program
    {
        static void Main(string[] args)
        {
            // create a path to the My Documents folder and the file name
            string filePath = Environment.GetFolderPath(Environment.SpecialFolder.MyDocuments) +
                                Path.DirectorySeparatorChar + "examplefile.txt";

            // if the file doesn't exist, create it by using WriteAllText
            if (!File.Exists(filePath))
            {
                string content = "This is a text file." + Environment.NewLine;
                Console.WriteLine("Creating the file...");
                File.WriteAllText(filePath, content);
            }

            // Use the AppendAllText method to add text to the content
            string addedText = "Text added to the file" + Environment.NewLine;
            Console.WriteLine("Adding content to the file...");
            File.AppendAllText(filePath, addedText);
            Console.WriteLine();

            // Read the contents of the file
            Console.WriteLine("The current contents of the file are:");
            Console.WriteLine("-------------------------------------");

            // Read the contents of the file using ReadAllText
            string currentContent = File.ReadAllText(filePath);
            Console.Write(currentContent);
            Console.WriteLine();

            // Read the contents of the file using ReadAllLines
            /*
            string[] contents = File.ReadAllLines(filePath);
            foreach (string s in contents)
            {
                Console.WriteLine(s);
            }
            Console.WriteLine();
            */

            Console.ReadLine();
        }
    }
}
