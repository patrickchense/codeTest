package dailyproblem;

import java.util.Arrays;

public class Daily20181006 {

    /*
    Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in
    the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?

https://www.interviewcake.com/question/java/product-of-other-numbers
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
        greedy
        simply   results[i] = multiple(1...i-1) * multiple(i+1 ... n-1)
        2 loop
        one calculate all multiple(1...i-1), store in result[i]
        one calculate all multiple(i+1 ... n-1)  multiply with the value in result[i] and put it back
     */
    private static int[] multipleArrayHandle(int[] intArray) {
        if (intArray.length < 2) {
            throw new IllegalArgumentException("Getting the product of numbers at other indices requires at least 2 numbers");
        }

        // we make an array with the length of the input array to
        // hold our products
        int[] productsOfAllIntsExceptAtIndex = new int[intArray.length];

        // for each integer, we find the product of all the integers
        // before it, storing the total product so far each time
        int productSoFar = 1;
        for (int i = 0; i < intArray.length; i++) {
            productsOfAllIntsExceptAtIndex[i] = productSoFar;
            productSoFar *= intArray[i];
        }

        // for each integer, we find the product of all the integers
        // after it. since each index in products already has the
        // product of all the integers before it, now we're storing
        // the total product of all other integers
        productSoFar = 1;
        for (int i = intArray.length - 1; i >= 0; i--) {
            productsOfAllIntsExceptAtIndex[i] *= productSoFar;
            productSoFar *= intArray[i];
        }

        return productsOfAllIntsExceptAtIndex;
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
