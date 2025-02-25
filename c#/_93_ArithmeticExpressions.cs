using System;
using System.Data;
using System.Collections.Generic;

public class _93_ArithmeticExpressions{
	static List<string[]> ops = GenerateOps();
	static string[] parens = {
        "(xox)oxox", "xo(xox)ox", "xoxo(xox)", "(xox)o(xox)",
        "(xoxox)ox", "xo(xoxox)",
        "((xox)ox)ox", "(xo(xox))ox", "xo((xox)ox)", "xo(xo(xox))",
        "xoxoxox"
	};
	
	public static string Euler93(){
		int max = 0;
		string res = "";
		List<List<int>> combs = GenerateCombs(9, 4);
		foreach (List<int> nums in combs){
			int count = CountTargets(nums);
			if (count > max){
				max = count;
				string digits = "";
				foreach (int num in nums){
					digits += num;
				}
				res = digits;
			}
		}
		return res;
	}
	
	public static List<string[]> GenerateOps(){
		List<string[]> res = new List<string[]>();
		string[] ops = {"+", "-", "*", "/"};
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++){
				for (int k = 0; k < 4; k++){
					res.Add(new string[]{ops[i], ops[j], ops[k]});
				}
			}
		}
		return res;
	}
	
	public static List<List<int>> GenerateCombs(int n, int k){
		// generate combinations of k choices of numbers 1 to n
		List<List<int>> combs = new List<List<int>>();
		BacktrackComb(combs, new List<int>(), 1, n, k);
		return combs;
	}
	
	public static void BacktrackComb(List<List<int>> combs, List<int> comb, int start, int n, int k){
		// combination fully generated
		if (comb.Count == k){
			combs.Add(new List<int>(comb));
			return;
		}
		for (int i = start; i <= n; i++){
			comb.Add(i);
			BacktrackComb(combs, comb, i + 1, n, k);
			comb.RemoveAt(comb.Count - 1);
		}
	}
	
	public static List<List<int>> GeneratePerms(List<int> nums){
		List<List<int>> perms = new List<List<int>>();
		bool[] used = new bool[nums.Count];
		BacktrackPerm(perms, new List<int>(), nums, used);
		return perms;
	}
	
	public static void BacktrackPerm(List<List<int>> perms, List<int> perm, List<int> nums, bool[] used){
		if (perm.Count == nums.Count){
			perms.Add(new List<int>(perm));
			return;
		}
		for (int i = 0; i < used.Length; i++){
			if (!used[i]){
				used[i] = true;
				perm.Add(nums[i]);
				BacktrackPerm(perms, perm, nums, used);
				perm.Remove(nums[i]);
				used[i] = false;
			}
		}
	}
	
	public static int CountTargets(List<int> nums){
		HashSet<int> targets = new HashSet<int>();
		List<List<int>> perms = GeneratePerms(nums);
		
		foreach(List<int> perm in perms){
			foreach (string[] op in ops){
				foreach (string paren in parens){
					int numIdx = 0, opIdx = 0;
					string expr = "";
					for (int i = 0; i < paren.Length; i++){
						if (paren[i] == 'o'){
							expr += op[opIdx++];
						}
						else if (paren[i] == 'x'){
							expr += perm[numIdx++];
						}
						else{
							expr += paren[i];
						}
					}
					double res = Evaluate(expr);
					if (res != double.NaN && (int) res == res){
						targets.Add((int) res);
					}
				}
			}
		}
		
		int target = 1;
		while (targets.Contains(target)){
			target++;
		}
		return target - 1;
	}
	
	public static double Evaluate(string expr){
        try {
            var table = new DataTable();
            var val = table.Compute(expr, "");
            return Convert.ToDouble(val);
        }
        catch (Exception){
            return double.NaN;
        }
    }
	
	public static void Main(){
		Console.WriteLine(Euler93());
	}
}
