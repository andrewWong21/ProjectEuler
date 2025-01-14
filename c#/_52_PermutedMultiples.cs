using System;

public class _52_PermutedMultiples{
	public static int Euler52(){
		int n = 1;
		while (true){
			int[] digits = GetDigitCounts(n);
			for (int k = 2; k <= 6; k++){
				if (!SameDigits(digits, GetDigitCounts(k * n))) break;
				if (k == 6) return n;
			}
			n++;
		}
	}
	
	private static int[] GetDigitCounts(int n){
		int[] digits = new int[10];
		while (n > 0){
			digits[n % 10]++;
			n/= 10;
		}
		return digits;
	}
	
	private static bool SameDigits(int[] arr1, int[] arr2){
		for (int i = 0; i < 10; i++){
			if (arr1[i] != arr2[i]) return false;
		}
		return true;
	}
	
	public static void Main(){
		Console.WriteLine(Euler52());
	}
}
