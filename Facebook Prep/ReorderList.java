/* Reorder a Linked List : A->B->C->D->E to A->E->B->D->C */

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

		while(fast != null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
		}

		Node node1 = node;
		Node node2 = slow.next;
		slow.next = null; //mark the end of first list

		node2 = reverseList(node2);

		node = new Node('Z');
		Node curr = node;

		while (node1 != null || node2 != null)
		{
			if(node1 != null)
			{
				curr.next = node1;
				curr = curr.next;
				node1 = node1.next;
			}

			if(node2 != null)
			{
				curr.next = node2;
				curr = curr.next;
				node2 = node2.next;
			}
		}

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