/* Check if a Binary Tree is a BST or not */
/* Time complexity: O(n) & O(1) auxiliary for stack */

class Node 
{ 
    int data; 
    Node left, right; 
  
    Node(int item) 
    { 
        data = item; 
        left = right = null; 
    } 
} 

class BSTCheck
{
	static Node root = null;

	public static void main(String args[])
	{
		root = new Node(3); 
        root.left = new Node(2); 
      	root.right = new Node(5); 
        root.left.left = new Node(1); 
       	root.left.right = new Node(4); 
  
        if (isBST(root,null,null)) 
            System.out.println("IS BST"); 
        else
            System.out.println("Not a BST"); 
	}

	static boolean isBST(Node root, Node left, Node right)
	{
		if(root == null)
			return true;

		if(left != null && root.data<left.data)
			return false;

		if(right != null && root.data>right.data)
			return false;

		return (isBST(root.left,left,root) && isBST(root.right,root,right));
	}
}