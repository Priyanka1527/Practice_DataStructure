/* Reverse a Linked List - O(n) and space O(1) */

class LinkedList
{
	int data;
	LinkedList next;

	LinkedList(int d)
	{
		data = d;
		next = null;
	}
}
class ReverseLinkedList
{
	static LinkedList head = null;
	public static void main(String args[])
	{
		head = new LinkedList(85);
		head.next = new LinkedList(15);
		head.next.next = new LinkedList(4);
		head.next.next.next = new LinkedList(20);

		System.out.println("Original List: ");
		printList(head);
		System.out.println();

		System.out.println("Reverse List: ");
		head = reverseList(head);
		printList(head);
		System.out.println();
	}

	static LinkedList reverseList(LinkedList node)
	{
		LinkedList prev = null;
		LinkedList current = node;
		LinkedList next = null;

		while(current != null)
		{
			next = current.next;
			current.next = prev;

			prev = current;
			current = next;
		}

		node = prev;
		return node;
	}

	static void printList(LinkedList node)
	{
		while(node != null)
		{
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
}