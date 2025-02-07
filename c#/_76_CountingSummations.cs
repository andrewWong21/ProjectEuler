using System;

public class _76_CountingSummations{
	public static int Euler76(){
		int[] sums = new int[101];
		sums[0] = 1;
        // summing positive integers less than 100 (exclusive)
        // i is current largest positive integer used
		for (int i = 1; i < 100; i++){
            // summing to positive integers up to 100 (inclusive)
			for (int j = i; j <= 100; j++){
				sums[j] += sums[j - i];
			}
		}
		return sums[100];
	}
	
	public static void Main(){
		Console.WriteLine(Euler76());
	}
}
