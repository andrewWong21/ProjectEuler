using System;

public class _46_GoldbachsOtherConjecture{
	public static int Euler46(){
		// n = p + 2x^2, x^2 = s
		// p = n - 2s
		int n = 9, res = 0;
		while (res == 0){
			if (!IsPrime(n)){
				bool found = false;
				for (int i = 1; 2 * i * i < n; i++){
					int s = i * i;
					if (IsPrime(n - 2 * s)){
						found = true;
						break;
					}
				}
				if (!found) res = n;
			}
			n += 2;
		}
		return res;
	}
	
	private static bool IsPrime(int n){
		for (int i = 2; i * i <= n; i++){
			if (n % i == 0) return false;	
		}
		return true;
	}
	
	public static void Main(){
		Console.WriteLine(Euler46());
	}
}
