package uber;

import java.util.*;

/*
A machine consists of list of blocks that you need to assemble in order. Each block has zero or more dependencies on another block.
For example, if block B has a dependency on block A, then A must be assembled before B.
 In this problem, you are given a list of blocks along with their list of dependencies, and your goal should be to print a valid order to assemble the blocks.

Example:

M -> []
N -> [M]
O -> [M]
P -> [N,0]

Output: Either [M,O,N,P] or [M,N,O,P] would work.
This question is on similar lines: https://leetcode.com/problems/course-schedule-ii

@phone

@solved


@graph

图怎么解? 怎么构建数据结构，怎么利用，什么题型

@dfs  https://leetcode.com/problems/course-schedule-ii/solution/  很有启发，3个颜色，遍历顺序，结果，
@nodeIndegree 更有效，根据degree，可以处理所有拓扑优先级题


 */
public class BlockDependency {

	public static void main(String[] args) {
		Map<String, List<String>> map = new HashMap<>();
		map.put("M", Collections.emptyList());
		map.put("N", Arrays.asList("M"));
		map.put("O", Arrays.asList("M"));
		map.put("P", Arrays.asList("N", "O"));
		System.out.println(assembleBlock(Arrays.asList("M", "P", "O", "N"), map));

	}

	// O(n ^ n ) , O(n)
	public static List<String> assembleBlock(List<String> blocks, Map<String, List<String>> depend) {
		List<String> res = new ArrayList<>();

		Set<String> contains = new HashSet<>();

		for (String s : blocks) {
			if (!depend.containsKey(s) || (depend.containsKey(s) && depend.get(s).isEmpty())) {
				contains.add(s);
				depend.remove(s);
			}
		}
		res.addAll(contains);
		int size = depend.keySet().size();
		while(size > 0) {
			Set<String> rms = new HashSet<>();
			for (Map.Entry<String, List<String>> ds : depend.entrySet()) {
				if (contains.containsAll(ds.getValue())) {
					contains.add(ds.getKey());
					size--;
					rms.add(ds.getKey());
					res.add(ds.getKey());
				}
			}
			if (!rms.isEmpty()) {
				for (String k : rms) depend.remove(k);
			}
		}

		return res;
	}


	public int[] findOrder(int numCourses, int[][] prerequisites) {

		boolean isPossible = true;
		Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
		int[] indegree = new int[numCourses];
		int[] topologicalOrder = new int[numCourses];

		// Create the adjacency list representation of the graph
		for (int i = 0; i < prerequisites.length; i++) {
			int dest = prerequisites[i][0];
			int src = prerequisites[i][1];
			List<Integer> lst = adjList.getOrDefault(src, new ArrayList<Integer>());
			lst.add(dest);
			adjList.put(src, lst);

			// Record in-degree of each vertex
			indegree[dest] += 1;
		}

		// Add all vertices with 0 in-degree to the queue
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}

		int i = 0;
		// Process until the Q becomes empty
		while (!q.isEmpty()) {
			int node = q.remove();
			topologicalOrder[i++] = node;

			// Reduce the in-degree of each neighbor by 1
			if (adjList.containsKey(node)) {
				for (Integer neighbor : adjList.get(node)) {
					indegree[neighbor]--;

					// If in-degree of a neighbor becomes 0, add it to the Q
					if (indegree[neighbor] == 0) {
						q.add(neighbor);
					}
				}
			}
		}

		// Check to see if topological sort is possible or not.
		if (i == numCourses) {
			return topologicalOrder;
		}

		return new int[0];
	}
}
