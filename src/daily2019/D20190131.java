package daily2019;

import java.util.Arrays;

/*
Given a set of closed intervals, find the smallest set of numbers that covers all the intervals. If there are multiple smallest sets, return any of them.

For example, given the intervals [0, 3], [2, 6], [3, 4], [6, 9], one set of numbers that covers all these intervals is {3, 6}.
@Google

@array
@interval
@range
@solved

边界问题，找到所有ingtervals之间的insect



 */
public class D20190131 {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{0,3}, {2,6}, {3,4}, {6,9}};
        System.out.println(Arrays.toString(findSmallestInterval(intervals)));
    }

    //这里假设所有都是包含的interval
    public static int[] findSmallestInterval(int[][] intervals) {
        int[] result = null;
        for (int[] interval : intervals) {
            if (result == null) {
                result = interval;
            } else {
/*
   // 这段逻辑是最大范围
            if (interval[1] <= result[0]) { //小于上界
                    result[0] = interval[0];
                } else if (interval[0] >= result[1]) {
                    result[1] = interval[1];
                } else if (interval[0] < result[0]){
                    result[0] = interval[0];
                } else if (interval[1] > result[1]) {
                    result[1] = interval[1];
                }*/
// 这段最小的逻辑，还是有点绕的
                if (interval[1] <= result[1] && interval[1] >= result[0]) {
                    result[1] = interval[1];
                }
                if (interval[0] >= result[0] && interval[0] <= result[1]) {
                    result[0] = interval[0];
                }
                // 没有intersect
                if (interval[1] < result[0]) {
                    result[0] = interval[1];
                } else if (interval[0] > result[1]){
                    result[1] = interval[0];
                }
            }
        }
        return result;
    }
}
