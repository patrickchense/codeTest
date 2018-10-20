package leetcode.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
leetcode 442
https://leetcode.com/problems/find-all-duplicates-in-an-array/description/

Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]

solution:
@swap

O(n), O(1)
 */
public class FindDuplicateInArray {

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0)
                res.add(Math.abs(index + 1)); // doesn't support over third times show
            nums[index] = -nums[index];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,5,6,6,6,2,6};
        System.out.println(Arrays.toString(findDuplicates(nums).toArray()));
    }
}
