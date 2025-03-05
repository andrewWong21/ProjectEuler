import java.util.*;

public class _47_DistinctPrimeFactors{
    
    static HashSet<Integer> primes = new HashSet<>();
    
    public static boolean isPrime(int n){
        for (int i = 2; i*i < n; i++){
            if (n % i == 0)
                return false;
        }
        return true;
    }
    
    public static HashSet<Integer> getDistinctPrimeFactors(int n){
        HashSet<Integer> factors = new HashSet<>();
        Iterator<Integer> iter = primes.iterator();
        while (n > 1 && iter.hasNext()){
            int p = iter.next();
            while (n % p == 0){
                factors.add(p);
                n /= p;
            }
        }
        return factors;
    }
    
    public static void main(String[] args){
        
        int n = 2;
        int lastConsecutiveInt = 0;
        int streak = 0;
        
        // The performance of this approach is impacted by the initial primality check for each n.
        // To remedy this, a sieve could be initialized, but there is no immediately apparent upper bound,
        // meaning that the sieve may need to be recalculated with a higher bound if no results are found.
        
        while (lastConsecutiveInt == 0){
            if (!isPrime(n)){
                HashSet<Integer> factors = getDistinctPrimeFactors(n);
                
                if (factors.size() == 4){
                    // List<Integer> factorsList = new ArrayList<>(factors);
                    // Collections.sort(factorsList);
                    // System.out.println(n + ": " + factors.size() + " " + factorsList);
                    streak++;
                }
                else{
                    streak = 0;
                }
            }
            else{ // cache primes for faster lookup
                primes.add(n);
                streak = 0;
            }
            
            if (streak == 4){
                lastConsecutiveInt = n;
            }
            n++;
        }
        
        System.out.println("First of four consecutive integers with four distinct prime factors: " + (lastConsecutiveInt - 3)); // 134043
        // 134043: 3, 7, 13, 491
        // 134044: 2, 23, 31, 47
        // 134045: 5, 17, 19, 83
        // 134046: 2, 3, 11, 677
    }
}