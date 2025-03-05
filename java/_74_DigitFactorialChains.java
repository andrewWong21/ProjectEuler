import java.util.*;

public class _74_DigitFactorialChains{
    
    static int[] fact = new int[10];
    
    public static int chainLength(int n){
        
        ArrayList<Integer> seen = new ArrayList<>();
        
        while (!seen.contains(n)){
            seen.add(n);
            
            char[] digits = String.valueOf(n).toCharArray();
            int sum = 0;
            for (char c : digits){
                sum += fact[c - '0'];
            }
            n = sum;
        }
        
        return seen.size();
    }
    
    public static void main(String[] args){
        
        Arrays.fill(fact, 1);
        for (int i = 2; i < fact.length; i++){
            for (int j = i; j < fact.length; j++){
                fact[j] *= i;
            }
        }
        
        int count = 0;
        for (int n = 1; n < 1000000; n++){
            int chain = chainLength(n);
            if (chain == 60){
                count++;
            }
        }
        
        System.out.println("Chains starting from numbers under one million with exactly 60 non-repeating terms: " + count); // 402
    }
}