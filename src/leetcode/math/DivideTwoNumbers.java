package leetcode.math;

/*
leetcode 29
https://leetcode.com/problems/divide-two-integers/discuss/179466/20ms-Binary-Search-Java-with-Explanations

 */
public class DivideTwoNumbers {

    public int divide(int dividend, int divisor) {

        long ldividend = (long) dividend, ldivisor = (long) divisor;

        boolean signNegative = false;
        if (ldividend < 0) {
            signNegative = !signNegative;
            ldividend = -ldividend;
        }
        if (ldivisor < 0) {
            signNegative = !signNegative;
            ldivisor = -ldivisor;
        }

        long result = divideRecur(ldividend, ldivisor);

        if (result > Integer.MAX_VALUE && !signNegative) {
            result = Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            result = Integer.MIN_VALUE;
        }

        return signNegative ? (int) -result : (int) result;
    }

    private long divideRecur(long dividend, long divisor) {

        if (dividend < divisor)
            return 0;

        long sum = divisor, quotient = 1;
        while (sum + sum < dividend) {
            sum += sum;
            quotient += quotient;
        }

        return quotient + divideRecur(dividend - sum, divisor);
    }

    // not using long
    public int divideNoLong(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (dividend > 0 && divisor > 0) return divideHelper(-dividend, -divisor);
        else if (dividend > 0) return -divideHelper(-dividend, divisor);
        else if (divisor > 0) return -divideHelper(dividend, -divisor);
        else return divideHelper(dividend, divisor);
    }

    private int divideHelper(int dividend, int divisor) {
        // base case
        if (divisor < dividend) return 0;
        // get highest digit of divisor
        int cur = 0, res = 0;
        while ((divisor << cur) >= dividend && divisor << cur < 0 && cur < 31) cur++;
        res = dividend - (divisor << cur - 1);
        if (res > divisor) return 1 << cur - 1;
        return (1 << cur - 1) + divide(res, divisor);
    }
}
