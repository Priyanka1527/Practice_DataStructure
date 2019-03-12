/* Implement QuickSort - 
O(n^2) worst case of array sorted in reverse order
O(nlogn) - average case */

/*QuickSort is useful for sorting arrays 
as many random access needed - MergeSort for LinkedList */

class Quicksort
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

	static void printArray(int[] arr)
	{
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
	}

	static int partition(int[] arr, int l, int h)
	{
		int pivot = arr[h];
		int i= l-1;

		for(int j=l; j<=h-1; j++)
		{
			if(arr[j] <= pivot)
			{
				i++;

				//swap
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		//swap the last
		int temp = arr[i+1];
		arr[i+1] = arr[h];
		arr[h] = temp;

		return i+1;
	}

	static void sort(int[] arr, int l, int h)
	{
		if(l<h)
		{
			int p = partition(arr,l,h);

			sort(arr,l,p-1);
			sort(arr,p+1,h);
		}
	}
}