using System;
using System.Collections.Generic;

public class _24_LexicographicPermutations{
	public static string Euler24(){
		List<char> digits = new List<char>("0123456789");
		int length = digits.Count, n = 1_000_000;
		n--; // account for 0-based indexing
		// precompute factorials
		int[] factorial = new int[length];
		factorial[0] = 1;
		for (int i = 1; i < length; i++){
			factorial[i] = i * factorial[i - 1];
		}
		string res = "";
		for (int i = length; i > 0; i--){
			// split d! permutations of d digits into d groups of (d - 1)! permutations
			int fact = factorial[i - 1];
			// determine which group of (d - 1)! permutations n is a member of
			int idx = n / fact;
			// append next common digit of group to result
			res += digits[idx];
			digits.RemoveAt(idx);
			// find next common digit within group of (d - 2)! permutations
			n %= fact;
		}
		return res;
	}
	
	public static void Main(){
		Console.WriteLine(Euler24());
	}
}
