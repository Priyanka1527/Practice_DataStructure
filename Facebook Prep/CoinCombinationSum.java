/* Given many coins of 3 different face values, print the combination sums of the coins up to 1000. Must be printed in order. 

eg: coins(10, 15, 55) 
print: 
10 
15 
20 
25 
30 
. 
. 
. 
1000

Approach: Dynamic Programming !!
Time Complexity : O(nlogn)
n is the sum (no. of times) search & insert in set
*/

import java.util.*;

class CoinCombinationSum
{
	void findSum(int c1, int c2, int c3)
	{
		Set<Integer> sum = new HashSet<>();
		sum.add(0);

		for(int i=1; i<=1000; i++)
		{
			if(sum.contains(i-c1) || sum.contains(i-c2) || sum.contains(i-c3))
			{
				System.out.println(i);
				sum.add(i);
			}
		}
	}

	public static void main(String args[])
	{
		CoinCombinationSum obj = new CoinCombinationSum();
		obj.findSum(10,15,55);
	}
}