using System;
using System.Collections.Generic;

public class _64_OddPeriodSquareRoots{
	public static int Euler64(){
		int res = 0;
		for (int n = 2; n <= 10_000; n++){
			if (GetPeriod(n) % 2 == 1){
				res++;
			}
		}
		return res;
	}
	
	private static int GetPeriod(int n){
		double s = Math.Sqrt(n);
		// if n is a perfect square, period is 0
		if (s == (int) s) return 0;
		
		// sqrt(n) = a + sqrt(n) - a
		// sqrt(n) = a + (sqrt(n) - b) / c
		int a = (int) Math.Floor(s);
		int b = a;
		int c = 1;
		
		// sqrt(n) = a0 + (sqrt(n) - b0) / c0
		// sqrt(n) = a0 + 1 / (c / (sqrt(n) - b0))
		// sqrt(n) = a0 + 1 / ((c * (sqrt(n) + b0)) / (n - b0^2))
		// sqrt(n) = a0 + 1 / ((sqrt(n) + b0) / ((n - b0^2) / c0))
		// sqrt(n) = a0 + 1 / d
		
		// d = (sqrt(n) + b0) / ((n - b0^2) / c0)
		// c1 = (n - b0^2) / c0
		// a1 = floor((sqrt(n) + b0) / c1)
		// b1 = a1 * c1 - b0
		
		Dictionary<(int, int), int> seen = new Dictionary<(int, int), int>();
		int count = 0;
		while (true){
			c = (n - b * b) / c;
			a = (int) Math.Floor((s + b) / c);
			b = a * c - b;
			var key = (b, c);
			if (seen.ContainsKey(key)){
				return count - seen[key];
			}
			seen.Add(key, count++);
		}
	}
	
	public static void Main(){
		Console.WriteLine(Euler64());
	}
}
