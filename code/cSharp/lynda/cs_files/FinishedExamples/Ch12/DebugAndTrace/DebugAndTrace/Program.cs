using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;
using System.Diagnostics; // need this to use the Debug class

namespace DebugAndTrace
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
                CreateFile(filePath);
            }

            // Use the AppendAllText method to add text to the content
            WriteFileData(filePath, "Text to add to the file");
            //WriteFileData(filePath, "");

            // Read the contents of the file
            Console.WriteLine("The current contents of the file are:");
            Console.WriteLine("-------------------------------------");

            ReadAndListFileContents(filePath);

            Console.ReadLine();
        }

        static void CreateFile(string filePath)
        {
            string content = "This is a text file." + Environment.NewLine;
            Console.WriteLine("Creating the file...");
            File.WriteAllText(filePath, content);
            
            Debug.WriteLine("Created the file with content: {0}", (object)content);
        }

        static void WriteFileData(string filePath, string content)
        {
            Debug.Assert(content.Length > 0);

            Debug.Indent();
            Debug.WriteLine("Writing File Data");
            Debug.Unindent();

            string addedText = content + Environment.NewLine;
            Console.WriteLine("Adding content to the file...");
            File.AppendAllText(filePath, addedText);
            Console.WriteLine();

            Debug.Indent();
            Debug.WriteLine("File Data Written");
            Debug.Unindent();
        }

        static void ReadAndListFileContents(string filePath)
        {
            string[] contents = File.ReadAllLines(filePath);

            Debug.WriteLineIf(contents.Length > 2, "The file has more than two lines");

            foreach (string s in contents)
            {
                Console.WriteLine(s);
            }
            Console.WriteLine();
        }
    }
}
