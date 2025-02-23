using System;
using System.Collections.Generic;

public class _92_SquareDigitChains{
	public static int Euler91(){
		List<int> nums = new List<int>();
		for (int i = 2; i < 10_000_000; i++){
			int n = i;
			while (n != 1 && n != 89){
				int sum = 0;
				while (n > 0){
					int d = n % 10;
					sum += d * d;
					n /= 10;
				}
				n = sum;
			}
			if (n == 89) nums.Add(i);
		}
		return nums.Count;
	}
	
	public static void Main(){
		Console.WriteLine(Euler91());
	}
}
