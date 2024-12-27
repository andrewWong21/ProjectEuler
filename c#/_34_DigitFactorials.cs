using System;

public class _34_DigitFactorials{
	public static int Euler34(){
		int[] fact = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
		// an n-digit number cannot be a digit factorial sum
		// if the maximum n-digit factorial sum, n * 9! = 362880n
		// is less than the smallest n-digit number, 10^(n-1)
		// 362880n < 10^(n - 1) is true when n > 7
		// bounds to check: [10, 2540160]
		int res = 0;
		for (int n = 10; n < 7 * fact[9]; n++){
			int i = n, sum = 0;
			while (i > 0){
				sum += fact[i % 10];
				i /= 10;
			}
			if (sum == n) res += n;
		}
		return res;
	}
	
	public static void Main(){
		Console.WriteLine(Euler34());
	}
}
