using System;
using System.Numerics;

public class _56_PowerfulDigitSum{
	public static int Euler56(){
		int res = 0;
		for (int a = 1; a < 100; a++){
			for (int b = 1; b < 100; b++){
				BigInteger pow = BigInteger.Pow(a, b);
				int sum = 0;
				while (pow > 0){
					sum += (int) (pow % 10);
					pow /= 10;
				}
				res = Math.Max(res, sum);
			}
		}
		return res;
	}
	
	public static void Main(){
		Console.WriteLine(Euler56());
	}
}
