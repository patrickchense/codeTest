package leetcode.arr;

/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Given nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.

It doesn't matter what you leave beyond the returned length.
Example 2:

Given nums = [0,0,1,1,1,1,2,3,3],

Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.

It doesn't matter what values are set beyond the returned length.

@medium
@array

@answered

 */
public class LT80_Remove_Duplicates_Array {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int length = nums.length;
        int start = 0, times = 1;
        for (int i = 1; i < length; i++) {
            if (nums[i] != nums[start]) {
                start++;
                nums[start] = nums[i];
                times = 1;
            } else {
                times++;
                if (times == 2) {
                    start++;
                    nums[start] = nums[start - 1];
                }
            }
        }
        return start + 1;
    }
}
