import java.util.*;

public class _73_CountingFractionsInARange{
    
    public static long countFractionsBetween(int a, int b, int c, int d, int n){
        if (b + d > n){
            // If the next mediant fraction between the given fractions a/b and b/d 
            // does not appear in F_n, then they are neighboring fractions in F_n.
            return 0;
        }
        
        // If b + d <= n, there exists at least one fraction between a/b and c/d in F_n.
        // There may also be fractions between the mediant and both bounds.
        return 1 + countFractionsBetween(a, b, a+c, b+d, n) + countFractionsBetween(a+c, b+d, b, d, n);
    }
    
    public static void main(String[] args){
        
        int a = 1, b = 3, c = 1, d = 2, n = 12000;
        
        long count = countFractionsBetween(a, b, c, d, n);
        
        System.out.println("Number of fractions between 1/3 and 1/2 in the set of reduced proper fractions up to d <= 12000: " + count); // 7295372
    }
}