class Cernerlist
{
  Node head;

  static class Node
  {
    char data;
    Node next;

    Node(char d)
    {
      data = d;
      next = null;
    }
  }

  void printList()
  {
    Node n = head;
    while(n != null)
    {
      System.out.print(n.data + " ");
      n = n.next;
    }
  }

  public static void main(String args[])
  {
    Cernerlist cer = new Cernerlist();

    cer.head = new Node('C');
    Node second = new Node('E');
    Node third = new Node('R');
    Node fourth = new Node('N');
    Node fifth = new Node('E');
    Node sixth = new Node('R');

    cer.head.next = second;
    second.next = third;
    third.next = fourth;
    fourth.next = fifth;
    fifth.next = sixth;

    cer.printList();
    System.out.println();
  }
}
