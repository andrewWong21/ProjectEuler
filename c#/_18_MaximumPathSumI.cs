using System;
using System.Collections.Generic;

public class _18_MaximumPathSumI{
	public static int Euler18(){
		List<int[]> triangle = new List<int[]>();
		triangle.Add(new int[]{75});
		triangle.Add(new int[]{95, 64});
		triangle.Add(new int[]{17, 47, 82});
		triangle.Add(new int[]{18, 35, 87, 10});
		triangle.Add(new int[]{20, 04, 82, 47, 65});
		triangle.Add(new int[]{19, 01, 23, 75, 03, 34});
		triangle.Add(new int[]{88, 02, 77, 73, 07, 63, 67});
		triangle.Add(new int[]{99, 65, 04, 28, 06, 16, 70, 92});
		triangle.Add(new int[]{41, 41, 26, 56, 83, 40, 80, 70, 33});
		triangle.Add(new int[]{41, 48, 72, 33, 47, 32, 37, 16, 94, 29});
		triangle.Add(new int[]{53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14});
		triangle.Add(new int[]{70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57});
		triangle.Add(new int[]{91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48});
		triangle.Add(new int[]{63, 66, 04, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31});
		triangle.Add(new int[]{04, 62, 98, 27, 23, 09, 70, 98, 73, 93, 38, 53, 60, 04, 23});
		for (int i = triangle.Count - 2; i >= 0; i--){
			int[] row = triangle[i];
			for (int j = 0; j < row.Length; j++){
				row[j] += Math.Max(triangle[i + 1][j], triangle[i + 1][j + 1]);
			}
		}
		return triangle[0][0];
	}
	
	public static void Main(){
		Console.WriteLine(Euler18());
	}
}
