package leetcode.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/find-k-closest-elements/
Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

Example 1:
Input: [1,2,3,4,5], k=4, x=3
Output: [1,2,3,4]
Example 2:
Input: [1,2,3,4,5], k=4, x=-1
Output: [1,2,3,4]
Note:
The value k is positive and will always be smaller than the length of the sorted array.
Length of the given array is positive and will not exceed 104
Absolute value of elements in the array and x will not exceed 104

@medium
@binarysearch

@answered

做不出的关键在不理解如果找不到x, 怎么办

Otherwise, we can use binary search to find the index of the element, which is equal (when this list has x) or a little bit larger than x (when this list does not have it). Then set low to its left k-1 position, and high to the right k-1 position of this index as a start. The desired k numbers must in this rang [index-k-1, index+k-1]. So we can shrink this range to get the result using the following rules.
If low reaches the lowest index 0 or the low element is closer to x than the high element, decrease the high index.
If high reaches to the highest index arr.size()-1 or it is nearer to x than the low element, increase the low index.
The looping ends when there are exactly k elements in [low, high], the subList of which is the result.

binarysearch 可以找到，或者大一点的值
            if (index < 0)
                index = -index - 1;


 */
public class LT658_Find_Kth_Closest {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        List<Integer> res = new ArrayList<>(k);
        if (x <= arr[0]) {
            for (int i = 0; i < k; i++) {
                res.add(arr[i]);
            }
            return res;
        } else if (arr[arr.length-1] <= x) {
            for (int i = n-k; i < n; i++) {
                res.add(arr[i]);
            }
            return res;
        } else {
            int index = Arrays.binarySearch(arr, x);
            if (index < 0)
                index = -index - 1;
            int low = Math.max(0, index - k - 1), high = Math.min(arr.length - 1, index + k - 1);

            while (high - low > k - 1) {
                if (low < 0 || (x - arr[low]) <= (arr[high] - x))
                    high--;
                else if (high > arr.length - 1 || (x - arr[low]) > (arr[high] - x))
                    low++;
                else
                    System.out.println("unhandled case: " + low + " " + high);
            }
            for (int i = low; i <= high; i++) {
                res.add(arr[i]);
            }
            return res;
        }
    }
}
