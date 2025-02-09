using System;

public class _78_CoinPartitions{
	public static int Euler78(){
		int[] partitions = new int[60_001];
		partitions[0] = 1;
		for (int i = 1; i < partitions.Length; i++){
			for (int j = i; j < partitions.Length; j++){
				partitions[j] += partitions[j - i] % 1_000_000;
				partitions[j] %= 1_000_000;
			}
			if (partitions[i] == 0) return i;
		}
		return 0;
	}
	
	public static void Main(){
		Console.WriteLine(Euler78());
	}
}
