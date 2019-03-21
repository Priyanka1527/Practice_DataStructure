/* Given an array A[] consisting 0s, 1s and 2s, write a function that sorts A[]. 
It should put all 0s first, all 1s and all 2s in last */

/* Time Complexity:  O(n)
Extra space for HashMap in case of assign category approach */

import java.util.*;
class DutchNationalFlag
{
	public static void main(String args[])
	{
		int[] arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		int n = arr.length;
		System.out.println("Original Array: ");
		printArray(arr,n);
		System.out.println();
		arrange(arr,n);
		System.out.println("After Seggregation: ");
		printArray(arr,n);
		System.out.println();

		int[] a = {2,3,9,5,1,7,8,1,1,2,9,4};
		int n2 = a.length;
		HashMap<Integer,String> map = new HashMap<Integer,String>();

		for(int i=0; i<n2; i++)
		{
			if(a[i] >= 0 && a[i] <= 3)
				map.put(a[i],"low");
			else if(a[i] >= 4 && a[i] <= 6)
				map.put(a[i],"med");
			else
				map.put(a[i],"high");
		}

		System.out.println("Original Array: ");
		printArray(a,n2);
		System.out.println();
		arrangeCategory(a,n2,map);
		System.out.println("After Seggregation: ");
		printArray(a,n2);
		System.out.println();
	}

	static void arrangeCategory(int[] a, int n2, HashMap<Integer,String> map)
	{
		int l=0;
		int m=0;
		int h=n2-1;

		while(m <= h)
		{
			switch(map.get(a[m]))
			{
				//replace with low since 0 need to be put 1st
				case "low":
					{
						int temp = a[l];
						a[l] = a[m];
						a[m] = temp;
						l++;
						m++;
						break;
					}

				//1 should be in middle so move on
				case "med":
					m++;
					break;

				//replace with high since 2 should be in last
				case "high":
					{
						int temp = a[h];
						a[h] = a[m];
						a[m] = temp;

						h--;
						break;
					}
			}
		}

	}

	static void printArray(int[] arr, int n)
	{
		for(int i=0; i<n; i++)
			System.out.print(arr[i] + " ");
	}

	static void arrange(int[] arr, int n)
	{
		int l=0;
		int m=0;
		int h=n-1;

		while(m <= h)
		{
			switch(arr[m])
			{
				//replace with low since 0 need to be put 1st
				case 0:
					{
						int temp = arr[l];
						arr[l] = arr[m];
						arr[m] = temp;
						l++;
						m++;
						break;
					}

				//1 should be in middle so move on
				case 1:
					m++;
					break;

				//replace with high since 2 should be in last
				case 2:
					{
						int temp = arr[h];
						arr[h] = arr[m];
						arr[m] = temp;

						h--;
						break;
					}
			}
		}
	}
}