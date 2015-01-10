package code.interview.general;

import java.util.HashMap;

public class Strings 
{
	private String string;
	
	public Strings(String string)
	{
		this.string = string;
	}
	
	public char findFirstNonRepeated1()
	{
		char result = '\u0000';
		
		for (int i = 0; i < string.length(); ++i)
		{
			char c = string.charAt(i);
			if (occursOnlyOnce(c))
			{
				result = c;
				break;
			}
		}
		return result;
	}
	
	public char findFirstNonRepeated2()
	{
		char 						result = '\u0000';
		HashMap<Character, Integer> hash   = new HashMap<Character, Integer>();
		
		for (int i = 0; i < string.length(); ++i)
		{
			char c = string.charAt(i);
			if (hash.containsKey(c))
			{
				int n = hash.get(c);
				hash.put(c, ++n);
			}
			else
			{
				hash.put(c, 1);
			}
		}
		
		for (char c : hash.keySet())
		{
			if (hash.get(c) == 1)
			{
				result = c;
			}
		}
		
		return result;
	}
	
	private boolean occursOnlyOnce(char c)
	{
		int 	amt	 	 = 0;
		boolean onlyOnce = true;

		for (int i = 0; i < string.length(); ++i)
		{
			if (string.charAt(i) == c)
			{
				++amt;
			}
			if (amt > 1)
			{
				onlyOnce = false;
				break;
			}
		}
		
		return onlyOnce;
	}
	
	public String reverseIteratively()
	{
		StringBuilder result = new StringBuilder(string);
		
		for (int i = string.length() - 1; i > -1; --i)
		{
			result.setCharAt(string.length() - i - 1, string.charAt(i));
		}
		
		return result.toString();
	}
	
	public static char[] reverseIteratively(char[] str)
	{
		for (int i = str.length - 1, j = 0; i > j; --i, ++j)
		{
			swap(str, j, i);
		}
		return str;
	}
	
	private static void swap(char[] str, int i, int j)
	{
		char tmp = str[i];
		str[i]   = str[j];
		str[j] 	 = tmp;
	}

	
	public static char[] reverseRecursively(char[] str)
	{
		return reverseRecursively(str, 0, str.length - 1);
	}
	
	private static char[] reverseRecursively(char[] str, int i, int j)
	{
		if (i < j)
		{
			swap(str, i, j);
			return reverseRecursively(str, ++i, --j);
		}
		
		return str;
	}
	
	public boolean areAnagrams(String other)
	{
		boolean areAnagarams = true;
		
		if (string.length() != other.length())
		{
			areAnagarams = false;
		}
		else
		{
			HashMap<Character, Integer> hash1 = new HashMap<Character, Integer>();
			HashMap<Character, Integer> hash2 = new HashMap<Character, Integer>();
			
			for (int i = 0; i < string.length(); ++i)
			{
				char c = string.charAt(i);
				if (hash1.containsKey(c))
				{
					int n = hash1.get(c);
					hash1.put(c, ++n);
				}
				else
				{
					hash1.put(c, 1);
				}
			}
			
			for (int i = 0; i < other.length(); ++i)
			{
				char c = other.charAt(i);
				if (hash2.containsKey(c))
				{
					int n = hash2.get(c);
					hash2.put(c, ++n);
				}
				else
				{
					hash2.put(c, 1);
				}
			}
			
			for (char key : hash1.keySet())
			{
				if (!hash2.containsKey(key))
				{
					areAnagarams = false;
					break;
				}
				if (hash1.get(key) != hash2.get(key))
				{
					areAnagarams = false;
					break;
				}
			}
		}
		
		return areAnagarams;
	}
	
	public boolean isPalindrome1()
	{
		String other = reverseIteratively();
		return (string.equals(other));
	}
	
	public boolean isPalindrome2()
	{
		boolean isPalindrome = true;
		
		for (int i = 0, j = string.length() - 1; i <= j; ++i, --j)
		{
			char iChar = string.charAt(i);
			char jChar = string.charAt(j);
			if (iChar != jChar)
			{
				isPalindrome = false;
				break;
			}
		}
		
		return isPalindrome;
	}
	
	public boolean allUnique()
	{
		boolean 					allUnique = true;
		HashMap<Character, Integer> hash 	  = new HashMap<Character, Integer>();
		
		for (int i = 0; i < string.length(); ++i)
		{
			char c = string.charAt(i);
			if (hash.containsKey(c))
			{
				int n = hash.get(c);
				hash.put(c, ++n);
			}
			else
			{
				hash.put(c, 1);
			}
		}
		
		for (char key : hash.keySet())
		{
			if (hash.get(key) != 1)
			{
				allUnique = false;
				break;
			}
		}
		
		return allUnique;
	}
	
	public char isIntOrDouble()
	{
		try
		{
			Integer.parseInt(string);
			return 'c';
		}
		catch (NumberFormatException e)
		{
			return 'd';
		}
	}

}
