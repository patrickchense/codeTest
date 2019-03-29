package daily2019;

import util.NumberUtil;

import java.util.Arrays;
import java.util.Set;

/*
Given an even number (greater than 2), return two prime numbers whose sum will be equal to the given number.

A solution will always exist. See Goldbach’s conjecture.

Example:

Input: 4
Output: 2 + 2 = 4
If there are more than one solution possible, return the lexicographically smaller solution.

If [a, b] is one solution with a <= b, and [c, d] is another solution with c <= d, then

[a, b] < [c, d]
If a < c OR a==c AND b < d.

@alibaba
@prime
@solved
@review
质数题, PrimeFactors 是乘数

关键在于2点， 1.判断是不是prime， 2. 范围选择

 */
public class D20190113 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(primeAddFactors(4)));
        System.out.println(Arrays.toString(primeAddFactors(6)));
        System.out.println(Arrays.toString(primeAddFactors(12)));
        System.out.println(Arrays.toString(primeAddFactors(14)));
    }

    public static int[] primeAddFactors(int n) {
        int i = 2;
        int j = n -2;
        while(i <= j) {
            if (NumberUtil.isPrime(i) && NumberUtil.isPrime(j)) {
                return new int[]{i, j};
            }
            i++;
            j--;
        }
        return null;
    }
}
