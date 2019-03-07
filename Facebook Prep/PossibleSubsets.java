/* Find all possible subsets of a given set */

/* Total no. of subsets of a given set is 2^ (no. of elements in the set) */
/* Time Complexity: O(2^n) */

import java.util.*;

class PossibleSubsets
{
	public static void main(String args[])
	{
		char[] set = {'a','b','c'};
		Arrays.sort(set);
		List<Character> out = new ArrayList<>();

		subset(set,out,set.length-1);
	}

	static void subset(char[] set, List<Character> out, int i)
	{
		if(i < 0)
		{
			System.out.println(out);
			return;
		}

		//include current element and recurse
		out.add(set[i]);
		subset(set,out,i-1);

		//exclude current element
		out.remove(out.size()-1);

		//remove adjacent duplicate elements
		while(i>0 && set[i]==set[i-1])
			i--;

		//exclude current element and recurse
		subset(set,out,i-1);

	}
}
