/* You are in a party of N people, where only one person is known to everyone. Such a person may be present in the party, if yes, (s)he doesn’t know anyone in the party. Your task is to find the stranger (celebrity) in party.
You will be given a square matrix M[][] where if an element of row i and column j  is set to 1 it means ith person knows jth person. You need to complete the function getId() which finds the id of the celebrity if present else return -1. The function getId() takes two arguments, the square matrix M and its size N.

Note: Expected time complexity is O(N) with constant extra space. */

/* O(n) Time complexity with auxiliary space for Stack O(n) - n is no. of people */

import java.util.Stack;

class Celebrity
{
	public static void main(String[] args)
	{
		int m[][] = { { 0, 0, 0, 0 }, 
                      { 1, 0, 0, 0 }, 
                      { 1, 0, 0, 0 },  
                      { 1, 0, 0, 0 } }; 

        int n = 4;

        int result = findCeleb(m,n);

        if(result == -1)
        	System.out.println("No Celebrity");
        else
        	System.out.println("Person " + (result+1) + " is a Celebrity");
	}

	static boolean knows(int a, int b, int m[][])
	{
		if(m[a][b] == 1)
			return true;
		else
			return false;
	}

	static int findCeleb(int m[][], int n)
	{
		Stack<Integer> st = new Stack<>();
		int c;

		for(int i=0; i<n; i++)
		{
			st.push(i);
		}

		while(st.size() > 1)
		{
			int a = st.pop();
			int b = st.pop();

			if (knows(a,b,m))
				st.push(b);
			else
				st.push(a);
		}

		c = st.pop();

		//Check if the last person knows anyone or if there is anybody who doesn't know c
		for(int i=0; i<n; i++)
		{
			if(i != c && (knows(c,i,m) || !knows(i,c,m)))
				return -1;
		}

		return c;
	}
}