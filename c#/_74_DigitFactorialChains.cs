using System;
using System.Collections.Generic;

public class _74_DigitFactorialChains{
	public static int Euler74(){
		int res = 0;
		int[] fact = {
			1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880
		};
		for (int i = 1; i < 1_000_000; i++){
			int n = i;
			HashSet<int> seen = new HashSet<int>();
			while (n < 1_000_000 && !seen.Contains(n)){
				seen.Add(n);
				int sum = 0;
				while (n > 0){
					sum += fact[n % 10];
					n /= 10;
				}
				n = sum;
			}
			if (seen.Count == 60) res++;
		}
		return res;
	}
	
	public static void Main(){
		Console.WriteLine(Euler74());
	}
}
