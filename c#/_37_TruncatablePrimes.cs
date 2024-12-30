using System;

public class _37_TruncatablePrimes{
	public static int Euler37(){
		int sum = 0, count = 0;
		for (int i = 11; count < 11; i += 2){
			if (IsPrime(i) && IsLeftTruncatable(i) && IsRightTruncatable(i)){
				sum += i;
				count++;
			}
		}
		return sum;
	}
	
	private static bool IsPrime(int n){
		if (n == 1) return false;
		for (int i = 2; i <= Math.Sqrt(n); i++){
			if (n % i == 0) return false;
		}
		return true;
	}
	
	private static bool IsLeftTruncatable(int n){
		int div = 1;
		while (n / div >= 10){
			div *= 10;
		}
		while (div > 0){
			if (!IsPrime(n)) return false;
			n %= div;
			div /= 10;
		}
		return true;	
	}
	
	private static bool IsRightTruncatable(int n){
		while (n > 0){
			if (!IsPrime(n)) return false;
			n /= 10;
		}
		return true;	
	}
	
	public static void Main(){
		Console.WriteLine(Euler37());
	}
}
