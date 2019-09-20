package leetcode.graph;

import java.awt.*;
import java.util.*;
import java.util.List;

/*
We have a list of bus routes. Each routes[i] is a bus route that the i-th bus repeats forever. For example if routes[0] = [1, 5, 7],
this means that the first bus (0-th indexed) travels in the sequence 1->5->7->1->5->7->1->... forever.

We start at bus stop S (initially not on a bus), and we want to go to bus stop T. Travelling by buses only, what is the least number of buses we must take to reach our destination? Return -1 if it is not possible.

Example:
Input:
routes = [[1, 2, 7], [3, 6, 7]]
S = 1
T = 6
Output: 2
Explanation:
The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.
Note:

1 <= routes.length <= 500.
1 <= routes[i].length <= 500.
0 <= routes[i][j] < 10 ^ 6.

@graph
@shortest

@dijkstra
@bfs

 */
public class LT_815_BusRoute {

	public static void main(String[] args) {

	}

	public static int shortPath(int[][] routs, int start, int end) {
		Map<Integer, Stop> stops = new HashMap<>();
		Map<Integer, Boolean> visited = new HashMap<>();
		for (int[] route : routs) {
			for (int i : route) {
				if (stops.containsKey(i)) {
					Stop s = stops.get(i);
					s.addRoute(route);
					stops.put(i, s);
				} else {
					Stop s = new Stop(i, route);
					stops.put(i, s);
					visited.put(i, false);
				}
			}
		}

		//find shortest
		int min = -1;

		if(!stops.containsKey(start)) return -1;

		return dfs(stops, min, start, end, visited, 0);

	}

	private static int dfs(Map<Integer, Stop> stops, int min, int start, int end, Map<Integer, Boolean> visited, int cur) {
		if (stops.containsKey(start) && stops.get(start).contains(end)) {
			return min == -1 ? cur + 1 : (cur + 1 < min ? cur + 1 : min);
		}
		if (!stops.containsKey(start)) return min;
		if (visited.get(start)) return min;

		visited.put(start, true);
		for (List<Integer> route : stops.get(start).neighbors) {
			for (int r : route) {
				min = dfs(stops, min, r, end, visited, cur + 1);
			}
		}
		visited.put(start, false);
		return min;
	}

	//dfs?
	static class Stop {
		int num;
		List<List<Integer>> neighbors;

		public Stop(int cur, int[] neighbors) {
			num = cur;
			if (this.neighbors == null) this.neighbors = new ArrayList<>();
			List<Integer> t = new ArrayList<>();
			for (int n : neighbors) {
				if (n != cur) t.add(n);
			}
			this.neighbors.add(t);
		}

		public void addRoute(int[] neighbors) {
			List<Integer> t = new ArrayList<>();
			for (int n : neighbors) {
				if (n != num) t.add(n);
			}
			this.neighbors.add(t);
		}

		public boolean contains(int k) {
			for (List<Integer> route : neighbors) {
				if (route.contains(k)) return true;
			}
			return false;
		}
	}

	// BFS, O(sum(N-i)bi)  N number of buses,  bi the number of stops on ith bus,  O(N^2 + sum(bi)) space,
	public int numBusesToDestination(int[][] routes, int S, int T) {
		if (S==T) return 0;
		int N = routes.length;

		List<List<Integer>> graph = new ArrayList();
		for (int i = 0; i < N; ++i) {
			Arrays.sort(routes[i]);
			graph.add(new ArrayList());
		}
		Set<Integer> seen = new HashSet();
		Set<Integer> targets = new HashSet();
		Queue<Point> queue = new ArrayDeque();

		// Build the graph.  Two buses are connected if
		// they share at least one bus stop.
		for (int i = 0; i < N; ++i)
			for (int j = i+1; j < N; ++j)
				if (intersect(routes[i], routes[j])) {
					graph.get(i).add(j);
					graph.get(j).add(i);
				}

		// Initialize seen, queue, targets.
		// seen represents whether a node has ever been enqueued to queue.
		// queue handles our breadth first search.
		// targets is the set of goal states we have.
		for (int i = 0; i < N; ++i) {
			if (Arrays.binarySearch(routes[i], S) >= 0) {
				seen.add(i);
				queue.offer(new Point(i, 0));
			}
			if (Arrays.binarySearch(routes[i], T) >= 0)
				targets.add(i);
		}

		while (!queue.isEmpty()) {
			Point info = queue.poll();
			int node = info.x, depth = info.y;
			if (targets.contains(node)) return depth+1;
			for (Integer nei: graph.get(node)) {
				if (!seen.contains(nei)) {
					seen.add(nei);
					queue.offer(new Point(nei, depth+1));
				}
			}
		}

		return -1;
	}

	public boolean intersect(int[] A, int[] B) {
		int i = 0, j = 0;
		while (i < A.length && j < B.length) {
			if (A[i] == B[j]) return true;
			if (A[i] < B[j]) i++; else j++;
		}
		return false;
	}
}
