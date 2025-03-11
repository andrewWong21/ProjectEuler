import java.util.*;

public class _95_AmicableChains{
    
    public static int sumProperDivisors(int n){
        int res = 1;
        for (int i = 2; i * i <= n; i++){
            if (n % i == 0){
                res += i + (n / i);
                if (i * i == n) res -= i;
            }
        }
        return res;
    }
    
    public static void main(String[] args){
        int max = 1_000_000, maxLen = 0;
        int res = max;
        for (int n = 1; n < max; n++){
            Set<Integer> chain = new HashSet<>();
            chain.add(n);
            int d = sumProperDivisors(n);
            
            while (!chain.contains(d)){
                chain.add(d);
                int divSum = sumProperDivisors(d);
                if (divSum > max) break;
                d = divSum;
            }
            
            // check if chain returns to starting point
            if (d == n && chain.size() > maxLen){
                // update length of longest chain found and minimum element in longest chain
                maxLen = chain.size();
                res = n;
                for (int num : chain) res = Math.min(res, num);
            }
        }
        
        System.out.println("Smallest member of longest amicable chain with no element exceeding 1 million: " + res); // 14316
    }
}
