/* 17. Given an array of numbers (1,2,3,8,0,2,2,0,10), 
move all 0s to the right end and all other numbers to the left 
while keeping relative order of non-zero numbers. 
Has to be linear in time and in-place. - O(n) & O(1) in place */

class ZeroInEnd
{
	public static void main(String args[])
	{
		int[] num = {1,2,3,8,0,2,2,0,10};
		zeroShift(num,num.length);

		System.out.println("Processed Array: ");

		for(int i=0; i<num.length; i++)
			System.out.print(num[i] + " ");

		System.out.println();
	}

	static void zeroShift(int[] num, int n)
	{
		int count = 0;
		for(int i =0; i<n; i++)
		{
			if(num[i] != 0)
				num[count++] = num[i];
		}

		while(count<n)
		{
			num[count] = 0;
			count++;
		}
	}
}