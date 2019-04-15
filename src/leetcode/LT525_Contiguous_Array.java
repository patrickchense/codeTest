package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/contiguous-array/

Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Note: The length of the given binary array will not exceed 50,000.

@medium
@subarray
@answered

 */
public class LT525_Contiguous_Array {

    public static void main(String[] args) {
        System.out.println(maxLength(new int[]{0,1}));
        System.out.println(maxLength(new int[]{0,1,0}));
        System.out.println(maxLength(new int[]{0,1,1,0,1,1,1,0}));
    }

    // 不对有漏洞？？
    public static int maxLength(int[] arr) {
        int max = 0;
        // dp formula,  counts[i-1] // counts[i-1] + 1,  if (diff == 0)
        int count0 = 0;
        int count1 = 0;
        for (int i = 0, len=arr.length; i < len; i++) {
            if (arr[i] == 0) count0++;
            else count1++;
            if (Math.abs(count1 - count0) < 2)
            max = Math.min(count0, count1) * 2;
        }
        return max;
    }

    // 很快，但是O(2n) space
    public int findMaxLength(int[] nums) {
        int N=nums.length, locs[] = new int[N+N+1], max=0, count=0;

        for( int i=0; i<N; i++ ) {
            count+=(nums[i]+nums[i]-1);
            if( locs[count+N]==0 && count!=0 ) locs[count+N]=i+1;
            max=Math.max( max, i+1-locs[count+N] );
        }

        return max;
    }

    // 更能理解，速度ok， O(n), O(n) space
    // 能理解了， i - j 之间最长，是 i 和 j 是0的话，才有比较, 否则没有
    public int findMaxLength1(int[] nums) {
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);
        int sum = 0, max = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (sumToIndex.containsKey(sum)) {
                max = Math.max(max, i - sumToIndex.get(sum));
            }
            else {
                sumToIndex.put(sum, i);
            }
        }

        return max;
    }

}
