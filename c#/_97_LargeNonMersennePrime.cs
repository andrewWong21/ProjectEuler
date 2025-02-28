using System;
using System.Numerics;

public class _97_LargeNonMersennePrime{
	static long mod = 10_000_000_000;
	
	public static long Euler97(){
		// alternatively, use BigInteger.ModPow(base, exp, mod)
		BigInteger res = Pow(2, 7_830_457);
		res = (28433 * res + 1) % mod;
		return (long) res;
	}
	
	public static BigInteger Pow(BigInteger x, int n){
		BigInteger res = 1;
		while (n > 0){
			if (n % 2 == 1){
				res = (x * res) % mod;
			}
			x = (x * x) % mod;
			n /= 2;
		}
		return res;
	}
	
	public static void Main(){
		Console.WriteLine(Euler97());
	}
}
