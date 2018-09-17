class Linkedlist
{
  Node head;

  static class Node
  {
    int data;
    Node next;

    Node(int d)
    {
      data = d;
      next = null;
    }
  }

  //insert node in the beginning
  void inserBeg(int d)
  {
    Node new_node = new Node(d);

    new_node.next = head;
    head = new_node;
  }

//insert node after a particular node
  void insertAfter(Node prev_node, int d)
  {
    Node new_node = new Node(d);

    new_node.next = prev_node.next;
    prev_node.next = new_node;
  }

//insert node in the end of the linked list
  void insertLast(int d)
  {
    if(head == null)
    {
      head = new Node(d);
      return;
    }

    Node new_node = new Node(d);

    Node last = head;
    while(last.next != null)
      last = last.next;

    last.next = new_node;
  }

//traversing linked list
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
    Linkedlist llist = new Linkedlist();
    llist.head = new Node(12);
    Node second = new Node(15);
    Node third = new Node(20);

    llist.head.next = second;
    second.next = third;

    llist.printList();
    System.out.println();

    llist.inserBeg(90);
    llist.printList();
    System.out.println();

    llist.insertAfter(second,75);
    llist.printList();
    System.out.println();

    llist.insertLast(100);
    llist.printList();
    System.out.println();
  }
}
