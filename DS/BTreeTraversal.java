/* Binary Tree Traversal Inorder,Preorder,Postorder 
- with and without recursion */

/* Time Complexity: O(n) */

import java.util.*;

class Node
{
	int data;
	Node left,right;

	Node(int d)
	{
		data = d;
		left=right=null;
	}
}

class BTreeTraversal
{
	//Recursive Solutions
	static void inRecursion(Node root)
	{
		if(root == null)
			return;

		inRecursion(root.left);
		System.out.print(root.data + " ");
		inRecursion(root.right);
	}

	static void preRecursion(Node root)
	{
		if(root == null)
			return;

		System.out.print(root.data + " ");
		preRecursion(root.left);
		preRecursion(root.right);
	}

	static void postRecursion(Node root)
	{
		if(root == null)
			return;

		preRecursion(root.left);
		preRecursion(root.right);
		System.out.print(root.data + " ");
	}

	//Non-Recursive Solutions
	static void inNoRecursion(Node root)
	{
		if(root == null)
			return;

		Node current = root;
		Stack<Node> stack = new Stack<Node>();

		while(current != null || stack.size() > 0)
		{
			while(current != null)
			{
				stack.push(current);
				current = current.left;
			}

			current = stack.pop();
			System.out.print(current.data + " ");
			current = current.right;
			
		}
	}

	static void preNoRecursion(Node root)
	{
		if(root == null)
			return;

		Stack<Node> stack = new Stack<Node>();
		Node current = root;
		stack.push(current);

		while(!stack.isEmpty())
		{
			current = stack.pop();
			System.out.print(current.data + " ");

			if(current.right != null)
				stack.push(current.right);

			if(current.left != null)
				stack.push(current.left);
		}
	}

	static void postNoRecursion(Node root)
	{
		if(root == null)
			return;

		Stack<Node> stack = new Stack<Node>();
		Node current = root;
		stack.push(current.left);

		while(!stack.isEmpty())
		{
			current = stack.pop();
			System.out.print(current.data + " ");

			if(current.right != null)
				stack.push(current.right);

			if(current.left != null)
				stack.push(current.left);
		}
	}

	public static void main(String args[])
	{
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		System.out.println("Inorder Traversal With Recursion: ");
		inRecursion(root);
		System.out.println();
		System.out.println("Inorder Traversal No Recursion: ");
		inNoRecursion(root);

		System.out.println();
		System.out.println();
		System.out.println("Preorder Traversal With Recursion: ");
		preRecursion(root);
		System.out.println();
		System.out.println("Preorder Traversal No Recursion: ");
		preNoRecursion(root);

		System.out.println();
		System.out.println();
		System.out.println("Postorder Traversal With Recursion: ");
		postRecursion(root);
		System.out.println();
		System.out.println("Postorder Traversal No Recursion: ");
		postNoRecursion(root);
		System.out.println();

	}
}