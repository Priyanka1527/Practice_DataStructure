/* Implement Merge Sort - O(nlogn) */

class MergeSort
{
	public static void main(String args[])
	{
		int arr[] = {12, 11, 13, 5, 6, 7}; 
		System.out.println("Original Array: ");
		printArray(arr);
		System.out.println();
		System.out.println("Sorted Array: ");
		sort(arr,0,arr.length-1);
		printArray(arr);
		System.out.println();
	}

	static void merge(int[] arr, int l, int m, int r)
	{
		int n1 = m-l+1;
		int n2 = r-m;

		int[] L = new int[n1];
		int[] R = new int[n2];

		for(int i=0; i<n1; i++)
			L[i] = arr[l+i];
		for(int j=0; j<n2; j++)
			R[j] = arr[m+1+j];

		int i = 0, j=0, k=l;

		//merge left and right sub array
		while(i<n1 && j<n2)
		{
			if(L[i] < R[j])
			{
				arr[k] = L[i];
				i++;
			}
			else
			{
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		//merge remaining
		while(i<n1)
		{
			arr[k] = L[i];
			i++;
			k++;
		}

		while(j<n2)
		{
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	static void sort(int[] arr, int l, int r)
	{
		if(l<r)
		{
			int mid = (l+r)/2;

			sort(arr,l,mid);
			sort(arr,mid+1,r);

			merge(arr,l,mid,r);
		}

	}

	static void printArray(int[] arr)
	{
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
	}
}