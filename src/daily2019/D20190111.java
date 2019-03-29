package daily2019;

import java.util.Arrays;

/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example, given [100, 4, 200, 1, 3, 2], the longest consecutive element sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.

@microsoft
@solved
@dp
@array
@sort

 */
public class D20190111 {
    public static void main(String[] args) {
        System.out.println(longestConsecutiveNumberLen(new int[]{100, 4, 200, 1, 3, 2}));
    }

    /*
    un sorted ?
    consecutive?
    第一种能想到的， sorted, 然后dp
     */
    public static int longestConsecutiveNumberLen(int[] arr) {
        Arrays.sort(arr);
        int[] lens = new int[arr.length];
        lens[0] = 1;
        int max = 1;
        for (int i = 1; i < arr.length; i++) {
            // dp formula L[i] = L[i-1] if arr[i] != a[i-1] + 1, else L[i] = L[i-1] + 1;
            if (arr[i] == arr[i-1] + 1) {
                lens[i] = lens[i-1] + 1;
                max = Math.max(lens[i], max);
            }
            else lens[i] = lens[i-1];
        }
        return max;
    }
}
