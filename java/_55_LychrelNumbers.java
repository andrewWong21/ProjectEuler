import java.util.*;

public class _55_LychrelNumbers{
    
    public static boolean isPalindrome(long num){
        long rev = 0;
        long n = num;
        while (n > 0){
            long digit = n % 10;
            rev = rev * 10 + digit;
            n = (n - digit) / 10;
        }
        return num == rev;
    }
    
    public static long reverse(long num){
        long rev = 0;
        while (num > 0){
            long digit = num % 10;
            rev = rev * 10 + digit;
            num = (num - digit) / 10;
        }
        return rev;
    }
    
    public static void main(String[] args){
        
        int nums = 0;
        
        for (int i = 1; i < 10000; i++){
            
            long num = i;
            boolean isLychrel = true;
            for (int j = 1; j <= 50; j++){
                long sum = num + reverse(num);
                if (isPalindrome(sum)){
                    // if (j > 20) System.out.println("\t" + i + " " + j + " " + sum);
                    isLychrel = false;
                    break;
                }
                num = sum;
            }
            if (isLychrel){
                // System.out.println("Lychrel: " + i);
                nums++;
            }
        }
        
        System.out.println("Number of integers that do not produce a palindrome within 50 iterations: " + nums); // 249
    }
}