package leetcode.stack;

import java.util.Stack;

/*
https://leetcode.com/problems/sum-of-subarray-minimums/

Given an array of integers A, find the sum of min(B), where B ranges over every (contiguous) subarray of A.

Since the answer may be large, return the answer modulo 10^9 + 7.



Example 1:

Input: [3,1,2,4]
Output: 17
Explanation: Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.  Sum is 17.


Note:

1 <= A.length <= 30000
1 <= A[i] <= 30000


@answered
@medium

@stack
@array
@subarray

logic:

 */
public class LT907_SumOfSubarrayMin {

    public int sumSubarrayMins(int[] A) {
        int MOD = 1_000_000_007;
        int N = A.length;

        // prev has i* - 1 in increasing order of A[i* - 1]
        // where i* is the answer to query j
        Stack<Integer> stack = new Stack();
        int[] prev = new int[N];
        for (int i = 0; i < N; ++i) {
            while (!stack.isEmpty() && A[i] <= A[stack.peek()])
                stack.pop();
            prev[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // next has k* + 1 in increasing order of A[k* + 1]
        // where k* is the answer to query j
        stack = new Stack();
        int[] next = new int[N];
        for (int k = N-1; k >= 0; --k) {
            while (!stack.isEmpty() && A[k] < A[stack.peek()])
                stack.pop();
            next[k] = stack.isEmpty() ? N : stack.peek();
            stack.push(k);
        }

        long ans = 0;
        for (int i = 0; i < N; ++i) {
            ans += (i - prev[i]) * (next[i] - i) % MOD * A[i] % MOD;
            ans %= MOD;
        }
        return (int) ans;
    }

    public int sumSubarrayMins2(int[] A) {
        int[] leftBigger = new int[A.length];
        int[] rightBigger = new int[A.length];
        long sum = 0;
        for (int i = 0; i < A.length; i++) {
            int countLeft = 1;
            int j = i - 1;
            while (j >= 0 && A[j] >= A[i]) {
                countLeft += leftBigger[j];
                j -= leftBigger[j];
            }
            leftBigger[i] = countLeft;
        }
        for (int i = A.length - 1; i >= 0; i--) {
            int countRight = 1;
            int k = i + 1;
            while (k < A.length && A[k] > A[i]) {
                countRight += rightBigger[k];
                k += rightBigger[k];
            }
            rightBigger[i] = countRight;
        }
        for (int i = 0; i < A.length; i++) {
            sum += (A[i] * leftBigger[i] * rightBigger[i]);
        }
        return (int) (sum % 1000000007);
    }
}
