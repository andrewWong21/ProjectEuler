using System;
using System.Collections.Generic;

public class _61_CyclicalFigurateNumbers{
	static List<int> triangles = new List<int>();
	static List<int> squares = new List<int>();
	static List<int> pentagons = new List<int>();
	static List<int> hexagons = new List<int>();
	static List<int> heptagons = new List<int>();
	static List<int> octagons = new List<int>();
	static List<List<int>> polygons = new List<List<int>>();
	static int sum = 0;
	
	public static int Euler61(){
		for (int i = 1000; i <= 9999; i++){
			if (IsOctagon(i)) octagons.Add(i);
			else if (IsHeptagon(i)) heptagons.Add(i);
			else if (IsHexagon(i)) hexagons.Add(i);
			else if (IsPentagon(i)) pentagons.Add(i);
			else if (IsSquare(i)) squares.Add(i);
			else if (IsTriangle(i)) triangles.Add(i);
		}
		
		polygons.Add(triangles);
		polygons.Add(squares);
		polygons.Add(pentagons);
		polygons.Add(hexagons);
		polygons.Add(heptagons);
		foreach (int octagon in octagons){
			List<int> cycle = new List<int>{octagon};
			if (GenerateCycle(cycle, new HashSet<int>())){
				break;
			}
		}
		
		return sum;
	}
	
	public static bool GenerateCycle(List<int> cycle, HashSet<int> used){
		if (cycle.Count == 6){
			if (cycle[5] % 100 == cycle[0] / 100){
				foreach (int num in cycle){
					sum += num;
				}
				return true;
			}
			else return false;
		}
		for (int i = 0; i < polygons.Count; i++){
			if (used.Contains(i)) continue;
			List<int> currSet = polygons[i];
			foreach (int p in currSet){
				if (p / 100 == cycle[cycle.Count - 1] % 100){
					cycle.Add(p);
					used.Add(i);
					if (GenerateCycle(cycle, used)) return true;
					cycle.RemoveAt(cycle.Count - 1);
					used.Remove(i);
				}
			}
		}
		return false;
	}
	
	public static bool IsTriangle(int p){
		// p = (n^2 + n) / 2
		// 0 = n^2 + n - 2p
		// n = (-1 + sqrt(8p + 1)) / 2;
		double n = (Math.Sqrt(8 * p + 1) - 1) / 2;
		return n == (int) n;
	}
	
	public static bool IsSquare(int p){
		double n = Math.Sqrt(p);
		return n == (int) n;
	}
	
	public static bool IsPentagon(int p){
		// p = (3n^2 - n) / 2
		// 0 = 3n^2 - n - 2p
		// n = (1 + sqrt(1 + 24p)) / 6
		double n = (Math.Sqrt(24 * p + 1) + 1) / 6;
		return n == (int) n;
	}
	
	public static bool IsHexagon(int p){
		// p = 2n^2 - n
		// 0 = 2n^2 - n - p
		// n = (1 + sqrt(1 + 8p)) / 4
		double n = (Math.Sqrt(8 * p + 1) + 1) / 4;
		return n == (int) n;
	}
	
	public static bool IsHeptagon(int p){
		// p = (5n^2 - 3n) / 2
		// 0 = 5n^2 - 3n - 2p
		// n = (3 + sqrt(9 + 40p) / 5
		double n = (Math.Sqrt(40 * p + 9) + 3) / 10;
		return n == (int) n;
	}
	
	public static bool IsOctagon(int p){
		// p = 3n^2 - 2n
		// 0 = 3n^2 - 2n - p
		// n = (2 + sqrt(4 + 12p)) / 6
		// n = (2 + 2 * sqrt(1 + 3p) / 6
		// n = (1 + sqrt(1 + 3p) / 3
		double n = (Math.Sqrt(3 * p + 1) + 1) / 3;
		return n == (int) n;
	}
	
	public static void Main(){
		Console.WriteLine(Euler61());
	}
}
