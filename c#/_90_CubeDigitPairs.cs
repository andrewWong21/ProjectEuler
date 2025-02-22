using System;
using System.Collections.Generic;

public class _90_CubeDigitPairs{
	public static int Euler90(){
		int res = 0;
		List<HashSet<int>> combs = GenerateCombinations(10, 6);
		for (int i = 0; i < combs.Count; i++){
			for (int j = i; j < combs.Count; j++){
				if (FormsAllSquares(combs[i], combs[j])){
					res++;
				}
			}
		}
		return res;
	}
	
	public static bool FormsAllSquares(HashSet<int> s1, HashSet<int> s2){
		if (s1.Contains(6) || s1.Contains(9)){
			s1.Add(6);
			s1.Add(9);
		}
		if (s2.Contains(6) || s2.Contains(9)){
			s2.Add(6);
			s2.Add(9);
		}
		for (int i = 1; i < 10; i++){
			int sq = i * i;
			if (
				!(s1.Contains(sq / 10) && s2.Contains(sq % 10)) &&
				!(s1.Contains(sq % 10) && s2.Contains(sq / 10))
			){
				return false;
			}
		}
		return true;
	}
	
	public static List<HashSet<int>> GenerateCombinations(int n, int k){
		List<HashSet<int>> combs = new List<HashSet<int>>();
		Backtrack(combs, new HashSet<int>(), n, 0, k);
		return combs;
	}
	
	public static void Backtrack(List<HashSet<int>> combs, HashSet<int> comb, int n, int start, int k){
		if (comb.Count == k){
			combs.Add(new HashSet<int>(comb));
			return;
		}
		for (int i = start; i < n; i++){
			comb.Add(i);
			Backtrack(combs, comb, n, i + 1, k);
			comb.Remove(i);
		}
	}
	
	public static void Main(){
		Console.WriteLine(Euler90());
	}
}
