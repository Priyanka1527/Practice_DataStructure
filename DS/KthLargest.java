/* Find the Kth largest element in an array */

/* (Kth Largest in Min Heap): We can use a min heap to solve this problem. 
The heap stores the top k largest elements.The top of the heap is the Kth Largest element 
and all other elements are greater than the heap top. Whenever the size is greater than k, 
delete the min. Time complexity is O(nlog(k)). Space complexity is O(k) for storing the 
top k numbers.

(Kth Smallest in Min-Heap): Create a min heap of k elements. after that
perform extractMin i.e. delete root and replace with last element & heapify.
After kth extraction, we'll get kth smallest.
1. First create one Priority Queue
2. Insert all elements to this priority queue
3. Extract elements one by one from this priority queue. 
The kth element extracted is the kth smallest element

We use PriorityQueue library function to implement min heap in java.
By Default, min heap is implemented. for Max heap, use Collections.reverseOrder()

QuickSelect : We partition the array based on pivot. For largest element,
look through right half of the array, for smallest check in left half.


	
/* 	Sorting : O(nlogn) 
	Using Min-Heap : O(nlogk) and O(k) meomry for heap
   	Using QuickSelect Shuffle : O(n) */

import java.util.*;
class KthLargest
{
	public static void main(String args[])
	{
		int[] nums = {1,3,6,5,2,9};
		int k = 2;

		//should be 6
		System.out.println("Kth Largest element(Min-Heap): " + findKthLargest(nums,k));
		System.out.println("Kth Largest element(QuickSelect): " + selectKthLargest(nums,k));
		System.out.println();
		//should be 2
		System.out.println("Kth smallest element(Min-Heap): " + findKthSmallest(nums,k));
		System.out.println("Kth smallest element(QuickSelect): " + selectKthSmallest(nums,k));
	}

	//QUICKSELECT

	static int partition(int[] nums, int low, int high)
	{
		Random rand = new Random();
		int pivotIndex = rand.nextInt((high - low) + 1) + low;

		int pivotValue = nums[pivotIndex];
		swap(nums,pivotIndex,high);

		int firstIndex = low;

		for(int i=low; i<=high-1; i++)
		{
			if(nums[i] < pivotValue)
			{
				swap(nums,firstIndex,i);
				firstIndex++;
			}
		}

		swap(nums,high,firstIndex);
		return firstIndex;
	}

	static void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    static int select(int[] nums, int left, int right, int k)
    {
    	if(left == right)
    		return nums[left];

    	int pivotIndex = partition(nums, left, right);

        if (pivotIndex == k)
        	return nums[pivotIndex];
        else if (pivotIndex < k)
            return select(nums, pivotIndex + 1, right, k);
        else
            return select(nums, left, pivotIndex - 1, k);
    }

	static int selectKthLargest(int[] nums, int k)
	{
		if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            return 0;
        }
        //nums.length-k is the length of right subarray since leargest element
        return select(nums, 0, nums.length - 1, nums.length - k);
	}

	static int selectKthSmallest(int[] nums, int k)
	{
		if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            return 0;
        }
        //nums.length-k is the length of right subarray since leargest element
        return select(nums, 0, nums.length - 1, k-1);
	}

	//MIN HEAP

	static int findKthSmallest(int[] nums, int k)
	{
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<nums.length; i++)
			pq.offer(nums[i]);

		int current = 0;
		while(k > 0)
		{
			current = pq.poll();
			k--;
		}
		return current;
	}

	static int findKthLargest(int[] nums, int k)
	{
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int val : nums)
		{
			pq.offer(val);

			if(pq.size() > k)
			{
				pq.poll();
			}
		}
		return pq.peek();
	}
}