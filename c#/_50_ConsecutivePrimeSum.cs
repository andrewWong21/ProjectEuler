using System;
using System.Collections.Generic;

public class _50_ConsecutivePrimeSum{
	public static int Euler50(){
		int max = 1_000_000;
		HashSet<int> primes = new HashSet<int>();
		bool[] sieved = new bool[max];
		for (int i = 2; i < sieved.Length; i++){
			if (!sieved[i]){
				for (int j = 2 * i; j < sieved.Length; j += i){
					sieved[j] = true;
				}
				primes.Add(i);
			}
		}
		
		List<int> sums = new List<int>(); 
		int sum = 0, terms = 0;
		foreach(int prime in primes){
			sum += prime;
			if (sum >= max) break;
			sums.Add(sum);
			terms++;
		}
		for (int len = terms; len > 0; len--){
			for (int start = terms - len; start >= 0; start--){
				int sumA = sums[start], sumB = sums[start + len - 1];
				if (sumB - sumA > max) break;
				if (primes.Contains(sumB - sumA)){
					return sumB - sumA;
				}
			}
		}
		return 0;
	}
	
	public static void Main(){
		Console.WriteLine(Euler50());
	}
}
