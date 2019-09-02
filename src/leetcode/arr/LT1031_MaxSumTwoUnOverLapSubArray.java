package leetcode.arr;

/*
https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/

Given an array A of non-negative integers, return the maximum sum of elements in two non-overlapping (contiguous) subarrays, which have lengths L and M.  (For clarification, the L-length subarray could occur before or after the M-length subarray.)

Formally, return the largest V for which V = (A[i] + A[i+1] + ... + A[i+L-1]) + (A[j] + A[j+1] + ... + A[j+M-1]) and either:

0 <= i < i + L - 1 < j < j + M - 1 < A.length, or
0 <= j < j + M - 1 < i < i + L - 1 < A.length.


Example 1:

Input: A = [0,6,5,2,2,5,1,9,4], L = 1, M = 2
Output: 20
Explanation: One choice of subarrays is [9] with length 1, and [6,5] with length 2.
Example 2:

Input: A = [3,8,1,3,2,1,8,9,0], L = 3, M = 2
Output: 29
Explanation: One choice of subarrays is [3,8,1] with length 3, and [8,9] with length 2.
Example 3:

Input: A = [2,1,5,6,0,9,5,0,3,8], L = 4, M = 3
Output: 31
Explanation: One choice of subarrays is [5,6,0,9] with length 4, and [3,8] with length 3.

@subarray
@slidewindow
@review

经典slide window, 用每个arr来保存之前所有的sum，然后通过相减来确定中间i-j的和
因为不可重叠，所以类似移动的方式来判断
 */
public class LT1031_MaxSumTwoUnOverLapSubArray {

	// O(n) O(1) very smart solution
	// the point is understand the compare logic
	public int maxSumTwoNoOverlap(int[] A, int L, int M) {
		// Construct prefix sum
		for (int i = 1; i < A.length; i++) {
			A[i] = A[i - 1] + A[i];
		}

		// Assign initial values so we can skip 1st run in below for loop
		int res = A[L + M - 1], maxL = A[L - 1], maxM = A[M - 1];

		// Either L before M or M before L, start this loop at index L + M
		for (int i = L + M; i < A.length; i++) {
			// Keep track maxL so far
			// L before M: A[i - M] - A[i - M - L] is sum of L-length sub array
			maxL = Math.max(maxL, A[i - M] - A[i - M - L]);
			// Keep track maxM so far
			// M before L: A[i - M] - A[i - L - M] is sum of M-length sub array
			maxM = Math.max(maxM, A[i - L] - A[i - L - M]);
			// Keep track res so far
			// maxL + (A[i] - A[i - M]): Sum of max L-length sub array and current M-length sub array
			// maxM + (A[i] - A[i - L]): Sum of max M-length sub array and current L-length sub array
			res = Math.max(res, Math.max(maxL + (A[i] - A[i - M]), maxM + (A[i] - A[i - L])));
		}

		return res;
	}

}
