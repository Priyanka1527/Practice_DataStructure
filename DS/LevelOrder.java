/* Level Order Traversal of Binary Tree */

/* Time Complexity: O(n^2) for first approach
					O(n) for second using Queue */

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

class LevelOrder
{
	static Node root = null;

	public static void main(String args[])
	{
		root= new Node(1); 
		root.left= new Node(2); 
    	root.right= new Node(3); 
       	root.left.left= new Node(4); 
       	root.left.right= new Node(5); 

       	//naive approach
       	levelOrder1(root);
       	System.out.println();

       	//using queue
       	levelOrder2(root);
       	System.out.println();

	}

	static void levelOrder2(Node root)
	{
		Queue<Node> q = new LinkedList<Node>();

		q.add(root);

		while(!q.isEmpty())
		{
			Node temp= q.poll();
			System.out.print(temp.data + " ");

			if(temp.left != null)
				q.add(temp.left);

			if(temp.right != null)
				q.add(temp.right);
		}
	}

	static int height(Node root)
	{
		if(root == null)
			return 0;

		else
		{
			int lheight = height(root.left);
			int rheight = height(root.right);

			if(lheight>rheight)
				return lheight+1;
			else
				return rheight+1;
		}
	}

	static void traverse(Node root, int level)
	{
		if(root == null)
			return;
		if(level == 1)
			System.out.print(root.data + " ");
		else if(level > 1)
		{
			traverse(root.left,level-1);
			traverse(root.right,level-1);
		}
	}

	static void levelOrder1(Node root)
	{
		int d = height(root);
		for(int i=1; i<=d; i++)
			traverse(root,i);
	}
}