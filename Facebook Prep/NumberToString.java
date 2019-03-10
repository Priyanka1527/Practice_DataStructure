/* Given a number of size <= 999 billion, return its String representation 
(for 123, return "One Hundred Twenty Three," not "123") */

class NumberToString
{
	public static void main(String args[])
	{
		long num = 140725463946016L;
		int numOfDig = numOfDig(num);
		System.out.println("No. of digit: " + numOfDig);
		// convertToWord(num,numOfDig);
	}

	static int numOfDig(long num)
	{
		int count = 0;
		while(num != 0)
		{
			num = num/10;
			count++;
		}
		return count;
	}
}