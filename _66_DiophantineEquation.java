import java.util.*;
import java.math.BigInteger;

public class _66_DiophantineEquation{
    
    public static ArrayList<Integer> getConvergentCycle(int D){
        double s = Math.sqrt(D);
        
        
        int a0 = (int) Math.floor(s);
        int a = a0;
        int b = a;
        int c = 1;
        
        ArrayList<Integer> seen = new ArrayList<>();
        
        boolean found = false;
        while (true){
            c = (D - b*b) / c;
            a = (int) Math.floor((s + b)/c);
            b = a*c - b;
            seen.add(a);
            
            if (a == 2*a0) break;
        }
        
        return seen;
    }
    
    public static BigInteger getSolution(int D){
        ArrayList<Integer> cycle = getConvergentCycle(D);
        
        BigInteger num0 = BigInteger.ONE;
        BigInteger den0 = BigInteger.ZERO;
        BigInteger num1 = BigInteger.valueOf((long) Math.floor(Math.sqrt(D)));
        BigInteger den1 = BigInteger.ONE;
        
        int count = 0;
        while (true){
            BigInteger k = BigInteger.valueOf(cycle.get(count % cycle.size()));
            BigInteger num = num1.multiply(k).add(num0);
            BigInteger den = den1.multiply(k).add(den0);
            num0 = num1;
            den0 = den1;
            num1 = num;
            den1 = den;
            
            // Determining the fundamental solution for sqrt(D) using the numerator and denominator of each convergent.
            // If n^2 - D*d^2 = 1, n corresponds to the minimal value of x that solves x^2 - Dy^2 = 1
            
            if (num.multiply(num).subtract(den.multiply(den).multiply(BigInteger.valueOf(D))).compareTo(BigInteger.ONE) == 0){
                // System.out.println(num);
                return num;
            }
            count++;
        }
    }
    
    public static void main(String[] args){
        
        HashSet<Integer> perfectSquares = new HashSet<>();
        for (int i = 1; i*i <= 1000; i++){
            perfectSquares.add(i*i);
        }
        
        BigInteger maxX = BigInteger.ZERO;
        int maxD = 0;
        
        for (int d = 1; d <= 1000; d++){
            if (perfectSquares.contains(d)) continue;
            BigInteger x = getSolution(d);
            // System.out.println(String.format("d: %d, x: %s", d, x));
            if (x.compareTo(maxX) > 0){
                maxX = x;
                maxD = d;
            }
        }
        
        System.out.println("D with largest minimal x for D <= 10000: " + maxD + ", x = " + maxX); // 661
        // When D = 661, the minimal solution in x is 16421658242965910275055840472270471049
    }
}