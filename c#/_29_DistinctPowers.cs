using System;
using System.Collections.Generic;
using System.Numerics;

public class _29_DistinctPowers{
	public static int Euler29(){
		HashSet<BigInteger> powers = new HashSet<BigInteger>();
		for (int a = 2; a <= 100; a++){
			for (int b = 2; b <= 100; b++){
				powers.Add(BigInteger.Pow(a, b));
			}
		}
		return powers.Count;
	}
	
	public static void Main(){
		Console.WriteLine(Euler29());
	}
}
