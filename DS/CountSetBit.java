/* Write a function that takes in an integer and 
returns the number of ones set in the binary representation.

Time Complexity: O(logn) -- countSet1()
				 O(1) Time & space -- countSet2() */

class CountSetBit
{
	public static void main(String args[])
	{
		int num = 31;
		System.out.println("Number of Set bits: " + countSet(num));
		System.out.println("Number of Set bits: " + countSet2(num));
	}

	static int countSet2(int num)
	{
		int[] numToBits = {0,1,1,2,1,2,2,3,1,2,2,3,2,3,3,4};

		//base case
		if(num == 0)
			return numToBits[0];

		//get the last nibble
		int nibble = num & 0xf;

		return (numToBits[nibble] + countSet2(num>>4));
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