import java.util.*;

public class _70_TotientPermutation{
    
    // One formula for calculating the totient of a given number n
    // is multiplying n by the product of (p-1)/p for all of n's distinct prime factors p.
    // However, this can result in rounding errors if p is sufficiently large.
    
    // Another formula for calculating phi(n) is the difference of n and
    // the totients of all the factors of n strictly less than n.
    // e.g. phi(20) = 20 - phi(1) - phi(2) - phi(4) - phi(5) = 20 - 1 - 1 - 2 - 4 = 12
    // This approach is useful for generating all totients up to a specified limit.
    
    public static int[] totientSieve(int n){
        int[] sieve = new int[n+1];
        for (int i = 0; i < sieve.length; i++){
            sieve[i] = i;
        }
        
        // When the index of n has been reached, its totient value is finalized.
        for (int i = 1; i < sieve.length; i++){
            int f = sieve[i];
            
            // Subtract n's totient from the currently stored totient values of all of its multiples.
            for (int j = 2*i; j < sieve.length; j += i){
                sieve[j] -= f;
            }
        }
        
        return sieve;
    }
    
    public static boolean isPermutation(int n, int phi){
        char[] digits1 = String.valueOf(n).toCharArray();
        char[] digits2 = String.valueOf(phi).toCharArray();
        Arrays.sort(digits1);
        Arrays.sort(digits2);
        return Arrays.equals(digits1, digits2);
    }
    
    public static void main(String[] args){
        
        int minN = -1;
        double minRatio = Double.MAX_VALUE;
        int[] sieve = totientSieve((int) 1e7);
        
        for (int n = 2; n < sieve.length; n++){
            int phi = sieve[n];
            double ratio = ((double) n) / phi;
            
            if (isPermutation(n, phi) && ratio < minRatio){
                minRatio = ratio;
                minN = n;
            }
        }
        System.out.println("Value of n for 1 < n < 10000000 that is a permutation of phi(n) and minimizes n/phi(n): " + minN); // 8319823
        // n = 8319823, phi(n) = 8313928
    }
}