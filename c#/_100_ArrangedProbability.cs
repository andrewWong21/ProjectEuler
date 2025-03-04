using System;

public class _100_ArrangedProbability{
	public static long Euler100(){
		
		// b / (b + r) * (b - 1) / (b + r - 1) = 1 / 2
		// (b^2 - b) / ((b + r) * (b + r - 1)) = 1 / 2
		// 2b^2 - 2b = (b + r)^2 - (b + r)
		// 2b^2 - 2b = b^2 + 2br + r^2 - b - r
		// b^2 - b = 2br + r^2 - r
		// b^2 - b - 2br + r - r^2 = 0
		// b^2 - (2r + 1)b + (r - r^2) = 0
		
		// a = 1, b = -(2r + 1), c = (r - r^2)
		// B = ((2r + 1) +/- sqrt(4r^2 + 4r + 1 - 4r + 4r^2)) / 2
		// B = (2r + 1 +/- sqrt(8r^2 + 1)) / 2
		
		// (2r + 1)^2 = 4r^2 + 4r + 1 < 8r^2 + 1 for all r > 1
		// discard -sqrt(...), as B must be a positive integer
		// sqrt(8r^2 + 1) must be an odd integer x
		// x = sqrt(8r^2 + 1), x^2 = 8r^2 + 1
		// x^2 - 8r^2 = 1, fundamental solution (x_f, r_f) = (3, 1)
		long max = 1_000_000_000_000;
		long x_f = 3, r_f = 1;
		long x = x_f, r = r_f;
		while (true){
			double discSqrt = Math.Sqrt((double) 8 * r * r + 1);
			if (discSqrt % 1 == 0 && discSqrt % 2 == 1){
				long b = r + (long) (discSqrt + 1) / 2;
				if (b + r > max) return b;
			}
			long newX = x_f * x + 8 * r_f * r;
			long newR = r_f * x + x_f * r;
			x = newX;
			r = newR;
		}
	}
	
	public static void Main(){
		Console.WriteLine(Euler100());
	}
}
