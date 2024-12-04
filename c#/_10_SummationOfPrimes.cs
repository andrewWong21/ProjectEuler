using System;

public class _10_SummationOfPrimes{
    public static long Euler10(){
        int limit = 2_000_000;
        long res = 0;
        bool[] sieved = new bool[limit];
        for (int i = 2; i < limit; i++){
            if (!sieved[i]){
                res += i;
                for (int j = 2 * i; j < limit; j += i){
                    sieved[j] = true;
                }
            }
        }
        return res;
    }
    
    public static void Main(string[] args){
        Console.WriteLine(Euler10());
    }
}
