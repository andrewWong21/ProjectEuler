import java.util.*;

public class _01_MultiplesOf3Or5{
    public static int sumMultiplesUnder(int n){
        int sum = 0;
        for (int i = 1; i < n; i++){
            if (i % 3 == 0 || i % 5 == 0){
                sum += i;
            }
        }
        return sum;
    }
    
    public static void main(String[] args){
        System.out.println("The sum of all natural numbers that are all multiples of 3 or 5 under 10 is " + sumMultiplesUnder(10));
        System.out.println("The sum of all natural numbers that are all multiples of 3 or 5 under 1000 is " + sumMultiplesUnder(1000));
    }
}