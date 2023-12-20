import java.util.*;

public class _50_ConsecutivePrimeSum{
    
    public static ArrayList<Integer> sieve(){
        
        boolean[] sieved = new boolean[(int) 1e6];
        sieved[0] = sieved[1] = true;
        
        for (int i = 2; i < sieved.length; i++){
            if (!sieved[i]){
                for (int j = 2*i; j < sieved.length; j += i){
                    sieved[j] = true;
                }
            }
        }
        
        ArrayList<Integer> primes = new ArrayList<>();
        
        for (int i = 2; i < sieved.length; i++){
            if (!sieved[i]){
                primes.add(i);
            }
        }
        
        return primes;
    }
    
    public static void main(String[] args){
        
        ArrayList<Integer> primes = sieve(); // 78498 primes under 1 million
        
        // Find the maximum number of primes that can be added before the sum exceeds 1 million.
        int maxTerms = 0;
        int sum = 0;
        for (int i = 0; i < primes.size(); i++){
            if (sum + primes.get(i) < 1000000){
                sum += primes.get(i);
                maxTerms++;
            }
            else{
                break;
            }
        }
        // System.out.println("terms: " + maxTerms + " sum: " + sum);
        // A maximum of 546 primes can be added together to get a sum under 1 million.
        
        // Keep track of cumulative sums for faster lookup.
        int[] compSum = new int[maxTerms + 1];
        for (int i = 1; i < compSum.length; i++){
            compSum[i] = compSum[i-1] + primes.get(i - 1);
        }
        
        // for (int i = 0; i < compSum.length; i++){
            // System.out.print((i + 1) + " " + compSum[i]);
            // if (i != 0){
                // System.out.print(" " + (compSum[i] - compSum[i - 1]));
            // }
            // System.out.println();
        // }
        
        // Using a set for faster prime checking of the sum.
        HashSet<Integer> primesSet = new HashSet<Integer>();
        primesSet.addAll(primes);
        
        int result = 0;
        int termCount = 0;
        
        // Check all possible consecutive prime sums with the given number of terms using a sliding window.
        for (int len = compSum.length; len >= 0 && result == 0; len--){
            // e.g. 1 possible 546-term sum: summing primes 1 through 546
            // 2 possible 545-term sums: summing primes 2-546 or primes 1-545
            // 3 possible 544-term sums: summing primes 3-546, primes 2-545, or primes 1-544
            for (int start = compSum.length - len - 1; start >= 0; start--){
                int sumA = 0;
                int sumB = compSum[start + len];
                
                if (start > 0){
                    sumA = compSum[start];
                }
                
                // System.out.printf("summing %d primes (%d to %d): %d\n", len, start + 1, start+len, sumB - sumA);
                if (primesSet.contains(sumB - sumA)){
                    termCount = len;
                    result = sumB - sumA;
                    break;
                }
            }
        }
        
        System.out.printf("%d can be written as a sum of %d primes\n", result, termCount); // 997651 as a sum of 543 primes
    }
}