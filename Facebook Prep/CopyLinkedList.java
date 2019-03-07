/* Copy a Linked List with next and Random pointer.
Random pointer included to actually prove that it has copied the original LL
as it is, not just sequentially */

/* Method1: Time Complexity: O(n) Space Complexity: O(n)
   Method2: Time Complexity: O(n) Space COmplexity: O(1)
   https://www.geeksforgeeks.org/clone-linked-list-next-random-pointer-o1-space/
    */

   import java.util.*;

   class Node
   {
   	int data;
   	Node next, random;

   	Node(int d)
   	{
   		data = d;
   		next = random = null;
   	}
   }

   class LinkedList
   {
   	Node head;

   	LinkedList(Node start)
   	{
   		head = start;
   	}

   	void push(int data)
   	{
   		Node node = new Node(data);
   		node.next = head;
   		head = node;
   	}

   	void printList()
   	{
   		Node temp = head;
   		while(temp != null)
   		{
   			Node random = temp.random;
   			int randomData = (random != null) ? random.data : -1;
   			System.out.println("Data: " + temp.data + " , " + "Random: " + randomData);
   			temp = temp.next;
   		}
   	}

   	public LinkedList clone()
   	{
   		Node orig = head, copy = null;

   		Map<Node,Node> map = new HashMap<Node,Node>();

   		while(orig != null)
   		{
   			copy = new Node(orig.data);
   			map.put(orig,copy);
   			orig = orig.next;
   		}

   		orig = head;

   		while(orig != null)
   		{
   			copy = map.get(orig);
   			copy.next = map.get(orig.next);
   			copy.random = map.get(orig.random);
   			orig = orig.next;
   		}

   		return new LinkedList(map.get(head));
   	}

   }

   class CopyLinkedList
   {
   	public static void main(String args[])
   	{
   		LinkedList list = new LinkedList(new Node(5));
   		list.push(4); 
        list.push(3); 
        list.push(2); 
        list.push(1); 
  
        // Setting up random references. 
        list.head.random = list.head.next.next; 
        list.head.next.random = list.head.next.next.next; 
        list.head.next.next.random = list.head.next.next.next.next; 
        list.head.next.next.next.random = list.head.next.next.next.next.next; 
        list.head.next.next.next.next.random = list.head.next;

        LinkedList clone = list.clone();

        System.out.println("Original linked list"); 
        list.printList(); 
        System.out.println("\nCloned linked list"); 
        clone.printList(); 

   	}

   }