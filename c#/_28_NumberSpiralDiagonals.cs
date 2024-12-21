using System;

public class _28_NumberSpiralDiagonals{
	public static int Euler28(){
		int sum = 1;
		// n = 3: corners 9, 7, 5, 3
		// n = 5: corners 25, 21, 17, 13
		// n = 7: corners 49, 43, 37, 31
		// n = 9: corners 81, 73, 65, 57
		// n = x: corners x^2, x^2 - x + 1, x^2 - 2x + 2, x^2 - 3x + 3
		// sum of corners: 4x^2 - 6x + 6
		for (int n = 3; n <= 1001; n += 2){
			sum += 4 * n * n - 6 * n + 6;
		}
		return sum;
	}
	
	public static void Main(){
		Console.WriteLine(Euler28());
	}
}
