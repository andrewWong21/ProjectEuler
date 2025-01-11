using System;
using System.Collections.Generic;

public class _49_PrimePermutations{
	public static long Euler49(){
		long res = 0;
		Dictionary<string, List<int>> digitsMap = new Dictionary<string, List<int>>();
		bool[] sieved = new bool[10000];
		for (int i = 2; i < sieved.Length; i++){
			if (!sieved[i]){
				for (int j = 2 * i; j < sieved.Length; j += i){
					sieved[j] = true;
				}
				if (i > 999){
					char[] digits = i.ToString().ToCharArray();
					Array.Sort(digits);
					String key = new string(digits);
					if (!digitsMap.ContainsKey(key)){
						digitsMap[key] = new List<int>();
					}
					digitsMap[key].Add(i);
				}
			}
		}
		foreach (List<int> nums in digitsMap.Values){
			res = Math.Max(res, FindSequence(nums));
		}
		return res;
	}
	
	public static long FindSequence(List<int> nums){
		long res = 0;
		if (nums.Count < 3) return 0;
		HashSet<int> numsSet = new HashSet<int>(nums);
		for (int i = 0; i < nums.Count; i++){
			for (int j = i + 1; j < nums.Count; j++){
				int diff = nums[j] - nums[i];
				int thirdTerm = nums[i] + 2 * diff;
				if (numsSet.Contains(thirdTerm)){
					res = Math.Max(
						res,
						(long) nums[i] * 100_000_000 + nums[j] * 10_000 + thirdTerm
					);
				}
			}
		}
		return res;
	}
	
	public static void Main(){
		Console.WriteLine(Euler49());
	}
}
