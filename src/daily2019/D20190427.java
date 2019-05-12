package daily2019;

import java.util.Arrays;

/*
A permutation can be specified by an array P, where P[i] represents the location of the element at i in the permutation.
For example, [2, 1, 0] represents the permutation where elements at the index 0 and 2 are swapped.

Given an array and a permutation, apply the permutation to the array. For example, given the array ["a", "b", "c"] and the permutation [2, 1, 0], return ["c", "b", "a"].

@twitter
@easy

@solved

 */
public class D20190427 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(swap(new String[]{"a","b","c"}, new int[]{2,1,0})));
    }

    // O(n) O(n) 很快解决
    public static String[] swap(String[] arr, int[] pos) {
        String[] res = new String[arr.length];
        int j = 0;
        for (int i: pos) {
            res[j++] = arr[i];
        }
        return res;
    }

    // can it be in-place? O(1)？ if 2, 0, 1, c, a, b
    // a, b, c ->  c, b, a,  ->  TODO
    public static String[] swapInPlace(String[] arr, int[] pos) {

        return arr;
    }
}
