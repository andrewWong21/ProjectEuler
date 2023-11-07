import java.util.*;

public class _06_SumSquareDifference{
    
    public static void main(String[] args){
        int sum = 0;
        int sumSq = 0;
        for (int i = 1; i <= 100; i++){
            sum += i;
            sumSq += i * i;
        }
        System.out.println("The square of the sum of the first 100 natural numbers is " + sum * sum);
        System.out.println("The sum of the squares of the first 100 natural numbers is " + sumSq);
        System.out.println(String.format("Difference: %d - %d = %d", sum * sum, sumSq, sum * sum - sumSq));
        
    }
}