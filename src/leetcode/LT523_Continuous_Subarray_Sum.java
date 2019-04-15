package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/continuous-subarray-sum/

@medium
@array
@subarray

Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous subarray of
size at least 2 that sums up to the multiple of k, that is, sums up to n*k where n is also an integer.

Example 1:

Input: [23, 2, 4, 6, 7],  k=6
Output: True
Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
Example 2:

Input: [23, 2, 6, 4, 7],  k=6
Output: True
Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.


Note:
The length of the array won't exceed 10,000.
You may assume the sum of all the numbers is in the range of a signed 32-bit integer.

@solved
@optimized
 */
public class LT523_Continuous_Subarray_Sum {

    public static void main(String[] args) {
        System.out.println(maxLenSubarraySumMultiple(new int[]{23,2,6,4,7}, 0));
    }

    // 不是很好， brute force, 怎么优化?
    public static boolean maxLenSubarraySumMultiple(int[] nums, int k) {
        if (k < 0) k = -1 * k;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < len; j++) {
                sum += nums[j];
                if (k != 0 && sum % k == 0) return true;
                if (k ==0 && sum == 0) return true;
            }
        }

        return false;
    }

    // 记录每个
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(){{put(0,-1);}};;
        int runningSum = 0;
        for (int i=0;i<nums.length;i++) {
            runningSum += nums[i];
            if (k != 0) runningSum %= k;
            Integer prev = map.get(runningSum); // 两次的余数相等，意味着?  sum[0-i] - sum[0-j] 是 k 的倍数
            if (prev != null) {
                if (i - prev > 1) return true;
            }
            else map.put(runningSum, i);
        }
        return false;
    }
}
