//Worst Case: O(n^2), array sorted in ascending/descending order and pivot is always greatest/smallest element
//Best Case: O(nlogn), partition process always picks the middle element as pivot
//Average Case: O(nlogn)

//QuickSort is faster in practice, because its inner loop can be efficiently implemented on most architectures, and in most real-world data
//QuickSort can be implemented in different ways by changing the choice of pivot, so that the worst case rarely occurs for a given type of data

//However, merge sort is generally considered better when data is huge and stored in external storage.
//Extra space in Merge sort increases running time of Algorithm - Quicksort preferred for Arrays

//Unlike array, in linked list, we can insert items in the middle in O(1) extra space and O(1) time,
//merge operation can be implemented without extra space for linked lists - Mergesort preferred for Linked List

class Quicksort
{
  void quickSort(int a[],int l,int r)
  {
    if(l < r)
    {
      //find the middle element to divide the array
      int p = partition(a,l,r);

      quickSort(a,l,p-1);
      quickSort(a,p+1,r);
    }
  }

  int partition(int a[],int l,int r)
  {
    int i = l-1;
    //choose the initial pivot as the last element in the array
    int pivot = a[r];

    for(int j=l; j<r; j++)
    {
      if(a[j] <= pivot)
      {
        i++;

        //swap a[i] and a[j]
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
      }
    }

    //swap a[i+1] and a[r]
    int t = a[i+1];
    a[i+1] = a[r];
    a[r] = t;

    //return pivot
    return i+1;
  }

  //print the array
  void printArray(int a[])
  {
    for(int i=0; i < a.length; i++)
      System.out.print(a[i] + " ");
  }

  //driver method
  public static void main(String args[])
  {
    int a[] = {10, 80, 30, 90, 40, 50, 70};
    int len = a.length;
    Quicksort obj = new Quicksort();

    System.out.println("Original Array: ");
    obj.printArray(a);

    obj.quickSort(a,0,len-1);

    System.out.println("\n\nSorted Array: ");
    obj.printArray(a);
    System.out.println("\n");
  }
}
