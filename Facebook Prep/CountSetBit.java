/* Write a function that takes in an integer and 
returns the number of ones set in the binary representation.

Time Complexity: O(logn) */

class CountSetBit
{
	public static void main(String args[])
	{
		int num = 13;
		System.out.println("Number of Set bits: " + countSet(num));
	}

	static int countSet(int num)
	{
		int count = 0;
		while(num > 0)
		{
			count += num & 1; //bitwise AND with binary of the number : 1001 & 0001
			num >>=1 ; //Bitwise right shift by 1: omit one character from right
			//Bitwise left shift adds one zero to the right
		}

		return count;
	}
	
}