import java.util.*;

public class _94_AlmostEquilateralTriangles{
    
    public static int gcd(int a, int b){
        while (b > 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    
    public static void main(String[] args){
        int max = (int) 1e9;
        long res = 0;
        Set<String> triangles = new HashSet<>();
        
        for (int m = 2; m * m <= max / 3; m++){
            for (int n = 1; n < m; n++){
                if (gcd(m, n) == 1){
                    // generate Pythagorean triple
                    int a = m * m - n * n;
                    int b = 2 * m * n;
                    int c = m * m + n * n;
                    
                    if (m % 2 == 1 && n % 2 == 1){
                        a /= 2;
                        b /= 2;
                        c /= 2;
                    }
                    
                    // check if triangles c-c-2a and c-c-2b are considered almost equilateral
                    if (Math.abs(c - 2 * a) == 1 && 2 * (a + c) < max){
                        if (triangles.add(a + " " + c)){
                            res += 2 * (a + c);
                        }
                    }
                    if (Math.abs(c - 2 * b) == 1 && 2 * (b + c) < max){
                        if (triangles.add(b + " " + c)){
                            res += 2 * (b + c);
                        }
                    }
                }
            }
        }
        
        System.out.println("Sum of perimeters with integral perimeters and area with perimeters not exceeding 1 billion: " + res); // 
    }
}
