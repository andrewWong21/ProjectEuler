using System;
using System.Numerics;

public class _48_SelfPowers{
	public static long Euler48(){
		BigInteger sum = 0;
		const long Mod = 10_000_000_000;
		for (int i = 1; i <= 1000; i++){
			sum += BigInteger.ModPow(i, i, Mod);
			sum %= Mod;
		}
		return (long) sum;
	}
	
	public static void Main(){
		Console.WriteLine(Euler48());
	}
}
