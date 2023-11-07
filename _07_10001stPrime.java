import java.util.*;

public class _07_10001stPrime{
    
    public static boolean isPrime(int num){
        if (num == 2 || num == 3){
            return true;
        }
        for (int i = 2; i <= Math.sqrt(num); i++){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
    
    public static int getNthPrime(int n){
        int count = 0;
        int result = 1;
        while (count < n){
            result++;
            if (isPrime(result)){
                count++;
            }
        }
        return result;
    }
    
    public static void main(String[] args){
        System.out.println("The 10001st prime is " + getNthPrime(10001));
    }
}