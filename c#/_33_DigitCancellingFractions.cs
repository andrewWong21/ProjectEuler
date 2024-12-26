using System;

public class _33_DigitCancellingFractions{
	public static int Euler33(){
		int num = 1, den = 1;
		// fractions less than 1 in value
		// with two digits in numerator and denominator
		for (int n = 10; n < 100; n++){
			for (int d = n + 1; d < 100; d++){
				// numerators that are multiples of 10
				// result in a fraction with 0 in the numerator after digit-cancelling
				// or require a single-digit denominator for digit-cancelling
				if (n % 10 == 0 || d % 10 == 0) continue;
				if (n % 10 == d / 10){
					int newNum = n / 10;
					int newDen = d % 10;
					if ((double) newNum / newDen == (double) n / d){
						num *= newNum;
						den *= newDen;
					}
				}	
				else if (n / 10 == d % 10){
					int newNum = n % 10;
					int newDen = d / 10;
					if ((double) newNum / newDen == (double) n / d){
						num *= newNum;
						den *= newDen;
					}
					
				}
			}
		}
		return den / GCD(den, num);
	}
	
	public static int GCD(int a, int b){
		while (b > 0){
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
	
	public static void Main(){
		Console.WriteLine(Euler33());
	}
}
