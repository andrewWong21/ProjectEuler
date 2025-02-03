using System;

public class _72_CountingFractions{
	public static long Euler72(){
		// number of reduced fractions with denominator d
		// is equal to number of positive integers less than d and relatively prime to d
		// i.e. the value of totient(d)
		// number of reduced fractions with denominator d <= 1_000_000
		// is equal to sum of totients from 2 <= d <= 1_000_000
		int max = 1_000_000;
		long res = 0;
		int[] totients = new int[max + 1];
		for (int i = 2; i <= max; i++){
			totients[i] += i - 1;
			for (int j = 2 * i; j <= max; j += i){
				totients[j] -= totients[i];
			}
			res += totients[i];
		}
		return res;
	}
	
	public static void Main(){
		Console.WriteLine(Euler72());
	}
}
