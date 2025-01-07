using System;

public class _45_TriangularPentagonalHexagonal{
	public static long Euler45(){
		// all hexagonal numbers are triangular
		// T_n = n * (n + 1) / 2
		// H_n = n * (2 * n - 1) = 2n^2 - n
		// 2n^2 - n = (4n^2 - 2n) / 2
		// (4n^2 - 2n) / 2 = 2n * (2n - 1) / 2
		// 2n * (2n - 1) / 2 = (2n - 1) * ((2n - 1) + 1) / 2
		// (2n - 1) * ((2n - 1) + 1) / 2 = T_(2n - 1)
		// H_n = T_(2n - 1)
		
		// H_143 = P_165 = T_285
		// starting from H_144, check if H_n is pentagonal
		long tph = 0;
		int n = 144;
		while (tph == 0){
			long h = GetHexagon(n);
			if (IsPentagon(h)) tph = h;
			n++;
		}
		return tph;
	}
	
	private static long GetHexagon(long n){
		return n * (2 * n - 1);
	}
	
	private static bool IsPentagon(long x){
		// p = (3x^2 - x) / 2
		// 3x^2 - x - 2p = 0
		// x = (1 + sqrt(1 + 24p)) / 6
		double n = (Math.Sqrt(24 * x + 1) + 1) / 6;
		return n == (long) n;
	}
	
	public static void Main(){
		Console.WriteLine(Euler45());
	}
}
