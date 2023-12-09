import java.util.*;

public class _39_IntegerRightTriangles{
    
    public static void main(String[] args){
        
        // Given the constraints
        // a^2 + b^2 = c^2, p = a + b + c, p <= 1000
        
        // We can rewrite c in terms of p, a, and b.
        // c = p - a - b    -->    a^2 + b^2 = (p - a - b)^2
        // This equation can then be used to rewrite b in terms of a and p.
        
        // a^2 + b^2 = p^2 - ap - bp - ap + a^2 + ab - bp + ab + b^2
        // 0 = p^2 + 2ab - 2ap - 2bp
        // 2bp - 2ab = p^2 - 2ap    -->    b(2p - 2a) = p(p - 2a)
        // b = p(p - 2a) / (2p - 2a)
        // b is an integer when p(p - 2a) is divisible by (2p - 2a).
        
        // Both the numerator and denominator must be positive.
        // p is positive by definition, so (p - 2a) must also be positive.
        // a is strictly less than p / 2.
        
        int maxSolutions = 0;
        int result = 0;
        
        for (int p = 1; p <= 1000; p++){
            int solutions = 0;
            for (int a = 1; a < p / 2; a++){
                if ((p * (p - 2*a)) % (2*p - 2*a) == 0){ // b is an integer
                    int b = (p * (p - 2*a)) / (2*p - 2*a);
                    
                    // Avoid double-counting solutions.
                    // a and b cannot be equal integers as c will then be non-integral
                    // due to the ratio of side lengths of isosceles right triangles being 1-1-sqrt(2).
                    if (a < b){
                        // System.out.printf("%d: %d %d %d\n", p, a, b, p - a - b);
                        solutions++;
                    }
                }
            }
            if (solutions > maxSolutions){
                maxSolutions = solutions;
                result = p;
            }
        }
        
        System.out.println("The value for p <= 1000 where the number of solutions for right triangles");
        System.out.println("with integral lengths a,b,c and a + b + c = p is maximized is " + result);
        // p = 840 maximizes the number of unique solutions at 8
        //  40 399 401,  56 390 394, 105 360 375, 120 350 370
        // 140 336 364, 168 315 357, 210 280 350, 240 252 348
    }
}