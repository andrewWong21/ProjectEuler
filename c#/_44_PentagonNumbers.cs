using System;

public class _44_PentagonNumbers{
	public static int Euler44(){
		// searching for D = P_k - P_j, k > j
		// using P_n = n * (3 * n - 1) / 2 = (3n^2 - n) / 2
		// D = (3k^2 - k) / 2 - (3j^2 - j) / 2
		// D = (3k^2 - k - 3j^2 + j) / 2
		
		// k > j, k = j + x
		// D = (3(j + x)^2 - (j + x) - 3j^2 + j) / 2
		// D = (3j^2 + 6jx + 3x^2 - j - x - 3j^2 + j) / 2
		// D = (6jx) / 2 + (3x^2 - x) / 2 = 3jx + P_x
		// D - P_x = 3jx
		
		int diff = 0, n = 1;
		while (diff == 0){
			int pentD = GetPentagon(n);
			for (int x = 1; x < n; x++){
				int pentX = GetPentagon(x);
				if ((pentD - pentX) % (3 * x) == 0){
					int j = (pentD - pentX) / (3 * x);
					int pentJ = GetPentagon(j);
					int pentK = GetPentagon(j + x);
					if (IsPentagon(pentJ + pentK)){
						diff = pentD;
						break;
					}
				}
			}
			n++;
		}
		return diff;
	}
	
	private static int GetPentagon(int n){
		return (3 * n * n - n) / 2;
	}
	
	private static bool IsPentagon(int x){
		// p = (3x^2 - x) / 2
		// 3x^2 - x - 2p = 0
		// x = (1 + sqrt(1 + 24p)) / 6
		double n = (Math.Sqrt(24 * x + 1) + 1) / 6;
		return n == (int) n;
	}
	
	public static void Main(){
		Console.WriteLine(Euler44());
	}
}
