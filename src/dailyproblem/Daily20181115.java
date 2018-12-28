package dailyproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a list of integers S and a target number k, write a function that returns a subset of S that adds up to k. If such a subset cannot be made, then return null.

Integers can appear more than once in the list. You may assume all numbers in the list are positive.

For example, given S = [12, 1, 61, 5, 9, 2] and k = 24, return [12, 9, 2, 1] since it sums up to 24.

@google


 */
public class Daily20181115 {

    public static void main(String[] args) {

    }

    public static List<Integer> subsetSumTo(int[] arr, int target) {
        Arrays.sort(arr);
        if (arr[0] > 24) return null;
        return null;
    }
}
