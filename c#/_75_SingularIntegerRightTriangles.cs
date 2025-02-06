using System;

public class _75_SingularIntegerRightTriangles{
	public static int Euler75(){
		int max = 1_500_000;
		int[] perims = new int[max + 1];
		
		for (int m = 2; m * m < max; m++){
			for (int n = 1; n < m; n++){
				if (GCD(m, n) == 1){
					int a = m * m - n * n;
					int b = 2 * m * n;
					int c = m * m + n * n;
					if (b < a) continue;
					if (m % 2 == 1 && n % 2 == 1){
						a /= 2;
						b /= 2;
						c /= 2;
					}
					int k = 1, p = a + b + c;
					while (k * p <= max){
						perims[k * p]++;
						k++;
					}
				}
			}
		}
		int res = 0;
		for (int i = 3; i <= max; i++){
			if (perims[i] == 1) res++;
		}
		return res;
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
		Console.WriteLine(Euler75());
	}
}
