import java.util.*;

public class _69_TotientMaximum{
    
    static ArrayList<Integer> primes = sieve(1000000);
    static HashSet<Integer> primesSet = new HashSet<>(primes);
    
    public static ArrayList<Integer> sieve(int n){
        
        ArrayList<Integer> primes = new ArrayList<>();
        boolean[] sieved = new boolean[n + 1];
        sieved[0] = sieved[1] = true;
        
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
    
    public static int totient(int n){
        if (primesSet.contains(n)){
            return n - 1;
        }
        
        HashSet<Integer> primeFactors = getDistinctPrimeFactors(n);
        double ans = 1;
        
        // Using Euler's totient formula phi(n) = n * P(p - 1/p)
        // where for all distinct prime factors p of n
        
        for (int p : primeFactors){
            ans *= (p - 1.0) / p;
        }
        return (int) (n * ans);
    }
    
    public static void main(String[] args){
        
        int maxN = 0;
        double maxRatio = 0;
        
        for (int n = 2; n <= 1000000; n++){
            double ratio = (double) n / totient(n);
            if (ratio > maxRatio){
                maxRatio = ratio;
                maxN = n;
            }
        }
        
        System.out.println("Value of n for n <= 1000000 with the greatest value for n/phi(n): " + maxN); // 510510
    }
}