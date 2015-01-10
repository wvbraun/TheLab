package tests.interview.general;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import code.interview.general.Strings;

public class StringsTest
{
	Strings s1, s2, s3, s4, s5;
	
	Class<?> c;
	
	@Before
	public void setup() throws ClassNotFoundException 
	{
		try 
		{
			c = Class.forName("code.interview.general.Strings");
		} 
		finally 
		{
		}
	}
	
	@Before
	public void setUp() throws Exception 
	{
		s1 = new Strings("hello");
		s2 = new Strings("racecar");
		s3 = new Strings("print");
		s4 = new Strings("123");
		s5 = new Strings("17179869184");
	} 
	
	@Test
	public void testFindFirstNonRepeated1()
	{
		char c = s1.findFirstNonRepeated1();
		assertEquals('h', c);
	}
	
	@Test
	public void testFindFirstNonRepeated2()
	{
		char c = s1.findFirstNonRepeated2();
		assertEquals('h', c);
	}
	
	@Test
	public void testReverseIteratively1()
	{
		String s = s1.reverseIteratively();
		assertEquals("olleh", s);
	}
	
	@Test
	public void testReverseIteratively2()
	{
		char[] s = Strings.reverseIteratively(new char[] {'a', 'b', 'c'});
		assertArrayEquals(new char[]{'c', 'b', 'a'}, s);
	}
	
	@Test
	public void testReverseRecursively()
	{
		char[] s = Strings.reverseRecursively(new char[] {'o', 'c', 'u', 'l', 'u', 's'});
		assertArrayEquals(new char[] {'s', 'u', 'l', 'u', 'c', 'o'}, s);
	}
	
	@Test
	public void testAreAnagrams1()
	{
		String s2 = "eollh";
		assertTrue(s1.areAnagrams(s2));
	}
	
	@Test
	public void testAreAnagrams2()
	{
		String other = "carrace";
		assertTrue(s2.areAnagrams(other));
	}
	
	@Test
	public void testAreAnagrams3()
	{
		String other = "oculus";
		assertFalse(s1.areAnagrams(other));
	}
	
	@Test
	public void testIsPalindrome1()
	{
		assertFalse(s1.isPalindrome1());
	}
	
	@Test
	public void testIsPalindrome2()
	{
		assertTrue(s2.isPalindrome1());
	}
	
	@Test
	public void testIsPalindrome3()
	{
		assertFalse(s1.isPalindrome2());
	}
	
	@Test
	public void testIsPalindrome4()
	{
		assertTrue(s2.isPalindrome2());
	}
	
	@Test
	public void testAllUnique1()
	{
		assertFalse(s1.allUnique());
	}
	
	@Test
	public void testAllUnique2()
	{
		assertTrue(s3.allUnique());
	}
	
	@Test
	public void testIsIntOrDouble1()
	{
		assertEquals('c', s4.isIntOrDouble());
	}
	
	@Test
	public void testIsIntOrDouble2()
	{
		assertEquals('d', s5.isIntOrDouble());
	}

}
