package daily2019;

import util.ArrayUtil;

/*
The transitive closure of a graph is a measure of which vertices are reachable from other vertices. It can be represented as a matrix M, where M[i][j] == 1 if there is a path between vertices i and j, and otherwise 0.

For example, suppose we are given the following graph in adjacency list form:

graph = [
    [0, 1, 3],
    [1, 2],
    [2],
    [3]
]
The transitive closure of this graph would be:

[1, 1, 1, 1]
[0, 1, 1, 0]
[0, 0, 1, 0]
[0, 0, 0, 1]
Given a graph, find its transitive closure.

@easy
@Microsoft

@solved
@10min

 */
public class D20190615 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{0,1,3}, {1,2}, {2}, {}};
        int[][] res = transitiveClosure(arr);
        ArrayUtil.printMatrixInt(res);
        arr = new int[][]{{0,1,3}, {1,2}, {2}, {3,5}};
        res = transitiveClosure(arr);
        ArrayUtil.printMatrixInt(res);
    }

    public static int[][] transitiveClosure(int[][] arr) {
        int len = 0;
        for (int[] ar : arr) {
            for (int i : ar) {
                len = Math.max(len, i);
            }
        }
        int[][] res = new int[arr.length][len + 1];
        for (int i = 0; i < arr.length; i++) {
            int[] ar = arr[i];
            if (ar.length == 1) res[i][ar[0]] = 1;
            else {
                for (int j = 1; j < ar.length; j++) {
                    int s = ar[j-1];
                    int e = ar[j];
                    for (int k = s; k <= e; k++) {
                        res[i][k] = 1;
                    }
                }
            }
        }

        return res;
    }

}
