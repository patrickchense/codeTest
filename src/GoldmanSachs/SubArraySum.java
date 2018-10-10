package GoldmanSachs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array, find a subarray such the sum of the elements in subarray is greater than or equal to target value.
 Find the minimum length of such subarray.
=>  how many big numbers in the array sum up greater than target

think: sort, and loop


related:
TODO 存在连续的subarray sum = n*k, n可为任意正整数
https://leetcode.com/problems/continuous-subarray-sum/description/

TODO 连续subarray sum == k
https://leetcode.com/problems/subarray-sum-equals-k/description/

TODO 连续subarray最短 sum >= k
https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/description/

TODO 最短subarray连续，sum >= k
https://leetcode.com/problems/minimum-size-subarray-sum/description/

 */
public class SubArraySum {

    public static void main(String[] args) {
        int[] nums = new int[]{2,34,54,32,13,4,2,4,312,6,45,5,888,210,3};
        System.out.println(subArrayGreaterEqualThanTarget(nums, 1022));
        System.out.println(subArrayGreaterEqualThanTarget(nums, 10222));
    }

    public static int subArrayGreaterEqualThanTarget(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = nums.length-1; i> -1; i--) {
            sum += nums[i];
            if (sum >= target) return nums.length - i;
        }
        return -1;
    }

}
