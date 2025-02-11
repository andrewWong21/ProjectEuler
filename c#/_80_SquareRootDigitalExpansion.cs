using System;
using System.Numerics;

public class _80_SquareRootDigitalExpansion{
	public static int Euler80(){
		int res = 0;
		for (int i = 1; i <= 100; i++){
			double s = Math.Sqrt(i);
			if (s == Math.Floor(s)) continue;
			res += GetRootDigitalSum(i);
		}
		return res;
	}
	
	public static int GetRootDigitalSum(int n){
		// method for calculating square roots digit by digit
		// http://www.afjarvis.org.uk/maths/jarvisspec02.pdf
		BigInteger a = 5 * n, b = 5;
		while (b.ToString().Length < 102){
			if (a >= b){
				a -= b;
				b += 10;
			}
			else{
				a *= 100;
				BigInteger d = b % 10;
				b = (b / 10) * 100 + d;
			}
			
		}
		string digits = b.ToString();
		int sum = 0;
		for (int i = 0; i < 100; i++){
			sum += int.Parse(digits[i].ToString());
		}
		return sum;
	}
	
	public static void Main(){
		Console.WriteLine(Euler80());
	}
}
