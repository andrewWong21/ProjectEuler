import java.util.*;

public class _60_PrimePairSets{
    
    static ArrayList<Integer> primes;
    static HashSet<Integer> primesSet;
    
    public static ArrayList<Integer> sieve(int n){
        boolean[] sieved = new boolean[n + 1];
        sieved[0] = sieved[1] = true;
        ArrayList<Integer> primes = new ArrayList<>();
        
        for (int i = 0; i < sieved.length; i++){
            if (!sieved[i]){
                for (int j = i + i; j < sieved.length; j += i){
                    sieved[j] = true;
                }
                // modification to skip primes that will always
                // result in at least one composite concatenation
                if (i != 2 && i != 5)
                primes.add(i);
            }
        }
        
        return primes;
    }
    
    public static boolean isPrime(int n){
        if (n < primes.size()) return primesSet.contains(n);
        
        // for (int i = 2; i*i < n; i++){
            // if (n % i == 0) return false;
        // }
        for (int i = 0; primes.get(i) * primes.get(i) <= n; i++){
            if (n % primes.get(i) == 0) return false;
        }
        return true;
    }
    
    public static boolean isConcatPrime(int a, int b){
        int cand1 = Integer.parseInt(String.valueOf(a) + String.valueOf(b));
        int cand2 = Integer.parseInt(String.valueOf(b) + String.valueOf(a));
        return isPrime(cand1) && isPrime(cand2);
    }
    
    // depth-first search for set of 5 primes
    public static int findMinSum(ArrayList<Integer> primeList){
        int minSum = Integer.MAX_VALUE;
        for (int a : primeList){
            for (int b : primeList){
                if (b <= a) continue;
                
                if (isConcatPrime(a, b)){
                    // System.out.println(String.format("%d %d", a, b));
                    for (int c: primeList){
                        if (c <= b) continue;
                        
                        if (isConcatPrime(a, c) && isConcatPrime(b, c)){
                            // System.out.println(String.format("%d %d %d", a, b, c));
                            for (int d: primeList){
                                if (d <= c) continue;
                                
                                if (isConcatPrime(a, d) && isConcatPrime(b, d) && isConcatPrime(c, d)){
                                    // System.out.println(String.format("%5d %5d %5d %5d", a, b, c, d));
                                    for (int e: primeList){
                                        if (e <= d) continue;
                                        
                                        if (isConcatPrime(a, e) && isConcatPrime(b, e) && isConcatPrime(c, e)  && isConcatPrime(d, e)){
                                            // System.out.println(String.format("%5d %5d %5d %5d %5d", a, b, c, d, e));
                                            int sum = a + b + c + d + e;
                                            minSum = sum < minSum ? sum : minSum;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return minSum;
    }
    
    public static ArrayList<ArrayList<Integer>> getPairs(ArrayList<Integer> primeList){
        ArrayList<ArrayList<Integer>> pairs = new ArrayList<>();
        for (int a : primeList){
            for (int b : primeList){
                if (b <= a) continue;
                
                if (isConcatPrime(a, b)){
                    ArrayList<Integer> pair = new ArrayList<Integer>();
                    pair.add(a);
                    pair.add(b);
                    // System.out.println(pair);
                    pairs.add(pair);
                }
            }
        }
        return pairs;
    }
    
    public static ArrayList<ArrayList<Integer>> getTriples(ArrayList<Integer> primeList){
        ArrayList<ArrayList<Integer>> pairs = getPairs(primeList);
        ArrayList<ArrayList<Integer>> triples = new ArrayList<>();
        for (ArrayList<Integer> pair : pairs){
            int a = pair.get(0);
            int b = pair.get(1);
            for (int c : primeList){
                if (c <= b) continue;
                
                if (isConcatPrime(a, c) && isConcatPrime(b, c)){
                    ArrayList<Integer> triple = new ArrayList<Integer>();
                    triple.add(a);
                    triple.add(b);
                    triple.add(c);
                    // System.out.println(triple);
                    triples.add(triple);
                }
            }
        }
        return triples;
    }
    
    public static ArrayList<ArrayList<Integer>> getQuads(ArrayList<Integer> primeList){
        ArrayList<ArrayList<Integer>> triples = getTriples(primeList);
        ArrayList<ArrayList<Integer>> quads = new ArrayList<>();
        for (ArrayList<Integer> triple : triples){
            int a = triple.get(0);
            int b = triple.get(1);
            int c = triple.get(2);
            for (int d : primeList){
                if (d <= c) continue;
                
                if (isConcatPrime(a, d) && isConcatPrime(b, d) && isConcatPrime(c, d)){
                    ArrayList<Integer> quad = new ArrayList<Integer>();
                    quad.add(a);
                    quad.add(b);
                    quad.add(c);
                    quad.add(d);
                    // System.out.println(quad);
                    quads.add(quad);
                }
            }
        }
        return quads;
    }
    
    public static ArrayList<ArrayList<Integer>> getQuints(ArrayList<Integer> primeList){
        ArrayList<ArrayList<Integer>> quads = getQuads(primeList);
        ArrayList<ArrayList<Integer>> quints = new ArrayList<>();
        for (ArrayList<Integer> quad : quads){
            int a = quad.get(0);
            int b = quad.get(1);
            int c = quad.get(2);
            int d = quad.get(3);
            for (int e : primeList){
                if (e <= d) continue;
                
                if (isConcatPrime(a, e) && isConcatPrime(b, e) && isConcatPrime(c, e) && isConcatPrime(d, e)){
                    ArrayList<Integer> quint = new ArrayList<Integer>();
                    quint.add(a);
                    quint.add(b);
                    quint.add(c);
                    quint.add(d);
                    quint.add(e);
                    // System.out.println(quint);
                    quints.add(quint);
                }
            }
        }
        return quints;
    }
    
    public static void main(String[] args){
        
        primes = sieve(100000);
        primesSet = new HashSet<Integer>(primes);
        
        // An important observation for reducing the number of checks:
        // Since 3 cannot be a divisor of any larger prime number,
        // all prime numbers greater than 3 must be congruent to either 1 or 2 (modulo 3).
        
        // Consider a prime p1 that is congruent to 1 (mod 3),
        // and a prime p2 that is congruent to 2 (mod 3).
        // The sum of p1's digits must then be congruent to 1 (mod 3),
        // and the sum of p2's digits must be congruent to 2 (mod 3).
        
        // The concatenation of these two primes cannot itself be prime,
        // as the sum of its digits will then be congruent to (2 + 1) mod 3.
        // 3 mod 3 is congruent to 0 mod 3, so the result is a multiple of 3.
        
        // The set of primes greater than 3 can then be divided into two sets,
        // the set of primes congruent to 1 (mod 3) and the set of primes congruent to 2 (mod 3).
        // The target group of five primes that produce primes from concatenating any two members of the set
        // cannot combine elements from both sets, so it must be a subset of one of these sets.
        
        int minSum = Integer.MAX_VALUE;
        ArrayList<Integer> p1 = new ArrayList<Integer>();
        ArrayList<Integer> p2 = new ArrayList<Integer>();
        ArrayList<Integer> pfull = new ArrayList<Integer>();
        p1.add(3);
        p2.add(3);
        
        for (int p : primes){
            if (p > 20000) break;
            pfull.add(p);
            if (p % 3 == 1){
                p1.add(p);
            }
            else{
                p2.add(p);
            }
        }

        // int p1sum = findMinSum(p1);
        // int p2sum = findMinSum(p2);
        // System.out.println(p1sum + " " + p2sum);
        // minSum = Math.min(p1sum, p2sum);
        
        ArrayList<ArrayList<Integer>> quints1 = getQuints(p1);
        
        for (ArrayList<Integer> quint : quints1){
            // System.out.println(quint);
            int sum = 0;
            for (int prime : quint){
                sum += prime;
            }
            minSum = sum < minSum ? sum : minSum;
        }
        
        // No sets of five are generated from the set of primes congruent to 2 (modulo 3).
        // ArrayList<ArrayList<Integer>> quints2 = getQuints(p2);
        // for (ArrayList<Integer> quint : quints1){
            // System.out.println(quint);
            // int sum = 0;
            // for (int prime : quint){
                // sum += prime;
            // }
            // minSum = sum < minSum ? sum : minSum;
        // }
        
        System.out.println("Lowest sum for a set of five primes that produce primes from concatenating any two members of the set: " + minSum); // 26033
        //    7  1237  2341 12409 18433     sum: 34427
        //   13  5197  5701  6733  8389     sum: 26033
    }
}