package GoldmanSachs;

import java.util.*;

/*
Based on the provided number, find all of its prime factors (when the factors are multiplied, they should result in the original number)
for example: 35 = 5 * 7

questions:
    number MAX_VALUE?
think: brute force,   for % == 0, judge if divided and dividend is prime

related:
count primes:
https://leetcode.com/problems/count-primes/description/
hard kth smallest prime pair  REVIEW
https://leetcode.com/problems/k-th-smallest-prime-fraction/description/
TODO prime number of set bit in Binary
https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/description/

 */
public class PrimeFactors {

    public static void main(String args[]) {
        int n = 35;
        System.out.println("%d's prime factor:");
        primeFactor(n).forEach(System.out::println);
    }

    // use set to exclude duplicates
    private static Set<Set<Integer>> primeFactor(int n) {
        Set<Set<Integer>> res = new HashSet<>();
        for (int i = n / 2; i > 1; i--) {
            if (n % i == 0 && isPrime(n % i) && isPrime(n / i)) res.add(new HashSet<>(Arrays.asList(i, n / i)));
        }
        return res;
    }

    /*
    Optimize: many duplicate calculate, use int[] to store the prime value
     */
    private static boolean isPrime(int n) {
        for (int i = n / 2; i > 1; i--) {
            if (n % i == 0) return false;
        }
        return true;
    }

    /*
    related
    https://www.geeksforgeeks.org/ugly-numbers/
    check for ugly numbers (only prime factor is 2,3,5)
    Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers. By convention, 1 is included.

Given a number n, the task is to find n’th Ugly number.

Examples:

Input  : n = 7
Output : 8

Input  : n = 10
Output : 12

Input  : n = 15
Output : 24

Input  : n = 150
Output : 5832

solution:
1. brute force,   check every number isUgly and until count == n
2. dp,
     (1) 1×2, 2×2, 3×2, 4×2, 5×2, …
     (2) 1×3, 2×3, 3×3, 4×3, 5×3, …
     (3) 1×5, 2×5, 3×5, 4×5, 5×5, …

@dp
     */

    int getNthUglyNo(int n) {
        int ugly[] = new int[n];  // To store ugly numbers
        int i2 = 0, i3 = 0, i5 = 0;
        int next_multiple_of_2 = 2;
        int next_multiple_of_3 = 3;
        int next_multiple_of_5 = 5;
        int next_ugly_no = 1;

        ugly[0] = 1;

        for (int i = 1; i < n; i++) {
            next_ugly_no = Math.min(next_multiple_of_2,
                    Math.min(next_multiple_of_3,
                            next_multiple_of_5));

            ugly[i] = next_ugly_no;
            if (next_ugly_no == next_multiple_of_2) {
                i2 = i2 + 1;
                next_multiple_of_2 = ugly[i2] * 2;
            }
            if (next_ugly_no == next_multiple_of_3) {
                i3 = i3 + 1;
                next_multiple_of_3 = ugly[i3] * 3;
            }
            if (next_ugly_no == next_multiple_of_5) {
                i5 = i5 + 1;
                next_multiple_of_5 = ugly[i5] * 5;
            }
        } /*End of for loop (i=1; i<n; i++) */
        return next_ugly_no;
    }
}
