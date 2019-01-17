package dailyproblem;

/*
Implement division of two positive integers without using the division, multiplication, or modulus operators. Return the quotient as an integer, ignoring the remainder.

@ContextLogic

@solved
 */
public class Daily20181231 {


    public static void main(String[] args) {
        System.out.println(divide(101, 2));
        System.out.println(divide(101, 3));
    }

    // O(log2N)?
    public static int divide(int a, int b) {
        //assume a > b
        int limit = b * 2;
        int num = 0;
        int previous = 0;
        while (limit < a) {
            previous = num;
            limit = b * num;
        }
        if (limit == a) return num;
        while (num > previous) {
            limit -= b;
            num--;
            if (limit <= a) break;
        }
        return num;
    }


    // better !!!!! only O(log(a)) ,  space O(1)
    public static long divide(long dividend,
                              long divisor) {

// Calculate sign of divisor
// i.e., sign will be negative
// only iff either one of them
// is negative otherwise it
// will be positive
        long sign = ((dividend < 0) ^
                (divisor < 0)) ? -1 : 1;

// remove sign of operands
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

// Initialize the quotient
        long quotient = 0, temp = 0;

// test down from the highest
// bit and accumulate the
// tentative value for
// valid bit
// 1<<31 behaves incorrectly and gives Integer
// Min Value which should not be the case, instead
        // 1L<<31 works correctly.
        for (int i = 31; i >= 0; --i) {

            if (temp + (divisor << i) <= dividend) {
                temp += divisor << i;
                quotient |= 1L << i;
            }
        }

        return (sign * quotient);
    }
}
