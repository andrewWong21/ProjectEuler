import java.util.*;

public class _08_LargestProductInSeries{
    
    public static StringBuilder sb = new StringBuilder();
    
    public static long getLargestProduct(int len, String str){
        long product = 0;
        for (int i = 0; i + len <= str.length(); i++){
            long currProduct = 1;
            for (int j = i; j < i + len; j++){
                currProduct *= Character.getNumericValue(str.charAt(j));
            }
            
            if (currProduct > product){
                product = currProduct;
            }
        }
        return product;
    }
    
    public static void main(String[] args){
        sb.append("73167176531330624919225119674426574742355349194934");
        sb.append("96983520312774506326239578318016984801869478851843");
        sb.append("85861560789112949495459501737958331952853208805511");
        sb.append("12540698747158523863050715693290963295227443043557");
        sb.append("66896648950445244523161731856403098711121722383113");
        sb.append("62229893423380308135336276614282806444486645238749");
        sb.append("30358907296290491560440772390713810515859307960866");
        sb.append("70172427121883998797908792274921901699720888093776");
        sb.append("65727333001053367881220235421809751254540594752243");
        sb.append("52584907711670556013604839586446706324415722155397");
        sb.append("53697817977846174064955149290862569321978468622482");
        sb.append("83972241375657056057490261407972968652414535100474");
        sb.append("82166370484403199890008895243450658541227588666881");
        sb.append("16427171479924442928230863465674813919123162824586");
        sb.append("17866458359124566529476545682848912883142607690042");
        sb.append("24219022671055626321111109370544217506941658960408");
        sb.append("07198403850962455444362981230987879927244284909188");
        sb.append("84580156166097919133875499200524063689912560717606");
        sb.append("05886116467109405077541002256983155200055935729725");
        sb.append("71636269561882670428252483600823257530420752963450");
        
        // Iterating over the full string and calculating all products
        // using a sliding window is a possible approach, but the 
        // presence of zeroes means that many computations are wasted
        // due to zero products.
        
        long maxProduct = 0;
        
        // splitting the string into smaller strings that do not contain 0
        for (String substring : sb.toString().split("0")){
            if (substring.length() >= 13){
                long maxSubProduct = getLargestProduct(13, substring);
                
                // keep track of the largest product discovered so far
                if (maxSubProduct > maxProduct){
                    maxProduct = maxSubProduct;
                    System.out.println("Current maximum product: " + maxProduct);
                }
            }
        }
        
        System.out.println("The largest product of 13 adjacent digits in the string is " + maxProduct);
        // System.out.println(5 * 5 * 7 * 6 * 6 * 8 * 9 * 6 * 6 * 4 * 8 * 9 * 5);
        // The largest product, 23514624000, is obtained from the digits in the substring "5576689664895".
    }
}