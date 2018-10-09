package dailyproblem;
/*
Given an array of integers, find the first missing positive integer in linear time and constant space.
In other words, find the lowest positive integer that does not exist in the array.
The array can contain duplicates and negative numbers as well.

For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

You can modify the input array in-place.

 */
public class Daily20181008 {


    public static void main(String[] args) {
        int[] nums = new int[]{3,4,-1,1};
        int missing = findMissingPositive(nums);
        System.out.println(missing);
        nums = new int[]{1, 2, 0};
        missing = findMissingPositive(nums);
        System.out.println(missing);
    }

    /*
        if minPositive - nums[i] > 1,  missingPositive = nums[i] + 1;


     */
    private static int findMissingPositive(int[] nums) {
        return -1;
    }
}
