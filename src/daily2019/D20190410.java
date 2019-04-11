package daily2019;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Given an array of elements, return the length of the longest subarray where all its elements are distinct.

For example, given the array [5, 1, 3, 5, 2, 3, 4, 1], return 5 as the longest subarray of distinct elements is [5, 2, 3, 4, 1].
@Google
@easy
@array
@subarray
@slidewindow
@solved
@12min

@optimized
@review

https://www.geeksforgeeks.org/length-of-the-longest-subarray-with-only-even-elements/
https://www.geeksforgeeks.org/longest-subarray-not-k-distinct-elements/
https://www.geeksforgeeks.org/longest-subarray-such-that-the-difference-of-max-and-min-is-at-most-one/
https://www.geeksforgeeks.org/longest-subarray-sum-elements-atmost-k/
https://www.geeksforgeeks.org/longest-subarray-such-that-adjacent-elements-have-at-least-one-common-digit/
 */
public class D20190410 {

    public static void main(String[] args) {
        System.out.println(sizeOfLongestDistinctSubArray(new int[]{5, 1, 3, 5, 2, 3, 4, 1}));
        System.out.println(sizeOfLongestDistinctSubArrayO1(new int[]{5, 1, 3, 5, 2, 3, 4, 1}));
    }

    // 最简单，循环, O(n^2) space O(n^2) time
    public static int sizeOfLongestDistinctSubArray(int[] arr) {
        int max = 0;
        for (int i = 0, len = arr.length; i < len; i++) {
            Set<Integer> pres = new HashSet<>();
            pres.add(arr[i]);
            for (int j = 1; j <len; j++) {
                if (pres.contains(arr[j])) max = Math.max(max, pres.size());
                else {
                    pres.add(arr[j]);
                }
            }
        }
        return max;
    }

    // 优化，不用set，不反复创建, O(n) O(n)
    public static int sizeOfLongestDistinctSubArrayO1(int[] arr) {
        int max = 0;
        Map<Integer, Integer> counts = new HashMap<>();
        int cur = 0;
        int prev = 0;
        for (int i = 0, len = arr.length; i < len; i++) {
            if (counts.containsKey(arr[i])) {
                int j = counts.get(arr[i]);
                max = Math.max(max, cur);
                prev = Math.max(j, prev);
//                cur = i -j; // 这里有错，
                cur = i - prev;
                counts.put(arr[i], i);
            } else {
                cur++;
                counts.put(arr[i], i);
            }
        }
        return Math.max(max, cur);
    }


    // 能O(n) O(1) 吗? 没想到，没找到

}
