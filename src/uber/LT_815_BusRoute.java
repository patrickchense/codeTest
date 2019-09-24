package uber;

import java.awt.*;
import java.util.*;
import java.util.List;

/*
https://leetcode.com/problems/bus-routes/

We have a list of bus routes. Each routes[i] is a bus route that the i-th bus repeats forever. For example if routes[0] = [1, 5, 7], this means that the first bus (0-th indexed) travels in the sequence 1->5->7->1->5->7->1->... forever.

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

@phone
@hard

https://leetcode.com/discuss/interview-question/124924/Uber-or-Phone-screen-or-String-pattern-matching

@review

 */
public class LT_815_BusRoute {

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
