using System;

public class _53_CombinatoricSelections{
	public static int Euler53(){
		int res = 0;
		for (int n = 23; n <= 100; n++){
			// nC1 = n! / ((n - 1)! * 1!) = n
			// nC2 = n! / ((n - 2)! * 2!) = n * (n - 1) / 2
			// nC3 = n! / ((n - 3)! * 3!) = n * (n - 1) * (n - 2) / 6
			// nCr = nC(r - 1) * (n - r + 1) / r
			int comb = 1;
			for (int r = 1; r <= n; r++){
				comb = comb * (n - r + 1) / r;
				if (comb > 1_000_000){
					// [r, n - r]
					// (n - r) - (r) + 1
					res += n - 2 * r + 1;
					break;	
				}
			}
		}
		return res;
	}
	
	public static void Main(){
		Console.WriteLine(Euler53());
	}
}
