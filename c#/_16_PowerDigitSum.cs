using System;
using System.Numerics;

public class _16_PowerDigitSum{
	public static int Euler16(){
		int res = 0;
		BigInteger pow = 1;
		for (int i = 0; i < 1000; i++) pow *= 2;
		foreach (char c in pow.ToString()){
			res += c - '0';
		}
		return res;
	}
	
	public static void Main(){
		Console.WriteLine(Euler16());
	}
}
