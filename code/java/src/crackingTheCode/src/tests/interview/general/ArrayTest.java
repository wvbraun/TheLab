package tests.interview.general;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import code.interview.general.Array;

import org.junit.Before;
import org.junit.Test;

public class ArrayTest 
{
	private Array array;
	private Array array1;
	
	Class<?> c;
	
	@Before
	public void setup() throws ClassNotFoundException 
	{
		try 
		{
			c = Class.forName("code.interview.general.Array");
		} 
		finally 
		{
		}
	}
	
	@Before
	public void setUp() throws Exception 
	{
		ArrayList<Integer> ls =  
				new ArrayList<Integer>(Arrays.asList(0, 0, 0, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7));
		ArrayList<Integer> ls1 = 
				new ArrayList<Integer>(Arrays.asList(5, 6, 7, 8, 1, 2, 3));
		
		array  = new Array(ls);
		array1 = new Array(ls1); 
	} 
	
	@Test
	public void testFindMostFrequent()
	{
		assertEquals(0, array.findMostFrequent());
	}
	
	@Test
	public void testFindSumPair()
	{
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(5, 5);
		map.put(6, 4);
		map.put(7, 3);
		Map<Integer, Integer> res = array.findSumPairs(10);
		assertEquals(map, res);
	}
	
	@Test
	public void testFindOneOccurrence()
	{
		assertEquals(1, array.findOneOccurrence());
	}
	
	@Test
	public void testBinarySearch()
	{
		assertEquals(3, array.binarySearch(1));
	}
	
	@Test
	public void testBinarySearchRotation()
	{
		assertEquals(4, array1.binarySearchRotation(1));
	}

}
