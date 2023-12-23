import java.util.*;

public class _53_CombinatoricSelections{
    
    public static void main(String[] args){
        
        int count = 0;
        
        for (int n = 1; n <= 100; n++){
            int combs = n; // n choose 1 = n
            
            for (int r = 2; r <= n - r + 1; r++){
                // nCr = nC(n - r), so all the unique values for a given value of n
                // will be found halfway through the possible values of r.
                // if nCr > 1 million, then nC(r+1), nC(r+2), ..., nC(n-r) will also be greater than 1 million.
                
                // The range [r, n-r] has n - 2r + 1 values, so when a value of r is found where
                // nCr exceeds 1 million, the count is incremented by n - 2r + 1 and the next value of n is checked.
                
                combs = ((n - r + 1) * combs / r);
                // System.out.printf("%dC%d = %d %b\n", n, r, combs, combs > 1e6);
                if (combs > 1e6){
                    // System.out.println(r + " " + (n - r) + " " + n + " " + (n - 2*r + 1));
                    count += n - 2*r + 1;
                    break;
                }
            }
            // System.out.println();
        }
        
        System.out.println("Number of values of nCr, 1 <= n <= 100, greater than 1 million: " + count); // 4075
    }
}