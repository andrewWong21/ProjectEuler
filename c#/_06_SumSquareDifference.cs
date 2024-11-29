using System;

public class _06_SumSquareDifference{
    public static int Euler06(){
        int sumSquares = 0;
        int squareSum = 0;
        for (int i = 1; i <= 100; i++){
            sumSquares += i * i;
            squareSum += i;
        }
        squareSum *= squareSum;
        return squareSum - sumSquares;
    }
    
    public static void Main(string[] args){
        Console.WriteLine(Euler06());
    }
}
