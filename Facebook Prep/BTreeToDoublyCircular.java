/* Convert a binary tree to a doubly linked circular linked list
- use Inorder Traversal !! */

/* Algorithm:

- The left and right pointers in nodes are to be used as previous and next pointers respectively in converted Circular Linked List.
- The order of nodes in List must be same as Inorder of the given Binary Tree.
- The first node of Inorder traversal must be head node of the Circular List.

Example:

		 10
		/   \
	   12    15
	  /  \   /
	 25  30  36


	 25-12-30-10-36-15

	 Inorder Traversal, hence Time complexity is O(n) -> n is no. of nodes */

	 // Class structure for the Binary Tree
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

	 class BTreeToDoublyCircular
	 {
	 	//root is of BTree and head,tail are of created DLL
	 	Node root, head, tail; 
	 	Node prev = null; //could be made static

	 	void toCDLL(Node root)
	 	{
	 		//base case
	 		if(root == null)
	 			return;

	 		//recursive conversion of left subtree
	 		toCDLL(root.left);

	 		//conversion of current node
	 		if(prev == null)
	 			head = root;
	 		else
	 		{
	 			root.left = prev;
	 			prev.right = root;
	 		}

	 		prev = root;

	 		//recursive conversion of right subtree
	 		toCDLL(root.right);

	 		//assigning tail
	 		if(root != null && root.right == null)
	 			tail = root;
	 	}

	 	void printCDLL(Node node)
	 	{
	 		Node head = node;
	 		do
	 		{
	 			System.out.print(node.data + " ");
	 			node = node.right;
	 		}while(node.data != head.data); //stop when encounter equal node
	 	}

	 	public static void main(String args[])
	 	{
	 		BTreeToDoublyCircular tree = new BTreeToDoublyCircular();
	 		tree.root = new Node(10);
	 		tree.root.left = new Node(12);
	 		tree.root.right = new Node(15);
	 		tree.root.left.left = new Node(25);
	 		tree.root.left.right = new Node(30);
	 		tree.root.right.left = new Node(36);

	 		tree.toCDLL(tree.root);

	 		tree.tail.right = tree.head;
	 		tree.head.left = tree.tail;

	 		tree.printCDLL(tree.head);

	 		System.out.println();
	 	}
	 }