using System;
using System.Collections.Generic;

public class _95_AmicableChains{
	public static int Euler95(){
		int max = 1_000_000, maxLen = 0, minNum = 0;
		for (int i = 12496; i < max; i++){
			SortedSet<int> chain = new SortedSet<int>();
			int n = i;
			while (!chain.Contains(n) && n < max){
				chain.Add(n);
				n = GetProperDivisorSum(n);
			}
			// found longer chain that returns to starting point
			if (n == i && chain.Count > maxLen){
				// update longest chain length and minimum element
				maxLen = chain.Count;
				minNum = chain.Min;
			}
		}
		return minNum;
    }
	
	public static int GetProperDivisorSum(int n){
		// 1 is always a proper divisor
		// n is a factor but not a proper divisor
		int res = 1;
		for (int i = 2; i*i <= n; i++){
			if (n % i == 0){
				// add pair of factors to proper divisor sum
				res += i + (n / i);
			}
		}
		// avoid double-counting factor if n is a perfect square
		if (Math.Sqrt(n) == (int) Math.Sqrt(n)){
			res -= (int) Math.Sqrt(n);
		}
		return res;
	}
	
	public static void Main(){
		Console.WriteLine(Euler95());
	}
}
