using System;

public class _07_10001stPrime{
    public static int Euler07(){
        int count = 1, curr = 3;
        while (true){
            if (IsPrime(curr)) count++;
            if (count == 10001) return curr;
            curr += 2;
        }
        return 0;
    }
    
    public static bool IsPrime(double n){
        for (int i = 2; i <= Math.Sqrt(n); i++){
            if (n % i == 0) return false;
        }
        return true;
    }
    
    public static void Main(string[] args){
        Console.WriteLine(Euler07());
    }
}
