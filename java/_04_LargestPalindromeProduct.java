import java.util.*;

public class _04_LargestPalindromeProduct{
    
    public static boolean isPalindrome(int num){
        // Check if reversing the digits returns 
        // the same number as the original.
        int rev = 0;
        int n = num;
        while (n > 0){
            int dig = n % 10;
            rev = rev * 10 + dig;
            n = (n - dig) / 10;
        }
        return num == rev;
    }
    
    public static int getLargestPalindrome(){
        int result = 0;
        // Bounds on largest 3-digit palindrome product:
        // 100000 (100*100) < p < 998001 (999*999)
        for (int a = 999; a >= 100; a--){
            for (int b = 999; b >= 100; b--){
                if (a*b > result && isPalindrome(a*b))
                    result = a*b;
            }
        }
        return result;
    }
    
    public static void main(String[] args){
        //long start1 = System.currentTimeMillis();
        System.out.println("Largest palindrome made from two 3-digit numbers: " + getLargestPalindrome());
        //long end1 = System.currentTimeMillis();
        //System.out.println(end1 - start1);
    }
}