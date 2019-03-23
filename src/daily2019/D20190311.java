package daily2019;

/*
You are given an N by M matrix of 0s and 1s. Starting from the top left corner, how many ways are there to reach the bottom right corner?

You can only move right and down. 0 represents an empty space while 1 represents a wall you cannot walk through.

For example, given the following matrix:

[[0, 0, 1],
 [0, 0, 1],
 [1, 0, 0]]
Return two, as there are only two ways to get to the bottom right:

Right, down, down, right
Down, right, down, right
The top left corner and bottom right corner will always be 0.

@Slack
@solved
@recursive

@review
@matrix path

https://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
https://www.geeksforgeeks.org/check-possible-path-2d-matrix/  O(n^2) 通过标记的方式 O(n*m)的space
https://www.geeksforgeeks.org/maximum-path-sum-matrix/
https://www.geeksforgeeks.org/longest-increasing-path-matrix/
https://www.geeksforgeeks.org/maximum-sum-path-matrix-top-bottom/
https://www.geeksforgeeks.org/find-whether-path-two-cells-matrix/
https://www.geeksforgeeks.org/minimum-odd-cost-path-in-a-matrix/
https://www.geeksforgeeks.org/maximum-decimal-value-path-in-a-binary-matrix/
https://www.geeksforgeeks.org/find-the-longest-path-in-a-matrix-with-given-constraints/
https://www.geeksforgeeks.org/find-maximum-path-length-in-a-binary-matrix/
https://www.geeksforgeeks.org/maximum-weight-path-ending-element-last-row-matrix/


 */
public class D20190311 {

    static int cur = 0;
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 0, 1},{0, 0, 1},{1, 0, 0}};
        countPath(matrix, 0, 0, matrix.length, matrix[0].length);
        System.out.println(cur);
    }

    // 碰到个问题，关于返回次数的增加，一开始用一个Integer, 然后Integer的值没有传递，最后=0，才用了类静态变量
    public static void countPath(int[][] matrix, int i, int j, int N, int M) {
        if (i >= N || j >= M) return;
        if (i == N-1 && j == M-1) {
            cur++;
            return;
        }
        if (i < N -1) {
            int next_r = matrix[i+1][j];
            if (next_r == 0) countPath(matrix, i+1, j, N, M);
        }
        if (j < M -1) {
            int next_d = matrix[i][j+1];
            if (next_d == 0) countPath(matrix, i, j+1, N, M);
        }
        return;
    }
}
