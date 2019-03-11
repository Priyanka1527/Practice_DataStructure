/* Check whether a string is a palindrome or not */
/* Time complexity : O(n) */

class PalindromeChecker
{
	public static void main(String args[])
	{
		String str = "Madam";
		str = str.replaceAll("[^a-zA-Z]", "").toLowerCase();

		if(isPalindrome(str))
			System.out.println("Palindrome!!");
		else
			System.out.println("Not a Palindrome");
	}

	static boolean isPalindrome(String str)
	{
		int left = 0;
		int right = str.length()-1;

		while(left<right)
		{
			if(str.charAt(left++) != str.charAt(right--))
				return false;
		}
		return true;
	}
}