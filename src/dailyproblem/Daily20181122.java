package dailyproblem;

/*
Given an array of numbers, find the maximum sum of any contiguous subarray of the array.

For example, given the array [34, -50, 42, 14, -5, 86], the maximum sum would be 137, since we would take elements 42, 14, -5, and 86.

Given the array [-5, -1, -8, -9], the maximum sum would be 0, since we would not take any elements.

Do this in O(N) time.
@amazon

 */
public class Daily20181122 {

    /*
    dp
       Max(0) = arr[0], 0
       Max(1) = Max(Max(0) + arr[1], arr[1], 0)

     */
    public static int contiguousSubArraySumMax(int[] array) {
        int max = 0;
        int[] maxes = new int[array.length];
        maxes[0] = Math.max(max, array[0]);
        for (int i = 1; i < array.length; i++) {
            if (maxes[i-1] + array[i] < 0) {
                maxes[i] = 0;
            } else {
                maxes[i] = maxes[i-1] + array[i];
            }
        }

        for (int i : maxes) {
            max = Math.max(i, max);
        }
        return max;
    }

    public static void main(String[] args){
        int[] tmp = new int[]{-5, -1, -8, -9};
        System.out.println(contiguousSubArraySumMax(tmp));
        int[] tmp1 = new int[]{34, -50, 42, 14, -5, 86};
        System.out.println(contiguousSubArraySumMax(tmp1));
        int[] tmp2 = new int[]{34, -50, 42, 14, -5, 86, -100, 98, -10, 60};
        System.out.println(contiguousSubArraySumMax(tmp2));
    }
}
