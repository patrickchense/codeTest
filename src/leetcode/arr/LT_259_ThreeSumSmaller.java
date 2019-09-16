package leetcode.arr;

import java.util.Arrays;

/*
https://gist.github.com/sdpatil/68a5dbb7e47197ecd92d5d6c439515e6

Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n
 * that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 * <p>
 * For example, given nums = [-2, 0, 1, 3], and target = 2.
 * <p>
 * Return 2. Because there are two triplets which sums are less than 2:
 * <p>
 * [-2, 0, 1]
 * [-2, 0, 3]



 */
public class LT_259_ThreeSumSmaller {

	public static void main(String[] args) {
		System.out.println(threeSumSmaller(new int[]{-2, 0, 1, 3}, 2));
	}

	public static int threeSumSmaller(int[] nums, int target) {
		int res = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			int t = target - nums[i];
			int k = i+1, j = nums.length - 1;
			int count = 0;
			while (k < j) {
				if (nums[k] + nums[j] < t) {
					count += j - k;
					k++;
					continue;
				}
				else {
					j--;
				}
			}
			if (count == 0) break;
			else res += count;
		}
		return res;
	}
}
