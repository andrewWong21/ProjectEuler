using System;

public class _21_AmicableNumbers{
	public static int Euler21(){
		int sum = 0;
		for (int i = 2; i < 10_000; i++){
			int divSum = GetProperDivisorSum(i);
			if (divSum > i && GetProperDivisorSum(divSum) == i){
				sum += i + divSum;
			}
		}
		return sum;
	}
	
	public static int GetProperDivisorSum(int n){
		if (n == 1) return 0;
		int res = 1;
		for (int i = 2; i <= Math.Sqrt(n); i++){
			if (n % i == 0){
				if (n / i == i) res += i;
				else res += i + n / i;
			}
		}
		return res;
	}
	
	public static void Main(){
		Console.WriteLine(Euler21());
	}
}
