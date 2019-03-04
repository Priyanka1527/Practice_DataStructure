/* Given an array of integers, find the combination of numbers from the array
adding up to a said Number.

For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3]

Two Approaches possible : DFS(Recursion) and DP(https://www.geeksforgeeks.org/subset-sum-problem-dp-25/)

-- If we need all the combinations use DFS, for best result use DP 
-- Also, could be a variation of printing pairwise sum */

import java.util.*;
class CombinationSum
{
	public static void main(String args[])
	{
		int[] arr = {6,4,2,8};
		int sum = 8;
		Arrays.sort(arr);

		printPairs(arr,sum); //O(n) where n is the size of candidate set + O(nlogn) for sort

		//Now starts the Recursion approach
		List<Integer> ar = new ArrayList<Integer>();
		ar.add(6);
		ar.add(4);
		ar.add(2);
		ar.add(8);

		List<List<Integer>> res = combinationSum(ar,sum);

		//Print the result
		if(res.size() == 0)
			System.out.println("Empty!!");

		for(int i=0; i<res.size(); i++)
		{
			System.out.print("(");
			List<Integer> temp = res.get(i);
			for(int j=0; j<temp.size(); j++)
				System.out.print(temp.get(j) + " ");
			System.out.print(")");
			System.out.println();
		}

	}

	static List<List<Integer>> combinationSum(List<Integer> ar, int sum)
	{
		Collections.sort(ar);
		List<Integer> r = new ArrayList<Integer>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		findNumbers(ar,sum,res,r,0);
		return res;
	}

	static void findNumbers(List<Integer> ar, int sum, List<List<Integer>> res, List<Integer> r, int i)
	{
		if(sum < 0)
			return;

		if(sum == 0)
		{
			res.add(new ArrayList<Integer>(r));
			return;
		}

		while(i<ar.size() && sum-ar.get(i) >= 0)
		{
			r.add(ar.get(i));
			findNumbers(ar,sum-ar.get(i),res,r,i);
			i++;

			//remove number from list (backtracking)
			r.remove(r.size() - 1);
		}
	}

	static void printPairs(int[] arr, int sum)
	{
		int first = 0;
		int last = arr.length - 1;

		while(first < last)
		{
			int s = arr[first] + arr[last];

			if(s == sum)
			{
				System.out.println(arr[first] + " " + arr[last]);
				first++;
				last--;
			}

			else if(s < sum)
				first++;
			else
				last --;
		}
	}
}