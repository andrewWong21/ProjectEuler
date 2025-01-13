using System;
using System.Collections.Generic;

public class _51_PrimeDigitReplacements{
	static HashSet<int> primes = new HashSet<int>();
	public static int Euler51(){
		int max = 1_000_000;
		bool[] sieved = new bool[max];
		for (int i = 2; i < sieved.Length; i++){
			if (!sieved[i]){
				for (int j = 2 * i; j < sieved.Length; j += i){
					sieved[j] = true;
				}
				primes.Add(i);
			}
		}
		foreach (int prime in primes){
			if (replace(prime)) return prime;
		}
		return 0;
	}
	
	private static bool replace(int n){
		char[] digits = n.ToString().ToCharArray();
		Array.Reverse<char>(digits);
		int len = digits.Length;
		for (int d = 0; d < 3; d++){
			int mask = 0;
			for (int i = 0; i < len; i++){
				if (digits[i] - '0' == d){
					mask += (int) Math.Pow(10, i);
				}
			}
			if (mask == 0) continue;
			int familySize = 1;
			for (int t = 1; t < 10 - d; t++){
				if (primes.Contains(n + mask * t)){
					familySize++;
				}
			}
			if (familySize == 8) return true;
		}
		return false;
	}
	
	public static void Main(){
		Console.WriteLine(Euler51());
	}
}
