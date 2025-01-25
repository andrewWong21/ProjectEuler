using System;
using System.Numerics;

public class _63_PowerfulDigitCounts{
	public static long Euler63(){
		int res = 0;
		for (int n = 1; n < 10; n++){
			BigInteger pow = 1;
			int exp = 1;
			while (true){
				pow *= n;
				if (pow.ToString().Length != exp){
					break;
				}
				exp++;
				res++;
			}
		}
		return res;
	}
	
	public static void Main(){
		Console.WriteLine(Euler63());
	}
}
