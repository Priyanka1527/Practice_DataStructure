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

Source: https://www.programcreek.com/2014/04/leetcode-binary-tree-vertical-order-traversal-java/
Using Hash Map, Time complexity : O(nlogn) */

import java.util.*;

class BTreeVerticalLevelOrder
{
	static class Node
	{
		int val;
		Node left,right;

		Node(int data)
		{
			val = data;
			left = right = null;
		}
	}

	static List<List<Integer>> printBTree(Node root)
	{
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

		int maxlevel = 0;
		int minlevel = 0;

		LinkedList<Node> queue = new LinkedList<Node>();
		LinkedList<Integer> level = new LinkedList<Integer>();

		queue.offer(root);
		level.offer(0);

		while(!queue.isEmpty())
		{
			Node p = queue.poll();
			int l = level.poll();

			//This to keep track so that it could be printed later
			minlevel = Math.min(minlevel, l);
			maxlevel = Math.max(maxlevel, l);

			if(map.containsKey(l))
			{
				map.get(l).add(p.val);
			}
			else
			{
				ArrayList<Integer> new_list = new ArrayList<Integer>();
				new_list.add(p.val);
				map.put(l, new_list);
			}

			if(p.left != null)
			{
				queue.offer(p.left);
				level.offer(l-1);
			}

			if(p.right != null)
			{
				queue.offer(p.right);
				level.offer(l+1);
			}
		}

		for(int i=minlevel; i<=maxlevel; i++)
		{
			if(map.containsKey(i))
				result.add(map.get(i));
		}

		return result;
	}

	public static void main(String args[])
	{
		List<List<Integer>> res = new ArrayList<List<Integer>>();
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

		res = printBTree(root);

		System.out.println(res);

	}
}