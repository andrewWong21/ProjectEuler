import java.util.*;

public class _33_DigitCancellingFractions{
    
    public static int getGCF(int a, int b){
        // precondition: a > b
        if (a % b == 0) return b;
        return getGCF(b, a % b);
    }
    
    public static void main(String[] args){
        
        // There are four possible situations for cancelling digits.
        // Consider a general fraction n/d = (n1 * 10 + n2) / (d1 * 10 + d2).
        // This fraction must be a proper fraction (n < d).
        // Both the numerator and denominator must have two digits.
        
        // If the first digits of both the numerator and denominator cancel,
        // then n1 = d1 = x and the fraction cancels to n2/d2.
        // If (x * 10 + n2) / (x * 10 + d2) = n2/d2, then
        // d2(x * 10 + n2) = n2(x * 10 + d2)
        // 10*d2*x + d2*n2 = 10*n2*x + d2*n2
        // 10*d2*x = 10*n2*x -> 10x(d2 - n2) = 0 -> x(d2 - n2) = 0
        // For the fractions to be equal, either x = 0 or d2 = n2.
        // If x = 0, then the numerator and denominator are less than 10, so they only have one digit.
        // If d2 = n2, then the numerator and denominator are the same (n = d).
        // Both of these options result in a fraction that does not fit the initial constraints.
        
        // If the second digits of both the numerator and denominator cancel,
        // then n2 = d2 = x and the fraction cancels to n1/d1.
        // If (n1 * 10 + x) / (d1 * 10 + x) = n1/d1, then
        // d1(n1 * 10 + x) = n1(d1 * 10 + x)
        // 10*d1*n1 + d1*x = 10*d1*n1 + n1*x
        // d1*x = n1*x -> x(n1 - d1) = 0
        // If x = 0, then the numerator and denominator are less than 10.
        // If d1 = n1, then the numerator and denominator are the same.
        
        // This means that the digits that are cancelled out cannot be 
        // in the same place for both the numerator and denominator.
        
        int numProduct = 1;
        int denProduct = 1;
        for (int num = 10; num <= 99; num++){
            for (int den = num + 1; den <= 99; den++){
                
                // System.out.println(num + "/" + den);
                
                // When the numerator or the denominator is a multiple of 10,
                // the situations being considered for digit cancelling may result in
                // either a simplified numerator of zero, which will not be equivalent
                // to the initial fraction, or a simplified denominator of zero, which
                // results in an illegal division by zero operation.
                
                if (num % 10 == 0 || den % 10 == 0) continue;
                
                // numerator's second digit cancels denominator's first digit
                if (num % 10 == den / 10){
                    int newNum = num / 10;
                    int newDen = den % 10;
                    if ((double) num / den == (double) newNum / newDen){
                        // System.out.printf("%d/%d equals %d/%d\n", num, den, newNum, newDen);
                        numProduct *= newNum;
                        denProduct *= newDen;
                    }
                }
                
                // It turns out that all 4 fractions we are looking for
                // are found with the previous conditional, but the following
                // check is included for completeness.
                
                // numerator's first digit cancels denominator's second digit
                if (num / 10 == den % 10){
                    int newNum = num % 10;
                    int newDen = den / 10;
                    if ((double) num / den == (double) newNum / newDen){
                        // System.out.printf("%d/%d equals %d/%d\n", num, den, newNum, newDen);
                        numProduct *= newNum;
                        denProduct *= newDen;
                        
                    }
                }
            }
        }
        
        // using the Euclidean algorithm to simplify the denominator
        // after multiplying all 4 fractions together
        int simpleDen = denProduct / getGCF(denProduct, numProduct);
        
        System.out.println("Simplified denominator of product of proper digit-cancelling fractions: " + simpleDen); // 100
    }
}