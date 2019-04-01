package dailyproblem;

import java.util.Arrays;

/*
Given a multiset of integers, return whether it can be partitioned into two subsets whose sums are the same.

For example, given the multiset {15, 5, 20, 10, 35, 15, 10}, it would return true, since we can split it up into {15, 5, 10, 15, 10} and {20, 35}, which both add up to 55.

Given the multiset {15, 5, 20, 10, 35}, it would return false, since we can't split it up into two subsets that add up to the same sum.

@facebook
@array
@sum
@subarray
@solved
 */
public class Daily20181203 {

    public static void main(String[] args) {
        int[] arr = new int[]{15, 5, 20, 10, 35, 15, 10};
        System.out.println(canSplitToTwo(arr));

        arr = new int[]{15, 5, 20, 10, 35, 15, 10, 10};
        System.out.println(canSplitToTwo(arr));
    }

    public static boolean canSplitToTwo(int[] arr) {
        Arrays.sort(arr);
        int left = 1;
        int right = arr.length -2;
        int leftSum = arr[0];
        int rightSum = arr[arr.length - 1];
        // need to <=, make sure every item in the arr is counted into left or right sum.
        while (left <= right){
           if (leftSum <= rightSum) {
               // ignore == , just continue, because only all the items been looped, then stop the loop.
               leftSum += arr[left++];
           } else if (leftSum > rightSum){
               rightSum += arr[right--];
           }
        }

        return leftSum == rightSum;
    }
}
