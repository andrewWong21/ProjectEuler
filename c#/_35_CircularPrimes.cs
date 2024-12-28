using System;
using System.Collections.Generic;

public class _35_CircularPrimes{
	public static int Euler35(){
		int count = 0, max = 1_000_000;
		bool[] sieved = new bool[max];
		HashSet<int> primes = new HashSet<int>();
		for (int i = 2; i < max; i++){
			if (!sieved[i]){
				for (int j = 2 * i; j < max; j += i){
					sieved[j] = true;
				}
				if (i < 10 || !HasCompositeRotation(i)){
					primes.Add(i);
				}
			}
		}
		foreach (int prime in primes){
			string primeStr = prime.ToString();
			bool isCircular = true;
			for (int i = 0; i < primeStr.Length; i++){
				string rotated = primeStr.Substring(i) + primeStr.Substring(0, i);
				if (!primes.Contains(int.Parse(rotated))){
					isCircular = false;
					break;
				}
			}
			if (isCircular) count++;
		}
		return count;
	}

	private static bool HasCompositeRotation(int n){
		HashSet<char> compositeDigits = new HashSet<char>{'0', '2', '4', '5', '6', '8'};
		foreach (char digit in n.ToString()){
			if (compositeDigits.Contains(digit)){
				return true;
			}
		}
		return false;
	}

	public static void Main(){
		Console.WriteLine(Euler35());
	}
}
