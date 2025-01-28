using System;
using System.Numerics;
using System.Collections.Generic;

public class _66_DiophantineEquation{
	public static BigInteger Euler66(){
		int resD = 0;
		BigInteger maxX = 0;
		for (int d = 1; d <= 1_000; d++){
			if (Math.Sqrt(d) == Math.Floor(Math.Sqrt(d))) continue;
			BigInteger x = GetMinimalSolution(d);
			if (x > maxX){
				maxX = x;
				resD = d;
				// Console.WriteLine(resD + " " + maxX);
			}
		}
		return resD;
	}
	
	public static BigInteger GetMinimalSolution(int d){
		List<int> convergents = GetConvergents(d);
		int len = convergents.Count;
		BigInteger prevNum = 1, prevDen = 0;
		BigInteger num = (int) Math.Floor(Math.Sqrt(d)), den = 1;
		int count = 0;
		while (true){
			BigInteger k = convergents[count % len];
			BigInteger newNum = num * k + prevNum;
			BigInteger newDen = den * k + prevDen;
			prevNum = num;
			prevDen = den;
			num = newNum;
			den = newDen;
			if (num * num - d * den * den == 1){
				return num;
			}
			count++;
		}
	}
	
	public static List<int> GetConvergents(int n){
		List<int> res = new List<int>();
		double s = Math.Sqrt(n);
		if (s == (int) s) return res;
		
		int a0 = (int) Math.Floor(s), a = a0;
		int b = a;
		int c = 1;
		
		while (true){
			c = (n - b * b) / c;
			a = (int) Math.Floor((s + b) / c);
			b = a * c - b;
			res.Add(a);
			if (a == 2 * a0) break;
		}
		return res;
	}
	
	public static void Main(){
		Console.WriteLine(Euler66());
	}
}
