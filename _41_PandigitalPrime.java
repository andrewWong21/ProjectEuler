import java.util.*;

public class _41_PandigitalPrime{
    
    public static boolean isPrime(int n){
        for (int i = 2; i*i <= n; i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
    
    
    public static boolean isPandigital(int p){
        String str = String.valueOf(p);
        HashSet<Character> digitSet = new HashSet<>();
        
        for (Character chr : str.toCharArray()){
            digitSet.add(chr);
        }
        
        if (digitSet.contains('0') || digitSet.size() != str.length()){
            return false;
        }
        
        String digits = "123456789";
        for (int i = 0; i < digitSet.size(); i++){
            if (!digitSet.contains(digits.charAt(i))){
                return false;
            }
        }
        
        return true;
    }
    
    public static String swapChars(String str, int i, int j){
        
        char[] charArr = str.toCharArray();
        
        char temp = charArr[i];
        charArr[i] = charArr[j];
        charArr[j] = temp;
        
        return String.valueOf(charArr);
    }
    
    public static void main(String[] args){
        // An n-digit pandigital prime uses all the digits from 1 to n exactly once,
        // so the largest pandigital prime can be at most 9 digits.
        
        // However, summing up the digits from 1 to 9 yields 45, which is divisible by 3.
        // Thus, any integer that is 1-9 pandigital will also be divisible by 3.
        // The same logic applies to 1-8 pandigital integers, as the sum of their digits is 36.
        // In fact, only integers with 1, 4, or 7 digits can be pandigital primes due to this divisibility rule.
        // N -> sum (1 -> 1, 2 -> 3, 3 -> 6, 4 -> 10, 5 -> 15, 6 -> 21, 7 -> 28, 8 -> 36, 9 -> 45)
        // The largest pandigital prime has at most 7 digits and is therefore less than 10^7.
        
        // Since there are over 650,000 primes less than 10^7, sieving all primes with at most 7 digits
        // and checking them in reverse order for pandigitalness is not efficient.
        
        // Another approach is finding all permutations of the digits 1-7 and 1-4, then iterating through
        // them in reverse lexicographical order until a prime permutation is found.
        // There are far fewer pandigital integers less than 10^7 than there are primes less than 10^7,
        // so this reduces the number of integers to be checked down to fewer than 6,000 (7! + 4! = 5064).
        
        int maxPandigitalPrime = 0;
        
        String str = "7654321";
        
        // Starting from the last permutation lexicographically, modify the string
        // to get the previous permutation and check if it is prime.
        while (maxPandigitalPrime == 0){
            
            int i = str.length() - 1;
            
            // Iterate backwards from the end to find the rightmost index i
            // that marks the start of a group of increasing digits until the end of the string.
            // The digit at index i - 1 will be the first different digit in the previous permutation.
            while (str.charAt(i - 1) < str.charAt(i)){
                i--;
            }
            
            // Find the index of the next largest digit in the group of increasing digits, j - 1,
            // and swap the digits at indices i - 1 and j - 1.
            int j = i + 1;
            while (j < str.length() && str.charAt(j) < str.charAt(i - 1)){
                j++;
            }
            
            // System.out.println(str);
            // System.out.println((i - 1) + " " + (j - 1) + " swapping chars " + str.charAt(i - 1) + " " + str.charAt(j - 1));
            str = swapChars(str, i - 1, j - 1);
            // System.out.println(str);
            
            // Since the digit originally at j - 1 is less than the digit originally at i - 1,
            // the group of digits from index i to the end of the string maintains its ascending property.
            // Reverse this group of digits to complete the previous permutation.
            
            // System.out.println("reversing chars " + str.substring(i));
            for (int x = i, y = str.length() - 1; x < y; x++, y--){
                str = swapChars(str, x, y);
            }
            
            int n = Integer.valueOf(str);
            
            if (isPrime(n)){
                maxPandigitalPrime = n;
                break;
            }
        }
        
        // Brute force checking all odd 7-digit integers from the highest 7-digit pandigital
        // to the lowest 7-digit pandigital and checking if they are both pandigital and prime.
        
        // for (int n = 7654321; n >= 1234567; n -= 2){
            // if (isPandigital(n)) && isPrime(n)){
                // // System.out.println(n);
                // maxPandigitalPrime = n;
                // break;
            // }
        // }
        
        System.out.println("The largest pandigital prime is " + maxPandigitalPrime); // 7652413
    }
}