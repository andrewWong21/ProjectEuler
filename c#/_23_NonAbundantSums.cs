using System;
using System.Collections.Generic;

public class _23_NonAbundantSums{
	public static int Euler23(){
		int res = 0, max = 28124;
		bool[] isAbundantSum = new bool[max];
		List<int> nums = new List<int>();
		for (int i = 2; i < max; i++){
			if (GetProperDivisorSum(i) > i){
				nums.Add(i);
				foreach (int num in nums){
					int sum = i + num;
					if (sum < max) isAbundantSum[sum] = true;
				}
			}
		}
		for (int i = 0; i < max; i++){
			if (!isAbundantSum[i]) res += i;
		}
		return res;
	}
	
	private static int GetProperDivisorSum(int n){
		if (n == 1) return 0;
		int sum = 1;
		for (int i = 2; i <= Math.Sqrt(n); i++){
			if (n % i == 0){
				if (n / i == i) sum += i;
				else sum += i + n / i;
			}
		}
		return sum;
	}
	
	public static void Main(){
		Console.WriteLine(Euler23());
	}
}
