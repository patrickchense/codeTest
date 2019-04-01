package dailyproblem;

/*
Given a list of integers, write a function that returns the largest sum of non-adjacent numbers.
 Numbers can be 0 or negative.

For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.

Follow-up: Can you do this in O(N) time and constant space?


@solved
@optimize
@array

 */
public class Daily20181013 {

    public static void main(String[] args) {
        int[] nums = new int[]{2,4,6,2,5};
        System.out.println(nonAdjacentSumLargest(nums));
        nums = new int[]{5, 1, 1, 5};
        System.out.println(nonAdjacentSumLargest(nums));

        nums = new int[]{2,4,6,2,5};
        System.out.println(nonAdjacentSumLargest2(nums));
        nums = new int[]{5, 1, 1, 5};
        System.out.println(nonAdjacentSumLargest2(nums));
    }

    /*
        d[i] = max{d[i-1], d[i-2] + nums[i], d[i-3] + nums[i]}
        O(n) time, O(n) space
     */
    public static int nonAdjacentSumLargest(int[] nums) {
        int[] sums = new int[nums.length + 3];
        sums[0] = 0;
        sums[1] = 0;
        sums[2] = 0;
        for (int i = 0; i < nums.length; i++) {
            sums[i+3] = Math.max(Math.max(sums[i+2], sums[i+1] + nums[i]), sums[i] + nums[i]);
        }
        return sums[sums.length - 1];
    }

    /*
        could be O(1) space, since only use sums[i-3], sum[i-2], sum[i-1], sum[i]
     */
    public static int nonAdjacentSumLargest2(int[] nums) {
        int[] sums = new int[4];
        sums[0] = 0;
        sums[1] = 0;
        sums[2] = 0;
        for (int i = 0; i < nums.length; i++) {
            sums[3] = Math.max(Math.max(sums[2], sums[1] + nums[i]), sums[0] + nums[i]);
            sums[0] = sums[1];
            sums[1] = sums[2];
            sums[2] = sums[3];
        }
        return sums[3];
    }
}
