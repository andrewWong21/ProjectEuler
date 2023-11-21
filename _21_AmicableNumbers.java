import java.util.*;

public class _21_AmicableNumbers{
    
    public static int getSumDivisors(int num){
        int factorSum = 1;
        for (int i = 2; i <= Math.sqrt(num); i++){
            if (num % i == 0){
                factorSum += i + num / i;
            }
        }
        if (Math.floor(Math.sqrt(num)) * Math.floor(Math.sqrt(num)) == num){
            factorSum -= Math.sqrt(num);
        }
        return factorSum;
    }
    
    public static void main(String[] args){
        int amicableSum = 0;
        
        for (int i = 2; i < 10000; i++){
            int divSum = getSumDivisors(i);
            if (i != divSum && getSumDivisors(divSum) == i){
                amicableSum += i;
                // System.out.println(i);
            }
        }
        System.out.println("The sum of all amicable numbers under 10000 is " + amicableSum); // 31626
        // 220, 284, 1184, 1210, 2620, 2924, 5020, 5564, 6232, 6368
    }
}