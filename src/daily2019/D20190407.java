package daily2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array of positive integers, divide the array into two subsets such that the difference between the sum of the subsets is as small as possible.

For example, given [5, 10, 15, 20, 25], return the sets {10, 25} and {5, 15, 20}, which has a difference of 5, which is the smallest possible difference.

@Microsoft
@hard

 */
public class D20190407 {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> divideSubsetSumDiffSmallest(int[] arr) {
        Arrays.sort(arr);
        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();
        int i = 0;
        int j = arr.length -1;
        int sum_i = 0;
        int sum_j = 0;
        while(i < j) {

        }

        return null;
    }
}
