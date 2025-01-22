using System;
using System.Collections.Generic;

public class _60_PrimePairSets{
	static HashSet<int> primesSet = new HashSet<int>();
	static List<int> primes1 = new List<int>();
	static List<int> primes2 = new List<int>();
	static int minSum = Int32.MaxValue;
	static int max = 10_000;
	
	public static int Euler60(){
		bool[] sieved = new bool[max];
		for (int i = 2; i < max; i++){
			if (!sieved[i]){
				for (int j = 2 * i; j < max; j += i){
					sieved[j] = true;
				}
				primesSet.Add(i);
				// skip primes with composite concatenations
				if (i != 2 && i != 5){
					// split primes by congruency modulo 3
					// concatenating primes from different groups
					// may result in concatenation divisible by 3
					if (i % 3 == 1) primes1.Add(i);
					else if (i % 3 == 2) primes2.Add(i);
					else{
						primes1.Add(i);
						primes2.Add(i);
					}
				}
			}
		}
		GenerateSet(new List<int>(), primes1, 0);
		// Console.WriteLine("res1: " + minSum);
		// GenerateSet(new List<int>(), primes2, 0);
		// Console.WriteLine("res2: " + minSum);
		return minSum;
	}
	
	public static void GenerateSet(List<int> curr, List<int> primes, int idx){
		if (curr.Count == 5){
			int sum = 0;
			foreach (int num in curr){
				sum += num;
			}
			minSum = Math.Min(minSum, sum);
			return;
		}
		if (idx >= primes.Count) return;
		int p = primes[idx];
		if (IsValidSet(curr, p)){
			curr.Add(p);
			GenerateSet(curr, primes, idx + 1);
			curr.RemoveAt(curr.Count - 1);
		}
		GenerateSet(curr, primes, idx + 1);
	}
	
	private static bool IsValidSet(List<int> nums, int prime){
		foreach (int num in nums){
			if (!IsConcatPrime(num, prime)){
				return false;
			}
		}
		return true;	
	}
	
	public static bool IsConcatPrime(int a, int b){
		int n1 = int.Parse(a.ToString() + b.ToString());
		int n2 = int.Parse(b.ToString() + a.ToString());
		return IsPrime(n1) && IsPrime(n2);
	}
	
	public static bool IsPrime(int n){
		if (n < max) return primesSet.Contains(n);
		for (int i = 2; i * i <= n; i++){
			if (n % i == 0) return false;	
		}
		return true;
	}
	
	public static void Main(){
		Console.WriteLine(Euler60());
	}
}
