using System;
using System.Collections.Generic;

public class _87_PrimePowerTriples{
	public static int Euler87(){
		int max = 50000000;
        int maxSqrt = (int) Math.Sqrt(max);
        int maxCbrt = (int) Math.Cbrt(max);
        int maxFtrt = (int) Math.Sqrt(Math.Sqrt(max));
		bool[] sieved = new bool[maxSqrt];
		List<int> squares = new List<int>();
		List<int> cubes = new List<int>();
		List<int> fourths = new List<int>();
		for (int i = 2; i < sieved.Length; i++){
			if (!sieved[i]){
				squares.Add(i * i);
				if (i < maxCbrt) cubes.Add(i * i * i);
				if (i < maxFtrt) fourths.Add(i * i * i * i);
				for (int j = 2 * i; j < sieved.Length; j += i){
					sieved[j] = true;
				}
			}
		}
		HashSet<int> sums = new HashSet<int>();
		foreach (int fourth in fourths){
			foreach (int cube in cubes){
				if (fourth + cube >= max) break;
				foreach (int square in squares){
					int sum = square + cube + fourth;
					if (sum >= max) break;
					sums.Add(sum);
				}
			}
		}
		return sums.Count;
	}
	
	public static void Main(){
		Console.WriteLine(Euler87());
	}
}
