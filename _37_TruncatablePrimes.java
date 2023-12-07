import java.util.*;

public class _37_TruncatablePrimes{
    
    // A left-truncatable prime remains prime when digits are
    // successively removed starting from the leftmost digit.
    public static boolean isLeftTrunc(int p){
        // precondition: p is prime
        String pStr = String.valueOf(p);
        while (pStr.length() > 0){
            if (!isPrime(Integer.parseInt(pStr))){
                return false;
            }
            pStr = pStr.substring(1);
        }
        return true;
    }
    
    // A right-truncatable prime remains prime when digits are
    // successively removed starting from the rightmost digit.
    public static boolean isRightTrunc(int p){
        // precondition: p is prime
        while (p > 0){
            if (!isPrime(p)){
                return false;
            }
            p /= 10;
        }
        return true;
    }
    
    public static boolean isPrime(int n){
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args){
        
        // The truncatable primes to be found must have at least 2 digits.
        
        // If a number contains the digits 0, 4, 6, or 8, then it will have a truncation that is composite.
        
        // The prime may not end in 2 or 5, as it will then be a multiple of a prime.
        // It may still begin with either of those digits, which ensures the last right truncation will be prime.
        
        ArrayList<Integer> truncPrimes = new ArrayList<>();
        
        int n = 10; // skip consideration of 2, 3, 5, 7
        while (truncPrimes.size() < 11){
            if (isPrime(n) && isLeftTrunc(n) && isRightTrunc(n)){
                // System.out.println(n);
                truncPrimes.add(n);
            }
            n++;
        }
        
        int sum = 0;
        for (int prime : truncPrimes){
            sum += prime;
        }
        
        System.out.println("Sum of all eleven L-R and R-L truncatable primes: " + sum); // 748317
        // Primes that are truncatable from both left-to-right and right-to-left (not counting 2, 3, 5, 7):
        // 23, 37, 53, 73, 313, 317, 373, 797, 3137, 3797, 739397
    }
}