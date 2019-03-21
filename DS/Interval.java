/* Find total time across a list of array of time intervals e.g.
input = {{1,4}, {6,8}, {2,4}, {7,9}, {10, 15}} will give 11
(1,4) & (2,4) merged to (1,4) = 3
(6,8) & (7,9) merged to (6,9) = 3
(10,15) = 5 , therefore 3+3+5 = 11  Time Complexity : O(nlogn) */

import java.util.*;

class Interval
{
	public static void main(String args[])
	{
		ArrayList<List<Integer>> rangeList = new ArrayList<>();

		rangeList.add(Arrays.asList(1,4));
		rangeList.add(Arrays.asList(6,8));
		rangeList.add(Arrays.asList(2,4));
		rangeList.add(Arrays.asList(7,9));
		rangeList.add(Arrays.asList(10,15));

		ArrayList<List<Integer>> result = mergeInterval(rangeList);

		System.out.println(sumInterval(result));
	}

	public static int sumInterval(ArrayList<List<Integer>> resultList)
	{
		int sum = 0;

		for(int i=0; i<resultList.size(); i++)
		{
			sum = sum + (resultList.get(i).get(1) - resultList.get(i).get(0));
		}
		return sum;
	}


	public static ArrayList<List<Integer>> mergeInterval(ArrayList<List<Integer>> rangeList)
	{
		if(rangeList.isEmpty())
			return rangeList;

		ArrayList<List<Integer>> result = new ArrayList<>();

		//Sort the list in aschending order of start time
		//(1,4) (2,4) (6,8) (7,9) (10,15)
		Collections.sort(rangeList, new Comparator<List<Integer>>() {
			public int compare(List<Integer> interval1, List<Integer> interval2)
			{
				return interval1.get(0) - interval2.get(0);
			}
		});

		List<Integer> first = rangeList.get(0);
		int start = first.get(0);
		int end = first.get(1);

		for(int i=0; i<rangeList.size(); i++)
		{
			List<Integer> current = rangeList.get(i);

			if(current.get(0) <= end)
			{
				end = Math.max(current.get(1), end);
			}
			else
			{
				ArrayList<Integer> temp = new ArrayList<>();
				temp.add(start);
				temp.add(end);
				result.add(temp);
				start = current.get(0);
				end = current.get(1);
			}
		}

		ArrayList<Integer> temp = new ArrayList<>();
		temp.add(start);
		temp.add(end);
		result.add(temp);

		return result;
	}
}