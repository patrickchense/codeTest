package leetcode.arr;

import java.util.Arrays;

/*
https://leetcode.com/problems/valid-triangle-number/

Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.
Example 1:
Input: [2,2,3,4]
Output: 3
Explanation:
Valid combinations are:
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3
Note:
The length of the given array won't exceed 1000.
The integers in the given array are in the range of [0, 1000].

@math
@optimze

 */
public class LT611_ValidTriangleNum {

	// O(n^3)
	public int triangleNumber(int[] nums) {
		int count = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			int k = i + 2;
			for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
				while (k < nums.length && nums[i] + nums[j] > nums[k])
					k++;
				count += k - j - 1;
			}
		}
		return count;
	}

	// O(n^2)
	public int triangleNumber1(int[] nums) {
		if (nums == null || nums.length < 3) return 0;
		Arrays.sort(nums);
		int result = 0;
		for (int i = nums.length - 1; i >= 2; i--) {
			result += twoSumBigger(nums, nums[i], i - 1);
		}
		return result;
	}

	public int twoSumBigger(int[] nums, int target, int index) {
		int start = 0;
		int end   = index;
		int result = 0;
		while (start < end) {
			if (nums[start] + nums[end] <= target) {
				start++;
			} else {
				result += end - start;
				end--;
			}
		}
		return result;
	}

}
