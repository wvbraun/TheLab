package code.interview.general;

import java.util.ArrayList;
import java.util.Arrays;

public class Run 
{
	static Array array;
	
	private static void createArray()
	{
		ArrayList<Integer> ls =  new ArrayList<Integer>(Arrays.asList(0, 0, 1, 2, 3, 4, 0));
		array = new Array(ls);
	}
	
	public static void main(String[] args)
	{
		createArray();
		System.out.println(array.findMostFrequent());
	}

}
