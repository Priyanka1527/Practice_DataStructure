/* Find the length of longest increasing subarray */
/* Time Complexity: O(n) */

class LongestIncreasingSubArray
{
	public static void main(String args[])
	{
		int[] arr = {5, 6, 3, 5, 7, 8, 9, 1, 2};
		findLongest(arr);
		System.out.println();
	}

	static void findLongest(int[] arr)
	{
		int index=0, max = 1, len = 1;

		for(int i=1; i<arr.length; i++)
		{
			if(arr[i] > arr[i-1])
				len++;
			else
			{
				if(len > max)
				{
					max = len;
					index = i - max;
				}

				len = 1;
			}
		}

		if(len > max)
		{
			max = len;
			index = arr.length - max;
		}

		System.out.println("Length of longest increasing subarray: " + max);
		System.out.println("The Longest Increasing Subarray: ");
		for(int j=index; j<index+max; j++)
			System.out.print(arr[j] + " ");

	}
}