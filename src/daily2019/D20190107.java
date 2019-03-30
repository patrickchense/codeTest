package daily2019;

import util.ArrayUtil;

import java.util.Arrays;

/*
Given a number represented by a list of digits, find the next greater permutation of a number, in terms of lexicographic ordering.
 If there is not greater permutation possible, return the permutation with the lowest value/ordering.

For example, the list [1,2,3] should return [1,3,2]. The list [1,3,2] should return [2,1,3]. The list [3,2,1] should return [1,2,3].

Can you perform the operation without allocating extra memory (disregarding the input memory)?

@palantir
@solved

理解下一个permutation就行了，
 */
public class D20190107 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextPermutation(new Integer[]{1,2,3})));
        System.out.println(Arrays.toString(nextPermutation(new Integer[]{3,2,1})));
        System.out.println(Arrays.toString(nextPermutation(new Integer[]{4,2,3,1}))); //4,3,2,1
        System.out.println(Arrays.toString(nextPermutation(new Integer[]{3,2,4,1}))); //3,4,1,2
        System.out.println(Arrays.toString(nextPermutation(new Integer[]{3,2,1,4}))); //3,2,4,1
        System.out.println(Arrays.toString(nextPermutation(new Integer[]{5,4,3,2,1}))); //3,2,4,1
        System.out.println(Arrays.toString(nextPermutation(new Integer[]{6,5,4,3,2,1}))); //3,2,4,1
    }

    // 关键在找下一个，怎么定义下一个，我认为是大小， 123 next= 213,  213 next 231, 321 最大，next 123
    // find the last number, loop from n-1 to 0, find the one smaller than cur, switch, if not find,  swith with the biggest
    // 逻辑有漏洞，后面的几个testcase不能支持，
    public static Integer[] nextPermutation(Integer[] arr) {
        for (int j = arr.length -1; j >= 0; j--) {
            int t = arr[j];
            for (int i = j - 1; i >= 0; i--) {
                if (t > arr[i]) {
                    ArrayUtil.swap(arr, i, j);
                    return arr;
                }
            }
        }
        //证明没有逆序，直接返回倒序
        for (int i = 0; i< arr.length/2; i++) {
            ArrayUtil.swap(arr, i, arr.length-1-i);
        }
        return arr;
    }
}
