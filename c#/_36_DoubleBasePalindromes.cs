using System;

public class _36_DoubleBasePalindromes{
	public static int Euler36(){
		int sum = 0;
		for (int i = 1; i < 1_000_000; i++){
			if (
				IsPalindrome(i.ToString()) && 
				IsPalindrome(Convert.ToString(i, 2))
			){
				sum += i;
			}
		}
		return sum;
	}
	
	public static bool IsPalindrome(string s){
		int i = 0, j = s.Length - 1;
		while (i < j){
			if (s[i] != s[j]) return false;
			i++;
			j--;
		}
		return true;
	}
	
	public static void Main(){
		Console.WriteLine(Euler36());
	}
}
