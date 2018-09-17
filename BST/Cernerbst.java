class Cernerbst
{
  static Node root;

  Cernerbst()
  {
    root = null;
  }

  static class Node
  {
    char key;
    Node left, right;

    Node(char data)
    {
      key = data;
      left=right = null;
    }
  }

  Node insert(Node root, char key)
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
    /* Create the below BST for CERN:
    usually BST doesn't allow duplicate, but you can add Two more inputs after 'N' i.e. E and R
    then same procedure will give C E R N E R

                C
                 \
                  E
                   \
                    R
                  /
                N

                */
    Cernerbst tree = new Cernerbst();

    root = tree.insert(root,'C');
    root = tree.insert(root,'E');
    root = tree.insert(root,'R');
    root = tree.insert(root,'N');

    System.out.println("Pre Order Traversal gives: ");
    tree.preorder(root);
    System.out.println();
  }
}
