using System;

public class _12_HighlyDivisibleTriangularNumber{
    public static int Euler12(){
        int n = 1;
        while (true){
            int t = n * (n + 1) / 2;
            if (NumDivisors(t) >= 500) return t;
            n++;
        }
    }
    
    public static int NumDivisors(int n){
        int count = 0;
        for (int i = 1; i <= Math.Sqrt(n); i++){
            if (n % i == 0){
                if (n / i == i) count++;
                else count += 2;
            }
        }
        return count;
    }
    
    public static void Main(string[] args){
        Console.WriteLine(Euler12());
    }
}
