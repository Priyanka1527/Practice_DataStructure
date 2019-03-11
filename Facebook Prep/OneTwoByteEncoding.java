/* Given a byte array, which is an encoding of characters. Here is the rule:
    a. If the first bit of a byte is 0, that byte stands for a one-byte
character
    b. If the first bit of a byte is 1, that byte and its following byte
together stand for a two-byte character

Now implement a function to decide if the last character is a one-byte
character or a two-byte character
Constraint: You must scan the byte array from the end to the start.
Otherwise it will be very trivial
*/

class OneTwoByteEncoding
{
	public static void main(String args[])
	{
		int[] bits = {1,1,1,0};
		if(isOneBit(bits))
			System.out.println("One byte Character");
		else
			System.out.println("Two byte Character");
	}

	static boolean isOneBit(int[] bits)
	{
		int i = 0;
		boolean ans = true;
		while(i<bits.length)
		{
			if(bits[i]==1)
			{
				i = i+2;
				ans = false;
				continue;
			}
			if(bits[i] == 0)
			{
				i = i+1;
				ans = true;
				continue;
			}
		}
		return ans;
	}
}

