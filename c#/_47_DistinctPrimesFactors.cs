using System;
using System.Collections.Generic;

public class _47_DistinctPrimesFactors{
	static HashSet<int> primes = new HashSet<int>();
	
	public static int Euler47(){
		int n = 2, streak = 0;
		while (true){
			if (IsPrime(n)){
				primes.Add(n);
				streak = 0;
			}
			else{
				int primeFactors = GetDistinctPrimeFactorCount(n);
				if (primeFactors == 4){
					if (++streak == 4){
						return n - streak + 1;
					}
				}
				else streak = 0;
			}
			n++;
		}
	}
	
	private static int GetDistinctPrimeFactorCount(int n){
		int count = 0;
		foreach (int prime in primes){
			if (n % prime == 0){
				count++;
				while (n % prime == 0){
					n /= prime;
				}
				if (n == 1) break;
			}
		}
		return count;
	}
	
	private static bool IsPrime(int n){
		for (int i = 2; i * i <= n; i++){
			if (n % i == 0) return false;	
		}
		return true;
	}
	
	public static void Main(){
		Console.WriteLine(Euler47());
	}
}
