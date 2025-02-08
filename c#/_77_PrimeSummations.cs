using System;

public class _77_PrimeSummations{
	public static int Euler76(){
		bool[] sieved = new bool[101];
		int[] sums = new int[101];
		sums[0] = 1;
		for (int i = 2; i < sieved.Length; i++){
			if (!sieved[i]){
				for (int j = i; j < sieved.Length; j++){
					sums[j] += sums[j - i];
					if (j % i == 0){
						sieved[j] = true;
					}
				}
			}
			if (sums[i] > 5_000) return i;
		}
		return -1;
	}
	
	public static void Main(){
		Console.WriteLine(Euler76());
	}
}
