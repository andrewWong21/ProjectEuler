import java.util.*;
import java.math.BigInteger;

public class _57_SquareRootConvergents{
    
    public static void main(String[] args){
        // Iteration 1: 1 + 1/2 = 3/2
        // Iteration 2: 1 + 1/(2 + 1/2) = 1 + 1/(5/2) = 1 + 2/5 = 7/5
        // Iteration 3: 1 + 1/(2 + 1/(2+1/2)) = 1 + 1/(12/5) = 1 + 5/12 = 17/12
        
        // Let the result of iteration x be n/d.
        // Then iteration (x+1) yields 1 + 1/(1 + n/d) = (2 + n/d)/(1 + n/d).
        // Multiplying both parts of the fraction by d results in (2*d + n)/(d + n).
        // Thus, n becomes (2*d + n) and d becomes (d + n) with each subsequent iteration.
        
        int numFractions = 0;
        BigInteger num = BigInteger.valueOf(3);
        BigInteger den = BigInteger.valueOf(2);
        
        for (int i = 0; i < 999; i++){
            BigInteger newNum = num.add(den.multiply(BigInteger.valueOf(2)));
            BigInteger newDen = num.add(den);
            
            // System.out.println(newNum + "/" + newDen);
            if (newNum.toString().length() > newDen.toString().length()){
                numFractions++;
            }
            num = newNum;
            den = newDen;
        }
        
        System.out.println("# of fractions with their numerator having more digits than the denominator: " + numFractions); // 153
    }
}