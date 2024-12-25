using System;
using System.Collections.Generic;

public class _32_PandigitalProducts{
	public static int Euler32(){
		HashSet<int> products = new HashSet<int>();
		// 2-digit * 3-digit = 4-digit
		for (int a = 12; a <= 98; a++){
			for (int b = 123; b <= 987; b++){
				if (b % 10 == 0) continue;
				int product = a * b;
				if (IsPandigital(a, b, product)){
					products.Add(product);
				}
			}
		}
		// 1-digit * 4-digit = 4-digit
		for (int a = 2; a < 10; a++){
			for (int b = 1234; b <= 9876; b++){
				if (b % 10 == 0) continue;
				int product = a * b;
				if (IsPandigital(a, b, product)){
					products.Add(product);
				}
			}
		}
		int res = 0;
		foreach (int product in products){
			res += product;
		}
		return res;
	}
	
	public static bool IsPandigital(int a, int b, int c){
		string digits = a.ToString() + b.ToString() + c.ToString();
		if (digits.Length != 9) return false;
		bool[] seen = new bool[9];
		foreach (char digit in digits){
			int idx = digit - '1';
			if (idx < 0 || seen[idx]) return false;
			seen[idx] = true;
		}
		return true;
	}
	
	public static void Main(){
		Console.WriteLine(Euler32());
	}
}
