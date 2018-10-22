package leetcode.locked;

import java.util.Arrays;

/*
leetcode 280
http://buttercola.blogspot.com/2015/09/leetcode-wiggle-sort.html

Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].

 */
public class WiggleSort {

    /*
      So we could actually observe that there is pattern that
A[even] <= A[odd], A[odd] >= A[even].
     */
    public static void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (i % 2 == 0) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            } else {
                if (nums[i] < nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String args[]) {
        int[] nums = {3, 5, 2, 1, 6, 4};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{1, 5, 1, 1, 6, 4};
        wiggleSort2(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{1, 3, 2, 2, 3, 1};
        wiggleSort2(nums);
        System.out.println(Arrays.toString(nums));
    }

    /*
    Wiggle Sort II leetcode 324
https://leetcode.com/problems/wiggle-sort-ii/
    Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example 1:

Input: nums = [1, 5, 1, 1, 6, 4]
Output: One possible answer is [1, 4, 1, 5, 1, 6].
Example 2:

Input: nums = [1, 3, 2, 2, 3, 1]
Output: One possible answer is [2, 3, 1, 3, 1, 2].
Note:
You may assume all input has valid answer.

Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?
     */

    public static void wiggleSort2(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (i % 2 == 0) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            } else {
                if (nums[i] < nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            }
        }
    }
}
