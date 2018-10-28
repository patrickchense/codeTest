package leetcode.locked;

import java.util.HashSet;
import java.util.Set;

/*
leetcode 548
Given an array with n integers, you need to find if there are triplets (i, j, k) which satisfies following conditions:

0 < i, i + 1 < j, j + 1 < k < n - 1
Sum of subarrays (0, i - 1), (i + 1, j - 1), (j + 1, k - 1) and (k + 1, n - 1) should be equal.
where we define that subarray (L, R) represents a slice of the original array starting from the element indexed L to the element indexed R.

Example:

Input: [1,2,1,2,1,2,1]
Output: True
Explanation:
i = 1, j = 3, k = 5.
sum(0, i - 1) = sum(0, 0) = 1
sum(i + 1, j - 1) = sum(2, 2) = 1
sum(j + 1, k - 1) = sum(4, 4) = 1
sum(k + 1, n - 1) = sum(6, 6) = 1
Note:
1 <= n <= 2000.
Elements in the given array will be in range [-1,000,000, 1,000,000].


思路：

首先想到的是暴力法，那就是三重循环，时间复杂度是O(n^3)，空间复杂度是O(n)。不出意料，过不了大数据。

有一种采用空间换时间的做法：我们从中间进行分割，然后在前半部分进行搜索，看看是不是可以找到和相同的划分，如果找到了，就将和加入哈希表中；然后再在后半部分进行搜索，如果找到了和相同的划分并且该和也存在于哈希表中，这说明我们找到了合适的i，j，k，可以将数组划分为和相同的四个部分，返回true。这样时间复杂度就降低成了O(n^2)。

代码：

1、暴力法：

class Solution {
public:
    bool splitArray(vector<int>& nums) {
        int n = nums.size();
        if (n < 7) {
            return false;
        }
        vector<int> sums(n, 0);
        sums[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            sums[i] = sums[i - 1] + nums[i];
        }
        for (int i = 1; i < n - 1; ++i) {
            for (int j = i + 2; j < n - 1; ++j) {
                for (int k = j + 2; k < n - 1; ++k) {
                    int part1 = sums[i - 1];                        // [0, i - 1]
                    int part2 = sums[j - 1] - sums[i];              // [i + 1, j - 1]
                    int part3 = sums[k - 1] - sums[j];              // [j + 1, k - 1]
                    int part4 = sums[nums.size() - 1] - sums[k];    // [k + 1, n - 1]
                    if (part1 == part2 && part2 == part3 && part3 == part4) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
};
2、哈希表法：

class Solution {
public:
    bool splitArray(vector<int>& nums) {
        int n = nums.size();
        if (n < 7) {
            return false;
        }
        vector<int> sums(n, 0);
        sums[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            sums[i] = sums[i - 1] + nums[i];
        }
        for (int j = 3; j < n - 3; ++j) {         // j is the middle cut
            unordered_set<int> hash;
            for (int i = 1; i < j - 1; ++i) {
                if (sums[i - 1] == sums[j - 1] - sums[i]) {     // compare [0, i - 1] and [i + 1, j - 1]
                    hash.insert(sums[i - 1]);
                }
            }
            for (int k = j + 2; k < n - 1; ++k) {
                if (sums[n - 1] - sums[k] == sums[k - 1] - sums[j] && hash.count(sums[k - 1] - sums[j])) {
                    return true;
                }
            }
        }
        return false;
    }
};


 */
public class SplitArrayWithEqualSum {

    /*

     */
    public static boolean findSplitArraySum(int[] nums) {
        if (nums == null || nums.length < 7) {
            return false;
        }
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] += sum[i - 1] + nums[i];
        }

        for (int j = 3; j < nums.length - 3; j++) {
            Set<Integer> set = new HashSet<>();
            for (int i = 1; i < j - 1; i++) {
                if (sum[i - 1] == sum[j - 1] - sum[i]) {
                    set.add(sum[i - 1]);
                }
            }
            for (int k = j + 1; k < nums.length - 1; k++) {
                if (sum[k - 1] - sum[j] == sum[nums.length - 1] - sum[k] && set.contains(sum[k - 1] - sum[j])) {
                    return true;
                }
            }
        }
        return false;
    }
}
