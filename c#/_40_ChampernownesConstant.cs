using System;

public class _40_ChampernownesConstant{
	public static int Euler40(){
		int res = 1;
		// 1-digit: 1-9, 9 digits (9)
		// 2-digit: 2 * 90 = 180 digits (189)
		// 3-digit: 3 * 900 = 2,700 digits (2889)
		// 4-digit: 4 * 9000 = 36,000 digits (38889)
		// 5-digit: 5 * 90000 = 450,000 digits (488889)
		// 6-digit: 6 * 900000 = 5,400,000 digits (5888889)
		int[] starts = {1, 10, 190, 2890, 38890, 488890, 5888890};
		for (int n = 1; n <= 1_000_000; n *= 10){
			// determine which group contains the n-th digit
			int d = 0;
			while (starts[d] <= n) d++;
			// determine which number in the group contains the n-th digit
			// divide (number of digits between start and nth digit) by d
			// k-th number in group contains n-th digit
			int start = starts[d - 1];
			int k = (n - start) / d;
			int num = (int) Math.Pow(10, d - 1) + k;
			// determine which digit of the number is the nth digit
			int pos = (n - start) % d;
			int digit = num.ToString()[pos] - '0';
			res *= digit;
		}
		return res;
	}
	
	public static void Main(){
		Console.WriteLine(Euler40());
	}
}
