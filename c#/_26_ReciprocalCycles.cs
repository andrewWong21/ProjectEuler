using System;
using System.Collections.Generic;

public class _26_ReciprocalCycles{
	public static int Euler26(){
		int res = 0, max = 0;
		for (int i = 2; i < 1000; i++){
			int cycle = GetCycleLength(i);
			if (cycle > max){
				max = cycle;
				res = i;
			}
		}
		return res;
	}
	
	public static int GetCycleLength(int n){
		int rem = 1, count = 0;
		Dictionary<int, int> seen = new Dictionary<int, int>();
		while (rem != 0){
			rem = (rem * 10) % n;
			if (seen.ContainsKey(rem)){
				return count - seen[rem];
			}
			seen.Add(rem, count++);
		}
		return 0;
	}
	
	public static void Main(){
		Console.WriteLine(Euler26());
	}
}
