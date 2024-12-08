using System;

public class _15_LatticePaths{
	public static long Euler15(int n){
		long res = 1;
		for (int i = n + 1; i <= 2 * n; i++){
			res *= i;
			res /= i - n;
		}
		return res;
	}
	
	public static void Main(){
		Console.WriteLine(Euler15(20));
	}
}
