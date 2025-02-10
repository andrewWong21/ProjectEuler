using System;
using System.Collections.Generic;

public class _79_PasscodeDerivation{
	public static string Euler79(){
		string[] codes = new string[]{
			"319", "680", "180", "690", "129",
			"620", "762", "689", "762", "318",
			"368", "710", "720", "710", "629",
			"168", "160", "689", "716", "731",
			"736", "729", "316", "729", "729",
			"710", "769", "290", "719", "680",
			"318", "389", "162", "289", "162",
			"718", "729", "319", "790", "680",
			"890", "362", "319", "760", "316",
			"729", "380", "319", "728", "716"
		};
		Dictionary<int, HashSet<int>> adj = new Dictionary<int, HashSet<int>>();
		foreach (string code in codes){
			for (int i = 0; i < 3; i++){
				int d1 = int.Parse(code[i].ToString());
				if (!adj.ContainsKey(d1)){
					adj[d1] = new HashSet<int>();
				}
				for (int j = i + 1; j < 3; j++){
					int d2 = int.Parse(code[j].ToString());
					adj[d1].Add(d2);
				}
			}
		}
		int[] indeg = new int[10];
		foreach (var node in adj){
			foreach (int nei in node.Value){
				indeg[nei]++;
			}
		}
		Queue<int> q = new Queue<int>();
		foreach (int d in adj.Keys){
			if (indeg[d] == 0){
				q.Enqueue(d);
			}
		}
		string res = "";
		while (q.Count > 0){
			int d = q.Dequeue();
			res += d.ToString();
			foreach (int nei in adj[d]){
				if (--indeg[nei] == 0){
					q.Enqueue(nei);
				}
			}
		}
		return res;
	}
	
	public static void Main(){
		Console.WriteLine(Euler79());
	}
}
