package dailyproblem;

import util.ArrayUtil;

import java.util.Arrays;

/*
Given an array of strictly the characters 'R', 'G', and 'B', segregate the values of the array so that all the Rs come first, the Gs come second, and the Bs come last.
You can only swap elements of the array.

Do this in linear time and in-place.

For example, given the array ['G', 'B', 'R', 'R', 'B', 'R', 'G'], it should become ['R', 'R', 'R', 'G', 'G', 'B', 'B'].

@google
https://www.careercup.com/question?id=13580661

@solved
 */
public class Daily20181108 {

    public static Character[] swapRGB(Character[] arr) {
        int i1 = 0;
        int i2 = 0;
        int len = arr.length - 1;
        while (i1 <= len) {
            if (arr[i1] == 'R') {
                ArrayUtil.swap(arr, i1, i2);
                i2++;
                i1++;
            }
            else if (arr[i1] == 'B') {
                ArrayUtil.swap(arr, i1, len);
                len--;
            }
            else {
                i1++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(swapRGB(new Character[]{'G', 'B', 'R', 'R', 'B', 'R', 'G'})));
    }
}
