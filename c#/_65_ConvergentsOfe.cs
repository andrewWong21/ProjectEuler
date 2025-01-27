using System;
using System.Numerics;

public class _65_ConvergentsOfe{
	public static int Euler65(){
		int res = 0;
		BigInteger prev = 1, curr = 1;
		int k = 1;
		for (int i = 1; i <= 100; i++){
			int r = 1;
			if (i % 3 == 0){
				r = 2 * k++;
			}
			BigInteger next = r * curr + prev;
			prev = curr;
			curr = next;
		}
		
		foreach (char c in curr.ToString()){
			res += c - '0';
		}
		return res;
	}
	
	public static void Main(){
		Console.WriteLine(Euler65());
	}
}
