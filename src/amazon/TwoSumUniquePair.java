package amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/discuss/interview-question/372434/Amazon-or-OA-2019-or-Two-Sum-Unique-Pairs
Given an int array nums and an int target, find how many unique pairs in the array such that their sum is equal to target.
 Return the number of pairs.

Example 1:

Input: nums = [1, 1, 2, 45, 46, 46], target = 47
Output: 2
Explanation:
1 + 46 = 47
2 + 45 = 47
Example 2:

Input: nums = [1, 1], target = 2
Output: 1
Explanation:
1 + 1 = 2

@solved
 */
public class TwoSumUniquePair {
    public static void main(String[] args) {
        System.out.println(uniquePairsCount2(new int[]{1, 1, 2, 45, 46, 46}, 47));
        System.out.println(uniquePairsCount2(new int[]{1, 1}, 2));
    }

    // O(nlogn) O(1)
    public static int uniquePairsCount(int[] nums, int target) {
        int res = 0;
        Arrays.sort(nums);
        int i = 0, j = nums.length -1;
        while (i < j) {
            if (nums[i] + nums[j] == target) {
                res++;
                while(i + 1 < nums.length && nums[i] == nums[++i]);
                while(j - 1 >= 0 && nums[j] == nums[--j]);
            }
            else if (nums[i] + nums[j] < target) i++;
            else j--;
        }
        return res;
    }

    // O(n) O(n)
    public static int uniquePairsCount2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i : nums) {
            if (map.containsKey(target - i)) {
                if (map.get(target - i) == 0) {
                    res++;
                    map.put(target - i, 1);
                }
            } else {
                map.put(i, 0);
            }
        }
        return res;
    }
}
