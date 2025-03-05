import java.util.*;

public class _88_ProductSumNumbers{
    
    public static void main(String[] args){
        int maxK = 12_000;
        // store minimum product-sum numbers found for each value of k
        int[] minPSNs = new int[maxK + 1];
        // the maximum product-sum number for a set of k natural numbers is 2 * k
        // k * 2 * 1 * 1 * 1 * ... * 1 = k + 2 + (k - 2) * 1
        // calculate factorizations of each product-sum number p
        List<List<List<Integer>>> factLists = new ArrayList<>();
        // dummy lists for 0 and 1
        factLists.add(new ArrayList<>());
        factLists.add(new ArrayList<>());
        for (int n = 2; n < 2 * maxK + 1; n++){
            List<List<Integer>> fact = new ArrayList<>();
            fact.add(Arrays.asList(n));
            // build factorizations for n
            for (int f = 2; f * f <= n; f++){
                // f is a factor of n
                if (n % f == 0){
                    // iterate over factorizations of n / f
                    // see if f can be prepended to the factorization as the smallest factor
                    for (List<Integer> factList : factLists.get(n / f)){
                        boolean prependable = true;
                        for (int factor : factList){
                            if (factor < f){
                                prependable = false;
                                break;
                            }
                        }
                        if (prependable){
                            List<Integer> newFact = new ArrayList<Integer>();
                            newFact.add(f);
                            newFact.addAll(factList);
                            fact.add(newFact);
                        }
                    }
                }
            }
            factLists.add(fact);
        }
        
        for (int n = 2; n < factLists.size(); n++){
            for (List<Integer> factList : factLists.get(n)){
                // at least two natural numbers required
                if (factList.size() < 2) continue;

                int factorSum = 0;
                for (int factor : factList){
                    factorSum += factor;
                }
                // factorization of n with factor sum < n can be padded with 1s
                // to make a set of k numbers that add and multiply to n
                if (factorSum <= n){
                    // difference of n and the sum of its factors is the number of 1s required
                    int k = factList.size() + n - factorSum;
                    if (k <= maxK && minPSNs[k] == 0){
                        minPSNs[k] = n;
                    }
                }
            }
        }
        
        // calculate sum of distinct minimal product-sum numbers
        Set<Integer> productSums = new HashSet<Integer>();
        int sum = 0;
        for (int n : minPSNs){
            if (n > 0){
                productSums.add(n);
            }
        }
        for (int ps : productSums){
            sum += ps;
        }
        System.out.println("Sum of all minimal product-sum numbers for 2 <= k <= 12000: " + sum); // 7587457
    }
}
