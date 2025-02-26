using System;
using System.Collections.Generic;

public class _94_AlmostEquilateralTriangles{
	public static int Euler94(){
		int maxPerim = (int) 1e9;
		int maxSide = (int) maxPerim / 3 + 1;
		int perimSum = 0;
		HashSet<(int, int)> almostTri = new HashSet<(int, int)>();
		
		for (int m = 1; m*m < maxSide; m++){
			for (int n = 1; n < m; n++){
				if (GCD(m, n) == 1){
					int a = m*m - n*n;
					int b = 2*m*n;
					int c = m*m + n*n;
					
					if (m % 2 == 1 && n % 2 == 1){
						a /= 2;
						b /= 2;
						c /= 2;
					}
					if (Math.Abs(c - 2*a) == 1 && 2 * (a + c) <= maxPerim && !almostTri.Contains((a, c))){
						almostTri.Add((a, c));
						perimSum += 2 * (a + c);
					}
					if (Math.Abs(c - 2*b) == 1 && 2 * (b + c) <= maxPerim && !almostTri.Contains((b, c))){
						almostTri.Add((b, c));
						perimSum += 2 * (b + c);
					}
				}
			}
		}
		return perimSum;
    }
	
	public static int GCD(int a, int b){
		while (b > 0){
			int temp = a % b;
			a = b;
			b = temp;
		}
		return a;
	}
	
	public static void Main(){
		Console.WriteLine(Euler94());
	}
}
