/* Convert a Binary Tree to BST preserving the tree structure */
/* Also a Tree Sort way to sort the Binary Tree */
/* Time complexity: O(nlogn) auxiliary space set : O(n) */

import java.util.*;

class Node
{
	int data;
	Node left,right;

	Node(int d)
	{
		data = d;
		left = right = null;
	}
}

class BTreeToBST
{
	static Node root = null;

	static void addToSet(Node root, Set<Integer> set)
	{
		if(root == null)
			return;

		addToSet(root.left,set);
		set.add(root.data);
		addToSet(root.right,set);
	}

	static void placeKeys(Node root, Iterator<Integer> it)
	{
		if(root == null)
			return;

		placeKeys(root.left,it);
		root.data = it.next();
		placeKeys(root.right,it);
	}

	static void printBST(Node root)
	{
		if(root == null)
			return;

		printBST(root.left);
		System.out.print(root.data + " ");
		printBST(root.right);
	}

	public static void main(String args[])
	{
		/* Construct below tree
			  8
			/   \
		   /	 \
		  3	      5
		 / \	 / \
		/   \   /   \
	   10	 2  4	 6   */

	   root = new Node(8);
	   root.left = new Node(3);
	   root.right = new Node(5);
	   root.left.left = new Node(10);
	   root.left.right = new Node(2);

	   root.right.left = new Node(4);
	   root.right.right = new Node(6);

	   //Traverse the original tree and extract the keys
	   Set<Integer> set = new TreeSet<>();
	   addToSet(root,set);

	   //take they keys and convert to BST
	   //We will place the keys Inorder way retrieving from set
	   Iterator<Integer> it = set.iterator();
	   placeKeys(root,it);

	   //Inorder traversal
	   printBST(root);
	   System.out.println();
	}
}