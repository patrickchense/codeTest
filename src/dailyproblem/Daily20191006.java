package dailyproblem;

import java.util.Arrays;

public class Daily20191006 {

    /*
    Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in
    the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?
     */

    public static void main(String []args) {
        int[] nums = {1,2,3,4,5};
        int[] result = multipleArrayHandle(nums);
        System.out.println(Arrays.toString(result));
        nums = new int[]{3,2,1};
        result = multipleArrayHandle(nums);
        System.out.println(Arrays.toString(result));
    }


    /*

     */
    private static int[] multipleArrayHandle(int[] nums) {
        int[] res = new int[nums.length];

        return res;
    }

    /*
    divide
     */
/*    private static int[] multipleArrayHandle(int[] nums) {
        int all = 1;
        for (int i: nums) all *= i;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = all / nums[i];
        }
        return res;
    }*/

    /*
      brute force
     */
/*    private static int[] multipleArrayHandle(int[] nums) {
        int res[] = new int[nums.length];
        for (int i = 0; i<nums.length; i++) {
            int tmp = 1;
            for (int j=0; j<nums.length; j++) {
                if (i != j) tmp *= nums[j];
            }
            res[i] = tmp;
        }
        return res;
    }*/





}
