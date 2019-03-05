/* Given a sorted (increasing order) array, write an algorithm 
to create a binary tree with minimal height. */

class Node
{
	int val;
	Node left,right;

	Node(int d)
	{
		val = d;
		left = right = null;
	}
}

class ArrayToBTree
{
	public static void main(String args[])
	{
		int[] arr = {3,4,5,7,10,15,17};
		Node root = createTree(arr);

		printBinaryTree(root,0);
		
	}

	//way to print a Binary Tree
	public static void printBinaryTree(Node root, int level)
	{
	    if(root==null)
	         return;
	    printBinaryTree(root.right, level+1);

	    if(level!=0)
	    {
	        for(int i=0;i<level-1;i++)
	            System.out.print("|\t");
	            System.out.println("|-------"+root.val);
	    }
	    else
	        System.out.println(root.val);
			printBinaryTree(root.left, level+1);
	} 

	//main function to create tree
	static Node createTree(int[] arr)
	{
		return madeTree(arr, 0, arr.length-1);
	}

	//Actual recursion happens here
	static Node madeTree(int[] arr, int start, int end)
	{
		if (end<start)
			return null;

		int mid = (start+end)/2;
		Node root = new Node(arr[mid]);

		root.left = madeTree(arr,start,mid-1);
		root.right = madeTree(arr,mid+1,end);

		return root;
	}
}