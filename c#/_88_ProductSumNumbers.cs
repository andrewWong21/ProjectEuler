using System;
using System.Collections.Generic;

public class _88_ProductSumNumbers{
	public static int Euler88(){
		int maxK = 12_000;
		int[] minPSNs = new int[maxK + 1];
		List<List<List<int>>> factLists = new List<List<List<int>>>();
		for (int i = 0; i < 2 * maxK + 1; i++){
			factLists.Add(new List<List<int>>());
		}
		
		// minimal product-sum number for a set of size k can be at most 2*k
		for (int n = 2; n < factLists.Count; n++){
			List<List<int>> fact = new List<List<int>>();
			fact.Add(new List<int>{n});
			
			// iterate over possible factors f of n
			for (int f = 2; f * f <= n; f++){
				if (n % f == 0){
					foreach (List<int> factList in factLists[n / f]){
						bool canPrepend = true;
						foreach (int num in factList){
							if (num < f){
								canPrepend = false;
								break;
							}
						}
						if (canPrepend){
							List<int> newFact = new List<int>(factList);
							newFact.Insert(0, f);
							fact.Add(newFact);
						}
					}
				}
			}
			factLists[n] = fact;
		}
		for (int n = 2; n < factLists.Count; n++){
			foreach (List<int> factList in factLists[n]){
				if (factList.Count < 2) continue;
				int factSum = 0;
				foreach (int factor in factList){
					factSum += factor;
				}
				if (factSum <= n){
					int k = factList.Count - factSum + n;
					if (k <= maxK && minPSNs[k] == 0){
						minPSNs[k] = n;
					}
				}
			}
		}
		
		// sum unique minimal product-sum numbers for sets of up to k numbers
		int sum = 0;
		foreach (int psn in new HashSet<int>(minPSNs)){
			sum += psn;
		}
		return sum;
	}
	
	public static void Main(){
		Console.WriteLine(Euler88());
	}
}
