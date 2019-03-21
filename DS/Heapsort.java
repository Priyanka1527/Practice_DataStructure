/*Implement Heap Sort - O(nlogn) */

class Heapsort
{
	static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    } 
  
    // Driver program 
    public static void main(String args[]) 
    { 
        int arr[] = {12, 11, 13, 5, 6, 7}; 
        int n = arr.length; 
        System.out.println("Actual array is"); 
        printArray(arr);
 
        sort(arr,n); 
  
        System.out.println("Sorted array is"); 
        printArray(arr); 
    } 

    static void heapify(int[] arr, int n, int i)
    {
    	int largest = i;
    	int l = 2*i + 1;
    	int r = 2*i + 2;

    	//if left child is greater than root
    	if(l<n && arr[l]>arr[largest])
    		largest = l;

    	//if right child is greater than root
    	if(r<n && arr[r]>arr[largest])
    		largest = r;

    	if(largest != i)
    	{
    		int temp = arr[i];
    		arr[i] = arr[largest];
    		arr[largest] = temp;

    		//heapify the affected sub-tree
    		heapify(arr,n,largest);
    	}

    }

    static void sort(int[] arr, int n)
    {
    	//Build Heap rearranging the array
    	for(int i=n/2-1; i>=0; i--)
    		heapify(arr,n,i);

    	//from max heap delete root and swap with last element
    	//then heapify
    	for(int i=n-1; i>=0; i--)
    	{
    		int temp = arr[i];
    		arr[i] = arr[0];
    		arr[0] = temp;

    		heapify(arr,i,0);
    	}
    }
}