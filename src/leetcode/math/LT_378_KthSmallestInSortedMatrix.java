package leetcode.math;

import java.util.PriorityQueue;

/*
https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note:
You may assume k is always valid, 1 ≤ k ≤ n2.

@answered
@google
@priorityqueue
@review



2种解法看到，1 binary search, 2 priorityQueue，


https://www.geeksforgeeks.org/kth-smallest-element-in-a-row-wise-and-column-wise-sorted-2d-array-set-1/

 */
public class LT_378_KthSmallestInSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int l = matrix[0][0];
        int r = matrix[n - 1][n - 1];
        while (l + 1 < r) {
            int m = l + (r - l) / 2;
            if (getCnt(matrix, m) >= k) {
                r = m;
            } else {
                l = m;
            }
        }
        return getCnt(matrix, l) >= k ? l : r;
    }

    private int getCnt(int[][] matrix, int val) {
        int cnt = 0;
        int n = matrix.length;
        for (int i = 0; i < n; ++i) {
            int[] row = matrix[i];
            int l = 0;
            int r = n - 1;
            while (l + 1 < r) {
                int m = l + (r - l) / 2;
                if (row[m] <= val) {
                    l = m;
                } else {
                    r = m;
                }
            }
            cnt += 1 + (row[r] <= val ? r : row[l] <= val ? l : l - 1);
        }
        return cnt;
    }

    // very slow
    public int kthSmallest2(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int n = matrix.length;
        for (int[] row: matrix) {
            for (int col: row) {
                pq.offer(col);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }
}
