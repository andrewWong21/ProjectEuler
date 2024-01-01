import java.util.*;

public class _61_CyclicalFigurateNumbers{
    static ArrayList<HashSet<Integer>> polygons;
    
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
    
    public static ArrayList<Integer> generateCycle(ArrayList<Integer> currCycle, boolean[] used){
        if (currCycle.size() == 6) return currCycle;
        for (int i = 0; i < polygons.size(); i++){
            if (!used[i]){
                // iterate through all unused polygon sets
                // if (polygon / 100 == currCycle.get(currCycle.size() - 1)){
                //   generateCycle()
                //}
            }
        }
        return new ArrayList<Integer>();
    }
    
    public static void main(String[] args){
        HashSet<Integer> triangles = new HashSet<Integer>(); // 96
        HashSet<Integer> squares   = new HashSet<Integer>(); // 68
        HashSet<Integer> pentagons = new HashSet<Integer>(); // 56
        HashSet<Integer> hexagons  = new HashSet<Integer>(); // 48
        HashSet<Integer> heptagons = new HashSet<Integer>(); // 43
        HashSet<Integer> octagons  = new HashSet<Integer>(); // 40
        
        for (int n = 1000; n <= 9999; n++){
            if (isTriangle(n))  triangles.add(n);
            if (isSquare(n))    squares.add(n);
            if (isPentagon(n))  pentagons.add(n);
            if (isHexagon(n))   hexagons.add(n);
            if (isHeptagon(n))  heptagons.add(n);
            if (isOctagon(n))   octagons.add(n);
        }
        
        polygons = new ArrayList<HashSet<Integer>>();
        polygons.add(triangles);
        polygons.add(squares);
        polygons.add(pentagons);
        polygons.add(hexagons);
        polygons.add(heptagons);
        
        // The cyclic set of six integers will not necessarily follow the order of
        // triangle > square > pentagon > hexagon > heptagon > octagon > triangle.
        // The set of octagonal numbers is a good starting point for
        // creating the cycle because it has the fewest numbers.
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int octagon : octagons){
            map.put(octagon, new ArrayList<Integer>());
            for (int triangle : triangles){
                if (triangle / 100 == octagon % 100){
                    // System.out.println(octagon + " " + triangle);
                }
            }
            for (int square : squares){
                if (square / 100 == octagon % 100){
                    // System.out.println(octagon + " " + square);
                }
            }
            for (int pentagon : pentagons){
                if (pentagon / 100 == octagon % 100){
                    // System.out.println(octagon + " " + pentagon);
                }
            }
            for (int hexagon : hexagons){
                if (hexagon / 100 == octagon % 100){
                    // System.out.println(octagon + " " + hexagon);
                }
            }
            for (int heptagon : heptagons){
                if (heptagon / 100 == octagon % 100){
                    // System.out.println(octagon + " " + heptagon);
                }
            }
        }
        // Approach: Build a cycle from a starting octagonal number,
        // find other polygonal numbers that start with last 2 digits,
        // keep track of built cycle in array until either 6 numbers are found
        // or all possible numbers in polygonal sets are exhausted (cycle not completed)
        
        // generateCycle
        
        int sum = 0;
        System.out.println("Sum of six cyclic integers that correspond to an s-gonal number, s = [2, 8]: " + sum); 
    }
}