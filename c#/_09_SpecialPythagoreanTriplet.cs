using System;

public class _09_SpecialPythagoreanTriplet{
    public static int Euler09(){
        // a + b + c = p, a^2 + b^2 = c^2
        // c = p - a - b
        
        // a^2 + b^2 = (p - a - b)^2
        // a^2 + b^2 = p^2 - ap - bp - ap + a^2 + ab - bp + ab + b^2
        // 0 = p^2 - 2ap - 2bp + 2ab
        // 2bp - 2ab = p^2 - 2ap
        // b * (2p - 2a) = p^2 - 2ap
        // b = (p^2 - 2ap) / (2p - 2a)
        
        int p = 1000;
        for (int a = 1; a <= p / 3; a++){
            int b = (p * p - 2 * a * p) / (2 * p - 2 * a);
            int c = p - a - b;
            if (a * a + b * b == c * c){
                return a * b * c;
            }
        }
        return 0;
    }
    
    public static void Main(string[] args){
        Console.WriteLine(Euler09());
    }
}
