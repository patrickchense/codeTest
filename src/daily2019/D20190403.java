package daily2019;

import util.Graph;

import java.util.*;

/*
A graph is minimally-connected if it is connected and there is no edge that can be removed while still leaving the graph connected. For example, any binary tree is minimally-connected.

Given an undirected graph, check if the graph is minimally-connected. You can choose to represent the graph as either an adjacency matrix or adjacency list.

    1
   / \
   2  3
  / \ /
 4   5
@Facebook
@medium
@graph
@review
@solved
@30min 构建Graph，思考

https://www.geeksforgeeks.org/check-removing-given-edge-disconnects-given-graph/
怎么表示一个graph?

graph相关的题
https://www.geeksforgeeks.org/edge-coloring-of-a-graph/
https://www.geeksforgeeks.org/program-to-calculate-the-edge-cover-of-a-graph/
https://www.geeksforgeeks.org/maximize-number-of-nodes-which-are-not-part-of-any-edge-in-a-graph/
https://www.geeksforgeeks.org/shortest-path-weighted-graph-weight-edge-1-2/
https://www.geeksforgeeks.org/check-star-graph/
https://www.geeksforgeeks.org/check-given-graph-tree/
https://www.geeksforgeeks.org/check-given-permutation-valid-dfs-graph/

 */
public class D20190403 {

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.root = 1;
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        Set<Integer> sets = new HashSet<>();
        sets.add(1);
        System.out.println(isMinimallyConnected(1, graph, graph.edges.get(1), sets));
        graph.addEdge(3, 5);
        sets.clear();
        sets.add(1);
        System.out.println(isMinimallyConnected(1, graph, graph.edges.get(1), sets));
    }

    //构建了Graph 对象，然后这里的关键是判断，从root开始的路线，是不是每个节点，只会访问到一次，如果不是，就不是minimally-connected
    // 还是很绕，比如怎么遍历，怎么比较
    public static boolean isMinimallyConnected(int v, Graph graph, List<Integer> edges, Set<Integer> visited) {
        if (edges.isEmpty()) return true;
        for (Integer val : edges) {
            if (visited.contains(val) && val != v) return false;
            visited.add(val);
            List<Integer> e = graph.edges.get(val);
            e.remove((Integer)v);
            boolean isMinimal = isMinimallyConnected(val, graph, e, visited);
            if (!isMinimal) return false;
        }
        return true;
    }
}
