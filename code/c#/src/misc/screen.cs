/*
 * Write a method in C# which accepts an array of integers and an integer and then
 * returns the array with all instances of the given integer removed.  
 * For example:  given the inputs {1,2,3,2} and 2, the function should return {1,3}. 
*/

using System;
using System.Collections.Generic;

class Remove {
	static void Main() {
		int[] i = {1, 2, 3, 2, 4, 2, 5, 2, 3, 2};
		removeItems(i, 2);
	}

		
	public static void removeItems(int[] items, int num) {
		List<int> myList = new List<int>();

		foreach (int item in items) {
			if (item != num) 
				myList.Add(item);
			   
		}

		int[] newArray = myList.ToArray();
		
		Console.WriteLine("\nList elements: \n");
		foreach (var y in myList) {
			Console.WriteLine(y);
		}

		Console.WriteLine("--------------------");
		Console.WriteLine("Array elements: \n");

		Array.ForEach(newArray, x => Console.Write(x.ToString()));
		Console.WriteLine("");


	}
}
				
				
