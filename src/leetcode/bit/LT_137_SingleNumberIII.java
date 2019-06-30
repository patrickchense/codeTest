package leetcode.bit;

/*
https://leetcode.com/problems/single-number-ii/

Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,3,2]
Output: 3
Example 2:

Input: [0,1,0,1,0,1,99]
Output: 99

@answered
@bit
@review

可以正常用hash来解决，但是明显是个 O(n） O(1)的bit操作
 */
public class LT_137_SingleNumberIII {

    public static void main(String[] args) {
        LT_137_SingleNumberIII s = new LT_137_SingleNumberIII();
        s.singleNumber(new int[]{0,1,0,1,0,1,99});
    }

    // 没看懂，
    public int singleNumber(int[] nums) {
        int one=0;
        int two=0;
        for(int value:nums)
        {
            System.out.println("value= " + value + ", bin=" + Integer.toBinaryString(value));
            one=one^value&~two;
            System.out.println("one=" + Integer.toBinaryString(one));
            two=two^value&~one;
            System.out.println("two=" + Integer.toBinaryString(two));
        }
        return one;
    }
}
