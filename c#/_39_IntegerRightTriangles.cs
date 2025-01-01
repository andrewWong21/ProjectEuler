using System;

public class _39_IntegerRightTriangles{
	public static int Euler39(){
		// p = a + b + c
		// c = p - a - b
		
		// a^2 + b^2 = c^2
		// a^2 + b^2 = (p - a - b)^2
		// a^2 + b^2 = p^2 - ap - bp - ap + a^2 + ab - bp + ab + b^2
		// 0 = p^2 - 2ap - 2bp + 2ab
		// 2bp - 2ab = p^2 - 2ap
		// b * (2p - 2a) = p^2 - 2ap
		// b = (p^2 - 2ap) / (2p - 2a)
		
		// p^2 - 2ap > 0
		// p * (p - 2a) > 0
		// p - 2a > 0 (p > 0)
		// p > 2a
		// a < p / 2
		
		int res = 0, count = 0;
		for (int p = 1; p <= 1000; p++){
			int curr = 0;
			for (int a = 1; a < p / 2; a++){
				int num = p * p - 2 * a * p;
				int den = 2 * (p - a);
				if (num % den == 0){
					int b = num / den;
					if (a < b) curr++;
				}
			}
			if (curr > count){
				res = p;
				count = curr;
			}
		}
		return res;
	}
	
	public static void Main(){
		Console.WriteLine(Euler39());
	}
}
