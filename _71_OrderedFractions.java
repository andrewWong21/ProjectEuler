import java.util.*;

public class _71_OrderedFractions{
    
    public static void main(String[] args){
        // A sequence of reduced proper fractions is called a Farey sequence.
        // Given two fractions a/b and c/d that are neighbors in a Farey sequence,
        // the next fraction to appear between them will be (a + c)/(b + d) in the Farey sequence of order (b + d).
        
        // Let F_n represent the Farey sequence of order n.
        // In F_8, 2/5 and 3/7 are neighboring fractions.
        // The next fraction to appear between them is (2 + 3)/(5 + 7) = 5/12, which first appears in F_12.
        // Repeating this process results in the following sequence for the left fraction:
        // 5/12, 8/19, 11/26, 14/33, 17/40, ...
        // which can be generalized to (2 + 3n)/(5 + 7n) for n = 1, 2, 3, ...
        
        // The greatest value of n for which 5 + 7n <= 1000000 is
        // n = floor((100000 - 5)/7) = floor(999995/7) = 142856
        // Therefore, the corresponding term in the sequence is
        // (2 + 3*142856)/(5 + 7*142856) = 428570/999997
        
        int a = 2, b = 5, c = 3, d = 7;
        int n = (int) Math.floor((1000000 - 5)/7);
        a += n*c;
        
        System.out.println("Numerator of fraction immediately left of 3/7 in the set of reduced proper fractions up to d <= 1000000: " + a); // 428570
    }
}