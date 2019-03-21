/* Given two sorted arrays, write a function 
to find the kth smallest element among both the arrays. */

/*NO EXTRA SPACE could be used */

class TwoSortedArrayMerge
{
	public static void main(String args[])
	{
		int arr1[] = {100, 112, 256, 349, 770};
		int arr2[] = {72, 86, 113, 119, 265, 445, 892};

		int m = arr1.length;
		int n = arr2.length;

		int k = 7;

		int res = findElement(arr1,arr2,m,n,k);

		System.out.println("Kth element is: " + res);
	}

	static int findElement(int[] arr1,int[] arr2,int m,int n,int k)
	{
		int i=0,j=0,d=0;

		while(i<m && j<n)
		{
			if(arr1[i] < arr2[j])
			{
				if(++d == k)
					return arr1[i];
				i++;
			}
			else
			{
				if(++d == k)
					return arr2[j];
				j++;
			}
			
		}

		while(i<m)
		{
			if(++d == k)
				return arr1[i];
			i++;
		}

		while(j<n)
		{
			if(++d == k)
				return arr2[j];
			j++;
		}

		return -1;
	}
}