package LINE;

import util.ArrayUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
Problem Statement
Given a directed graph, detect whether the graph contains a cycle or not.

Input
[N_NODES] [N_EDGES]
[E1_FROM_NODE] [E1_TO_NODE]
[E2_FROM_NODE] [E2_TO_NODE]
...
Where N_NODES is the number of nodes in the graph, and N_EDGES is the number of edges in the graph.

N_EDGES lines follow after the first line.

A pair of En_FROM_NODE  and En_TO_NODE represents a directed edge in the graph.

En_FROM_NODE and En_TO_NODE are node ids, which are integers in the range 0..N_NODES-1

Output
Output "true" if the graph contains at least one cycle; otherwise, "false".

[RESULT]
Input Example
3 3
0 1
1 2
2 0
Output Example
true
 */
public class DirectCycle {
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] params = input.split(" ");
        int nodes = Integer.valueOf(params[0]);
        int edgeSize = Integer.valueOf(params[1]);
        List<List<Integer>> edges = new ArrayList<>(nodes);
        for (int i = 0; i < nodes; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0 ; i < edgeSize; i++) {
            String edge = br.readLine();
            String[] paths = edge.split(" ");
            int start = Integer.valueOf(paths[0]);
            int end = Integer.valueOf(paths[1]);
            edges.get(start).add(end);
        }
        System.out.println(edges.toString());

        // using DFS to detect cycle

        for (int i = 0; i < nodes; i++) {
            boolean[] visited = new boolean[nodes];
            boolean[] recursions = new boolean[nodes];
            if (isCycle(edges, i, visited, recursions)) {
                System.out.println("true");
                return;
            }
        }
        System.out.println("false");
        br.close();
    }
    public static boolean isCycle(List<List<Integer>> edges, int node, boolean[] visited, boolean[] recursions) {
        if (recursions[node]) return true; // already recursion
        if (visited[node]) return true; // self cycle
        visited[node] = true;
        recursions[node] = true; // assume it's recursion
        // loop all the paths from this node
        for (int p : edges.get(node)) {
            if (isCycle(edges, p, visited, recursions)) {
                return true;
            }
        }
        recursions[node] = false;
        return false;
    }




}
