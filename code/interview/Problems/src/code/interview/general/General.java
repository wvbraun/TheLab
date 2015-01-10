package code.interview.general;

public class General
{
	
	public General()
	{
		
	}

	public boolean isRotation(int[] ls1, int[] ls2)
	{
		if (ls1.length != ls2.length)
		{
			return false;
		}
		for (int i = 0; i < ls1.length; ++i)
		{
			if (isSame(ls1, ls2))
			{
				return true;
			}
			
			ls2 = shiftArray(ls2, 1);
		}
		
		return false;
		
	}
	
	private int[] shiftArray(int[] ls, int amt)
	{
		int   j;
		int   i   = amt;
		int[] res = new int[ls.length];
		
		for (j = 0; i < ls.length; ++j, ++i)
		{
			res[j] = ls[i];
		}

		for (i = 0; i < amt; ++i, ++j)
		{
			res[j] = ls[i];
		}
			
		return res;
	}
	
	private boolean isSame(int[] ls1, int[] ls2)
	{
		boolean result = true;
		
		for (int i = 0; i < ls1.length; ++i)
		{
			if (ls1[i] != ls2[i])
			{
				result = false;
				break;
			}
		}
			
		return result;
	}
	
	public int[] findCommonElements(int[] ls1, int[] ls2)
	{
		int[] result = ls1;
		
		for (int x : result)
		{
			if (!hasElement(ls2, x))
			{
				result = removeElement(result, x);
			}
		}
		
		return result;
	}
	
	private boolean hasElement(int[] xs, int e)
	{
		boolean result = false;
		
		for (int x : xs)
		{
			if (x == e)
			{
				result = true;
				break;
			}
		}
		return result;
	}
	
	private int[] removeElement(int[] ls, int e)
	{
		int[] res = new int[ls.length - 1];
		
		for (int i = 0, j = 0; i < ls.length; ++i)
		{
			if (ls[i] != e)
			{
				res[j] = ls[i];
				++j;
			}
		}
		
		return res;
	}
	
	
	private boolean isPrime(int n)
	{
		boolean isPrime = true;
		
		if (n < 2)
		{
			isPrime = false;
		}
		else
		{
			for (int i = 2; i < n; ++i)
			{
				if (n % i == 0)
				{
					isPrime = false;
					break;
				}
			}
		}
		
		return isPrime;	
	}
	
	public int[] getPrimes(int n)
	{
		int[] primes = new int[n];
		
		for (int i = 0, k = 2; i < n; ++k)
		{
			if (isPrime(k))
			{
				primes[i] = k;
				++i;
			}
		}
		
		return primes;
	}
	
	// this time we will use the fact that after 2 and 3
	// the primes follow an odd pattern.
	public int[] getPrimes1(int n)
	{
		int[] primes = new int[n];
		primes[0] = 2;
		primes[1] = 3;
		
		for (int i = 2, k = 6; i < n; k += 6)
		{
			if (isPrime(k - 1))
			{
				primes[i] = k - 1;
				++i;
			}
			if (i < n && isPrime(k + 1))
			{
				primes[i] = k + 1;
				++i;
			}
		}
		return primes;
	}
	
	public int[] toBinary(int n)
	{
		int   remainder;
		int[] binary = new int[(int) Math.ceil((Math.log(n) / Math.log(2)))];
		
		for (int i = 0; n > 0; ++i)
		{
			remainder = n % 2;
			n 		  = (int) Math.floor(n / 2);
			binary[i] = remainder;
		}
		
		return binary;
	}
	
	public int parseInt(String str, int radix)
	{
		int result = 0;
		int power  = str.length() - 1;
		
		for (int i = 0; i < str.length(); ++i)
		{
			int tmp = Character.getNumericValue(str.charAt(i));
			tmp    *= Math.pow(radix, power);
			result += tmp;
			--power;
		}
			
		return result;
	}
	
}
