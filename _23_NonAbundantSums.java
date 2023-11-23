import java.util.*;

public class _23_NonAbundantSums{
    
    // Keep track of discovered abundant numbers
    static HashSet<Integer> abNums = new HashSet<>();
        
    public static int sumProperDivs(int num){
        // Proper divisors are strictly less than the dividend.
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
    
    public static boolean isAbSum(int num){
        // Instead of checking every possible sum of two abundant numbers (0(n^2)),
        // check if the current number minus any of the previously found
        // abundant numbers is also an abundant number (0(n)).
        for (int abNum : abNums){
            if (abNums.contains(num - abNum)){
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args){
        int sum = 0;
        
        for (int i = 1; i < 28123; i++){
            int divSum = sumProperDivs(i);
            
            if (divSum > i){
                abNums.add(i);
            }
            if (!isAbSum(i)){
                sum += i;
            }
        }
        
        System.out.println("The sum of all positive integers under 28123 that cannot be written as the sum of two abundant numbers is " + sum); // 4179871
    }
}