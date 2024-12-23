using System;

public class _30_DigitFifthPowers{
	public static int Euler30(){
		int res = 0;
		int[] powers = new int[]{0, 1, 32, 243, 1024, 3125, 7776, 16807, 32768, 59049};
		// if the maximum digit fifth power sum for a number with n digits
		// is less than the smallest n-digit number, no more digit fifth powers can be found
		// n * 9^5 < 10^(n - 1) is true when n > 7 (n must be positive)
		for (int i = 10; i < 10000000; i++){
			int n = i, sum = 0;
			while (n > 0){
				sum += powers[n % 10];
				n /= 10;
			}
			if (sum == i) res += sum;
		}
		return res;
	}
	
	public static void Main(){
		Console.WriteLine(Euler30());
	}
}
