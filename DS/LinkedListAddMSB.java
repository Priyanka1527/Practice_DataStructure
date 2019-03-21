/* You are given two non-empty linked lists representing two non-negative integers. 
The Most significant digit (MSB) comes first and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list. 
Time Complexity = O(m) where m is size of longer list
Reference: https://www.geeksforgeeks.org/sum-of-two-linked-lists/
Here, same hting without using additional List - RECURSION*/

import java.util.*;

class LinkedListAddMSB
{
	static LinkedList<Integer> addList(LinkedList<Integer> num1, LinkedList<Integer> num2)
	{
		LinkedList<Integer> res = new LinkedList<Integer>();
		LinkedList<Integer> shorter = new LinkedList<Integer>();
		LinkedList<Integer> longer = new LinkedList<Integer>();
		int carry = 0;
		int maxlen,minlen;
		if(num1.size() >= num2.size())
		{
			maxlen = num1.size();
			minlen = num2.size();
			shorter = num2;
			longer = num1;
		}
		else
		{
			maxlen = num2.size();
			minlen = num1.size();
			shorter = num1;
			longer = num2;
		}

		//Pad shorter list to same length by adding preceeding 0
		int diff = maxlen - minlen;
		for(int i=0; i<diff; i++)
		{
			shorter.addFirst(0);
		}

		for(int i=maxlen-1; i>=0; i--)
		{
			int temp1 = longer.get(i);
			int temp2 = shorter.get(i);
			int temp3 = temp1 + temp2 + carry;
			carry = 0;

			if(temp3 >= 10)
			{
				carry = (temp3/10)%10;
				temp3 = temp3%10;
			}
			res.addFirst(temp3);
		}

		if(carry > 0)
			res.addFirst(carry);
		
        return res;
	}

	public static void main(String args[])
	{
		LinkedList<Integer> num1 = new LinkedList<Integer>();
		LinkedList<Integer> num2 = new LinkedList<Integer>();
		LinkedList<Integer> res = new LinkedList<Integer>();
		//64957
		num1.add(2);
		num1.add(1);
		num1.add(7);
		// num1.add(5);
		// num1.add(7);

		System.out.println("First Number: " + num1);

		//48
		num2.add(3);
		num2.add(4);

		System.out.println("First Number: " + num2);

		res = addList(num1,num2);
		System.out.println("Result: " + res);
	}
}