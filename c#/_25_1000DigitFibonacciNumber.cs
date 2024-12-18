using System;
using System.Numerics;

public class _25_1000DigitFibonacciNumber{
	public static int Euler25(){
		int idx = 1;
		BigInteger f1 = 0;
		BigInteger f2 = 1;
		while (f2.ToString().Length < 1000){
			BigInteger temp = f2;
			f2 += f1;
			f1 = temp;
			idx++;
		}
		return idx;
	}
	
	public static void Main(){
		Console.WriteLine(Euler25());
	}
}
