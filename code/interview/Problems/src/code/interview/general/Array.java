package code.interview.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Array 
{
	ArrayList<Integer> xs;
	
	public Array(ArrayList<Integer> xs)
	{
		this.xs = xs;
	}
	
	public int getMax()
	{
		int max = xs.get(0);
		
		for (int i = 1; i < xs.size(); ++i)
		{
			if (xs.get(i) > max)
			{
				max = xs.get(i);
			}
		}
		
		return max;
	}
	
	public int findMostFrequent()
	{
		Array lookup = new Array(new ArrayList<Integer>());
		
		// set every possible element (2^32) to 0.
		for (int i = 0; i < xs.size(); ++i)
		{
			lookup.xs.add(0);
		}
		
		// increment the value of lookup[x] each time we encounter it
		for (int x : xs)
		{
			lookup.xs.set(x, lookup.xs.get(x) + 1);
		}
		
		int index = lookup.getMax();
		return lookup.xs.indexOf(index);
	}
	
	public Map<Integer, Integer> findSumPairs(int sum)
	{
		Map<Integer, Integer> pairs  = new HashMap<Integer, Integer>();
		Map<Integer, Integer> result = new HashMap<Integer, Integer>(); 
		
		for (int x : xs)
		{
			if (pairs.containsKey(x))
			{
				result.put(x, pairs.get(x));
			}
			else
			{
				pairs.put(sum - x, x);
			}
		}
		
		return result;
	}
	
	public int findOneOccurrence()
	{
		Array lookup = new Array(new ArrayList<Integer>());
		
		// set every possible element (2^32) to 0.
		for (int i = 0; i < xs.size(); ++i)
		{
			lookup.xs.add(0);
		}
		
		// increment the value of lookup[x] each time we encounter it
		for (int x : xs)
		{
			lookup.xs.set(x, lookup.xs.get(x) + 1);
		}
		
		int index = lookup.xs.indexOf(1);
		return lookup.xs.get(index);
	}
	
	public int binarySearch(int key)
	{
		int iMin = 0;
		int iMax = xs.size() - 1;
		
		while (iMin <= iMax)
		{
			int iMid = midPoint(iMin, iMax);
			int mid  = xs.get(iMid);
			
			if (mid == key)
			{
				return iMid;
			}
			else if (mid > key)
			{
				iMax = iMid - 1;
			}
			else
			{
				iMin = iMid + 1;
			}
		}
		
		return -1; // key not found
	}
	
	private int midPoint(int m, int n)
	{
		return (m + n) / 2;
	}
	
	public int binarySearchRotation(int key)
	{
		int iMin = 0;
		int iMax = xs.size() - 1;
		
		while (iMin <= iMax)
		{
			int iMid = midPoint(iMin, iMax);
			int mid  = xs.get(iMid);
			
			if (mid == key)
			{
				return iMid;
			}
			else if (xs.get(iMin) <= mid)
			{
				if (xs.get(iMin) <= key && key < mid)
				{
					iMax = iMid - 1;
				}
				else
				{
					iMin = iMid + 1;
				}
			}
			else
			{
				if (mid < key && key <= xs.get(iMax))
				{
					iMin = iMid + 1;
				}
				else
				{
					iMax = iMid - 1;
				}
			}
		}
		return -1;
	}



}
