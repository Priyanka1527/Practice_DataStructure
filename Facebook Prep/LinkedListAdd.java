/* You are given two non-empty linked lists representing two non-negative integers. 
The Least significant digit comes first and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list. 
Time Complexity = O(m+n) where m,n are size of 2 lists 
Reference: https://www.geeksforgeeks.org/sum-of-two-linked-lists/
Here, same hting without using additional List - RECURSION*/

class LinkedListAdd
{
	static Node head1, head2;

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

	void printList(Node node)
	{
		while(node != null)
		{
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	Node addList(Node first, Node second)
	{
		Node prev = null;
		Node res = null;
		Node temp = null;
		int carry = 0, sum;

		while(first != null || second != null)
		{
			sum = carry + (first != null ? first.data : 0) + (second != null ? second.data : 0);
			carry = (sum >= 10 ? 1 : 0);
			sum = sum%10;

			temp = new Node(sum);

			if(res == null)
				res = temp;
			else
				prev.next = temp;

			prev = temp;

			if(first != null)
				first = first.next;
			if(second != null)
				second = second.next;
		}

		if(carry > 0)
			temp.next = new Node(carry);

		return res;
	}

	public static void main(String args[])
	{
		LinkedListAdd list = new LinkedListAdd();

		//represents number 64957 - LSB comes first
		list.head1 = new Node(7);
		list.head1.next = new Node(5);
		list.head1.next.next = new Node(9);
		list.head1.next.next.next = new Node(4);
		list.head1.next.next.next.next = new Node(6);

		list.head2 = new Node(8);
		list.head2.next = new Node(4);

		list.printList(head1);
		System.out.println();
		list.printList(head2);
		System.out.println();

		Node result = list.addList(head1,head2);
		System.out.println("Resultant list is : ");
		list.printList(result);
	}
}