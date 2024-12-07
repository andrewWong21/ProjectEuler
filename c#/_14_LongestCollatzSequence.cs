using System;
using System.Collections.Generic;

public class _14_LongestCollatzSequence{
	public static int Euler14(){
		int start = 0, longest = 0;
		int[] lengths = new int[1_000_000];
		lengths[1] = 1;
		for (int i = 2; i < 1_000_000; i++){
			long n = i;
			HashSet<long> chain = new HashSet<long>();
			bool cached = false;
			while (true){
				if (n < 1_000_000 && lengths[n] != 0){
					cached = true;
					break;
				}
				chain.Add(n);
				if (n % 2 == 0) n /= 2;
				else n = 3 * n + 1;
			}
			lengths[i] = chain.Count;
			if (cached) lengths[i] += lengths[n];
			if (lengths[i] > longest){
				longest = lengths[i];
				start = i;
			}
		}
		return start;
	}
	
	public static void Main(){
		Console.WriteLine(Euler14());
	}
}
