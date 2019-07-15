package leetcode.arr;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/binary-subarrays-with-sum/
In an array A of 0s and 1s, how many non-empty subarrays have sum S?

Example 1:

Input: A = [1,0,1,0,1], S = 2
Output: 4
Explanation:
The 4 subarrays are bolded below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]

自己的解法O(n^2) 不能解决问题(time limited)

其他有3个解法:

 */
public class LT_930_BinarySubArrWithSum {

    // O(n) O(1)
    // 3指针减，
    public int numSubarraysWithSum(int[] A, int S) {
        int iLo = 0, iHi = 0;
        int sumLo = 0, sumHi = 0;
        int ans = 0;

        for (int j = 0; j < A.length; ++j) {
            // While sumLo is too big, iLo++
            sumLo += A[j];
            while (iLo < j && sumLo > S)
                sumLo -= A[iLo++];

            // While sumHi is too big, or equal and we can move, iHi++
            sumHi += A[j];
            while (iHi < j && (sumHi > S || sumHi == S && A[iHi] == 0))
                sumHi -= A[iHi++];

            if (sumLo == S)
                ans += iHi - iLo + 1;
        }

        return ans;
    }

    // O(n) O(n), Prefix Sum
    public int numSubarraysWithSum2(int[] A, int S) {
        int N = A.length;
        int[] P = new int[N + 1];
        for (int i = 0; i < N; ++i)
            P[i+1] = P[i] + A[i];

        Map<Integer, Integer> count = new HashMap();
        int ans = 0;
        for (int x: P) {
            ans += count.getOrDefault(x, 0);
            count.put(x+S, count.getOrDefault(x+S, 0) + 1);
        }

        return ans;
    }

    // O(n) O(n)  index of ones,  事实上这个最快，最省内存
    public int numSubarraysWithSum3(int[] A, int S) {
        int su = 0;
        for (int x: A) su += x;

        // indexes[i] = location of i-th one (1 indexed)
        int[] indexes = new int[su + 2];
        int t = 0;
        indexes[t++] = -1;
        for (int i = 0; i < A.length; ++i)
            if (A[i] == 1)
                indexes[t++] = i;
        indexes[t] = A.length;

        int ans = 0;
        if (S == 0) {
            for (int i = 0; i < indexes.length - 1; ++i) {
                // w: number of zeros between consecutive ones
                int w = indexes[i+1] - indexes[i] - 1;
                ans += w * (w + 1) / 2;
            }
            return ans;
        }

        for (int i = 1; i < indexes.length - S; ++i) {
            int j = i + S - 1;
            int left = indexes[i] - indexes[i-1];
            int right = indexes[j+1] - indexes[j];
            ans += left * right;
        }

        return ans;
    }
}
