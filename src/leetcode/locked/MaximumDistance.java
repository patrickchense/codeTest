package leetcode.locked;

import java.util.*;

/*
leetcode 624 Maximum Distance in Array
https://leetcode.com/articles/maximum-distance-in-array/
Given m arrays, and each array is sorted in ascending order. Now you can pick up two integers from two different arrays (each array picks one) and calculate the distance.
We define the distance between two integers a and b to be their absolute difference |a-b|. Your task is to find the maximum distance.

Example 1:
Input:
[[1,2,3],
 [4,5],
 [1,2,3]]
Output: 4
Explanation:
One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.
Note:
Each given array will have at least 1 number. There will be at least two non-empty arrays.
The total number of the integers in all the m arrays will be in the range of [2, 10000].
The integers in the m arrays will be in the range of [-10000, 10000].

@solved

 */
public class MaximumDistance {

    public static void main(String args[]) {
        int[][] nums = new int[][]{
                {1, 2, 3},
                {4, 5},
                {1, 2, 3}};
        System.out.println(maximumDistance(nums));
    }

    /*
    自己写的用到了 O(nums.length)space, O(nums.length) time
    发现问题, Arrays.asList 返回的List不能add(fix size)
     */
    public static int maximumDistance(int[][] nums) {
        if (nums == null) return 0;
        Map<Integer, List<Integer>> maxes = new HashMap<>();
        Map<Integer, List<Integer>> mins = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int s_min = Integer.MAX_VALUE;
        int s_max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (mins.containsKey(nums[i][0])) {
                mins.get(nums[i][0]).add(i);
            } else {
                List<Integer> indexes = new ArrayList<>();
                indexes.add(i);
                mins.put(nums[i][0], indexes);
            }
            min = Math.min(min, nums[i][0]);
            if (min < nums[i][0]) {
                s_min = Math.min(s_min, nums[i][0]);
            }
            if (maxes.containsKey(nums[i][nums[i].length - 1])) {
                maxes.get(nums[i][nums[i].length - 1]).add(i);
            } else {
                List<Integer> indexes = new ArrayList<>();
                indexes.add(i);
                maxes.put(nums[i][nums[i].length - 1], indexes);
            }
            max = Math.max(max, nums[i][nums[i].length - 1]);
            if (max > nums[i][nums[i].length - 1]) {
                s_max = Math.max(nums[i][nums[i].length - 1], s_max);
            }
        }
        if (maxes.get(max).size() > 1 || mins.get(min).size() > 1) return max - min;
        if (maxes.get(max).get(0) != mins.get(min).get(0)) return max - min;
        // find the seconde largest
        return Math.max(max - s_min, s_max - min);
    }

    /*
    better solution
    O(n), O(1)
     */
    public int maxDistance(int[][] list) {
        int res = 0, min_val = list[0][0], max_val = list[0][list[0].length - 1];
        for (int i = 1; i < list.length; i++) {
            res = Math.max(res, Math.max(Math.abs(list[i][list[i].length - 1] - min_val), Math.abs(max_val - list[i][0])));
            min_val = Math.min(min_val, list[i][0]);
            max_val = Math.max(max_val, list[i][list[i].length - 1]);
        }
        return res;
    }
}
