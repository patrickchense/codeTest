package uber;

import sun.security.pkcs11.P11TlsMasterSecretGenerator;

import java.util.*;

/*
Given a list of tuples, find the list which belong to same tuple.
Input (Matrix):
int input[][] = {{1,2},{3,4},{7,2},{5,12},{11,3},{9,7}}

Output:
ArrayList of Arraylist: {{1,2,7,9},{3,4,11},{5,12}}

Note: Order of output is not important.

My approach : I used disjoint sets to solve this question. At the end, group with same parent will belong to same list and then we can output the list. Looking for a better approach (if available).
Thanks!

Similar problem: https://leetcode.com/problems/accounts-merge/

@phone
@dsu
@review

disjoint set union, data structure
 https://leetcode.com/articles/redundant-connection/


 */
public class MergeTuples {

	public static void main(String[] args) {
		System.out.println(mergeTuple(Arrays.asList(new int[]{1,2},new int[]{3,4},new int[]{7,2}, new int[]{5,12}, new int[]{11,3}, new int[]{9,7})));
		System.out.println(mergeTuple2(Arrays.asList(new int[]{1,2},new int[]{3,4},new int[]{7,2}, new int[]{5,12}, new int[]{11,3}, new int[]{9,7})));
	}

	// O(n) space, O(n ^ 2) time
	public static List<Set<Integer>> mergeTuple(List<int[]> tuples) {
		List<Set<Integer>> result = new ArrayList<>();

		for (int[] tuple : tuples) {
			boolean find = false;
			for (Set<Integer> res : result) {
				if (res.contains(tuple[0]) || res.contains(tuple[1])) {
					res.add(tuple[0]);
					res.add(tuple[1]);
					find = true;
					break;
				}
			}
			if (!find) {
				Set<Integer> res = new HashSet<>();
				res.add(tuple[0]);
				res.add(tuple[1]);
				result.add(res);
			}
		}
		return result;
	}

	// optimize DSU
	public static List<Set<Integer>> mergeTuple2(List<int[]> tuples) {
		int max = 0;
		for (int[] tuple : tuples) {
			max = Math.max(max, tuple[0]);
			max = Math.max(max, tuple[1]);
		}
		int[] pos = new int[max];
		Arrays.fill(pos, -1);
		Map<Integer, Set<Integer>> vals = new HashMap<>();
		int count = 1;
		for (int[] tuple : tuples) {
			int id = find(tuple[0], pos);
			if (id > 0) {
				vals.get(id).add(tuple[0]);
				vals.get(id).add(tuple[1]);
				pos[tuple[1]-1] = id;
				continue;
			}
			id = find(tuple[1], pos);
			if (id > 0) {
				vals.get(id).add(tuple[0]);
				vals.get(id).add(tuple[1]);
				pos[tuple[0]-1] = id;
				continue;
			}

			Set<Integer> set = new HashSet<>();
			set.add(tuple[0]);
			set.add(tuple[1]);
			pos[tuple[0]-1] = count;
			pos[tuple[1]-1] = count;
			vals.put(count++, set);

		}

		List<Set<Integer>> result = new ArrayList<>();
		result.addAll(vals.values());
		return result;
	}

	private static int find(int i, int[] pos) {
		if (pos[i-1] > 0 ) return pos[i-1];
		return pos[i-1];
	}

	// optimize? java8 computeIfAbsent(key, x -> value new).add() is very great
	// email name both key, graph build
	// O(sum(AilogAi)) Ai is the length of accounts[i],  O(sum(Ai)) space
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		Map<String, String> emailToName = new HashMap();
		Map<String, ArrayList<String>> graph = new HashMap();
		for (List<String> account: accounts) {
			String name = "";
			for (String email: account) {
				if (name == "") {
					name = email;
					continue;
				}
				graph.computeIfAbsent(email, x-> new ArrayList<String>()).add(account.get(1));
				graph.computeIfAbsent(account.get(1), x-> new ArrayList<String>()).add(email);
				emailToName.put(email, name);
			}
		}

		Set<String> seen = new HashSet();
		List<List<String>> ans = new ArrayList();
		for (String email: graph.keySet()) {
			if (!seen.contains(email)) {
				seen.add(email);
				Stack<String> stack = new Stack();
				stack.push(email);
				List<String> component = new ArrayList();
				while (!stack.empty()) {
					String node = stack.pop();
					component.add(node);
					for (String nei: graph.get(node)) {
						if (!seen.contains(nei)) {
							seen.add(nei);
							stack.push(nei);
						}
					}
				}
				Collections.sort(component);
				component.add(0, emailToName.get(email));
				ans.add(component);
			}
		}
		return ans;
	}


	// optimize Disjoint Set Union (DSU)
	class Solution {
		public List<List<String>> accountsMerge(List<List<String>> accounts) {
			DSU dsu = new DSU();
			Map<String, String> emailToName = new HashMap();
			Map<String, Integer> emailToID = new HashMap();
			int id = 0;
			for (List<String> account: accounts) {
				String name = "";
				for (String email: account) {
					if (name == "") {
						name = email;
						continue;
					}
					emailToName.put(email, name);
					if (!emailToID.containsKey(email)) {
						emailToID.put(email, id++);
					}
					dsu.union(emailToID.get(account.get(1)), emailToID.get(email));
				}
			}

			Map<Integer, List<String>> ans = new HashMap();
			for (String email: emailToName.keySet()) {
				int index = dsu.find(emailToID.get(email));
				ans.computeIfAbsent(index, x-> new ArrayList()).add(email);
			}
			for (List<String> component: ans.values()) {
				Collections.sort(component);
				component.add(0, emailToName.get(component.get(0)));
			}
			return new ArrayList(ans.values());
		}
	}
	class DSU {
		int[] parent;
		public DSU() {
			parent = new int[10001];
			for (int i = 0; i <= 10000; ++i)
				parent[i] = i;
		}
		public int find(int x) {
			if (parent[x] != x) parent[x] = find(parent[x]);
			return parent[x];
		}
		public void union(int x, int y) {
			parent[find(x)] = find(y);
		}
	}
}
