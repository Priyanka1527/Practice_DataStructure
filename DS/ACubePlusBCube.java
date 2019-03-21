/* Write all solutions for a^3+b^3 = c^3 + d^3 
   Time Complexity: O(n^2) --hashMap */

/* Example: if the range is 0-500, then 
first solution
9, 10, 1, 12 = 9^3 + 10^3 = 1729 = 1^3 + 10^3
last solution
414, 418, 292, 492 = 414^3 + 418^3 = 143992576 = 292^3 + 492^3 */


import java.util.*;
import java.lang.*;
class Pair
{
	int a,b;

	Pair(int a, int b)
	{
		this.a = a;
		this.b = b;
	}

	public String toString()
	{
		return (this.a + ", " + this.b);
	}
}

class ACubePlusBCube
{
	public static void main(String args[])
	{
		int n = 500;
		findSolution(n);
	}

	static void findSolution(int n)
	{
		HashMap<Integer,Pair> map = new HashMap<Integer,Pair>();
		for(int i=0; i<n; i++)
		{
			for(int j=i+1; j<n; j++)
			{
				int val = (int)(Math.pow(i,3) + Math.pow(j,3));
				if(map.containsKey(val))
					System.out.println(new Pair(i,j).toString() + ", " + map.get(val).toString());
				else
					map.put(val,new Pair(i,j));
			}
		}
	}
}