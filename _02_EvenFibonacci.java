import java.util.*;

public class _02_EvenFibonacci{
    public static void main(String[] args){
        int sum = 0;
        int prevFib = 1;
        int currFib = 1;
        while (currFib < 4000000){
            if (currFib % 2 == 0){
                sum += currFib;
                
            }
            int temp = currFib;
            currFib += prevFib;
            prevFib = temp;
          
        System.out.println(prevFib + " " + currFib);
        }
        System.out.println(sum);
    }
}