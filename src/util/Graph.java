package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    public int root;

    public Map<Integer, List<Integer>>  edges = new HashMap<>();

    public Graph(int root, Map<Integer, List<Integer>> edges) {
        this.edges = edges;
        this.root = root;
    }

    public Graph() {
    }

    public void addEdge(int v, int u) {
        if (edges.containsKey(v)) {
            this.edges.get(v).add(u);
        } else {
            List<Integer> s = new ArrayList<>();
            s.add(u);
            this.edges.put(v, s);
        }
        if (edges.containsKey(u)) {
            this.edges.get(u).add(v);
        } else {
            List<Integer> s = new ArrayList<>();
            s.add(v);
            this.edges.put(u, s);
        }
    }

    public boolean isConnected(int v, int u) {
        return (edges.containsKey(v) && edges.get(v).contains(u)) || (edges.containsKey(u) && edges.get(u).contains(v));
    }
}
