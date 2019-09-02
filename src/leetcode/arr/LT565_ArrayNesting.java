package leetcode.arr;

/*
https://leetcode.com/problems/array-nesting/

A zero-indexed array A of length N contains all integers from 0 to N-1. Find and return the longest length of set S, where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... } subjected to the rule below.

Suppose the first element in S starts with the selection of element A[i] of index = i, the next element in S should be A[A[i]], and then A[A[A[i]]]… By that analogy, we stop adding right before a duplicate element occurs in S.



Example 1:

Input: A = [5,4,0,3,1,6,2]
Output: 4
Explanation:
A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.

One of the longest S[K]:
S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}


Note:

N is an integer within the range [1, 20,000].
The elements of A are all distinct.
Each element of A is an integer within the range [0, N-1].

@array
@optimize


占位
 */
public class LT565_ArrayNesting {

	// normal, using extra space to log visited, O(n), O(n)
	public int arrayNesting(int[] nums) {
		boolean[] visited = new boolean[nums.length];
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			if (!visited[i]) {
				int start = nums[i], count = 0;
				do {
					start = nums[start];
					count++;
					visited[start] = true;
				}
				while (start != nums[i]);
				res = Math.max(res, count);
			}
		}
		return res;
	}

	//占位法, 原地修改， O(n), O(1)
	public int arrayNesting1(int[] nums) {
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != Integer.MAX_VALUE) {
				int start = nums[i], count = 0;
				while (nums[start] != Integer.MAX_VALUE) {
					int temp = start;
					start = nums[start];
					count++;
					nums[temp] = Integer.MAX_VALUE;
				}
				res = Math.max(res, count);
			}
		}
		return res;
	}
}
