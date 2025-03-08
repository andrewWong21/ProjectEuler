import java.util.*;

public class _92_SquareDigitChains{
    
    public static void main(String[] args){
        int res = 0;
        for (int i = 1; i < 10_000_000; i++){
            int n = i;
            Set<Integer> seen = new HashSet<>();
            while (!seen.contains(n)){
                seen.add(n);
                // loop reached when n becomes 1 or 89
                if (n == 1 || n == 89) break;
                int sum = 0;
                while (n > 0){
                    int d = n % 10;
                    sum += d * d;
                    n /= 10;
                }
                n = sum;
            }
            if (n == 89){
                res++;
            }
        }
        
        System.out.println("Number of starting numbers below 10 million that end at 89: " + res); // 8581146
    }
}
