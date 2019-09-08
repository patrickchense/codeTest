package daily2019;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Given an integer, find the next permutation of it in absolute order. For example, given 48975, the next permutation would be 49578.

@IBM
@easy

https://leetcode.com/submissions/detail/133435624/

@answered

@array
@sort
@review
@permutation


 */
public class D20190426 {

    public static void main(String[] args) {
        System.out.println(nextPermutationInt(48975));
    }

    public static int nextPermutationInt(int num) {
        List<Integer> vals = new ArrayList<>();
        while (num > 0) {
            vals.add(num % 10);
            num /= 10;
        }

        int[] nums = vals.stream().mapToInt(i -> i).toArray();
        nextPermutation(nums);
        int res = 0;
        for (int i = 0; i < vals.size(); i++) {
            res += vals.get(i) * Math.pow(10, i);
        }
        return res;
    }

    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 1;
        while (i >= 1 && nums[i] <= nums[i-1])
            i--;
        i--; // this is the pivot
        // now find the least digit greater than nums[i] to the right of nums[i]
        if (i >= 0) {
            int j;
            for (j = len-1; j > i; j--)
                if (nums[j] > nums[i])
                    break;
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start) {
        for (int i = start, j = nums.length - 1; i < j; i++, j--)
            swap(nums, i, j);
    }
}
