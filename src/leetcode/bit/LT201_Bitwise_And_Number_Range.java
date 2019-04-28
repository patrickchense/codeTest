package leetcode.bit;

/*
https://leetcode.com/problems/bitwise-and-of-numbers-range/

@medium

Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

Example 1:

Input: [5,7]
Output: 4
Example 2:

Input: [0,1]
Output: 0


@bitop
@answered

The bitwise AND of all the numbers in range [m, n] is just the bitwise AND of the two special number

 */
public class LT201_Bitwise_And_Number_Range {

    public static void main(String[] args) {
        // 5 ->  101, , 110, 111, 只有一位bit == 0, 那么结果对应的bit就是0，怎么判断一个数字的哪位是0？
        System.out.println(rangeBitwiseAnd(5, 7));
        System.out.println(rangeBitwiseAnd(5, 8));
    }

    public static int rangeBitwiseAnd(int m, int n) {
        int i = 0;
        for (; m != n; ++i) {
            m >>= 1;
            n >>= 1;
        }
        return n << i;
    }
}
