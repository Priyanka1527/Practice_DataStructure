/* Given the root of a binary tree containing integers, print the columns of the tree in order with the nodes in each column printed top-to-bottom.


Input:
      6
     / \
    3   4
   / \   \
  5   1   0
 / \     /
9   2   8
     \
      7

Output:
9 5 3 2 6 1 7 4 8 0

Need to use Level order traversal for storing the order
Source: https://www.programcreek.com/2014/04/leetcode-binary-tree-vertical-order-traversal-java/
Using Hash Map, Time complexity : O(nlogn) */

import java.util.TreeMap;
import java.util.Vector;
import java.util.Map.Entry;

class BinaryTreeColumnWise
{
	static class Node
	{
		int data;
		Node left, right;

		Node(int d)
		{
			data = d;
			left = right = null;
		}
	}

	static void getColumn(Node root, int hd, TreeMap<Integer,Vector<Integer>> m)
	{
		if(root == null)
			return;

		Vector<Integer> get = m.get(hd);

		if(get == null)
		{
			get = new Vector<>();
			get.add(root.data);
		}
		else
			get.add(root.data);

		m.put(hd,get);

		getColumn(root.left, hd-1, m);
		getColumn(root.right, hd+1, m);
	}
	static void printTree(Node root)
	{
		TreeMap<Integer,Vector<Integer>> m = new TreeMap<>();
		int hd = 0;

		getColumn(root,hd,m);

		//Print on Traversal
		for (Entry<Integer,Vector<Integer>> entry : m.entrySet()) 
        { 
            System.out.println(entry.getValue()); 
        } 
	}

	public static void main(String args[])
	{
		Node root = new Node(6);
		root.left = new Node(3);
		root.right = new Node(4);
		root.right.right = new Node(0);
		root.right.right.left = new Node(8);
		root.left.left = new Node(5);
		root.left.right = new Node(1);
		root.left.left.left = new Node(9);
		root.left.left.right = new Node(2);
		root.left.left.right.right = new Node(7);

		printTree(root);

	}
}