package leetcode.arr;

/*
leetcode 713
https://leetcode.com/problems/subarray-product-less-than-k/description/
Your are given an array of positive integers nums.

Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.

Example 1:
Input: nums = [10, 5, 2, 6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
Note:

0 < nums.length <= 50000.
0 < nums[i] < 1000.
0 <= k < 10^6.

solution:
@slidewindow
 */
public class SubArrayMultiplyLessThanK {

    /*
       Intuition

For each right, call opt(right) the smallest left so that the product of the subarray nums[left] * nums[left + 1] * ... * nums[right] is less than k.
 opt is a monotone increasing function, so we can use a sliding window.

Algorithm
Our loop invariant is that left is the smallest value so that the product in the window prod = nums[left] * nums[left + 1] * ... * nums[right] is less than k.
For every right, we update left and prod to maintain this invariant. Then, the number of intervals with subarray product less than k and with right-most coordinate right, is right - left + 1. We'll count all of these for each value of right.

TODO summarize
What kind of types of questions suit to SlideWindow solution?
What the key point in SlideWindow solutions?
    */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) prod /= nums[left++];
            ans += right - left + 1;
        }
        return ans;
    }
}
