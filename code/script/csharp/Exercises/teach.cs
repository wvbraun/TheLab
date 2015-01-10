// teach.cs 
// --------------

using System; 

public class teach 
{
	public static void Main()
	{
		int[,] score = new int[30,15];
		
		
		Random rnd = new Random();
		
		int class_sum = 0;
		int student_sum = 0;
		int wut;
		int test_nbr = 1;
		
		for (int x = 0; x < score.GetLength(0); x++)
		{
			
		
		for ( int x = 0; x < score.GetLength(1); x++)
		{
			for ( int y = 0; y < score.GetLength(0); y++)
			{
				wut = rnd.Next(1,101);
				student_sum += wut;
				
				while ( test_nbr < 16)
				{
					Console.WriteLine("The average score on exam {0}: {1}', test_nbr, student
			}
			
		
		
		//foreach( int x in score[,15]) // 15 exams
		//{
			
			//foreach ( int x in score[30,]) // 30 students
			//{
				//score[x] = rnd.Next(1,100);
				// Console.WriteLine("Score: {0}", score[x]);
			//	student_sum += score[x];
			//}
			
			student_sum /= 30; // finds avg student score
			class_sum += student_sum; // adds the avg student score to the total class score 
			
			int test_nbr = 1;
			
			while ( test_nbr < 16)
			{
				Console.WriteLine("The average score on exam {0}: {1}", test_nbr, student_sum);
			}
			
			student_sum = 0; // resets student_sum
			
		}
			
			
		class_sum /= 15;
				
		Console.WriteLine("The average score on each exam for the class was {0}", class_sum);
	
	}
}
			