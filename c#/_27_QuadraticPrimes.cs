using System;
using System.Collections.Generic;

public class _27_QuadraticPrimes{
	static HashSet<int> primes = new HashSet<int>();
	static int max = 1000;
	public static int Euler27(){
		bool[] sieved = new bool[max];
		for (int i = 2; i < max; i++){
			if (!sieved[i]){
				for (int j = 2 * i; j < max; j += i){
					sieved[j] = true;
				}
				primes.Add(i);
			}
		}
		int res = 0, maxStreak = 0;
		foreach (int b in primes){
			for (int a = -999; a <= 999; a++){
				int streak = GetStreak(a, b);
				if (streak > maxStreak){
					maxStreak = streak;
					res = a * b;
				}
			}
		}
		return res;
	}
	
	private static int GetStreak(int a, int b){
		int n = 0;
		while (true){
			n++;
			int curr = n * n + a * n + b;
			if ((curr > max && !IsPrime(curr)) || !primes.Contains(curr)) break;
		}
		return n - 1;
	}
	
	private static bool IsPrime(int n){
		for (int i = 2; i <= Math.Sqrt(n); i++){
			if (n % i == 0) return false;
		}
		return true;
	}
	
	public static void Main(){
		Console.WriteLine(Euler27());
	}
}
