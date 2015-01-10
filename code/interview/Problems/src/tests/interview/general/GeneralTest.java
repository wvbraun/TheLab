package tests.interview.general;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import code.interview.general.General;

public class GeneralTest 
{
	General g;
	
	Class<?> c;
	
	@Before
	public void setup() throws ClassNotFoundException 
	{
		try 
		{
			c = Class.forName("code.interview.general.General");
		} 
		finally 
		{
		}
	}
	
	@Before
	public void setUp() throws Exception 
	{
		g = new General();
	} 
	
	@Test
	public void testIsRotation1()
	{
		int[] ls1 = {1, 2, 3, 4, 5, 6, 7, 8};
		int[] ls2 = {5, 6, 7, 8, 1, 2, 3, 4};
		assertTrue(g.isRotation(ls1, ls2));
	}
	
	@Test
	public void testIsRotation2()
	{
		int[] ls1 = {1, 2, 3, 4, 5, 6, 7, 8};
		int[] ls2 = {5, 6, 7, 8, 9, 0, 1, 2};
		assertFalse(g.isRotation(ls1, ls2));
	}
	
	@Test
	public void testFindCommonElements()
	{
		int[] ls1 = {1, 2, 3, 4, 5};
		int[] ls2 = {1, 0, 0, 4, 0};
		int[] res = {1, 4};
		
		int[] com = g.findCommonElements(ls1, ls2);
		assertArrayEquals(res, com);
	}
	
	@Test
	public void testGetPrimes1()
	{
		int[] ls     = {2, 3, 5, 7, 11, 13};
		int[] primes = g.getPrimes(6);
		assertArrayEquals(ls, primes);
	}
	
	@Test
	public void testGetPrimes2()
	{
		int[] ls     = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61};
		int[] primes = g.getPrimes1(ls.length);
		assertArrayEquals(ls, primes);
	}
	
	@Test
	public void testToBinary()
	{
		int[] ls 	 = {0, 0, 1, 1, 1, 0, 0, 1};
		int[] binary = g.toBinary(156);
		assertArrayEquals(ls, binary);
	}
	
	@Test
	public void testParseInt()
	{
		int res = g.parseInt("192", 10);
		assertEquals(192, res);
	}

}
