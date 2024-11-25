using System;

public class HelloWorld{
    public static int euler01(int num){
        return sumMultiples(3, num) + sumMultiples(5, num) - sumMultiples(15, num);
    }
    
    public static int sumMultiples(int n, int max){
        int mults = (max - 1) / n;
        return n * mults * (mults + 1) / 2;
    }
    
    public static void Main(string[] args){
        Console.WriteLine(euler01(1000));
    }
}
