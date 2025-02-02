using System;

public class _70_TotientPermutation{
	public static int Euler70(){
		int n = 10_000_000, res = 0;
		double minRatio = n;
		int[] totients = new int[n];
		for (int i = 2; i < n; i++){
			totients[i] = i - 1;
		}
		for (int i = 2; i < n; i++){
		    int t = totients[i];
			for (int j = 2 * i; j < n; j += i){
				totients[j] -= t;
			}
			double ratio = i / (double) totients[i];
			if (IsPermutation(i, totients[i]) && ratio < minRatio){
				res = i;
				minRatio = ratio;
			}
		}
		return res;
	}
	
	private static bool IsPermutation(int n1, int n2){
		string s1 = n1.ToString();
		string s2 = n2.ToString();
		if (s1.Length != s2.Length) return false;
		int[] digits = new int[10];
		while (n1 > 0){
			digits[n1 % 10]++;
			n1 /= 10;
		}
		while (n2 > 0){
			int d = n2 % 10;
			if (--digits[d] < 0) return false;
			n2 /= 10;
		}
		return true;
	}
	
	public static void Main(){
		Console.WriteLine(Euler70());
	}
}
