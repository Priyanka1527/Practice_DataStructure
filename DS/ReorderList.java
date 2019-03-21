/* Reorder a Linked List : A->B->C->D->E to A->E->B->D->C */
/* O(n) */

class ReorderList {
	static Node head;

	//Node data structure
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

	//print the linked list
	void printList(Node node)
	{
		if(node == null)
		{
			return;
		}
		while(node != null)
		{
			System.out.print(node.data + "->");
			node = node.next;
		}
	}

	//reverse the linked list
	Node reverseList(Node node)
	{
		Node prev = null, curr = node, next;

		while(curr != null)
		{
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		node = prev;
		return node;
	}

	//reorder the linked list
	void reOrder(Node node)
	{
		Node slow = node, fast = slow.next;


        // 1) Find the middle point using tortoise and hare method 
		while(fast != null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
		}
		// 2) Split the linked list in two halves 
        // node1, head of first half    1 -> 2 -> 3 
        // node2, head of second half   4 -> 5 
		Node node1 = node;
		Node node2 = slow.next;
		slow.next = null; //mark the end of first list
		// 3) Reverse the second half, i.e., 5 -> 4 
		node2 = reverseList(node2);
		// 4) Merge alternate nodes 
		node = new Node('Z'); //dummy node

		// curr is the pointer to this dummy Node, which will 
        // be used to form the new list 
		Node curr = node;

		// First add the element from first list 
		while (node1 != null || node2 != null)
		{
			if(node1 != null)
			{
				curr.next = node1;
				curr = curr.next;
				node1 = node1.next;
			}

			// Then add the element from second list 
			if(node2 != null)
			{
				curr.next = node2;
				curr = curr.next;
				node2 = node2.next;
			}
		}

		// Assign the head of the new list to head pointer 
		node = node.next;
	}

	public static void main(String args[])
	{
		ReorderList list = new ReorderList();
		list.head = new Node('A');
		list.head.next = new Node('B');
		list.head.next.next = new Node('C');
		list.head.next.next.next = new Node('D');
		list.head.next.next.next.next = new Node('E');

		list.printList(head);
		list.reOrder(head);
		System.out.println();
		list.printList(head);
	}

}