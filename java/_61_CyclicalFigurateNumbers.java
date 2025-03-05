import java.util.*;

public class _61_CyclicalFigurateNumbers{
    
    static ArrayList<HashSet<Integer>> polygonSets = new ArrayList<HashSet<Integer>>();
    static HashSet<Integer> triangles = new HashSet<Integer>(); // 96
    static HashSet<Integer> squares   = new HashSet<Integer>(); // 68
    static HashSet<Integer> pentagons = new HashSet<Integer>(); // 56
    static HashSet<Integer> hexagons  = new HashSet<Integer>(); // 48
    static HashSet<Integer> heptagons = new HashSet<Integer>(); // 43
    static HashSet<Integer> octagons  = new HashSet<Integer>(); // 40
    
    public static boolean isTriangle(int p){
        // n(n+1)/2
        double n = (Math.sqrt(8*p + 1) - 1) / 2;
        return n == (int) n;
    }
    
    public static boolean isSquare(int p){
        // n^2
        double n = Math.sqrt(p);
        return n == (int) n;
    }
    
    public static boolean isPentagon(int p){
        // n(3n-1)/2
        double n = (Math.sqrt(24*p + 1) + 1) / 6;
        return n == (int) n;
    }
    
    public static boolean isHexagon(int p){
        // n(2n-1)
        double n = (Math.sqrt(8*p + 1) + 1) / 4;
        return n == (int) n;
    }
    
    public static boolean isHeptagon(int p){
        // n(5n-3)/2
        double n = (Math.sqrt(40*p + 9) + 3) / 10;
        return n == (int) n;
    }
    
    public static boolean isOctagon(int p){
        // n(3n-2)
        double n = (Math.sqrt(3*p + 1) + 1) / 3;
        return n == (int) n;
    }
    
    public static int[] generateCycle(int p1){
        
        for (int i = 0; i < polygonSets.size(); i++){
            for (HashSet<Integer> pSet2 : polygonSets){
                for (int p2 : pSet2){
                    if (p2 == p1) continue;
                    
                    if ((p2 / 100) == (p1 % 100)){
                        // System.out.println(String.format("%d %d", p1, p2));
                        
                        for (HashSet<Integer> pSet3 : polygonSets){
                            if (pSet3 == pSet2) continue;
                            
                            for (int p3 : pSet3){
                                if (p3 == p1 || p3 == p2) continue;
                                
                                if ((p3 / 100) == (p2 % 100)){
                                    // System.out.println(String.format("%d %d %d", p1, p2, p3));
                                    
                                    for (HashSet<Integer> pSet4 : polygonSets){
                                        if (pSet4 == pSet2 || pSet4 == pSet3) continue;
                                        
                                        for (int p4 : pSet4){
                                            if (p4 == p1 || p4 == p2 || p4 == p3) continue;
                                            
                                            if ((p4 / 100) == (p3 % 100)){
                                                // System.out.println(String.format("%d %d %d %d", p1, p2, p3, p4));
                                                
                                                for (HashSet<Integer> pSet5 : polygonSets){
                                                    if (pSet5 == pSet2 || pSet5 == pSet3 || pSet5 == pSet4) continue;
                                                    
                                                    for (int p5 : pSet5){
                                                        if (p5 == p1 || p5 == p2 || p5 == p3 || p5 == p4) continue;
                                                        
                                                        if ((p5 / 100) == (p4 % 100)){
                                                            // System.out.println(String.format("%d %d %d %d %d", p1, p2, p3, p4, p5));
                                                            
                                                            for (HashSet<Integer> pSet6 : polygonSets){
                                                                if (pSet6 == pSet2 || pSet6 == pSet3 || pSet6 == pSet4 || pSet6 == pSet5) continue;
                                                                
                                                                for (int p6 : pSet6){
                                                                    if (p6 == p1 || p6 == p2 || p6 == p3 || p6 == p4 || p6 == p5) continue;
                                                                    
                                                                    if (((p6 / 100) == (p5 % 100)) && ((p6 % 100) == (p1 / 100))){
                                                                        System.out.println(String.format("%d %d %d %d %d %d", p1, p2, p3, p4, p5, p6));
                                                                        return new int[]{p1, p2, p3, p4, p5, p6};
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            } 
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return new int[0];
    }
    
    public static void main(String[] args){
        
        for (int n = 1000; n <= 9999; n++){
            if (isTriangle(n))  triangles.add(n);
            if (isSquare(n))    squares.add(n);
            if (isPentagon(n))  pentagons.add(n);
            if (isHexagon(n))   hexagons.add(n);
            if (isHeptagon(n))  heptagons.add(n);
            if (isOctagon(n))   octagons.add(n);
        }
        
        polygonSets.add(triangles);
        polygonSets.add(squares);
        polygonSets.add(pentagons);
        polygonSets.add(hexagons);
        polygonSets.add(heptagons);
        
        // The cyclic set of six integers will not necessarily follow the order of
        // triangle > square > pentagon > hexagon > heptagon > octagon > triangle.
        // The set being cyclic allows starting from any set to find a solution.
        // The set of octagonal numbers is a good starting point for
        // creating the cycle because it has the fewest numbers.
        
        // Approach: Build a cycle from a starting octagonal number,
        // find other polygonal numbers in unused sets that start with last 2 digits of previous number,
        // keep track of numbers in cycle and used polygon sets and repeat until a cycle of 6 numbers is found
        
        int sum = 0;
        int[] cycle = new int[0];
        
        for (int octagon : octagons){
            cycle = generateCycle(octagon);
            
            if (cycle.length == 6){
                // System.out.println(Arrays.toString(cycle));
                for (int num : cycle){
                    sum += num;
                }
                break;
            } 
        }
        
        System.out.println("Sum of six cyclic integers that correspond to an s-gonal number, s = [3, 8]: " + sum); // 28684
        // 1281, 8128, 2882, 8256, 5625, 2512
        // 8-gon 6-gon 5-gon 3-gon 4-gon 7-gon
        // octagon, hexagon, pentagon, triangle, square, heptagon
    }
}