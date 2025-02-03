using System;

public class _71_OrderedFractions{
	public static int Euler71(){
		// calculate mediant of a/b and c/d, (a + c) / (b + d)
		int max = 1_000_000;
		int a = 2, b = 5, c = 3, d = 7;
		// while (b + d <= 1_000_000){
		//     a += c;
		//     b += d;
		// }
		// return a;
		double k = (max - b) / d;
		return a + (int) Math.Floor(k) * c;
	}
	
	public static void Main(){
		Console.WriteLine(Euler71());
	}
}
