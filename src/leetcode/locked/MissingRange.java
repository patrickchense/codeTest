package leetcode.locked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
leetcode 163 Missing Ranges

https://tonycao.gitbooks.io/leetcode-locked/content/LeetCode%20Locked/c1.8.html

Given a sorted integer array where the range of elements are [0, 99] inclusive, return its missing ranges. For example, given [0, 1, 3, 50, 75], return [“2”, “4->49”, “51->74”, “76->99”]

Example Questions Candidate Might Ask:

Q: What if the given array is empty?
A: Then you should return [“0->99”] as those ranges are missing.
Q: What if the given array contains all elements from the ranges?
A: Return an empty list, which means no range is missing.

@solved
使用状态占位法


 */
public class MissingRange {

    public static void main(String args[]) {
        int[] nums = {0, 1, 3, 50, 75};
        System.out.println(missingRanges(nums));
        System.out.println(findMissingRanges(nums, 0, 99));
    }

    // O(n) time,  O(n) space
    public static List<String> missingRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        boolean[] exists = new boolean[100];
        Arrays.fill(exists, Boolean.FALSE);
        for (int i = 0; i < nums.length; i++) {
            exists[nums[i]] = true;
        }
        int i = 0;
        while (i < 100) {
            if (!exists[i]) {
                if (i != 99 && !exists[i + 1]) {
                    int j = i;
                    int tmp = i;
                    while (j < 100 && !exists[j++]) i = j - 1;
                    res.add(tmp + "->" + i);
                } else {
                    res.add(i + "");
                }
            }
            i++;
        }
        return res;
    }

    /*
    extended
    扩展不是0-99,而是任意start, end
    不需要额外的O(n) space
    只需要判断 curr - prev >= 2,  == 2 理解为单独的， 否则需要 ->
     */
    public static List<String> findMissingRanges(int[] vals, int start, int end) {
        List<String> ranges = new ArrayList<>();
        int prev = start - 1;
        for (int i = 0; i <= vals.length; i++) {
            int curr = (i == vals.length) ? end + 1 : vals[i];
            if (curr - prev >= 2) {
                ranges.add(getRange(prev + 1, curr - 1));
            }
            prev = curr;
        }
        return ranges;
    }

    private static String getRange(int from, int to) {
        return (from == to) ? String.valueOf(from) : from + "->" + to;
    }
}
