using System;
using System.IO;

namespace FileHandling
{
	class Program
	{
		static void Main()
		{
			if (File.Exists("test.txt"))
			{
				string content = File.ReadAllText("test.txt");
				Console.WriteLine("Current contents of file:");
				Console.WriteLine(content);
			}

			Console.WriteLine("Please enter new content for the file:");
			// if you do not use the using() statment, you
			// will have to manually call the Close() method
			// on the StreamWriter instance.
			using (StreamWriter sw = new StreamWriter("test.txt"))
			{
				string newContent = Console.ReadLine();
				while (newContent != "exit")
				{
					sw.Write(newContent + Environment.NewLine);
					newContent = Console.ReadLine();
				}
			}
		}
	}
}
