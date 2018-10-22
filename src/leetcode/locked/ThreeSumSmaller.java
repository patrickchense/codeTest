package leetcode.locked;

import java.util.Arrays;

/*
leetcode 259
http://buttercola.blogspot.com/2015/08/leetcode.html

Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
For example, given nums = [-2, 0, 1, 3], and target = 2.
Return 2. Because there are two triplets which sums are less than 2:
[-2, 0, 1]
[-2, 0, 3]
Follow up:
Could you solve it in O(n2) runtime?

@sort
@two pointers

 */
public class ThreeSumSmaller {

    public static void main(String args[]) {
        int[] nums = {-2, 0, 1, 3};
        System.out.println(threeSumSmaller(nums, 2));
    }


    public static int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int n = nums.length - 1;
            while( j < n) {
                if (nums[i] + nums[j] + nums[n] < target) {
                    res += (n - j);
                    j++;
                }
                else {
                    n--;
                }
            }
        }
        return res;
    }
}
