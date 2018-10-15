package leetcode.math;

/*
leetcode 371
https://leetcode.com/problems/sum-of-two-integers/description/
add two numbers can't use +/-

TODO
add two numbers II
https://leetcode.com/problems/add-two-numbers-ii/description/

 */
public class AddTwoNumbers {

    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }

        return a;
    }
}


