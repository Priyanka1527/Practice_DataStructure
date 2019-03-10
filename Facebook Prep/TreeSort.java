/* Create BST from an array and sort using Inorder */
/* O(nlogn) avg case and O(n^2) worst case
can be improved using self balancing AVL/RED-BLACK tree */

class Node
{
	int key;
	Node left,right;

	Node(int d)
	{
		key = d;
		left = right = null;
	}
}
class TreeSort
{
	static Node root = null;

	public static void main(String[] args)  
    { 
        int arr[] = {5, 4, 7, 2, 11}; 
        treeIns(arr); 
       	inorderRec(root); 
    } 

    static void treeIns(int[] arr)
    {
    	for(int i=0; i<arr.length; i++)
    		insert(arr[i]);
    }

    static void insert(int key)
    {
    	root = insertRec(root,key);
    }

    static void inorderRec(Node root)  
    { 
        if (root != null)  
        { 
            inorderRec(root.left); 
            System.out.print(root.key + " "); 
            inorderRec(root.right); 
        } 
    }

    static Node insertRec(Node root, int key)
    {
    	if(root == null)
    	{
    		root = new Node(key);
    		return root;
    	}

    	if(key < root.key)
    		root.left = insertRec(root.left,key);
    	else if (key > root.key) 
            root.right = insertRec(root.right, key); 
  
        /* return the root */
        return root;
    }
}