class Binarysearchtree
{
  static Node root;

  Binarysearchtree()
  {
    root = null;
  }

  static class Node
  {
    int key;
    Node left, right;

    Node(int data)
    {
      key = data;
      left = right = null;
    }
  }

  Node insert(Node root,int key)
  {
    if(root == null)
    {
      root = new Node(key);
      return root;
    }

    if(key < root.key)
      root.left = insert(root.left,key);
    else
      root.right = insert(root.right,key);

    return root;
  }

  void inorder(Node root)
  {
    if(root != null)
    {
      inorder(root.left);
      System.out.print(root.key + " ");
      inorder(root.right);
    }
  }

  void postorder(Node root)
  {
    if(root != null)
    {
      postorder(root.left);
      postorder(root.right);
      System.out.print(root.key + " ");
    }
  }

  void preorder(Node root)
  {
    if(root != null)
    {
      System.out.print(root.key + " ");
      preorder(root.left);
      preorder(root.right);
    }
  }

  public static void main(String args[])
  {
    /* Create the below Binary Search Tree:
            40
          /   \
        25      78
      /  \
    10    32

    */

    Binarysearchtree bst = new Binarysearchtree();
    bst.root = new Node(40);
    root = bst.insert(root,25);
    root = bst.insert(root,10);
    root = bst.insert(root,32);
    root = bst.insert(root,78);

    //inorder traversal produce sorted list: 10 25 32 40 78
    System.out.println("In Order: ");
    bst.inorder(root);
    System.out.println("\n");

    //postorder traversal will give: 10 32 25 78 40
    System.out.println("Post Order: ");
    bst.postorder(root);
    System.out.println("\n");

    //preorder traversal will give: 40 25 10 32 78
    System.out.println("Pre Order: ");
    bst.preorder(root);
    System.out.println();
  }
}
