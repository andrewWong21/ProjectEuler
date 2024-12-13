using System;
using System.Numerics;

public class _20_FactorialDigitSum{
	public static BigInteger Euler20(){
		BigInteger fact = 1, sum = 0;
		for (int i = 1; i <= 100; i++){
			fact *= new BigInteger(i);
		}
		while (fact > 0){
			sum += fact % 10;
			fact /= 10;
		}
		return sum;
	}
	
	public static void Main(){
		Console.WriteLine(Euler20());
	}
}
