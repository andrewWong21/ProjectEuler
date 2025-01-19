using System;
using System.Numerics;

public class _57_SquareRootConvergents{
	public static int Euler57(){
		int res = 0;
		BigInteger num = 1, den = 1;
		for (int i = 1; i <= 1000; i++){
			BigInteger newNum = num + 2 * den;
			BigInteger newDen = num + den;
			num = newNum;
			den = newDen;
			
			if (CountDigits(num) > CountDigits(den)){
				res++;
			}
		}
		return res;
	}
	
	public static int CountDigits(BigInteger num){
		int count = 0;
		while (num > 0){
			num /= 10;
			count++;
		}
		return count;
	}
	
	public static void Main(){
		Console.WriteLine(Euler57());
	}
}
