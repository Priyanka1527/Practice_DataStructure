/* Given a set of characters, print out all possible permutations.  */

/* Function printPerm() doesn't consider duplicate characters in the string.
Function printNoDupPerm() considers that */

/* Time Complexity : O(n^2 * n!) from "Cracking the Coding Interview"
O(n*n!) for perm()  and then O(n) for printing each answer, so O(n^2 * n!) */

class StringPermutation
{
	public static void main(String args[])
	{
		String str = "geek";
		System.out.println("Permutations with Duplicate: ");
		printPerm(str,"");
		System.out.println();
		System.out.println("Permutation without Duplicate: ");
		printNoDupPerm(str,"");
		System.out.println();
	}

	static void printNoDupPerm(String str, String res)
	{
		

		if(str.length() == 0)
		{
			System.out.print(res + " ");
			return;
		}

		boolean alpha[] = new boolean[26];

		for(int i=0; i<str.length(); i++)
		{
			char ch = str.charAt(i);
			String remaining = str.substring(0,i) + str.substring(i+1);

			if(alpha[ch - 'a'] == false)
				printNoDupPerm(remaining, res+ch);
			alpha[ch - 'a'] = true;
		}
	}

	static void printPerm(String str, String res)
	{
		if(str.length() == 0)
		{
			System.out.print(res + " ");
			return;
		}

		for(int i=0; i<str.length(); i++)
		{
			char ch = str.charAt(i);
			String remaining = str.substring(0,i) + str.substring(i+1);
			printPerm(remaining, res+ch);
		}
	}
}