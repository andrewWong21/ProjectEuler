using System;

public class _73_CountingFractionsInARange{
	public static int Euler73(){
		int max = 12_000, res = 0;
		for (int i = 2; i <= max; i++){
			for (int j = i / 3 + 1; j * 2 < i; j++){
				if (GCF(i, j) == 1) res++;
			}
		}
		return res;
	}
	
	public static int GCF(int a, int b){
		while (b > 0){
			int temp = a % b;
			a = b;
			b = temp;
		}
		return a;
	}
	
	public static void Main(){
		Console.WriteLine(Euler73());
	}
}
