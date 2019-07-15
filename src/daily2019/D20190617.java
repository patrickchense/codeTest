package daily2019;

import java.util.Arrays;

/*
Given an array of integers out of order, determine the bounds of the smallest window that must be sorted in order for the entire array to be sorted. For example, given [3, 7, 5, 6, 9], you should return (1, 3).

@easy
@WhatsApp

optimize?

self: need sort, and O(n) space,
@solved

can optimize?

 */
public class D20190617 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(needSortWindow(new int[]{3, 7, 5, 6, 9})));
    }

    // left:  < min_right
    // right: < max_left
    // O(nlogn) O(n) space
    public static int[] needSortWindow(int[] arr) {
        int left_i = -1;
        int right_i = -1;
        int[] tmp = new int[arr.length];
        System.arraycopy(arr, 0, tmp, 0, arr.length);
        Arrays.sort(arr);
        for (int i = 0; i < arr.length-1; i++) {
            if (left_i == -1 && arr[i] != tmp[i]) {
                left_i = i;
            } else if (arr[i] != tmp[i]){
                right_i = i;
            }
        }

        return new int[]{left_i, right_i};
    }

}
