using System;
using System.Collections.Generic;

public class _41_PandigitalPrime{
	public static int Euler41(){
		// no 1-9 pandigital numbers are prime (digital sum of 45)
		// no 1-8 pandigital numbers are prime (digital sum of 36)
		// numbers are divisible by 3 if they have digital sums that are multiples of 3
		// largest pandigital prime can have at most 7 digits (digital sum of 28)
		
		// 7! = 5040 permutations of the digits 1234567
		// more efficient than checking all 7-digit numbers (900,000 numbers)
		
		// generate permutations from largest to smallest
		// first prime found will be largest pandigital prime
		string digits = "7654321";
		List<int> perms = new List<int>();
		Backtrack(perms, digits, 0, new bool[7], 0);
		foreach (int perm in perms){
			if (IsPrime(perm)) return perm;
		}
		return 0;
	}
	
	private static void Backtrack(List<int> perms, string digits, int curr, bool[] seen, int idx){
		if (idx == digits.Length){
			perms.Add(curr);
			return;
		}
		for (int i = 0; i < seen.Length; i++){
			if (!seen[i]){
				seen[i] = true;
				curr = curr * 10 + digits[i] - '0';
				Backtrack(perms, digits, curr, seen, idx + 1);
				curr /= 10;
				seen[i] = false;
			}
		}
	}
	
	private static bool IsPrime(int n){
		for (int i = 2; i * i <= n; i++){
			if (n % i == 0) return false;
		}
		return true;
	}
	
	public static void Main(){
		Console.WriteLine(Euler41());
	}
}
