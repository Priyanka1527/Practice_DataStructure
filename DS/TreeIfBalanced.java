/* Implement a function to check if a tree is balanced. 
For the purposes of this question, a balanced tree is defined 
to be a tree such that no two leaf nodes differ in distance from the root by more than one */

import java.lang.*;
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

class TreeIfBalanced
{
	static boolean isBalanced(Node root)
	{
		return ((maxDepth(root) - minDepth(root)) <=1);
	}

	static int maxDepth(Node root)
	{
		if(root == null)
			return 0;

		return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
	}

	static int minDepth(Node root)
	{
		if(root == null)
			return 0;

		return 1+Math.min(minDepth(root.left),minDepth(root.right));
	}

	public static void main(String args[])
	{
		Node root = new Node(10);
		root.left = new Node(11);
		root.right = new Node(12);
		root.left.left = new Node(15);
		root.left.left.left = new Node(20);

		if(isBalanced(root))
			System.out.println("Yes Balanced");
		else
			System.out.println("Not Balanced");	
	}
	

}