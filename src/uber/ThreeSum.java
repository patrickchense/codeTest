package uber;

import java.util.Arrays;

/*
Given an array of n integers nums and an int target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] > target.

Example:

Input: nums = [2, 1, 3, 0, 3], target = 5
Output: 5
Explanation:
[0, 3, 3]
[1, 3, 3]
[1, 2, 3]
[1, 2, 3]
[2, 3, 3]
Related problems:

https://leetcode.com/problems/3sum-smaller (premium)

@phone
@solved
 */
public class ThreeSum {

	public static void main(String[] args) {
		System.out.println(threeSum(new int[]{2, 1, 3, 0, 3}, 5));
	}

	// O(n ^ 2)
	public static int threeSum(int[] nums, int target) {
		Arrays.sort(nums);
		int res = 0;
		for (int p = nums.length - 1; p >= 2; p--) {
			int t = target - nums[p];
			int count = 0;
			int i = 0, j = p -1;
			while(i < j) {
				if (nums[i] + nums[j] > t) {
					// count = sum( (j - i) + ... + 1)
					count += j - i;
					j--;
				}
				else {
					i++;
				}
			}
			if (count == 0) break;
			else res += count;
		}
		return res;
	}
}
