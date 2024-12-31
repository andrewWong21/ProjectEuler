using System;

public class _38_PandigitalMultiples{
	public static int Euler38(){
		string res = "";
		for (int i = 1; i <= 9876; i++){
			string s = "";
			for (int k = 1; s.Length < 9; k++){
				s += (i * k).ToString();
			}
			if (IsPandigital(s) && s.CompareTo(res) > 0){
				res = s;
			}
		}
		return int.Parse(res);
	}
	
	private static bool IsPandigital(string s){
		if (s.Length != 9) return false;
		bool[] seen = new bool[9];
		foreach (char c in s){
			int idx = c - '1';
			if (idx < 0 || seen[idx]) return false;
			seen[idx] = true;
		}
		return true;
	}
	
	public static void Main(){
		Console.WriteLine(Euler38());
	}
}
