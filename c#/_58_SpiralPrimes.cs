using System;

public class _58_SpiralPrimes{
	public static int Euler58(){
		int s = 3, primes = 3, total = 5;
		while (primes * 10 >= total){
			s += 2;
			if(IsPrime(s * s - s + 1)) primes++;
			if(IsPrime(s * s - 2 * s + 2)) primes++;
			if(IsPrime(s * s - 3 * s + 3)) primes++;
			total += 4;
		}
		
		return s;	
	}
	
	public static bool IsPrime(int n){
		for (int i = 2; i * i <= n; i++){
			if (n % i == 0) return false;
		}
		return true;
	}
	
	public static void Main(){
		Console.WriteLine(Euler58());
	}
}
