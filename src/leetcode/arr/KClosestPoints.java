package leetcode.arr;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
https://leetcode.com/problems/k-closest-points-to-origin/
LT 973
We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)



Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)

@sort
@answered
@quicksort
@review

sort the whole points is not the hard part O(nlogn) O(n) space, using priorityqueue is also not hard
how to optimize?

using quicksort  kClosest2

 */
public class KClosestPoints {

    public static void main(String[] args) {

    }

    public int[][] kClosest(int[][] points, int K) {
        int[][] res = new int[K][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingInt(a -> (a[0] * a[0] + a[1] * a[1])));
        for(int[] nums : points) {
            pq.add(nums);
        }

        int i = 0;
        while(K-- != 0) {
            res[i++] = pq.poll();
        }
        return res;
    }

    public int[][] kClosest1(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparingInt(n -> ((n[0] * n[0]) + (n[1] * n[1]))));
        int [][] result = new int[K][2];
        for(int i = 0; i < K; i++)
            for(int j = 0; j < points[0].length; j++)
                result[i][j] = points[i][j];
        return result;
    }

    public int[][] kClosest2(int[][] points, int k) {
        quickPartition(points, k, 0, points.length - 1);
        return Arrays.copyOf(points, k);
    }

    private void quickPartition(int[][] points, int k, int from, int to) {
        if(from > to) return;
        int pos = partition(points, k, from, to);
        int q = pos - from + 1;
        if (q < k)
            quickPartition(points, k-q, pos + 1, to);
        else if (q > k)
            quickPartition(points, k, from, pos);
    }

    private int partition(int[][] points, int k, int i, int j) {

        int m = (i + j) / 2;
        int[] p = points[m];
        int pd = p[0] * p[0] + p[1] * p[1];

        i--;
        j++;
        while(i < j) {
            do
                i++;
            while(compare(points[i], pd) < 0);

            do
                j--;
            while(compare(points[j], pd) > 0);
            if (i >= j)
                return j;
            int[] tmp = points[i];
            points[i] = points[j];
            points[j] = tmp;
        }
        return j;
    }

    private int compare(int[] a, int b) {
        return Integer.compare(a[0] * a[0] + a[1] * a[1], b);
    }


}
