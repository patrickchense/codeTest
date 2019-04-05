package dailyproblem;
/*
Given an array of integers, find the first missing positive integer in linear time and constant space.
In other words, find the lowest positive integer that does not exist in the array.
The array can contain duplicates and negative numbers as well.

For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

You can modify the input array in-place.

@Stripe
@array
@solved
@optimize 最优解O(n) O(1)
@classic

这题用了一个很经典的手段 a[a[i]] 的方式来modify inplace
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
        直接a[a[i]] 修改值， 如果a[i] >= a.length, 直接抛弃，如果a[i] < 0 抛弃
        [0] = 1, [1] = 0, [2] = 1, [3] = 1
        [0] = 1, [1] = 1, [2] = 0,
        如果没有，那么就是a.length

     */
    private static int findMissingPositive(int[] nums) {
        for (int i : nums) {
            if (i > nums.length || i <= 0) continue;
            nums[i-1] = 1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) continue;
            return i + 1;
        }
        return nums.length;
    }
}
