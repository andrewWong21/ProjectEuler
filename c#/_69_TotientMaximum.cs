using System;

public class _69_TotientMaximum{
	public static int Euler69(){
		int n = 1_000_000, res = 0;
		double maxRatio = 1;
		bool[] sieved = new bool[n + 1];
		double[] totients = new double[n + 1];
		for (int i = 0; i <= n; i++){
			totients[i] = i;
		}
		for (int i = 2; i <= n; i++){
			if (!sieved[i]){
				totients[i]--;
				for (int j = 2 * i; j <= n; j += i){
					sieved[j] = true;
					totients[j] *= (i - 1.0) / i;
				}
			}
			double ratio = i / totients[i];
			if (ratio > maxRatio){
				res = i;
				maxRatio = ratio;
			}
		}
		return res;
	}
	
	public static void Main(){
		Console.WriteLine(Euler69());
	}
}
