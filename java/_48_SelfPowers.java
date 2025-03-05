import java.util.*;

public class _48_SelfPowers{
    
    public static void main(String[] args){
        long mod = (long) 1e10;
        
        long lastTenDigits = 10405071317L;
        
        // 1000^1000 
        for (int i = 11; i <= 999; i++){
            long product = i;
            for (int j = 1; j < i; j++){
                // Using the modular multiplication property (A * B) mod m === ((A mod m) * (B mod m)) mod m
                // Since i < 1000, i % 1e10 = i, so the modulo operation does not change its value.
                product = ((product % mod) * i) % mod;
            }
            // Using the modular addition property (A + B) mod m === ((A mod m) + (B mod m)) mod m
            lastTenDigits = ((lastTenDigits % mod) + (product % mod)) % mod;
        }
        
        System.out.println("Last ten digits of the series n^n, n = 1, 2, 3, ..., 1000: " + lastTenDigits); // 9110846700
    }
}