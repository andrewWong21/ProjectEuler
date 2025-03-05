import java.util.*;

public class _75_SingularIntegerRightTriangles{
    
    public static int gcd(int a, int b){
        if (a < b) return gcd(b, a);
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }
    
    public static boolean isCoprime(int a, int b){
        return gcd(a, b) == 1;
    }
    
    public static void main(String[] args){
        
        HashMap<Integer, Integer> triangles = new HashMap<>();
        int count = 0;
        
        // Pythagorean triples can be generated using Euclid's formula.
        // Given two integers m, n where m > n > 0,
        // then the identity a^2 + b^2 = c^2 can be represented as
        // a = m^2 - n^2, b = 2*m*n, c = m^2 + n^2.
        // (m^2 - n^2)^2 + (2*m*n)^2 = m^4 - 2*m^2*n^2 + n^4 + 4*m^2*n^2 = m^4 + 2*m^2*n^2 + n^4 = (m^2 + n^2)^2
        
        // Primitive triples can be uniquely generated with the additional requirement that m and n are coprime.
        // To produce all triples, the values of a,b,c generated from a given pair m,n can be scaled by a factor k as needed.
        
        for (int m = 2; m*m < 1500000; m++){
            for (int n = 1; n < m; n++){
                if (isCoprime(m, n)){
                    int a = m*m - n*n;
                    int b = 2*m*n;
                    if (a > b) continue; // uniquely define a Pythagorean triple as a < b < c
                    int c = m*m + n*n;
                    
                    // If m and n are odd, the resulting triple can be scaled by 1/2
                    // to obtain another valid Pythagorean triple.
                    if (m % 2 == 1 && n % 2 == 1){
                        a /= 2;
                        b /= 2;
                        c /= 2;
                    }
                    int p = a+b+c;
                    
                    for (int k = 1; k*p <= 1500000; k++){
                        triangles.put(k*p, triangles.getOrDefault(k*p, 0) + 1);
                    }
                }
            }
        }
        
        for (int perimeter : triangles.keySet()){
            if (triangles.get(perimeter) == 1){
                count++;
            }
        }
        
        System.out.println("Number of values L <= 1500000 from which exactly one integer sided right triangle can be formed: " + count); // 161667
    }
}