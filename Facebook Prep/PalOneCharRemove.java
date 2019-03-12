/* Check if a string could be a palindrome after removing one character */

class PalOneCharRemove
{
	public static void main(String args[])
	{
		String str = "hahaa";
		if(possiblePal(str))
			System.out.println("possible");
		else
			System.out.println("Not possible");
	}

	static boolean isPalindrome(String str, int low, int high)
	{
		while(low<high)
		{
			if(str.charAt(low) != str.charAt(high))
				return false;

			low++;
			high--;
		}
		return true;
	}

	static boolean possiblePal(String str)
	{
		int low = 0;
		int high = str.length()-1;
		boolean flag = false;

		while(low<high)
		{
			if(str.charAt(low) == str.charAt(high))
			{
				low++;
				high--;
				flag = true;
			}
			else
			{
				if(isPalindrome(str,low+1,high))
				{
					flag = true;
					break;
				}

				else if(isPalindrome(str,low,high-1))
				{
					flag = true;
					break;
				}
				else
				{
					flag = false;
					break;
				}
			}
		}

		return flag;
	}
}