import java.util.*;
import java.io.File;

public class _79_PasscodeDerivation{
    
    public static void main(String[] args){
        
        String ans = "";
        
        try{
            File file = new File("0079_keylog.txt");
            Scanner sc = new Scanner(file);
            
            HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
            while (sc.hasNext()){
                String str = sc.next();
                
                for (int i = 0; i < str.length(); i++){
                    int num = (int) (str.charAt(i) - '0');
                    
                    // Create a new node in the graph for newly-encountered digits.
                    if (!graph.containsKey(num)){
                        graph.put(num, new HashSet<Integer>());
                    }
                    
                    // Connect subsequent digits as outgoing edges.
                    for (int j = i + 1; j < str.length(); j++){
                        graph.get(num).add((int) (str.charAt(j) - '0'));
                    }
                }
            }
            
            // System.out.println(graph);
            // The resulting graph has a clear source node with no incoming edges
            // and sink node with no outgoing edges, so a path can be traced through
            // the graph that visits all nodes once from the source to the sink.
            
            // Ordering the digits by out-degree, descending, results in the shortest possible passcode.
            // If the passcode had repeating digits, the resulting graph would be more complex and this approach would not work.
            
            ArrayList<Integer> digits = new ArrayList<>(graph.keySet());
            Collections.sort(digits, (e1, e2) -> Integer.compare(graph.get(e2).size(), graph.get(e1).size()));
            
            for (Integer digit : digits){
                ans += digit;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("Shortest possible secret passcode: " + ans); // 73162890
    }
}