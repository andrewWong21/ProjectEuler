using System;

public class _05_SmallestMultiple{
    public static int Euler05(){
        int res = 1;
        for (int i = 2; i <= 20; i++){
            res = res / GCD(res, i) * i;
        }
        return res;
    }
    
    private static int GCD(int a, int b){
        while (b > 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    public static void Main(string[] args){
        Console.WriteLine(Euler05());
    }
}
