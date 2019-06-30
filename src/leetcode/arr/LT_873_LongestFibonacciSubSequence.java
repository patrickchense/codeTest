package leetcode.arr;

import java.util.*;
import java.util.stream.Collectors;

/*
https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/

A sequence X_1, X_2, ..., X_n is fibonacci-like if:

n >= 3
X_i + X_{i+1} = X_{i+2} for all i + 2 <= n
Given a strictly increasing array A of positive integers forming a sequence, find the length of the longest fibonacci-like subsequence of A.  If one does not exist, return 0.

(Recall that a subsequence is derived from another sequence A by deleting any number of elements (including none) from A, without changing the order of the remaining elements.  For example, [3, 5, 8] is a subsequence of [3, 4, 5, 6, 7, 8].)



Example 1:

Input: [1,2,3,4,5,6,7,8]
Output: 5
Explanation:
The longest subsequence that is fibonacci-like: [1,2,3,5,8].
Example 2:

Input: [1,3,7,11,12,14,18]
Output: 3
Explanation:
The longest subsequence that is fibonacci-like:
[1,11,12], [3,11,14] or [7,11,18].


@solved
@subarray
@fobinacci
@dp ?

my solution: brute force O(n^3), O(1) space

@optimize
how?


 */
public class LT_873_LongestFibonacciSubSequence {

    public int lenLongestFibSubseq(int[] A) {
        if (A == null || A.length < 3) return 0;
        int cur = 0;
        int max = 0;
        for (int i = 0; i < A.length-2; i++) {
            for (int j = i+1; j < A.length-1; j++) {
                int k = j + 1;
                int sum = A[i] + A[j];
                int pre = i;
                int pre_2 = j;
                while (k < A.length) {
                    if (A[k] == sum) {
                        //System.out.println("i=" + i + ",sum=" + sum+ ",k=" + k);
                        if (cur == 0) cur = 3;
                        else cur++;
                        max = Math.max(cur, max);
                        sum += sum - A[pre];
                        pre = pre_2;
                        pre_2 = k;
                    }
                    if (A[k] > sum) break;
                    k++;
                }
                cur = 0;
            }
        }
        return max;
    }

    // O(n^2 * logM ) O(n) M is the maximum value of A  could it be any better ?
    public int lenLongestFibSubseq2(int[] A) {
        if (A == null || A.length < 3) return 0;
        Set<Integer> nums = new HashSet(A.length);
        for (int i : A) {
            nums.add(i);
        }
        int max = 0;
        int len = A.length;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i+1; j < len - 1; j++) {
                int pre = A[i];
                int pre_i = A[j];
                int cur = 0;
                while (nums.contains(pre + pre_i)) {
                    if (cur == 0) cur = 3;
                    else cur++;
                    int t = pre+pre_i;
                    pre = pre_i;
                    pre_i = t;
                }
                max = Math.max(cur, max);
            }
        }
        return max;
    }

    // dp
    public int lenLongestFibSubseq3(int[] A) {
        int N = A.length;
        Map<Integer, Integer> index = new HashMap();
        for (int i = 0; i < N; ++i)
            index.put(A[i], i);

        Map<Integer, Integer> longest = new HashMap();
        int ans = 0;

        for (int k = 0; k < N; ++k)
            for (int j = 0; j < k; ++j) {
                int i = index.getOrDefault(A[k] - A[j], -1);
                if (i >= 0 && i < j) {
                    // Encoding tuple (i, j) as integer (i * N + j)
                    int cand = longest.getOrDefault(i * N + j, 2) + 1;
                    longest.put(j * N + k, cand);
                    ans = Math.max(ans, cand);
                }
            }

        return ans >= 3 ? ans : 0;
    }


}
