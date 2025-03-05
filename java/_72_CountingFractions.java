import java.util.*;

public class _72_CountingFractions{
    
    public static int[] totientSieve(int n){
        int[] sieve = new int[n + 1];
        
        for (int i = 0; i < sieve.length; i++){
            sieve[i] = i;
        }
        
        for (int i = 1; i < sieve.length; i++){
            int phi = sieve[i];
            for (int j = 2*i; j < sieve.length; j += i){
                sieve[j] -= phi;
            }
        }
        
        return sieve;
    }
    
    public static void main(String[] args){
        // F_2 has  1 fraction      1/2
        // F_3 has  3 fractions    +(1, 2)/3
        // F_4 has  5 fractions    +(1, 3)/4
        // F_5 has  9 fractions    +(1, 2, 3, 4)/5
        // F_6 has 11 fractions    +(1, 5)/6
        // F_7 has 17 fractions    +(1, 2, 3, 4, 5, 6)/7
        // F_8 has 21 fractions    +(1, 3, 5, 7)/8
        
        // |F_n| = |F_(n-1)| + phi(n)
        
        int[] sieve = totientSieve(1000000);
        
        long sum = 0;
        for (int i = 2; i < sieve.length; i++){
            sum += sieve[i];
        }
        
        System.out.println("Number of elements in the set of reduced proper fractions up to d <= 1000000: " + sum); // 303963552391
    }
}