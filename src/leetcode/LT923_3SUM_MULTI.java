package leetcode;

import java.util.*;

/*
https://leetcode.com/problems/3sum-with-multiplicity/
Given an integer array A, and an integer target, return the number of tuples i, j, k  such that i < j < k and A[i] + A[j] + A[k] == target.

As the answer can be very large, return it modulo 10^9 + 7.
Example 1:
Input: A = [1,1,2,2,3,3,4,4,5,5], target = 8
Output: 20
Explanation:
Enumerating by the values (A[i], A[j], A[k]):
(1, 2, 5) occurs 8 times;
(1, 3, 4) occurs 8 times;
(2, 2, 4) occurs 2 times;
(2, 3, 3) occurs 2 times.

Example 2:
Input: A = [1,1,2,2,2,2], target = 5
Output: 12
Explanation:
A[i] = 1, A[j] = A[k] = 2 occurs 12 times:
We choose one 1 from [1,1] in 2 ways,
and two 2s from [2,2,2,2] in 6 ways.

Note:
3 <= A.length <= 3000
0 <= A[i] <= 100
0 <= target <= 300


@array
@sum
@subarray

@answered

 */
public class LT923_3SUM_MULTI {

    public static void main(String[] args) {
        System.out.println(threeSumMulti1(new int[]{1,1,2,2,3,3,4,4,5,5}, 8));
    }

    public static int countSumTarget(int[] A, int target) {
        Map<Integer, Integer> counts = new HashMap<>();
        Map<Integer, List<List<Integer>>> countsIndex = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j =0; j < A.length; j++) {
                if (i == j) continue;
                counts.put(A[i] + A[j], counts.getOrDefault(A[i] + A[j], 0) + 1);
                List<List<Integer>> indexes = countsIndex.getOrDefault(A[i] + A[j], new ArrayList<>());
                indexes.add(Arrays.asList(i, j));
                countsIndex.put(A[i] + A[j], indexes);
            }
        }
        int res = 0;
        Set<Integer> did = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            if (!did.contains(A[i]) && counts.containsKey(target - A[i])) {
                res += counts.get(target - A[i]);
                for (List<Integer> indexes : countsIndex.get(target - A[i])) {
                    if (indexes.contains(i)) res--;
                }
                did.add(A[i]);
            }
        }
        return res;
    }

    // 这个很慢，
    public int threeSumMulti(int[] A, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        int res = 0;
        int mod = 1000000007;
        for (int i = 0; i < A.length; i++) {
            res = (res + map.getOrDefault(target - A[i], 0)) % mod;

            for (int j = 0; j < i; j++) {
                int temp = A[i] + A[j];
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }
        return res;
    }

    /*
    Count the occurrence of each number.
using hashmap or array up to you.

Loop i on all numbers,
loop j on all numbers,
check if k = target - i - j is valid.

Add the number of this combination to result.
3 cases covers all possible combination:

i == j == k
i == j != k
i < k && j < k
Time Complexity:
3 <= A.length <= 3000, so N = 3000
But 0 <= A[i] <= 100
So my solution is O(N + 101 * 101)

     */
    // 超快！！！！！
    // 超快！！！！！
    public static int threeSumMulti1(int[] A, int target) {
        long[] c = new long[101];
        for (int a : A) c[a]++;
        long res = 0;
        for (int i = 0; i <= 100; i++)
            for (int j = i; j <= 100; j++) {
                int k = target - i - j;
                if (k > 100 || k < 0) continue;
                if (i == j && j == k)
                    res += c[i] * (c[i] - 1) * (c[i] - 2) / 6;
                else if (i == j && j != k)
                    res += c[i] * (c[i] - 1) / 2 * c[k];
                else if (j < k)
                    res += c[i] * c[j] * c[k];
            }
        return (int)(res % (1e9 + 7));
    }
}
