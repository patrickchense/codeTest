package dailyproblem;

import java.util.Arrays;

/*
Given a list of integers, return the largest product that can be made by multiplying any three integers.

For example, if the list is [-10, -10, 5, 2], we should return 500, since that's -10 * -10 * 5.

You can assume the list has at least three integers.

@facebook
@solved
 */
public class Daily20181212 {

    public static void main(String[] args){
        int[] arr = new int[]{-10, -10, 5, 2};
        System.out.println(largestMultipleOfThree(arr));
        arr = new int[]{-10, 10, 5, 2};
        System.out.println(largestMultipleOfThree(arr));
        arr = new int[]{1, 10, 5, 2};
        System.out.println(largestMultipleOfThree(arr));
    }

    /*
        two ways,
            1. two smallest negative, and largest positive
            2. three positive
     */
    public static long largestMultipleOfThree(int[] arr) {
        Arrays.sort(arr);
        long negative = 1;
        long positive = 1;
        for (int i = 0; i <= 1; i ++){
            if (arr[i] < 0) {
                negative *= arr[i];
            }
        }
        for (int i = arr.length - 1; i>= arr.length-3; i--) {
            positive *= arr[i];
        }
        return Math.max(negative*arr[arr.length - 1], positive);
    }
}
