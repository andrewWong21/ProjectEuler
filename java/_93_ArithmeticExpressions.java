import java.util.*;

public class _93_ArithmeticExpressions{
    
    // generate combinations of 4 digits from 0-9
    static List<List<Integer>> digits = generateCombs(9, 4);
    
    // generate groups of 3 operators
    static List<String> ops = generateOps();
    
    // list out postfix groupings of digits and operators
    static String[] groups = new String[]{
        "xxxx...", "xxx.x..", "xxx..x.", "xx.xx..", "xx.x.x."
    };
    
    public static List<String> generateOps(){
        List<String> res = new ArrayList<>();
        String operators = "+-*/";
        // operators may appear more than once or not at all
        // sampling operators with replacement
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                for (int k = 0; k < 4; k++){
                    StringBuilder newOp = new StringBuilder();
                    newOp.append(operators.charAt(i));
                    newOp.append(operators.charAt(j));
                    newOp.append(operators.charAt(k));
                    res.add(newOp.toString());
                }
            }
        }
        return res;
    }
    
    public static List<List<Integer>> generateCombs(int n, int k){
        List<List<Integer>> combs = new ArrayList<>();
        backtrackCombs(combs, new ArrayList<>(), n, k, 0);
        return combs;
    }
    
    private static void backtrackCombs(List<List<Integer>> combs, List<Integer> curr, int n, int k, int idx){
        if (curr.size() == k){
            combs.add(new ArrayList<>(curr));
            return;
        }
        for (int i = idx; i <= n; i++){
            curr.add(i);
            backtrackCombs(combs, curr, n, k, i + 1);
            // avoiding ambiguity of value vs. position
            // when removing an element from a list of integers
            // specifying an Integer object removes a value
            curr.remove(Integer.valueOf(i));
        }
    }
    
    public static List<List<Integer>> generatePerms(List<Integer> nums){
        List<List<Integer>> perms = new ArrayList<>();
        backtrackPerms(perms, new ArrayList<>(), nums, new boolean[nums.size()]);
        return perms;
    }
    
    private static void backtrackPerms(List<List<Integer>> perms, List<Integer> curr, List<Integer> nums, boolean[] used){
        if (curr.size() == used.length){
            perms.add(new ArrayList<Integer>(curr));
            return;
        }
        for (int i = 0; i < used.length; i++){
            if (!used[i]){
                used[i] = true;
                curr.add(nums.get(i));
                backtrackPerms(perms, curr, nums, used);
                curr.remove(nums.get(i));
                used[i] = false;
            }
        }
    }
    
    private static int countResults(List<Integer> digits){
        List<List<Integer>> perms = generatePerms(digits);
        Set<Integer> results = new HashSet<>();
        
        for (List<Integer> perm : perms){
            for (String op : ops){
                for (String group : groups){
                    int res = evaluateExpression(perm, op, group);
                    if (res > 0){
                        results.add(res);
                    }
                }
            }
        }
        // calculate consecutive streak of integer results starting from 1
        int i = 0;
        while (results.contains(i + 1)) i++;
        return i;
    }
    
    // evaluate postfix expression given digits and operators
    private static int evaluateExpression(List<Integer> perm, String op, String group){
        Stack<Double> results = new Stack<>();
        int numIdx = 0, opIdx = 0;
        for (char c : group.toCharArray()){
            if (c != 'x'){
                char currOp = op.charAt(opIdx++);
                if (currOp == '+'){
                    results.push((double) results.pop() + results.pop());
                }
                else if (currOp == '*'){
                    results.push(results.pop() * results.pop());
                }
                else if (currOp == '-'){
                    double op2 = results.pop();
                    double op1 = results.pop();
                    results.push(op1 - op2);
                }
                else{
                    double op2 = results.pop();
                    if (op2 == 0) return 0;
                    double op1 = results.pop();
                    results.push(op1 / op2);
                }
            }
            else{
                results.push((double) perm.get(numIdx++));
            }
        }
        double res = results.pop();
        if (res < 0 || (int) res != res) return 0;
        return (int) res;
    }
    
    public static void main(String[] args){
        int maxStreak = 0;
        String res = "";
        
        for (List<Integer> comb : digits){
            int streak = countResults(comb);
            if (streak > maxStreak){
                maxStreak = streak;
                StringBuilder sb = new StringBuilder();
                for (int d : comb) sb.append(d);
                res = sb.toString();
            }
        }
        
        System.out.println("Digits that result in longest set of consecutive integers using arithmetic operations: " + res); // 1258
    }
}
