import java.util.*;

public class _46_GoldbachsOtherConjecture{
    
    public static boolean isPrime(int n){
        for (int i = 2; i*i < n; i++){
            if (n % i == 0)
                return false;
        }
        return true;
    }
    
    public static void main(String[] args){
        
        // If n = p + 2*s^2, then p = n - 2*s^2.
        // Starting at n = 35, apply the algorithm to every odd composite number.
        // Iterate through all values of i such that i*i = s and 2*s < n,
        // then check if the difference is prime.
        // If all values of i have been checked and no corresponding sum has been found,
        // n is the smallest number that contradicts Goldbach's conjecture.
        
        int smallest = 0;
        // 33 can be written as a sum of a prime and twice a square. (33 = 31 + 2 * 1^2)
        int n = 35; 
        while (smallest == 0){
            
            if (isPrime(n)){
                // System.out.println(n + " is prime");
                n += 2;
                continue;
            }
            
            boolean foundSum = false;
            for (int i = 1; 2*i*i < n; i++){
                int s = i*i;
                if (isPrime(n - 2*s)){
                    // System.out.printf("%d = %d + 2*%d\n", n, n - 2*s, s);
                    foundSum = true;
                    break;
                }
            }
            
            if (!foundSum)
                smallest = n;
            n += 2;
        }
        
        System.out.println("Smallest odd composite that cannot be written as the sum of a prime and twice a square: " + smallest); // 5777
    }
}