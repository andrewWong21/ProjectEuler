using System;

public class _55_LychrelNumbers{
	public static int Euler55(){
		int res = 0;
		for (int i = 1; i < 10_000; i++){
			if (IsLychrel(i)){
				res++;
			}
		}
		return res;
	}
	
	public static bool IsLychrel(long n){
		for (int i = 0; i < 50; i++){
			n += Reverse(n);
			if (IsPalindrome(n)) return false;
		}
		return true;
	}
	
	public static long Reverse(long n){
		long rev = 0;
		while (n > 0){
			rev = rev * 10 + n % 10;
			n /= 10;
		}
		return rev;
	}
	
	public static bool IsPalindrome(long n){
		return n == Reverse(n);
	}
	
	public static void Main(){
		Console.WriteLine(Euler55());
	}
}
