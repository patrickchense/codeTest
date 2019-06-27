package leetcode.bit;

/**
 https://leetcode.com/problems/single-number-iii/

 @bit
 @answered

 @review

 bit操作，
 Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

 Example:

 Input:  [1,2,1,3,2,5]
 Output: [3,5]

 必须O(n), O(1)
 */
public class LT260_SingleNumberII {

    // 都知道一个数，直接 ^=,  那么两个怎么办， 分成两组，分别^=, 怎么分成两组，通过 ^=的值，&他的负数，然后在结果，分别 &每个数
    public int[] singleNumber(int[] nums) {
        int t = 0;
        for (int n: nums) t ^= n;
        t &= -t; // 得到那两个数，不同的位数1的值
        int[] ret = new int[2];
        for (int n: nums) {
            if ((t & n) > 0) ret[0] ^= n;
            else ret[1] ^= n;
        }
        return ret;
    }
}
