package GoldmanSachs;

import java.util.Arrays;

/**

 Given sequence on integers and asked to find the second lowest integer

 */
public class SecondLowest {

    public static void main(String[] args) {
        //for getSecondLowest
        int[] nums = new int[]{1,2,5,23,6,34,22,11,3,5,1,5};
        int secondLow = getSecondLowest(nums);
        System.out.println(secondLow);
        nums = new int[]{1,1,2,5,23,6,34,22,11,3,5,1,5};
        secondLow = getSecondLowest(nums);
        System.out.println(secondLow);
    }

    public static int getSecondLowest(int[] nums) {
        if (nums.length == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        // sort O(nlogN)
        // if no duplicate
/*        Arrays.sort(nums);
        return nums[1];*/
        // duplicate, O(n), O(1) space
/*        int i = 2;
        int[] lowNumber = new int[]{nums[0], nums[1]};
        if (nums[0] > nums[1]) {
            lowNumber[0] = nums[1];
            lowNumber[1] = nums[0];
        } else if (nums[0] == nums[1]){
            while (nums[i] == nums[1]) i++;
            lowNumber[0] = nums[0] > nums[i] ? nums[i] : nums[0];
            lowNumber[1] = nums[0] > nums[i] ? nums[0] : nums[i];
        }*/
        // no duplicates it ok
        /*for (int i = 2; i < nums.length; i++) {
            if (nums[i] >= lowNumber[1]) continue;
            if (nums[i] >= lowNumber[0]) lowNumber[1] = nums[i];
            else {
                lowNumber[1] = lowNumber[0];
                lowNumber[0] = nums[i];
            }
        }
        return lowNumber[1];*/

        // with duplicates
/*        for (;i < nums.length; i++) {
            if (nums[i] >= lowNumber[1]) continue;
            if (nums[i] > lowNumber[0]) lowNumber[1] = nums[i];
            else if (nums[i] < lowNumber[0]){
                lowNumber[1] = lowNumber[0];
                lowNumber[0] = nums[i];
            }
        }
        return lowNumber[1];*/

        // in-place replace
        for (int i = 2; i < nums.length; i++) {

        }
        return nums[1];
    }
}
