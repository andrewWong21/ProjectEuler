using System;

public class _04_LargestPalindromeProduct{
    public static int Euler04(){
        int res = 0;
        for (int i = 999; i >= 100; i--){
            for (int j = 999; j >= 100; j--){
                int product = i * j;
                if (product > res && IsPalindrome(product.ToString())){
                    res = product;
                }
            }
        }
        return res;
    }
    
    private static bool IsPalindrome(string s){
        for (int i = 0; i < s.Length / 2; i++){
            if (s[i] != s[s.Length - i - 1]) return false;
        }
        return true;
    }
    
    public static void Main(string[] args){
        Console.WriteLine(Euler04());
    }
}
