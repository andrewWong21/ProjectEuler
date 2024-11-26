using System;

public class _03_LargestPrimeFactor{
    public static int euler03(double n){
        int maxFactor = (int) Math.Floor(Math.Sqrt(n));
        int res = 0;
        bool[] sieved = new bool[maxFactor];
        for (int i = 2; i < sieved.Length; i++){
            if (!sieved[i]){
                if (n % i == 0) res = i;
                for (int j = 2 * i; j < sieved.Length; j += i){
                    sieved[j] = true;
                }
            }
        }
        return res;
    }
    
    public static void Main(string[] args){
        Console.WriteLine(euler03(600_851_475_143));
    }
}
