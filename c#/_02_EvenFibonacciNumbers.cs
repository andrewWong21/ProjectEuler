using System;

public class _02_EvenFibonacciNumbers{
    public static int euler02(){
        int n1 = 1, n2 = 0, total = 0;
        while (n2 < 4_000_000){
            int temp = n2;
            n2 += n1;
            n1 = temp;
            if (n2 % 2 == 0) total += n2;
        }
        return total;
    }
    
    public static void Main(string[] args){
        Console.WriteLine(euler02());
    }
}
