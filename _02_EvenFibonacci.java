import java.util.*;

public class _02_EvenFibonacci{
    public static int evenFibSumUnder(int n){
        int sum = 0;
        int prevFib = 1;
        int currFib = 1;
        while (currFib < n){
            if (currFib % 2 == 0){
                sum += currFib;
                
            }
            int temp = currFib;
            currFib += prevFib;
            prevFib = temp;
          
        // System.out.println(prevFib + " " + currFib);
        }
        return sum;
    }
    
    public static void main(String[] args){
        System.out.println("The sum of all even Fibonacci numbers under 4,000,000 is " + evenFibSumUnder(4000000));
    }
}