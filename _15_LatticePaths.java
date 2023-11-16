import java.util.*;
import java.math.BigInteger;

public class _15_LatticePaths{
    
    public static BigInteger factorial(BigInteger bigInt){
        if (bigInt.equals(BigInteger.ONE)){
            return bigInt;
        }
        return bigInt.multiply(factorial(bigInt.subtract(BigInteger.ONE)));
    }
    
    public static BigInteger getNumPaths(int n){
        // A path from the top left corner to the bottom right corner
        // of an NxN grid is composed of n movements right and
        // n movements down, for a total of 2*n movements.
        
        // e.g. n = 2: DDRR, DRDR, DRRD, RDDR, RDRD, RRDD
        
        // The number of possible paths for a given grid is equal to 
        // the number of possible arrangements of down and right inputs
        // such that there are n down and n right inputs in total.
        
        // To calculate this, find the number of ways to choose
        // n down inputs from the total 2*n movements.
        
        // (2*n)! arrangements of the 2*n movements
        // n! arrangements of the n down inputs
        // n! arrangements of the n right inputs
        
        // # of paths = (2*n)! / (n! * n!)
        
        BigInteger nFact = factorial(BigInteger.valueOf(n));
        return factorial(BigInteger.valueOf(2*n)).divide(nFact).divide(nFact);
    }
    
    public static void main(String[] args){
        int n = 20;
        System.out.println("The number of possible routes to the opposite corner of a 20x20 grid is " + getNumPaths(n)); // 137846528820
        
    }
}