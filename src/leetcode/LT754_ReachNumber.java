package leetcode;

/*
https://leetcode.com/problems/reach-a-number/

You are standing at position 0 on an infinite number line. There is a goal at position target.

On each move, you can either go left or right. During the n-th move (starting from 1), you take n steps.

Return the minimum number of steps required to reach the destination.

Example 1:
Input: target = 3
Output: 2
Explanation:
On the first move we step from 0 to 1.
On the second step we step from 1 to 3.
Example 2:
Input: target = 2
Output: 3
Explanation:
On the first move we step from 0 to 1.
On the second move we step  from 1 to -1.
On the third move we step from -1 to 2.

@answered

 */
public class LT754_ReachNumber {


    // 0 ... n,  n步， 1...2...3...4..
    /*
        3,  1,2
        2,  1, -2, 3
        4,  1, 2, -3, 4
        5,  1, 2, 3, 4, -5
        6,  1, 2, 3


    */
    public int reachNumber(int target) {
        target = Math.abs(target);
        // k1 -- steps to reach next number in a row after 'target'
        int k1 = (int)Math.ceil(Math.sqrt(0.25+2.0*target) - 0.5);
        int k2 = k1+1; // <-- and one more step

        // actual 'number' at step [k1] and [k2]
        int S1 = (k1*(1+k1))/2;
        int S2 = (k2*(1+k2))/2;

        // calculate difference to decide if 1 negative element needed
        int d1 = S1 - target;
        int d2 = S2 - target;

        // if the difference is even, than 1 negative element exists, otherwise add 2 more steps
        int m1 = k1 + (d1%2==0 ? 0 : 2);
        int m2 = k2 + (d2%2==0 ? 0 : 2);

        // define min steps count between [k1] and [k2]
        return Math.min(m1, m2);
    }
}
