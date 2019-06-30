package leetcode.math;

import java.util.Random;

/*
https://leetcode.com/problems/random-pick-index/

Given an array of integers with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.

Note:
The array size can be very large. Solution that uses too much extra space will not pass the judge.

Example:

int[] nums = new int[] {1,2,3,3,3};
Solution solution = new Solution(nums);

// pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
solution.pick(3);

// pick(1) should return 0. Since in the array only nums[0] is equal to 1.
solution.pick(1);

@solved
@random
@review
@optimize

自己的想法，得到每个数字的重复数，然后nextInt(count), 得到坐标

优化的方法，随机算法不一样

 */
public class LT_398_RandomPickIndex {

    // 优化
    private int[] nums;

    public LT_398_RandomPickIndex(int[] nums) {
        this.nums=nums;
    }

    /**
     * 1.About Complexity
     *     1.1 Time Complexity is O(n)
     *     1.2 Space Complexity is O(1)
     * 2.how I solve
     *     2.1 The solution is base on tank arithmetic
     *     2.2 use a 1 to nums.length to get target's index
     *         2.2.1 the random variable is to generate a num to locate index when the target's index is more than one
     * 3.About submit record
     *     3.1 224ms and 69MB memory in LeetCode China
     *     3.2 93ms and 50.5MB memory in LeetCode
     * 4.Q&A
     * @param target
     * @return
     */
    public int pick(int target) {
        Random r=new Random();
        int res=0;
        int flag=0;
        for(int i=0,size=nums.length;i<size;i++){
            if(nums[i]==target){
                flag++;
                if(r.nextInt(flag)==0){ // flag 等于几，那么这个index，被命中的几率和  nextInt(flag) == 0 一致)
                    res=i;
                }
            }
        }
        return res;
    }
}
