package daily2019;

import java.util.Arrays;

/*
Given a sorted list of integers, square the elements and give the output in sorted order.

For example, given [-9, -2, 0, 2, 3], return [0, 4, 4, 9, 81].

@Google
@array
@sort
@solved
@square
@review
找到0， 如果0在0位，那么直接pow就行
否则就需要把前面的负数，插入到对应的位置, 类似quicksort, 用了O(n) space, O(n) time

能O(1) space吗？怎么原地换位？
https://www.geeksforgeeks.org/sort-array-converting-elements-squares/  也只有O(nlogn) 排序和 O(n) space两种方式

related 都是sort array 有关的题
https://www.geeksforgeeks.org/sort-elements-of-the-array-that-occurs-in-between-multiples-of-k/
https://www.geeksforgeeks.org/sort-elements-of-array-whose-modulo-with-k-yields-p/
https://www.geeksforgeeks.org/sort-an-almost-sorted-array-where-only-two-elements-are-swapped/
https://www.geeksforgeeks.org/sort-array-containing-two-types-elements/
https://www.geeksforgeeks.org/sort-linked-list-order-elements-appearing-array/
https://www.geeksforgeeks.org/insertion-sorteven-odd-positioned-elements/
https://www.geeksforgeeks.org/sort-elements-by-frequency/ 这个有一组5+题


 */
public class D20190130 {

    public static void main(String[] args) {
        int[] arr = new int[]{-9, -2, 0, 2, 3};
        System.out.println(Arrays.toString(powArray(arr)));
    }

    // O(n) time O(n) space
    public static int[] powArray(int[] arr) {
        if (arr[0] >= 0) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (int) Math.pow(arr[i], 2);
            }
            return arr;
        }
        int zero_i = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                zero_i = i;
                break;
            }
        }
        int[] res = new int[arr.length];
        int i = zero_i -1;
        int j = zero_i;
        int k = 0;
        while (i >= 0 || j <= arr.length -1) {
            if (i < 0 && j <= arr.length -1) {
                res[k++] = (int) Math.pow(arr[j++], 2);
                continue;
            }
            if (j >= arr.length && i >= 0) {
                res[k++] = (int) Math.pow(arr[i--], 2);
                continue;
            }
            if (-1 * arr[i] < arr[j]) res[k++] = (int) Math.pow(arr[i--], 2);
            else res[k++] =  (int) Math.pow(arr[j++], 2);
        }
        return res;
    }
}
