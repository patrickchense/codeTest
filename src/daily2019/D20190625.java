package daily2019;

import java.util.Arrays;

/*
MegaCorp wants to give bonuses to its employees based on how many lines of codes they have written.
They would like to give the smallest positive amount to each worker consistent with the constraint that if a developer has written more lines of code than their neighbor, they should receive more money.

Given an array representing a line of seats of employees at MegaCorp, determine how much each one should get paid.

For example, given [10, 40, 200, 1000, 60, 30], you should return [1, 2, 3, 4, 2, 1].

@easy
@Atlassian
@solved

 */
public class D20190625 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(bonus(new int[]{10, 40, 200, 1000, 60, 30})));
        System.out.println(Arrays.toString(bonus(new int[]{10, 40, 200, 1000, 30, 50})));
    }

    // O(n) O(n)
    public static int[] bonus(int[] arr) {
        int[] res = new int[arr.length];
        res[0] = arr[0] > arr[1] ? 2 : 1;
        res[arr.length-1] = arr[arr.length - 1] > arr[arr.length - 2] ? 2 : 1;
        for (int i = 1; i < arr.length-1; i++) {
            if (arr[i] > arr[i-1]) {
                res[i] = res[i-1] + 1;
            } else if (arr[i] > arr[i+1]) {
                if (res[i+1] == 0) res[i] = 2;
                else res[i] = res[i+1] + 1;
            } else {
                res[i] = 1;
            }
        }
        return res;
    }
}
