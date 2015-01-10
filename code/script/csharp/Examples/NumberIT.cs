using System; 
using System.IO;

/// <summary>
/// Class to number a listing. Assumes fewer than 1000 lines.
/// <summary>

class NumberIT
{

	/// <summary>
	/// The main entry point for the application
	/// <summary>
	
	public static void Main(string[] args)
	{
	
		// check to see if a file name was included on the
		// command line.
		
		if (args.Length <= 0)
		{
			Console.WriteLine("\nYou need to include a filename.");
		}
		else
		{
			// declare objects for connecting to files
		StreamReader InFile = null;
		StreamWriter OutFile = null;
		
		try
		{
		// Open file name included on command line...
		InFile = File.OpenText(args[0]);
		// Create the output file...
		OutFile = File.CreateText("outfile.txt");
		
		Console.Write("\nNumbering...");
		
		// Read first line of the file...
		string line = InFile.ReadLine();
		int ctr = 1;
		
		// loop through the file as long as not at the end...
		while (line != null)
		{
			OutFile.WriteLine("{0}: {1}", 
					ctr.ToString().PadLeft(3, '0'), line);
			Console.Write("..{0}..", ctr.ToString());
			ctr++;
			line = InFile.ReadLine();
		}
	}
	catch (System.IO.FileNotFoundException)
	{
		Console.WriteLine("Could not find the file {0}", args[0]);
	}
	catch (Exception e)
	{
		Console.WriteLine("Error: {0}", e.Message);
	}
	finally
	{
		if(InFile != null)
		{
			// Close the files 
			InFile.Close();
			OutFile.Close();
			Console.WriteLine("...Done.");
		}
	  }
	}
  }
}