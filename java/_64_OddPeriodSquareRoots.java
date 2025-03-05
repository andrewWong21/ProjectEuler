import java.util.*;

public class _64_OddPeriodSquareRoots{
    
    public static int getRootPeriod(int n){
        double s = Math.sqrt(n);
        
        // Square roots of perfect squares have a period of 0.
        if (s == Math.floor(s)) return 0;
        
        // sqrt(n) = a_0 + sqrt(n) - a_0
        // sqrt(n) = a_0 + (sqrt(n) - b_0)/c_0
        // a_0 = floor(sqrt(n)), b_0 = a_0, c_0 = 1
        
        // sqrt(n) = a_0 + 1/(c_0/(sqrt(n) - b_0))
        // sqrt(n) = a_0 + 1/((sqrt(n) + b_0)/((n - b_0^2)/c_0))
        //     (sqrt(n) + b_0)/((n - b_0^2)/c_0) = a_1 + (sqrt(n) - b_1)/c_1
        // sqrt(n) = a_0 + 1/(a_1 + (sqrt(n) - b_1)/c_1)
        
        // c_1 = (n - b_0^2) / c_0;
        // a_1 = floor((sqrt(n) + b_0)/c_1)
        // b_1 = a_1*c_1 - b_0
        
        // a_0 + 1/(a_1 + (sqrt(n) - (a_1*c_1 + b_0))/c_1)
        // a_0 + 1/(a_1 - a_1 + (sqrt(n) - a_0)/c_1)
        // a_0 + 1/((sqrt(n) + a_0)/(n - a_0^2))
        // a_0 + (n - a_0^2)/(sqrt(n) + a_0)
        // a_0 + sqrt(n) - a_0
        // sqrt(n)
        
        ArrayList<List<Integer>> seen = new ArrayList<>();
        int count = 0;
        
        int a = (int) Math.floor(s);
        int b = a;
        int c = 1;
        
        while (true){
            c = (n - b*b) / c;
            a = (int) Math.floor((Math.sqrt(n) + b)/c);
            b = a*c - b;
            // System.out.println(b + " " + c);
            for (int i = 0; i < seen.size(); i++){
                List<Integer> list = seen.get(i);
                if (list.get(0) == b && list.get(1) == c){
                    // System.out.println(seen);
                    return count - i;
                }
            }
            seen.add(Arrays.asList(new Integer[]{b, c}));
            count++;
        }
    }
    
    public static void main(String[] args){
        
        int numFractions = 0;
        
        for (int n = 2; n <= 10000; n++){
            int period = getRootPeriod(n);
            // System.out.println(n + ": " + period);
            
            if (period % 2 == 1){
                numFractions++;
            }
        }
        
        System.out.println("Number of continued fractions with odd periods: " + numFractions); // 1322
    }
}