import java.util.*;

public class _77_PrimeSummations{
    
    public static ArrayList<Integer> sieve(int n){
        boolean[] sieved = new boolean[n + 1];
        
        ArrayList<Integer> primes = new ArrayList<Integer>();
        for (int i = 2; i < sieved.length; i++){
            if (!sieved[i]){
                for (int j = i+i; j < sieved.length; j += i){
                    sieved[j] = true;
                }
                primes.add(i);
            }
        }
        
        return primes;
    }
    
    public static void main(String[] args){
        
        ArrayList<Integer> primes = sieve(1000);
        int[] sums = new int[1001];
        sums[0] = 1;
        
        for (int prime : primes){
            for (int i = prime; i < sums.length; i++){
                // For each prime p, iterate through all integers i at least equal to p
                // and add the number of currently known ways to sum primes to the difference of i and p
                // to the currently known number of ways to sum to i using primes less than p.
                
                // A given integer i will have all of its sums calculated when p reaches a value greater than i.
                
                if (prime <= i){
                    sums[i] += sums[i - prime];
                }
            }
        }
        
        int ans = -1;
        for (int i = 0; i < sums.length && ans == -1; i++){
            if (sums[i] >= 5000){
                ans = i;
            }
        }
        
        System.out.println("First number that can be written as a sum of primes in over 5000 ways: " + ans); // 71
    }
}