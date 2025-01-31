using System;
using System.Text;
using System.Collections.Generic;

public class _68_Magic5gonRing{
	static string maxString = "";
	public static string Euler68(){
		Backtrack(new List<int>(), new bool[10], 0);
		return maxString;
	}
	
	private static void Backtrack(List<int> curr, bool[] used, int idx){
		if (idx == used.Length){
		    string ring = GetRing(curr);
			if (maxString.CompareTo(ring) < 0){
				maxString = ring;
			}
			return;
		}
		for (int i = 0; i < used.Length; i++){
			if (!used[i]){
				used[i] = true;
				curr.Add(i + 1);
				Backtrack(curr, used, idx + 1);
				curr.RemoveAt(curr.Count - 1);
				used[i] = false;
			}
		}
	}
	
	private static string GetRing(List<int> nums){
		List<int> inner = nums.GetRange(0, 5);
		List<int> outer = nums.GetRange(5, 5);
		StringBuilder sb = new StringBuilder();
		int sum = -1;
		for (int i = 0; i < 5; i++){
			if (i > 0 && outer[i] < outer[0]){
				return "";
			}
			int nodeSum = outer[i] + inner[i] + inner[(i + 1) % 5];
			if (sum != -1 && sum != nodeSum){
				return "";
			}
			else sum = nodeSum;
			sb.Append(outer[i]);
			sb.Append(inner[i]);
			sb.Append(inner[(i + 1) % 5]);
		}
		return sb.ToString();
	}
	
	public static void Main(){
		Console.WriteLine(Euler68());
	}
}
