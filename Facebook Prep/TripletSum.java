/* 3. Three sum problem. Given an array of numbers, 
write a function to find groups of all three numbers such that their sum is 0. 
The numbers can be repeated.  */

/* First Method: O(n^3) time complexity - using 3 loops
   Second Approach : O(n^2) */

   class TripletSum
   {

   	public static void main(String args[])
   	{
   		int arr[] = {0, -1, 2, -3, 1};
   		System.out.println("Naive Method: ");
   		findSum1(arr);
   		System.out.println();
   		System.out.println("Efficient: ");
   		findSum2(arr);
   		System.out.println();
   	}

   	static void findSum2(int[] arr)
   	{
   		boolean found = false;
   		int n = arr.length;

   		for(int i=0; i<n-1; i++)
   		{
   			int l = i+1;
   			int r = n-1;
   			int k = arr[i];

   			while(l<r)
   			{
   				if(arr[l] + arr[r] + k == 0)
   				{
   					found = true;
   					System.out.println(arr[l] + " " + arr[r] + " " + k);
   					l++;
   					r--;
   				}

   				else if(arr[l] + arr[r] + k < 0)
   					l++;

   				else
   					r--;
   			}
   		}

   		if(found == false)
   			System.out.println("Not Found");
   	}

   	static void findSum1(int[] arr)
   	{
   		boolean found = false;
   		int n = arr.length;

   		for(int i=0; i<n-2; i++)
   		{
   			for(int j=i+1; j<n-1; j++)
   			{
   				for(int k=j+1; k<n; k++)
   				{
   					if(arr[i] + arr[j] + arr[k] == 0)
   					{
   						System.out.println(arr[i] + " " + arr[j]+ " "+ arr[k]);
   						found = true;
   					}

   				}
   			}
   		}

   		if(found == false)
   			System.out.println("Not found");
   	}

   }

