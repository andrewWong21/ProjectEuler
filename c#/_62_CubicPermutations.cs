using System;
using System.Collections.Generic;

public class _62_CubicPermutations{
	public static long Euler62(){
		long minCube = long.MaxValue;
		long n = 345;
		int len = 8;
		while (minCube == long.MaxValue){
			Dictionary<string, List<long>> cubeDigits = new Dictionary<string, List<long>>();
			for (; n * n * n < Math.Pow(10, len); n++){
				long cube = n * n * n;
				char[] digits = cube.ToString().ToCharArray();
				Array.Sort(digits);
				string key = new string(digits);
				if (!cubeDigits.ContainsKey(key)){
					cubeDigits[key] = new List<long>();
				}
				cubeDigits[key].Add(cube);
				
			}
			foreach (String key in cubeDigits.Keys){
				if (cubeDigits[key].Count == 5){
					minCube = Math.Min(minCube, cubeDigits[key][0]);
				}
			}
			len++;
		}
		return minCube;
	}
	
	public static void Main(){
		Console.WriteLine(Euler62());
	}
}
