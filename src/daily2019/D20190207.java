package daily2019;

import util.ArrayUtil;

import java.util.Arrays;

/*
Write a function that rotates a list by k elements. For example, [1, 2, 3, 4, 5, 6] rotated by two becomes [3, 4, 5, 6, 1, 2].
Try solving this without creating a copy of the list. How many swap or move operations do you need?

@Facebook
@array
@rotate
@answered
@review
@kth

不创建额外的array的话，肯定要用length次吧?  len-k move up,  k swap to end, total len times
how? 写代码证明

https://www.programcreek.com/2015/03/rotate-array-in-java/

关键在于reverse 这些rotate array的题目很多都可以通过reverse来解决

 */
public class D20190207 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotateKth(new int[]{1, 2, 3, 4, 5, 6}, 2)));
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        rotate(arr, 2);
        System.out.println(Arrays.toString(arr));
    }

    // O(n) O(n)
    public static int[] rotateKth(int[] arr, int k) {
        int[] res = new int[arr.length];
        for (int i = k; i < arr.length; i++) {
            res[i-k] = arr[i];
        }
        for (int i=k; i > 0; i--) {
            res[arr.length - i] = arr[k - i];
        }
        return res;
    }

    public static void rotate(int[] arr, int order) {
        if (arr == null || arr.length==0 || order < 0) {
            throw new IllegalArgumentException("Illegal argument!");
        }

        if(order > arr.length){
            order = order %arr.length;
        }

        //length of first part
        int a = order;

        ArrayUtil.reverse(arr, 0, a-1);  // 2, 1
        ArrayUtil.reverse(arr, a, arr.length-1);  // 2, 1, 6,5,4,3
        ArrayUtil.reverse(arr, 0, arr.length-1); //  3,4,5,6,1,2

    }



}
